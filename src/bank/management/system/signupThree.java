
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener{
    
    JRadioButton saving, current, fixdeposit;
    JCheckBox atm, mobilebanking, internetbanking, emailalert, smsalert, chequebook, agree;
    JButton cancel,previous,submit;
    String Application_no;
    
    signupThree(String Application_no){
        
        this.Application_no = Application_no;
        setLayout(null);
        
        JLabel account_details = new JLabel("<html><u>Page 3 : Account Details</u></html>");
        account_details.setFont(new Font("Arial", Font.BOLD, 20));
        account_details.setBounds(280,40,250,25);
        add(account_details);
                
        JLabel account_type = new JLabel("Account Type");
        account_type.setFont(new Font("Times Roman", Font.BOLD, 18));
        account_type.setBounds(80,120,200,25);
        add(account_type);
        
        saving = new JRadioButton("Saving Account ");
        saving.setFont(new Font("Raleway", Font.BOLD, 15));
        saving.setBackground(Color.WHITE);
        saving.setBounds(90, 160, 200, 22);
        add(saving);
        
        current = new JRadioButton("Current Account ");
        current.setFont(new Font("Raleway", Font.BOLD, 15));
        current.setBackground(Color.WHITE);
        current.setBounds(320, 160, 200, 22);
        add(current);
        
        fixdeposit = new JRadioButton("Fixed Deposit Account ");
        fixdeposit.setFont(new Font("Raleway", Font.BOLD, 15));
        fixdeposit.setBackground(Color.WHITE);
        fixdeposit.setBounds(90, 190, 200, 22);
        add(fixdeposit);
        
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(saving);
        acctype.add(current);
        acctype.add(fixdeposit);
        
        JLabel card_number = new JLabel("CARD NUMBER :");
        card_number.setFont(new Font("Times Roman", Font.BOLD, 18));
        card_number.setBounds(80,250,200,25);
        add(card_number);
        
        JLabel dummy_cardno = new JLabel("XXXX-XXXX-XXXX-XXXX");
        dummy_cardno.setFont(new Font("Times Roman", Font.BOLD, 18));
        dummy_cardno.setBounds(300,250,300,25);
        add(dummy_cardno);
        
        JLabel card_det = new JLabel("your 16 digit card number will be generated once you click submit");
        card_det.setFont(new Font("Raleway", Font.BOLD, 14));
        card_det.setBounds(300,270,500,20);
        add(card_det);
        
        JLabel pin_number = new JLabel("PIN NUMBER :");
        pin_number.setFont(new Font("Times Roman", Font.BOLD, 18));
        pin_number.setBounds(80,320,200,25);
        add(pin_number);
        
        JLabel dummy_pinno = new JLabel("XXXX");
        dummy_pinno.setFont(new Font("Times Roman", Font.BOLD, 18));
        dummy_pinno.setBounds(300,320,300,25);
        add(dummy_pinno);
        
        JLabel pin_det = new JLabel("your 4 digit pin number will be generated once you click submit");
        pin_det.setFont(new Font("Raleway", Font.BOLD, 14));
        pin_det.setBounds(300,340,500,20);
        add(pin_det);
        
        JLabel services = new JLabel("Sevices :");
        services.setFont(new Font("Times Roman", Font.BOLD, 18));
        services.setBounds(80,390,200,25);
        add(services);
        
        atm = new JCheckBox("Atm Card");
        atm.setFont(new Font("Raleway", Font.BOLD, 15));
        atm.setBackground(Color.WHITE);
        atm.setBounds(90, 430, 150, 22);
        add(atm);
        
        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setFont(new Font("Raleway", Font.BOLD, 15));
        mobilebanking.setBackground(Color.WHITE);
        mobilebanking.setBounds(300, 430, 200, 22);
        add(mobilebanking);
        
        internetbanking = new JCheckBox("Internet Banking");
        internetbanking.setFont(new Font("Raleway", Font.BOLD, 15));
        internetbanking.setBackground(Color.WHITE);
        internetbanking.setBounds(500, 430, 200, 22);
        add(internetbanking);
        
        emailalert = new JCheckBox("Email Alert");
        emailalert.setFont(new Font("Raleway", Font.BOLD, 15));
        emailalert.setBackground(Color.WHITE);
        emailalert.setBounds(90, 470, 150, 22);
        add(emailalert);
        
        smsalert = new JCheckBox("SMS Alert");
        smsalert.setFont(new Font("Raleway", Font.BOLD, 15));
        smsalert.setBackground(Color.WHITE);
        smsalert.setBounds(300, 470, 150, 22);
        add(smsalert);
        
        chequebook = new JCheckBox("Cheque Book");
        chequebook.setFont(new Font("Raleway", Font.BOLD, 15));
        chequebook.setBackground(Color.WHITE);
        chequebook.setBounds(500, 470, 150, 22);
        add(chequebook);
        
        agree = new JCheckBox(" I, hereby , declare that the above information is correct.");
        agree.setFont(new Font("Raleway", Font.BOLD, 15));
        agree.setBackground(Color.WHITE);
        agree.setBounds(80, 520, 600, 22);
        add(agree);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.CYAN);
        cancel.setBounds(380, 580, 100, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        previous = new JButton("Previous");
        previous.setFont(new Font("Raleway", Font.BOLD, 18));
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.CYAN);
        previous.setBounds(500, 580, 120, 25);
        previous.addActionListener(this);
        add(previous);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.CYAN);
        submit.setBounds(640, 580, 100, 25);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,700);
        setVisible(true);
        setLocation(400, 100);
    }
    
    public void actionPerformed(ActionEvent e){
                    
            String Account_type = null;                         //For Account Type
            if(saving.isSelected())
                Account_type ="Saving Account";
           else if(current.isSelected())
                Account_type = "Current Account";
            else if(fixdeposit.isSelected())
                Account_type = "Fixed Deposit Account";
                        
            String Services = "";                               //For Services
            if(atm.isSelected())
                Services = Services + " Atm Card";
            if(mobilebanking.isSelected())
                Services = Services + "Mobile Banking";
            if(internetbanking.isSelected())
                Services = Services + "Internet Banking";
            if(emailalert.isSelected())
                Services = Services + "Email Alert";
            if(smsalert.isSelected())
                Services = Services + "SMS Alert";
            if(chequebook.isSelected())
                Services = Services + "Cheque Book";
            try{
                if(Account_type.equals(null))
                    JOptionPane.showMessageDialog(null, "Choose Account type");
                
//                else if()
//                    JOptionPane.showMessageDialog(null, "Check on the agree box");
                else{                                        
                    Connec c = new Connec();
                    
                    if(e.getSource()==submit){
                        
                        //For generating card number and pin number
                        Random ran = new Random();
                        String Card_Number =""+ Math.abs(ran.nextLong(999999999)+8860549000000000L);
                        String Pin_Number = ""+ Math.abs(ran.nextInt(9999));
                        
                        String query = "insert into signupthree values('"+Application_no+"','"+Account_type+"', '"+Card_Number+"', '"+Pin_Number+"', '"+Services+"')";
                        String query1= "insert into login values('"+Card_Number+"', '"+Pin_Number+"')";
                        c.s.executeUpdate(query);
                        c.s.executeUpdate(query1);

                        JOptionPane.showMessageDialog(null, "Card Number: "+Card_Number+"\nPin: "+Pin_Number);

                        setVisible(false);
                        new login().setVisible(true);
                    }
                    
                    else if(e.getSource()==cancel){
                                                
                        int res = JOptionPane.showConfirmDialog(null, "Do you really want to cancel", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);
                        
                        if(res == JOptionPane.YES_OPTION){
                            String query  = "DELETE FROM signuptwo WHERE Application_no='"+Application_no+"'";
                            String query1  = "DELETE FROM signup WHERE Application_no='"+Application_no+"'";
                            c.s.executeUpdate(query);
                            c.s.executeUpdate(query1);
                            
                            setVisible(false);
                            new login().setVisible(true);
                        }
                        
                        else if(res == JOptionPane.NO_OPTION){
                            JOptionPane.getRootFrame().dispose();
                        }
                        
                    }
                }
            }
        
            catch(Exception e3){
                System.out.println(e3);
            }
    }

//    public static void main(String[] args){
//     
//        new signupThree("");        
//    }
    
}
