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

    public JPanel dungeon_panel;
    public JTextArea display_box;
    private JLabel display_label;
    private JLabel ac_number;
    private JLabel str_number;
    private JLabel int_number;
    private JLabel hp_number;
    private JLabel xp_number;
    private JLabel lvl_number;
    
    
    
    public Dungeon_Adventure_Display(){
        //Set the JFrame
        this.setLayout(null);
        this.setSize(600, 500);
        this.setTitle("Dungeon Adventure");
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add panel for the components
        dungeon_panel = new JPanel();
        dungeon_panel.setBackground(Color.LIGHT_GRAY);
        dungeon_panel.setLayout(null);
        dungeon_panel.setSize(600,500);
        
        //Using JLabels to displat stats
        JLabel str_label = new JLabel();
        str_label.setText("Strength: ");
        str_label.setBounds(27, 15, 75, 10);
        
        str_number = new JLabel();
        str_number.setText("00");
        str_number.setBounds(115, 15, 20, 10);
        
        JLabel int_label = new JLabel();
        int_label.setText("Intelligence: ");
        int_label.setBounds(11, 35, 75, 10);
        
        int_number = new JLabel();
        int_number.setText("00");
        int_number.setBounds(115, 35, 20, 10);
        
        JLabel hp_label = new JLabel();
        hp_label.setText("Hit Points: ");
        hp_label.setBounds(21, 55, 75, 10);
        
        hp_number = new JLabel();
        hp_number.setText("0000");
        hp_number.setBounds(101, 55, 35, 10);
        
        JLabel xp_label = new JLabel();
        xp_label.setText("Experience: ");
        xp_label.setBounds(11, 75, 75, 10);
        
        xp_number = new JLabel();
        xp_number.setText("00000");
        xp_number.setBounds(95, 75, 55, 10);
        
        JLabel lvl_label = new JLabel();
        lvl_label.setText("Level: ");
        lvl_label.setBounds(45, 95, 75, 10);
        
        lvl_number = new JLabel();
        lvl_number.setText("00");
        lvl_number.setBounds(115, 95, 35, 10);
        
        JLabel ac_label = new JLabel();
        ac_label.setText("Armor Class: ");
        ac_label.setBounds(11, 115, 80, 10);
        
        ac_number = new JLabel();
        ac_number.setText("00");
        ac_number.setBounds(115, 115, 35, 10);
        
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
        display_label = new JLabel();
        //display_label.setBounds(250,10,300,225);
        display_label.setSize(300, 225);
        //display_label.setIcon(new ImageIcon("images/square_1.jpg"));
        display_panel.add(display_label);
        
        
        //Add Text Area with scroll bar to display text information
        display_box = new JTextArea();
        JScrollPane display_scroll = new JScrollPane(display_box, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        display_scroll.setBounds(10, 300, 573, 160);
        display_box.setLineWrap(true);
        //DefaultCaret caret = (DefaultCaret)display_box.getCaret();
        //caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        //display_box.setCaretPosition(display_box.getDocument().getLength());
        display_box.setEditable(false);  
               
        
                
        //Add the panel and components to the JFrame
        this.add(dungeon_panel);
        dungeon_panel.add(ac_label);
        dungeon_panel.add(ac_number);
        dungeon_panel.add(lvl_label);
        dungeon_panel.add(lvl_number);
        dungeon_panel.add(xp_label);
        dungeon_panel.add(xp_number);
        dungeon_panel.add(hp_label);
        dungeon_panel.add(hp_number);
        dungeon_panel.add(int_label);
        dungeon_panel.add(int_number);
        dungeon_panel.add(str_label);
        dungeon_panel.add(str_number);
        //dungeon_panel.add(forward_button);
        //dungeon_panel.add(turn_left_button);
        //dungeon_panel.add(turn_right_button);
        dungeon_panel.add(display_panel);
        dungeon_panel.add(display_scroll);
        
        //Turn it on so it can be seen
        this.setVisible(true);
    }
    
    public void add_text(String added_text){
        display_box.append(added_text);
    }
    
    //change the image in the display window
    public void change_image(String img_location){
        display_label.setIcon(new ImageIcon("images/" + img_location));
    }
    
    //set ac_number
    public void set_ac_number (String armor_num){
        ac_number.setText(armor_num);
    }

    //set str_number
    public void set_str_number (String str_num){
        str_number.setText(str_num);
    }
    
    //set int_number
    public void set_int_number (String int_num){
        int_number.setText(int_num);
    }
    
    //set hp_number
    public void set_hp_number (String hp_num){
        hp_number.setText(hp_num);
    }
    
    //set xp_number
    public void set_xp_number (String xp_num){
        xp_number.setText(xp_num);
    }
    
    //set lvl_number
    public void set_lvl_number (String lvl_num){
        lvl_number.setText(lvl_num);
    }
    
    
}

