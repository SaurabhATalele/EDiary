
package ebilling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,l11;
    JButton b1,b2;
    ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icon/muktai logo.jpg"));
    NewCustomer(){
        setLocation(600,200);
        setSize(700,500);
        setIconImage(logo.getImage());
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
       
        p.setBackground(new Color(173,216,230));
        
        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);
        
        l1 = new JLabel("Customer Name");
        l1.setBounds(100, 80, 100, 20);
        
        t1 = new JTextField();
        t1.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Customer Id");
        l2.setBounds(100, 120, 100, 20);
        
        l11 = new JTextField();
        l11.setBounds(240, 120, 200, 20);
        p.add(l2);
        p.add(l11);
        l3 = new JLabel("Address");
        l3.setBounds(100, 160, 100, 20);
        t3 = new JTextField();
        t3.setBounds(240, 160, 200, 20);
        p.add(l3);
        p.add(t3);
        l5 = new JLabel("City");
        l5.setBounds(100, 200, 100, 20);
        t5 = new JTextField();
        t5.setBounds(240, 200, 200, 20);
        p.add(l5);
        p.add(t5);
       
        l7 = new JLabel("Phone Number");
        l7.setBounds(100, 250, 100, 20);
        t7 = new JTextField();
        t7.setBounds(240, 250, 200, 20);
        p.add(l7);
        p.add(t7);
        
        b1 = new JButton("Next");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        
        
        add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String name = t1.getText();
            String meter = l11.getText();
            String address = t3.getText();
            
            String city = t5.getText();
            
            String phone = t7.getText();

            String q1 = "insert into customers values('"+meter+"','"+name+"','"+address+"','"+phone+"','"+city+"')";
//            String q2 = "insert into pa values('"+meter+"', '', '', '', '')";
            try{
                Conn c1 = new Conn();
                c1.Stmt.executeUpdate(q1);
//                c1.Stmt.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                this.setVisible(false);
                

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() ==b2){
                this.setVisible(false);
                }
    }
    
    
    public static void main(String[] args){
        new NewCustomer().setVisible(true);
    }
}
