/*
 * Dungeon Adventure is a simple little game with the objective
 * of finding the exit of a dungeon
 * As time passes I will be adding more features hopefully resembling
 * a full blown dungeon crawl
 */
package dungeon_adventure;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Scott Klein
 * @version 1.0
 */
public class Dungeon_Adventure {
    static Character_Information Character;
    static Monster_Information[] Creature;
    static Combat Encounter;
    static Dungeon_Adventure_Display Dungeon_Display;
    static Dungeon_Level Dungeon_Info;
    static Compass_Location Coords;
    static String facing;
    static String location_visual;
    static int left_wall, right_wall, front_wall;
    static String cant_move_forward = "You hit your head on the wall as you cannot more forward.";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        game_monster_initialization();
        game_initialization();
        game_key_processing();
        
    }

    public static void game_initialization() {
        Dungeon_Display = new Dungeon_Adventure_Display();
        Dungeon_Info = new Dungeon_Level();  
        Coords = new Compass_Location(0,0,0,0,1,1,1,0); //starting location
        
        Character = new Character_Information(); //character creation
        //character.set_in_combat(true); //set for testing purposes
        
        Encounter = new Combat();
        
        //auto scroll msgs to the bottom of display box
        DefaultCaret caret = (DefaultCaret)Dungeon_Display.display_box.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                
        //Input Maps for arrow keys
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "move_forward");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "turn_left");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "turn_right");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "fight");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "run");
        
              
        //set up game when first loading up
        String welcome_text = "Welcome to Dungeon Adventure\nStay a while!\nStay forever!\n";
        Dungeon_Display.add_text(welcome_text);   
        Coords.set_direction_name();
        facing = "Facing " + Coords.get_direction_name() + "\n";
        Dungeon_Display.add_text(facing);
        
        where_walls();
        location_visual=location_surrounding_walls();
        Dungeon_Display.set_image(location_visual);
                        
    }
  
    public static void game_key_processing() {
        //game engine procesing
        //Action Map for each arrow key leading to method for movement
        Dungeon_Display.dungeon_panel.getActionMap().put("move_forward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move_forward();
            }
        });
        
        Dungeon_Display.dungeon_panel.getActionMap().put("turn_left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn_left();
            }
        });
        
        Dungeon_Display.dungeon_panel.getActionMap().put("turn_right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn_right();
            }
        });
        
        Dungeon_Display.dungeon_panel.getActionMap().put("fight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fight();
            }
        });
        
        Dungeon_Display.dungeon_panel.getActionMap().put("run", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //run();
            }
        });
    }
    
    //move in direction facing unless wall is in the way, then process what the area looks like
    public static void move_forward(){
        
        if (!(Character.in_combat())){        
            if (front_wall == 1) {
                Dungeon_Display.add_text(cant_move_forward + "\n");
            }
            else {
                if (!(Character.get_char_hp() >= Character.get_char_hp_max())){
                    Character.set_char_hp(Character.get_char_hp() + 1); //gain 1 HP with each valid forward move
                    Dungeon_Display.add_text("Current HP: " + Character.get_char_hp() + "\n");
                }
                move_in_facing_direction();            
        }                
        location_processing();
        encounter_processing();
        }
        /*else {
         *  Dungeon_Display.add_text("You are in combate and cannot more forward." + "\n");
        }*/
    }
    
    //turn left, set the direction, then process what the area looks like
    public static void turn_left(){
        
        if (Character.in_combat()== false){ 
        Coords.set_direction(Coords.get_direction() - 1);
        if (Coords.get_direction() == -1) {
            Coords.set_direction(3);
        }        
        location_processing();    
        }
        /*else {
         *   Dungeon_Display.add_text("You are in combate and cannot turn left." + "\n");
        }*/
    }
    //turn right, set the diretion, then process what the area looks like
    public static void turn_right(){
        
        if (Character.in_combat()== false){ 
        Coords.set_direction(Coords.get_direction() + 1);
        if (Coords.get_direction() == 4) {
            Coords.set_direction(0);
        }        
        location_processing();
        }
        /*else {
         *  Dungeon_Display.add_text("You are in combate and cannot turn right." + "\n");
        }*/
    }
    
    //process what the area looks like
    public static void location_processing(){
        Coords.set_direction_name();
        where_walls();
        location_visual=location_surrounding_walls();
        Dungeon_Display.set_image(location_visual);
        facing = "Facing " + Coords.get_direction_name() + "\n";
        Dungeon_Display.add_text(facing);
        
    }
    
    //determine if there is a creature encounter and sent it off to combat if there is
    public static void encounter_processing(){
        int monster = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][4];
        if (monster >= 1 && monster <= 100){
            Character.set_in_combat(true);
            Dungeon_Display.add_text("Oh no! You've encountered a " + Creature[monster].get_name() + "! \n");
            Dungeon_Display.add_text("Would you like to (R)un or (F)ight?\n");
            Creature[monster].set_prompted_combat(true);
        }
        
    }
    
    //get surrouding wall location with regards to facting direction
    public static void where_walls(){
        
        switch (Coords.get_direction()) {
            
            case 0:
                left_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][3];
                right_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][1];
                front_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][0];
                break;
                
            case 1:
                left_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][0];
                right_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][2];
                front_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][1];
                break;
                
            case 2:
                left_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][1];
                right_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][3];
                front_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][2];
                break;
                
            case 3:
                left_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][2];
                right_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][0];
                front_wall = Dungeon_Info.dungeon_layout[Coords.get_x_location()][Coords.get_y_location()][3];
                break;
        }
    }
    
    //determine where the walls are based on what's on the right, left and in front
    public static String location_surrounding_walls(){
        if ((left_wall == 1) && (right_wall ==1) && (front_wall ==1)){
            return "square_1.jpg";
        } 
        else if ((left_wall == 1) && (right_wall ==0) && (front_wall ==1)){
            return "square_2.jpg";
        }
        else if ((left_wall == 0) && (right_wall ==0) && (front_wall ==1)){
            return "square_3.jpg";
        }
        else if ((left_wall == 0) && (right_wall ==1) && (front_wall ==1)){
            return "square_4.jpg";
        }
        else if ((left_wall == 1) && (right_wall ==1) && (front_wall ==0)){
            return "square_5.jpg";
        }
        else if ((left_wall == 1) && (right_wall ==0) && (front_wall ==0)){
            return "square_6.jpg";
        }
        else if ((left_wall == 0) && (right_wall ==1) && (front_wall ==0)){
            return "square_7.jpg";
        }
        else if ((left_wall == 0) && (right_wall ==0) && (front_wall ==0)){
            return "square_8.jpg";
        }
        
        return "Error";
     
    
    }
    
    //processes movement in facing direction depending on compass direction
    // 0=North 1=East 2=South 3=West
    public static void move_in_facing_direction(){
        
        switch (Coords.get_direction()) {
            
            case 0:
                Coords.set_x_location(Coords.get_x_location()+1);
                break;
                
            case 1:
                Coords.set_y_location(Coords.get_y_location()+1);
                break;
                
            case 2:
                Coords.set_x_location(Coords.get_x_location()-1);
                break;
                
            case 3:
                Coords.set_y_location(Coords.get_y_location()-1);
                break;    
        }
    }
    
    //initialize each Creature in an instance array of creatures of no more than 100, but starting with 1 (not 0)
    public static void game_monster_initialization(){
        Creature = new Monster_Information[101];
        // armor class, to hit, min_dam, max_dam, hp, xp, weapon type, name
        Creature[1] = new Monster_Information(10, 20, 1, 6, 6, 20, "short sword", "skeleton");
    }
}
