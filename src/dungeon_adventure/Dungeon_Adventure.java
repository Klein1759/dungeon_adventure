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
    static Dungeon_Adventure_Display Dungeon_Display;
    static Dungeon_Level Dungeon_Info;
    static String info;
    static Compass_Location coords;
    static String facing;
    static String location_visual;
    static int left_wall, right_wall, front_wall;
    static String cant_move_forward = "You hit your head on the wall as you cannot more forward.";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        game_initialization();
        game_key_processing();
        
    }

    public static void game_initialization() {
        Dungeon_Display = new Dungeon_Adventure_Display();
        Dungeon_Info = new Dungeon_Level();  
        coords = new Compass_Location(0,0,0,0,1,1,1,0); //starting location
        DefaultCaret caret = (DefaultCaret)Dungeon_Display.display_box.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                
        //Input Maps for arrow keys
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "move_forward");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "turn_left");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "turn_right");
              
        String welcome_text = "Welcome to Dungeon Adventure\nStay a while!\nStay forever!\n";
        Dungeon_Display.add_text(welcome_text);   
        coords.set_direction_name();
        facing = "Facing " + coords.get_direction_name() + "\n";
        Dungeon_Display.add_text(facing);
        
        where_walls();
        location_visual=location_surrounding_walls();
        Dungeon_Display.change_image(location_visual);
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
    }
    
    public static void move_forward(){
        
        if (front_wall == 1) {
            Dungeon_Display.add_text(cant_move_forward + "\n");
        }
        else {
            move_in_facing_direction();            
        }
        
        
        location_processing();
        
    }
    
    public static void turn_left(){
        coords.set_direction(coords.get_direction() - 1);
        if (coords.get_direction() == -1) {
            coords.set_direction(3);
        }
        
        location_processing();
    }
    
    public static void turn_right(){
        coords.set_direction(coords.get_direction() + 1);
        if (coords.get_direction() == 4) {
            coords.set_direction(0);
        }
        
        location_processing();
    }
    
    public static void location_processing(){
        coords.set_direction_name();
        where_walls();
        location_visual=location_surrounding_walls();
        Dungeon_Display.change_image(location_visual);
        facing = "Facing " + coords.get_direction_name() + "\n";
        Dungeon_Display.add_text(facing);
        
    }
    
    //get surrouding wall location with regards to facting direction
    public static void where_walls(){
        
        switch (coords.get_direction()) {
            
            case 0:
                left_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][3];
                right_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][1];
                front_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][0];
                break;
                
            case 1:
                left_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][0];
                right_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][2];
                front_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][1];
                break;
                
            case 2:
                left_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][1];
                right_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][3];
                front_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][2];
                break;
                
            case 3:
                left_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][2];
                right_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][0];
                front_wall = Dungeon_Info.dungeon_layout[coords.get_x_location()][coords.get_y_location()][3];
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
    
    public static void move_in_facing_direction(){
        
        switch (coords.get_direction()) {
            
            case 0:
                coords.set_x_location(coords.get_x_location()+1);
                //coords.set_y_location(coords.get_y_location());
                break;
                
            case 1:
                coords.set_y_location(coords.get_y_location()+1);
                break;
                
            case 2:
                coords.set_x_location(coords.get_x_location()-1);
                break;
                
            case 3:
                coords.set_y_location(coords.get_y_location()-1);
                break;    
        }
    }
    
}
