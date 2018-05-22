/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_adventure;

/**
 *
 * @author Scott
 */
public class Combat {
    
    
    public void encounter(Dungeon_Adventure_Display display, Character_Information character, Monster_Information monster){
       display.add_text("Oh no! You've encountered a " + monster.get_name() + "! \n");
       display.add_text("Would you like to (R)un or (F)ight?\n");
       monster.set_prompted_combat(true);
    }
}
