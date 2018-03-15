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

/* The purpose of this class is to store basic character information
 * This includes hitpoints, strenght, intelligence, level, gold, experience
 * armorclass, weapon damage, armor worn and weapon used
 */
public class Character_Information {
    
    int char_level;
    int char_hp;
    int char_str;
    int char_int;
    int char_gold;
    int char_xp;
    int char_hp_max;
    int char_weapon_dmg;
    int char_armor_class;
    String char_weapon;
    String char_armor;
    
    
    public Character_Information(int c_l, int c_h, int c_s, int c_i, int c_g, int c_x, int c_h_m, int c_w_d, int c_a_c, String c_w, String c_a){
        char_level = c_l;
        char_hp = c_h;
        char_str = c_s;
        char_int = c_i;
        char_gold = c_g;
        char_xp = c_x;
        char_hp_max = c_h_m;
        char_weapon_dmg = c_w_d;
        char_armor_class = c_a_c;
        char_weapon = c_w;
        char_armor = c_a;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
