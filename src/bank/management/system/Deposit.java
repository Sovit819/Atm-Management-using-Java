
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener{
    
    JFormattedTextField deposit_amount;
    JButton deposit,clear,back;
    String card_number, pin_number;
    
    Deposit(String card_number,String pin_number){
        
        this.card_number = card_number;
        this.pin_number = pin_number;
        setLayout(null);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img = i.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(img);
        
        JLabel image = new JLabel(img1);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel label = new JLabel("Enter the amount you want to deposit");
        label.setFont(new Font("Calibri", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setBounds(160, 240, 400, 25);
        image.add(label);
        
        JLabel msg = new JLabel("Max. amount = 50,000");
        msg.setFont(new Font("Calibri", Font.BOLD, 12));
        msg.setForeground(Color.WHITE);
        msg.setBounds(320, 300, 150, 14);
        image.add(msg);
        
        deposit_amount = new JFormattedTextField(currency());
        deposit_amount.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        deposit_amount.setFont(new Font("Arial", Font.BOLD, 16));
        deposit_amount.setBounds(250,270,200,25);
        image.add(deposit_amount);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(138, 325, 140, 22);
        back.addActionListener(this);
        image.add(back);
        
        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(320, 325, 140, 22);
        clear.addActionListener(this);
        image.add(clear);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 14));
        deposit.setBounds(320, 377, 140, 22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        setSize(800,700);
        setLocation(400,80);
        setVisible(true);
    }
    
    private NumberFormatter currency(){
        NumberFormatter amount = new NumberFormatter();
        amount.setMinimum(0);
        return amount;
    }
   
    public void actionPerformed(ActionEvent e){
                
        if(e.getSource()==clear)
            deposit_amount.setValue(null);
        
        else if(e.getSource()==back){
            setVisible(false);
            new Transaction(card_number, pin_number).setVisible(true);
        }
        else if(e.getSource()==deposit){
            Date date = new Date();
            String Type_of_Transaction = "Deposit";
            String Total_Balance;
            long amount;
            try{
                Object check =deposit_amount.getValue();
                if (check instanceof Number){
                    amount = ((Number) check).longValue();
                    if (amount < 500)
                        JOptionPane.showMessageDialog(deposit_amount, "Amount should be more than 500");
                    else if(amount%100 != 0)
                        JOptionPane.showMessageDialog(this, "Amount should be in the multiple of 100");
                    else if(amount > 50000){
                        JOptionPane.showMessageDialog(deposit_amount, "Maximum amount you can deposit is 50,000");
                    }
                    else{        
                        
                        Connec c = new Connec();
                        
                        String query ="SELECT Total_Balance FROM transaction WHERE card_number ='"+card_number+"'";
                        ResultSet result =c.s.executeQuery(query);
                        if (result.last()) {
                            String Total = result.getString("Total_Balance");
                            long TotalAmount =Long.parseLong(Total);
                            long sum =TotalAmount + amount;
                            Total_Balance = Long.toString(sum);
                            
                        }
                        else{
                            long TotalAmount=0;
                            long sum =TotalAmount + amount;
                            Total_Balance = Long.toString(sum);
                        }
                        
                        String query1 = "insert into transaction values('"+card_number+"','"+pin_number+"','"+date+"','"+Type_of_Transaction+"','"+amount+"','"+Total_Balance+"')";
                        c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null, "You have deposited "+amount+" successfully");
                        setVisible(false);
                        new Transaction(card_number, pin_number).setVisible(true);
                        }
                }
            }
            catch(Exception e4){
                System.out.println(e4);
            }
        }
    }
    
//    public static void main(String[] args){
//        new Deposit("","");
//    }
}
