/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_adventure;

/**
 *
 * @author Scott Klein
 * @version 1.0
 */

/* This is the dungeon level class. It includes all the information about a 
 * a dungeon level. To start they are 10 x 10. Using an x,y coord system
 * This will be used to determine what walls one sees in the display panel
 * This will also determine how one is able to move through the dungeon
 * [x][y][z] is the layout.
 * [z] will let the main program know which way movement is possible and
 * if there is an encounter or other event happening in that location
 * The fist 4 array items in [z] determine what direction is moveable
 * The 5th array item in [z] determines in there is a monster encounter
 * The 6th array item in [z] determines if there is anoter event
 * x, y, n, e, s, w, m, t
 * For the diretions a 0 = nothing in that direction, a 1 = a wall in that direction
 * For m 0 = no monster, for t 0 = no treasure
 */
public class Dungeon_Level {
    
    final int [][][] dungeon_layout; 

    public Dungeon_Level() {
        this.dungeon_layout = new int[][][]{
       { {0,1,1,1,0,0}, {1,1,1,1,0,0}, {1,1,1,0,0,0}, {0,1,1,1,0,0}, {0,1,1,1,0,0}, {0,0,1,1,0,0}, {1,0,1,0,0,0}, {1,0,1,0,0,0}, {1,0,1,0,0,0}, {0,1,1,0,0,0} },
       { {1,0,0,1,0,0}, {1,0,1,0,0,0}, {0,0,1,0,0,0}, {1,1,0,0,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,0,1,1,0,0}, {1,0,1,0,0,0}, {1,1,1,0,0,0}, {0,1,0,1,0,0} },
       { {0,0,1,1,0,0}, {0,1,1,0,0,0}, {0,1,0,1,0,0}, {0,0,1,1,0,0}, {0,1,0,0,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,0,1,1,0,0}, {1,0,1,0,0,0}, {0,1,0,0,0,0} },
       { {1,0,0,1,0,0}, {1,1,0,0,0,0}, {0,1,0,1,0,0}, {1,0,0,1,0,0}, {1,1,0,0,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,1,1,0,0}, {0,1,0,1,0,0} },
       { {0,0,1,1,0,0}, {1,0,1,0,0,0}, {0,0,0,0,0,0}, {1,0,1,0,0,0}, {1,0,1,0,0,0}, {1,1,0,0,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {1,1,0,1,0,0}, {0,1,0,1,0,0} },
       { {0,1,0,1,0,0}, {0,1,1,1,0,0}, {0,1,0,1,0,0}, {0,0,1,1,0,0}, {1,0,1,0,0,0}, {1,0,1,0,0,0}, {1,1,0,0,0,0}, {0,0,0,1,0,0}, {1,0,1,0,0,0}, {0,1,0,1,0,0} },
       { {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,0,1,1,0,0}, {1,0,1,0,0,0}, {1,0,1,0,0,0}, {0,1,0,0,0,0}, {0,1,1,1,0,0}, {0,1,0,1,0,0} },
       { {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,0,1,1,0,0}, {0,1,1,0,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0}, {0,1,0,1,0,0} },
       { {0,1,0,1,0,0}, {1,1,0,1,0,0}, {0,1,0,1,0,0}, {1,1,0,1,0,0}, {0,1,0,1,0,0}, {1,0,0,1,0,0}, {1,1,0,0,0,0}, {0,1,0,1,0,0}, {1,1,0,1,0,0}, {0,1,0,1,0,0} },
       { {1,0,0,1,0,0}, {1,0,1,0,0,0}, {1,0,0,0,0,0}, {1,0,1,0,0,0}, {1,0,0,0,0,0}, {1,0,0,1,0,0}, {1,0,1,0,0,0}, {1,0,0,0,0,0}, {1,0,1,0,0,0}, {1,1,0,0,0,0} }
       };
       
       }
    
    

    
}
