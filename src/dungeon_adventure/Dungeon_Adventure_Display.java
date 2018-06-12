/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon_adventure;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Scott
 * @version 1.0
 */
public class Dungeon_Adventure_Display extends JFrame{

    public JPanel jpanel_dungeon_panel;
    public JTextArea jtxtarea_display_box;
    private JLabel jlabel_display_label;
    private JLabel jlabel_ac_number;
    private JLabel jlabel_str_number;
    private JLabel jlabel_int_number;
    private JLabel jlabel_hp_number;
    private JLabel jlabel_xp_number;
    private JLabel jlabel_lvl_number;
    
    
    
    public Dungeon_Adventure_Display(){
        //Set the JFrame
        this.setLayout(null);
        this.setSize(600, 500);
        this.setTitle("Dungeon Adventure");
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add panel for the components
        jpanel_dungeon_panel = new JPanel();
        jpanel_dungeon_panel.setBackground(Color.LIGHT_GRAY);
        jpanel_dungeon_panel.setLayout(null);
        jpanel_dungeon_panel.setSize(600,500);
        
        //Using JLabels to displat stats
        JLabel str_label = new JLabel();
        str_label.setText("Strength: ");
        str_label.setBounds(27, 15, 75, 10);
        
        jlabel_str_number = new JLabel();
        jlabel_str_number.setText("00");
        jlabel_str_number.setBounds(115, 15, 20, 10);
        
        JLabel int_label = new JLabel();
        int_label.setText("Intelligence: ");
        int_label.setBounds(11, 35, 75, 10);
        
        jlabel_int_number = new JLabel();
        jlabel_int_number.setText("00");
        jlabel_int_number.setBounds(115, 35, 20, 10);
        
        JLabel hp_label = new JLabel();
        hp_label.setText("Hit Points: ");
        hp_label.setBounds(21, 55, 75, 10);
        
        jlabel_hp_number = new JLabel();
        jlabel_hp_number.setText("0000");
        jlabel_hp_number.setBounds(101, 55, 35, 10);
        
        JLabel xp_label = new JLabel();
        xp_label.setText("Experience: ");
        xp_label.setBounds(11, 75, 75, 10);
        
        jlabel_xp_number = new JLabel();
        jlabel_xp_number.setText("00000");
        jlabel_xp_number.setBounds(95, 75, 55, 10);
        
        JLabel lvl_label = new JLabel();
        lvl_label.setText("Level: ");
        lvl_label.setBounds(45, 95, 75, 10);
        
        jlabel_lvl_number = new JLabel();
        jlabel_lvl_number.setText("00");
        jlabel_lvl_number.setBounds(115, 95, 35, 10);
        
        JLabel ac_label = new JLabel();
        ac_label.setText("Armor Class: ");
        ac_label.setBounds(11, 115, 80, 10);
        
       jlabel_ac_number = new JLabel();
       jlabel_ac_number.setText("00");
       jlabel_ac_number.setBounds(115, 115, 35, 10);
        
        /*
        JButton forward_button = new JButton();
        //forward_button.setText("Forward");
        forward_button.setBounds(105, 160, 20, 60);
        Icon forward_icon = new ImageIcon("images/forward_icon.jpg");
        forward_button.setIcon(forward_icon);
        
        JButton turn_left_button = new JButton();
        //left_turn_button.setText("Turn Left");
        turn_left_button.setBounds(15, 230, 100, 20);
        Icon turn_left_icon = new ImageIcon("images/turn_left_icon.jpg");
        turn_left_button.setIcon(turn_left_icon);
        
        JButton turn_right_button = new JButton();
        //turn_right_button.setText("Turn Right");
        turn_right_button.setBounds(115, 230, 100, 20);
        Icon turn_right_icon = new ImageIcon("images/turn_right_icon.jpg");
        turn_right_button.setIcon(turn_right_icon);
        */

        //Display box for graphics such as walls, monsters, and treasures
        JPanel display_panel = new JPanel();
        display_panel.setBackground(Color.gray);
        display_panel.setLayout(null);
        display_panel.setSize(300,225);
        display_panel.setBounds(250, 10, 300, 225);
        
        //Add label to the panel for images later in the game
        jlabel_display_label = new JLabel();
        //jlabel_display_label.setBounds(250,10,300,225);
        jlabel_display_label.setSize(300, 225);
        //jlabel_display_label.setIcon(new ImageIcon("images/square_1.jpg"));
        display_panel.add(jlabel_display_label);
        
        
        //Add Text Area with scroll bar to display text information
        jtxtarea_display_box = new JTextArea();
        JScrollPane display_scroll = new JScrollPane(jtxtarea_display_box, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        display_scroll.setBounds(10, 300, 573, 160);
        jtxtarea_display_box.setLineWrap(true);
        //DefaultCaret caret = (DefaultCaret)jtxtarea_display_box.getCaret();
        //caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        //jtxtarea_display_box.setCaretPosition(jtxtarea_display_box.getDocument().getLength());
        jtxtarea_display_box.setEditable(false);  
               
        
                
        //Add the panel and components to the JFrame
        this.add(jpanel_dungeon_panel);
        jpanel_dungeon_panel.add(ac_label);
        jpanel_dungeon_panel.add(jlabel_ac_number);
        jpanel_dungeon_panel.add(lvl_label);
        jpanel_dungeon_panel.add(jlabel_lvl_number);
        jpanel_dungeon_panel.add(xp_label);
        jpanel_dungeon_panel.add(jlabel_xp_number);
        jpanel_dungeon_panel.add(hp_label);
        jpanel_dungeon_panel.add(jlabel_hp_number);
        jpanel_dungeon_panel.add(int_label);
        jpanel_dungeon_panel.add(jlabel_int_number);
        jpanel_dungeon_panel.add(str_label);
        jpanel_dungeon_panel.add(jlabel_str_number);
        //jpanel_dungeon_panel.add(forward_button);
        //jpanel_dungeon_panel.add(turn_left_button);
        //jpanel_dungeon_panel.add(turn_right_button);
        jpanel_dungeon_panel.add(display_panel);
        jpanel_dungeon_panel.add(display_scroll);
        
        //Turn it on so it can be seen
        this.setVisible(true);
    }
    
    public void add_text(String added_text){
        jtxtarea_display_box.append(added_text);
    }
    
    //change the image in the display window
    public void set_image(String img_location){
        jlabel_display_label.setIcon(new ImageIcon("images/" + img_location));
    }
    
    //set jlabel_ac_number
    public void set_ac_number (String armor_num){
       jlabel_ac_number.setText(armor_num);
    }

    //set jlabel_str_number
    public void set_jlabel_str_number (String str_num){
        jlabel_str_number.setText(str_num);
    }
    
    //set int_number
    public void set_jlabel_int_number (String int_num){
        jlabel_int_number.setText(int_num);
    }
    
    //set jlabel_hp_number
    public void set_jlabel_hp_number (String hp_num){
        jlabel_hp_number.setText(hp_num);
    }
    
    //set jlabel_xp_number
    public void set_jlabel_xp_number (String xp_num){
        jlabel_xp_number.setText(xp_num);
    }
    
    //set jlabel_lvl_number
    public void set_jlabel_lvl_number (String lvl_num){
        jlabel_lvl_number.setText(lvl_num);
    }
    
    
}

