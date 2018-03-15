/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_adventure;

import java.util.Random;

/**
 *
 * @author User
 */
public class Compass_Random_Location extends Compass_Location {
    
    int random_level;
    int random_x;
    int random_y;
    
    Random random_number = new Random();
    

    public Compass_Random_Location(int l, int x, int y, int n_w, int e_w, int s_w, int w_w, int dir, String direction) {
        super(l, x, y, n_w, e_w, s_w, w_w, dir, direction);
    }
    
     //Set random level
        public int get_random_level(int level_max) {
        random_level = random_number.nextInt(level_max);
        this.set_level(random_level);
        return random_level;
    }
    
    //Set random x-axis
        public int get_random_x (int x_max) {
        random_x = random_number.nextInt(x_max);
        this.set_x_location(random_x);
        return random_x;
    }
    
    //Set random y-axis
    public int get_random_y (int y_max) {
        random_y = random_number.nextInt(y_max);
        this.set_y_location(random_x);
        return random_y;
    }
}
