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
 * @version 1.0
 */

/* The purpose of this class is to store basic character information
 * This includes hitpoints, strenght, intelligence, level, gold, experience
 * armorclass, weapon damage, armor worn and weapon used
 */
public class Character_Information {
    
    private int char_level;
    private int char_hp;
    private int char_str;
    private int char_int;
    private int char_gold;
    private int char_xp;
    private int char_hp_max;
    private int char_weapon_dmg;
    private int char_armor_class;
    private String char_weapon;
    private String char_armor;
    
    private Random rand_num = new Random();
    
    
    public Character_Information(){
       new_stats();
    }
    
    //set character level
    public void set_char_level(int lvl){
        char_level = lvl;
    }
    
    //get character level
    public int get_char_lvl(){
        return char_level;
    }
    
    //set character hit points
    public void set_char_hp(int hp){
        char_hp = hp;
    }
    
    //get character hit points
    public int get_char_hp(){
        return char_hp;
    }
    
    //set character strength
    public void set_char_str(int str){
        char_str = str;
    }
    
    //get character strength
    public int get_char_str(){
        return char_str;
    }
    
    //set character intelligence
    public void set_char_int(int intelli){
        char_int = intelli;
    }
    
    //get character intelligence
    public int get_char_int(){
        return char_int;
    }
    
    //set character gold
    public void set_char_gold(int gold){
        char_gold = gold;
    }
    
    //get character gold
    public int get_char_gold(){
        return char_gold;
    }
    
    //set character experience
    public void set_char_xp(int xp){
        char_xp = xp;
    }
    
    //get character experience
    public int get_char_xp(){
        return char_xp;
    }
    
    //set character mxx hp
    public void set_char_hp_max(int max){
        char_hp_max = max;        
    }
    
    //get character max hp
    public int get_char_hp_max(){
        return char_hp_max;
    }
    
    //set character weapon damage
    public void set_char_weapon_dmg(int dam){
        char_weapon_dmg = dam;
    }
    
    //get character weapon damage
    public int get_char_weapon_dmg(){
        return char_weapon_dmg;
    }
    
    //set character armor class
    public void set_char_armor_class(int ac){
        char_armor_class = ac;
    }
    
    //get character armor class
    public int get_char_armor_class(){
        return char_armor_class;
    }
    
    //set character weapon name
    public void set_char_weapon(String wep){
        char_weapon = wep;
    }
    
    //get character weapon name
    public String get_char_weapon(){
        return char_weapon;
    }
    
    //set characeter armor name
    public void set_char_armor(String arm){
        char_armor = arm;
    }
    
    //get character armor name
    public String get_char_armor(){
        return char_armor;
    }
    
    //check against current level and xp to see if a new level is warranted
    public void check_xp(){
        if ((char_xp >= 200) && (char_xp < 400) && (char_level == 1)){
            level_up();
        }
        else if ((char_xp >= 400) && (char_xp < 800) && (char_level == 2)){
            level_up();
        }
        else if ((char_xp >= 800) && (char_xp < 1600) && (char_level == 3)){
            level_up();
        }
        else if ((char_xp >= 1600) && (char_xp < 3200) && (char_level == 4)){
            level_up();
        }
        else if ((char_xp >= 3200) && (char_xp < 6400) && (char_level == 5)){
            level_up();
        }
        else if ((char_xp >= 6400) && (char_xp < 12800) && (char_level == 6)){
            level_up();
        }
        else if ((char_xp >= 12800) && (char_xp < 25600) && (char_level == 7)){
            level_up();
        }
        else if ((char_xp >= 25600) && (char_xp < 53200) && (char_level == 8)){
            level_up();
        }
        else if ((char_xp >= 53200) && (char_level == 9)){
            level_up();
        }
        
    }
    
    //level up character
    private void level_up(){
        char_level ++;
        char_str ++;
        char_int++;
        char_hp_max += rand_num.nextInt(10)+1;
        
    }
    
    //to create new random character stats
    //like strength, hit points, and constitution
    public void new_stats(){
        char_level = 0;
        char_hp = rand_num.nextInt(10)+1; //randomize this 10/level
        char_str = 1; //randomize this
        char_int = 1; //randomize this
        char_gold = 0;
        char_xp = 0;
        char_hp_max = char_hp;
        char_weapon_dmg = 6;
        char_armor_class = 10;
        //char_weapon = c_w;
        //char_armor = c_a;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
