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
    private int x_location = 0;
    private int y_location = 0;
    private int north_wall;
    private int east_wall;
    private int south_wall;
    private int west_wall;
    private int direction; //north = 0, east = 1, south = 2, west = 3
    private String direction_name;
    
    
    
    public Compass_Location(int l, int x, int y, int n_w, int e_w, int s_w, int w_w, int dir){
        
        this.level = l;
        this.x_location = x;
        this.y_location = y;
        this.north_wall = n_w;
        this.east_wall = e_w;
        this.south_wall = s_w;
        this.west_wall = w_w;
        this.direction = dir;
             
    }
    
    //set direction
    public void set_direction(int dir){
        direction = dir;
    }
    
    //get direction
    public int get_direction(){
        return direction;
    }
    
    //get direction name
    public String get_direction_name() {
        return direction_name;
    }
    
    //set direction name based on 0=N 1=E 2=S 3=W
    public void set_direction_name(){
        
        switch (this.direction){
        
            case 0:
                direction_name = "North";
                break;
            
            case 1:
                direction_name = "East";
                break;
                
            case 2:
                direction_name = "South";
                break;
                
            case 3:
                direction_name = "West";
                break;
        }
        
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
  
    
}
