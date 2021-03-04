/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebilling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author CORECOMP
 */
public class Payments extends JFrame implements ActionListener {
    
    ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icon/muktai logo.jpg"));
    JFrame j;
    JScrollPane pane;
    JTextField amt,date,bal;
    JLabel l1,l2;
    JButton submit,clear,back,print;
    JTable t1;
    int id,j1=0,i=0, bala;
    String x[] = {"Date","Amount","balance",""};
    String y[][] = new String[40][4];
    public Payments(int id){
        this.id = id;
        j = new JFrame("Payments");
        j.setLayout(null);
        j.getContentPane().setBackground(Color.WHITE);
        j.setLocation(300, 100);
        j.setIconImage(logo.getImage());
        
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from payments where id='"+id+"'";
            ResultSet rs  = c1.Stmt.executeQuery(s1);
            
            while(rs.next()){
                y[i][j1++]=rs.getString("dt");
                y[i][j1++]=rs.getString("amount");
                y[i][j1++]=rs.getString("balance");
                String b = rs.getString("balance");
                bala = Integer.parseInt(b);
               
                i++;
                j1=0;
                
            }
             t1 = new JTable(y,x);
            
                 }catch(Exception e){
            e.printStackTrace();
        }
        
        l1 = new JLabel("Amount");
        l1.setBounds(20,20,100,30);
        l1.setFont(l1.getFont().deriveFont(18.0f));
        j.add(l1);
        
        amt = new JTextField();
        amt.setBounds(20,70,100,30);
        j.add(amt);
        
        l2 = new JLabel("Balance");
        l2.setBounds(20,110,100,30);
        l2.setFont(l1.getFont().deriveFont(18.0f));
        j.add(l2);
        
        bal = new JTextField();
        bal.setBounds(20,150,100,30);
        j.add(bal);
        
        l2 = new JLabel("Date");
        l2.setBounds(20,190,100,30);
        l2.setFont(l1.getFont().deriveFont(18.0f));
        j.add(l2);
        
        date = new JTextField();
        date.setBounds(20,230,100,30);
        j.add(date);
        
        pane = new JScrollPane(t1);
        pane.setBounds(130,0,650,750);
        j.add(pane);
        
        submit = new JButton("Submit");
        submit.setBounds(20,280,100,30);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        j.add(submit);
        
        clear = new JButton("Clear 5");
        clear.setBounds(20,320,100,30);
        clear.addActionListener(this);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        j.add(clear);
            
        print = new JButton("Print");
        print.setBounds(20,380,100,30);
        print.addActionListener(this);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        j.add(print);
        
        back = new JButton("Back");
        back.setBounds(20,430,100,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        j.add(back);
        
        j.setSize(800,800);
        j.setVisible(true);
    }
    
    public static void main(String[] args){
        Payments p= new Payments(8788);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit){
           String amount = amt.getText();
           String balance = bal.getText();
           if(bal.equals("")){
               balance="0";
           }
          if(bala>0){
               balance = Integer.toString(bala-Integer.parseInt(amount));
              if(Integer.parseInt(balance)<=0){
                  balance = "0";
              }
          }
          if(amount.equals("")){
              amount="0";
          }
           String id1 = Integer.toString(id);
           String date1 = date.getText();
            try{
            Conn c  = new Conn();
//             String sql = "insert into payments value("+id+","+amount+","+balance+",sysdate());";
//            c.insert = c.con.prepareStatement(sql);
//            c.insert.setInt(1, id);
//            c.insert.setInt(2, amount);
//            c.insert.setInt(3, balance);
//            System.out.println(sql);
String sql;
            if(date1.equals("")){
                sql= "insert into payments value( "+id+","+amount+","+balance+","+"sysdate());";
            }
            else{
          sql= "insert into payments value( "+id+","+amount+","+balance+",'"+date1+"');";
          
            }
            c.Stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Submitted SuccessFully!!!");
            j.setVisible(false);
            }
            catch(Exception EXE){
                System.out.print(EXE);
            }
       }
       else if(e.getSource()==clear){
           try{
            Conn c1  = new Conn();
            String sql = "delete  from payments where id ='"+id+"' limit 5";
            c1.Stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Deleted SuccessFully!!!");
            }
            catch(Exception EXE){
                
            }
       }
       else if(e.getSource()==print){
           try{
            t1.print();
        }catch(Exception e1){}
       }
       else{
           j.setVisible(false);
           
       }
    }
    
}
