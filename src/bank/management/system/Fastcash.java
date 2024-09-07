
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton c1,c2,c3,c4,c5,c6,back;
    String card_number, pin_number;
    
    Fastcash(String card_number, String pin_number){
    
        this.card_number = card_number;
        this.pin_number = pin_number;
        setLayout(null);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = i.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        
        JLabel image = new JLabel(img);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("Select your choice");
        text.setFont(new Font("Calibri", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        text.setBounds(220,250,150,20);
        image.add(text);
        
        c1 = new JButton("Rs 100");
        c1.setFont(new Font("Arial", Font.BOLD, 18));
        c1.setBounds(138, 325, 140, 22);
        c1.addActionListener(this);
        image.add(c1);
        
        c2 = new JButton("Rs 500");
        c2.setFont(new Font("Arial", Font.BOLD, 18));
        c2.setBounds(320, 325, 140, 22);
        c2.addActionListener(this);
        image.add(c2);
        
        c3 = new JButton("Rs 1000");
        c3 .setFont(new Font("Arial", Font.BOLD, 18));
        c3 .setBounds(138, 352, 140, 22);
        c3 .addActionListener(this);
        image.add(c3 );
        
        c4 = new JButton("Rs 2000");
        c4.setFont(new Font("Arial", Font.BOLD, 18));
        c4.setBounds(320, 352, 140, 22);
        c4.addActionListener(this);
        image.add(c4);
        
        c5 = new JButton("Rs 5000");
        c5 .setFont(new Font("Arial", Font.BOLD, 18));
        c5 .setBounds(138, 379, 140, 22);
        c5 .addActionListener(this);
        image.add(c5 );
        
        c6 = new JButton("Rs 10000");
        c6.setFont(new Font("Arial", Font.BOLD, 18));
        c6.setBounds(320, 379, 140, 22);
        c6.addActionListener(this);
        image.add(c6);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBounds(320, 406, 140, 22);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,700);
        setLocation(400,80);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(card_number,pin_number).setVisible(true);
        }
        
        else{
            Date date = new Date();
            String bal = ((JButton)e.getSource()).getText().substring(3);
            long amount = Long.parseLong(bal);
            String Type_of_Transaction = "Fast Cash";
            String Total_Balance;
            
            try{
                Connec c = new Connec();
                String query = "SELECT Total_Balance FROM transaction WHERE card_number='"+card_number+"' ";
                ResultSet result = c.s.executeQuery(query);
               
                if(result.last()){
                
                    String check = result.getString("Total_Balance");
                    long TotalAmount = Long.parseLong(check);
                    
                    if(TotalAmount < amount)
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    
                    else{
                    
                        long update = TotalAmount - amount;
                        Total_Balance = Long.toString(update);
                       
                        String query1 = "INSERT INTO transaction values('"+card_number+"', '"+pin_number+"', '"+date+"', '"+Type_of_Transaction+"', '"+amount+"', '"+Total_Balance+"')";
                        c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null, "You have withdrawn "+amount+" successfully");
                        setVisible(false);
                        new Transaction(card_number, pin_number).setVisible(true);
                    }
                }
                
                else{
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }
            }
            
            catch(Exception e6){
                System.out.println(e6);
            }
        }
    }
    
//    public static void main(String[] args){
//        new Fastcash("","");
//    }
}
