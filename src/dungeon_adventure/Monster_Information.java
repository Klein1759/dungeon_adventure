/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_adventure;

import java.util.Random;

/**
 *
 * @author Scott Klein
 */

/* Monster_Information is to hold the stats for each monster created for 
 * predetermined encounters and random encounters when they are implemented
 * Each instance of this class will be referred via an array starting with 1
 * no larger than 100 creatures at the moment.
 */
public class Monster_Information {
    private Random random_damage = new Random();
    
    private String name;
    private int armor_class;
    private int thaco;
    private int min_damage;
    private int max_damage;
    private int hit_points;
    private int xp_value;
    private int damage;
    private String attack_type;
    private String attack_text;
    
    public Monster_Information (int ac, int tohit, int min_d, int max_d, int hp,
            int xp, String type, String nm){
       
        armor_class = ac;
        thaco = tohit;
        min_damage = min_d;
        max_damage = max_d;
        hit_points = hp;
        xp_value = xp;
        attack_type = type;        
        name = nm;
        
    }
    
    //get name
    public String get_name(){
        return name;
    }
    //get ac
    public int get_armor_class(){
        return armor_class;
    }
    
    //get THACO
    public int get_thaco(){
        return thaco;
    }
    
    //get min damage done
    public int get_min_damage(){
        return min_damage;
    }
    
    //get max damage done
    public int get_max_damage(){
        return max_damage;
    }
    
    //get hit points of creature
    public int get_hit_points(){
        return hit_points;
    }
        
    //get xp value
    public int get_xp_value(){
        return xp_value;
    }
    
    //get combat text
    public String get_attack_type(){
        return attack_type;
    }
    
    //calculate damage done
    private int get_damage_done(){
        damage = random_damage.nextInt(max_damage - min_damage + 1) + min_damage;
        return damage;
    }
    
    //full attack text
    public String get_attack_text(){
        attack_text = "You've been hit by " + attack_type + " for a total of " + get_damage_done() + " damage.";
        return attack_text;
    }
}
