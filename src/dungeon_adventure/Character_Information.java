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
    
    
    
    
}
