/*
 * Compass Location class that stores level location and x, y
 * Also will have methods to spin the compass in a random direction
 * And random location placement
 */
package dungeon_adventure;

/**
 *
 * @author Scott Klein
 * @version 1.0
 * 
 */
public class Compass_Location {

    private int level;
    private int level_end = 0;
    private int x_location = 0;
    private int y_location = 0;
    private int x_size = 0;
    private int y_size = 0;
    private int north_wall;
    private int east_wall;
    private int south_wall;
    private int west_wall;
    private String facing_direction;
    
    
    
    public Compass_Location(int l_bottom, int x_end, int y_end, int l, int x, int y, int n_w, int e_w, int s_w, int w_w, String direction){
        this.level_end = l_bottom;
        this.y_size = y_end;
        this.x_size = x_end;
        this.level = l;
        this.x_location = x;
        this.y_location = y;
        this.north_wall = n_w;
        this.east_wall = e_w;
        this.south_wall = s_w;
        this.west_wall = w_w;
        this.facing_direction = direction;        
    }
    
    //get facing direction
    public String get_direction() {
        return facing_direction;
    }
    
    //set facing direction
    public void set_direction(String new_direction) {
        facing_direction = new_direction;
    }
    
    //set x location
    public void set_x_location(int x){
        x_location = x;
    }
    
    //set y location
    public void set_y_location(int y){
        y_location = y;
    }
    
    //get x location
    public int get_x_location() {
        return x_location;
    }

    //get y location
    public int get_y_location() {
        return y_location;
    }

    //set dungeon level
    public void set_level(int lvl){
        level = lvl;
    }
    
    //get dungeon level
    public int get_level() {
        return level;
    }
  
    //set if there is a north wall
    public void set_north_wall(int n){
        north_wall = n;
    }
    
    //get if there is a north wall
    public boolean get_north_wall() {
        return (north_wall != 0);
    }
    
    //set if there is a east wall
    public void set_east_wall(int e){
        east_wall = e;
    }
    
    //get if there is a east wall
    public boolean get_east_wall() {
        return (east_wall != 0);
    }
    
    //set if there is a south wall
    public void set_south_wall(int s){
        south_wall = s;
    }
    
    //get if there is a south wall
    public boolean get_south_wall() {
        return (south_wall != 0);
    }
    
    //set if there is a west wall
    public void set_west_wall(int w){
        west_wall = w;
    }
    
    //get if there is a west wall
    public boolean get_west_wall() {
        return (west_wall != 0);
    }
    
    //set facing direction
    public void set_facing_direction(String f_d){
        facing_direction = f_d;
    }
    
    //get facing direction
    public String get_facing_direction(){
        return facing_direction;
    }
    
}
