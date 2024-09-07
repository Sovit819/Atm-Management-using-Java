
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String card_number, pin_number;
    
    BalanceEnquiry(String card_number, String pin_number){
        
        this.card_number = card_number;
        this.pin_number = pin_number;
        
        setLayout(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = i.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        
        JLabel image = new JLabel(img);
        image.setBounds(0,0,800,700);
        add(image);
        
        try{
            Connec c = new Connec();
            String query = "SELECT Total_Balance FROM transaction WHERE card_number='"+card_number+"'";
            ResultSet result = c.s.executeQuery(query);
            
            if(result.last()){
                String total_amount = result.getString("Total_Balance");
                long amount = Long.parseLong(total_amount);
                JLabel text = new JLabel("Your Balance is Rs."+amount);
                text.setFont(new Font("Arial", Font.BOLD, 18));
                text.setForeground(Color.WHITE);
                text.setBounds(175,260,300,25);
                image.add(text);
            }
            
            else{
                long amount = 0;
                JLabel text = new JLabel("Your Balance is Rs."+amount);
                text.setFont(new Font("Arial", Font.BOLD, 18));
                text.setForeground(Color.WHITE);
                text.setBounds(175,260,300,25);
                image.add(text);
            }
        }
        
        catch(Exception e6){
            System.out.println(e6); 
        }
        
         back = new JButton("Back");
         back.setFont(new Font("Arial", Font.BOLD, 18));
         back.setBounds(320,377,140,22);
         back.addActionListener(this);
         image.add(back);
        
        setSize(800,700);
        setLocation(400,80);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        setVisible(false);
        new Transaction(card_number, pin_number).setVisible(true);
        
    }
    
//    public static void main(String[] args){
//        new BalanceEnquiry("","");
//    }
}
