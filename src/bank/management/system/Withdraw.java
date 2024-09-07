
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
import javax.swing.text.NumberFormatter;

public class Withdraw extends JFrame implements ActionListener{
    
    JFormattedTextField withdraw_amount;
    JButton withdraw, clear, back;
    String card_number, pin_number;
    
    Withdraw(String card_number, String pin_number){
        
        this.card_number = card_number;
        this.pin_number = pin_number;
        
        setLayout(null);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = i.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        
        JLabel image = new JLabel(img);
        image.setBounds(0,0,800,700);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want withdraw");
        text.setFont(new Font("Calibri", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        text.setBounds(160,240,300,25);
        image.add(text);
        
        withdraw_amount = new JFormattedTextField(currency());
        withdraw_amount.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        withdraw_amount.setFont(new Font("Arial", Font.BOLD, 16));
        withdraw_amount.setBounds(250, 270,200,25);
        image.add(withdraw_amount);
                
        JLabel msg = new JLabel("Max. amount = 15,000");
        msg.setFont(new Font("Calibri", Font.BOLD, 12));
        msg.setForeground(Color.WHITE);
        msg.setBounds(320, 300, 150, 14);
        image.add(msg);
        
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
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Arial", Font.BOLD, 14));
        withdraw.setBounds(320, 377, 140, 22);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
            withdraw_amount.setValue(null);
        
        else if(e.getSource() == back){
            setVisible(false);
            new Transaction(card_number, pin_number).setVisible(true);
        }
   
        else if(e.getSource() == withdraw){
            Date date = new Date();
            String Type_of_Transaction = "Withdraw";
            String Total_Balance;
            long amount;
            try{
                Object check = withdraw_amount.getValue(); //JFormattedTextField returns object if any specific datatype is not mentioned
                
                if(check instanceof Number){   // checks whether the inputted text is Number or not
                    amount = ((Number)check).longValue();
                    if(amount < 100)
                        JOptionPane.showMessageDialog(null, "Minumum amount you can withdraw is 100");
                    else if(amount > 15000)
                        JOptionPane.showMessageDialog(withdraw_amount, "Maximum amount you can withdraw is 15,000");
                    else if(amount%100 != 0)
                        JOptionPane.showMessageDialog(withdraw_amount, "Please enter the amount in the multiple of 100");
                    else{
                        Connec c = new Connec();
                        String query = "SELECT Total_Balance FROM transaction WHERE card_Number='"+card_number+"' ";
                        ResultSet result = c.s.executeQuery(query);
                       
                        if(result.last()){
                           
                            String total = result.getString("Total_Balance");
                            long TotalAmount =Long.parseLong(total);
                           
                            if(TotalAmount < amount)
                                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                           
                            else{
                                
                                long newbalance = TotalAmount - amount;
                                Total_Balance = Long.toString(newbalance);

                                String query1 = "insert into transaction values('"+card_number+"','"+pin_number+"','"+date+"','"+Type_of_Transaction+"','"+amount+"','"+Total_Balance+"')";
                                c.s.executeUpdate(query1);
                                JOptionPane.showMessageDialog(withdraw_amount, "You have withdrawn "+amount+" successfully!");
                                setVisible(false);
                                new Transaction(card_number, pin_number).setVisible(true);
                            }
                        }  
                        
                        else{
                            JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        }
                    }
                }
            }
            
            catch(Exception e5){
                System.out.println(e5);
            }
        }
    }
    
//    public static void main(String[] args){
//        new Withdraw("","");
//    }
}
