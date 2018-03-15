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
    public static Dungeon_Adventure_Display Dungeon_Display;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        game_initialization();
        game_engine();
    }

    public static void game_initialization() {
        String welcome_text = "Welcome to Dungeon Adventure\nStay a while!\nStay forever!";
        Dungeon_Display = new Dungeon_Adventure_Display();
        Dungeon_Display.change_image("square_1.jpg");
        Dungeon_Display.add_text(welcome_text);
        
        //Input Maps for arrow keys
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "move_forward");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "turn_left");
        Dungeon_Display.dungeon_panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "turn_right");
              
        
    }
  
    public static void game_engine() {
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
    
}
