
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    
    JButton signin, signup, clear;
    JTextField cardfield;
    JPasswordField pinfield;
    login(){
        
        setLayout(null);
        setTitle("ATM Machine");
        
        //For inserting the photo
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i1 = img1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //For resizing the photo
        ImageIcon img2 = new ImageIcon(i1);
        JLabel label = new JLabel(img2);
        label.setBounds(60,30,100,100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("BREMEN BD BT", Font.BOLD, 40));
        text.setBounds(200,30,500,100);
        add(text);
        
        JLabel cardnumber = new JLabel("CARD NO :");
        cardnumber.setFont(new Font("Times Roman", Font.BOLD, 25));
        cardnumber.setBounds(100,200,180,30);
        add(cardnumber);
        
        cardfield = new JTextField();
        cardfield.setBounds(250, 200, 300, 30);
        cardfield.setFont(new Font("Arial",Font.BOLD, 18));
        add(cardfield);
        
        JLabel pinnumber = new JLabel("PIN           :");
        pinnumber.setFont(new Font("Times Roman", Font.BOLD, 25));
        pinnumber.setBounds(100,240,180,30);
        add(pinnumber);
        
        pinfield = new JPasswordField();
        pinfield.setBounds(250, 240, 300, 30);
        pinfield.setFont(new Font("Arial",Font.BOLD, 18));
        add(pinfield);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(280, 320, 80, 40);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.CYAN);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(400, 320, 80, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.CYAN);
        clear.addActionListener(this);
        add(clear);
       
        signup = new JButton("SIGN UP");
        signup.setBounds(280, 380, 200, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.CYAN);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 600);
        setVisible(true);
        setLocation(300,200);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == signin){
            String card_number = cardfield.getText();
            char [] pin = pinfield.getPassword();
            String pin_number = String.valueOf(pin);
            
            try{
                Connec c = new Connec();
                String query = "select * from login where Card_Number = '"+card_number+"' and Pin_Number = '"+pin_number+"'";
                ResultSet result =(c.s.executeQuery(query));
                
                if(result.next()){
                    setVisible(false);
                    new Transaction(card_number, pin_number).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
            }
            catch(Exception e0){
                System.out.println(e0);
            }
        }
        else if(e.getSource() == clear){
            cardfield.setText("");
            pinfield.setText("");
        }
        else if(e.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new login();
        
    }
}
