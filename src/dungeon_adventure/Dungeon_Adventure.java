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
    static int left_wall, right_wall, front_wall;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        game_initialization();
        
    }

    public static void game_initialization() {
        Dungeon_Display = new Dungeon_Adventure_Display();
        Dungeon_Info = new Dungeon_Level();  
        coords = new Compass_Location(0,0,0,0,1,1,1,0,"North"); //starting location
                
        //Input Maps for arrow keys
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "move_forward");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "turn_left");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "turn_right");
              
        String location_visual;
        String welcome_text = "Welcome to Dungeon Adventure\nStay a while!\nStay forever!\n";
        Dungeon_Display.add_text(welcome_text);               
        facing = "Facing " + coords.get_direction_name() + "\n";
        Dungeon_Display.add_text(facing);
        
        where_walls();
        location_visual=location_surrounding_walls();
        Dungeon_Display.change_image(location_visual);
        game_key_processing();
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
        
    }
    
    public static void turn_left(){
        
    }
    
    public static void turn_right(){
        
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
        
        return null;
     
    
    }
    
    
}
