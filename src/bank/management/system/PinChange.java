
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PinChange extends JFrame implements ActionListener {
    
    JButton change,back;
    JPasswordField newpinfield, confirmpinfield;
    String card_number, pin_number;
    
    PinChange(String card_number, String pin_number){
        
        this.card_number = card_number;
        this.pin_number = pin_number;
        
        setLayout(null);
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = i.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        JLabel image = new JLabel(img);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        JLabel newpin = new JLabel("Enter your new 4 digit PIN: ");
        newpin.setFont(new Font("Calibri", Font.BOLD, 17));
        newpin.setForeground(Color.white);
        newpin.setBounds(150,240,200,22);
        image.add(newpin);
        
        newpinfield = new JPasswordField();
        newpinfield.setFont(new Font("Arial", Font.BOLD, 20));
        newpinfield.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        newpinfield.setBounds(345,240,100,22);
        image.add(newpinfield);
        
        JLabel confirmpin = new JLabel("Re-type your new PIN: ");
        confirmpin.setFont(new Font("Calibri", Font.BOLD, 17));
        confirmpin.setForeground(Color.white);
        confirmpin.setBounds(150,270,200,22);
        image.add(confirmpin);
        
        confirmpinfield = new JPasswordField();
        confirmpinfield.setFont(new Font("Arial", Font.BOLD, 20));
        confirmpinfield.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        confirmpinfield.setBounds(345,270,100,22);
        image.add(confirmpinfield);
        
        change = new JButton("Change");
        change.setFont(new Font("Arial", Font.BOLD, 16));
        change.setBounds(138,352,140,22);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBounds(320 ,379,140,22);
        back.addActionListener(this);
        image.add(back);  
        
        
        setSize(800,700);
        setLocation(400,80);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()== back){
            setVisible(false);
            new Transaction(card_number, pin_number).setVisible(true);
        }
        
        else if(e.getSource() == change){

            try{
                char [] newpin = newpinfield.getPassword();
                String newpinnumber = String.valueOf(newpin);
                char[] confirmpin = confirmpinfield.getPassword();
                String confirmpinnumber = String.valueOf(confirmpin);
                
                if(newpinnumber.isEmpty() || confirmpinnumber.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please enter both of the fields", "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(!newpinnumber.equals(confirmpinnumber)){
                    JOptionPane.showMessageDialog(this, "New pin and Confirm pin do not match", "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(newpinnumber.length() != 4 || confirmpinnumber.length() != 4){
                    JOptionPane.showMessageDialog(this, "Pin should contains only 4 digits", "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                boolean isNumeric = newpinnumber.matches("\\d+") && confirmpinnumber.matches("\\d+");
                if(!isNumeric){
                    JOptionPane.showMessageDialog(this, "PIN should consist of only numbers", "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Connec c = new Connec();
                String query1 ="UPDATE signupthree SET pin_number='"+confirmpinnumber+"' WHERE pin_number='"+pin_number+"'"; 
                String query2 ="UPDATE login SET pin_number='"+confirmpinnumber+"' WHERE pin_number='"+pin_number+"'"; 
                String query3 ="UPDATE transaction SET pin_number='"+confirmpinnumber+"' WHERE pin_number='"+pin_number+"'"; 
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(this, "PIN is changed successfully", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
                new Transaction(card_number, pin_number).setVisible(true);
            }
            
            catch(Exception e7){
                System.out.println(e7);
            }
        }
        
    }
        
//    public static void main(String[] args){
//        new PinChange("","");
//    }
}
