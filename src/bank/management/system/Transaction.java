package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastcash, balanceenquery,pinchange, exit;
    String card_number, pin_number;
    Transaction(String card_number, String pin_number) {

        this.card_number = card_number;
        this.pin_number = pin_number;
        setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i = img.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i);
        JLabel image = new JLabel(img1);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel selection = new JLabel("Please select to continue");
        selection.setFont(new Font("Calibri", Font.BOLD, 18));
        selection.setBounds(200, 250, 300, 25);
        selection.setForeground(Color.WHITE);
        image.add(selection);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 14));
        deposit.setBounds(138, 325, 140, 22);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Arial", Font.BOLD, 14));
        withdraw.setBounds(320, 325, 140, 22);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setFont(new Font("Arial", Font.BOLD, 14));
        fastcash.setBounds(138, 352, 140, 22);
        fastcash.addActionListener(this);
        image.add(fastcash);

        balanceenquery = new JButton("Check Balance");
        balanceenquery.setFont(new Font("Arial", Font.BOLD, 14));
        balanceenquery.setBounds(320, 352, 140, 22);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);

        pinchange = new JButton("Pin Change");
        pinchange.setFont(new Font("Arial", Font.BOLD, 14));
        pinchange.setBounds(138, 379, 140, 22);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 14));
        exit.setBounds(320, 406, 140, 22);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800, 700);
        setLocation(400, 80);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(card_number, pin_number).setVisible(true);
        }
        
        else if(e.getSource()==withdraw){
            setVisible(false);
            new Withdraw(card_number, pin_number).setVisible(true);
        }
        
        else if(e.getSource()==fastcash){
            setVisible(false);
            new Fastcash(card_number, pin_number).setVisible(true);
        }
        
        else if(e.getSource()==balanceenquery){
            setVisible(false);
            new BalanceEnquiry(card_number, pin_number).setVisible(true);
        }
        
        else if(e.getSource() == pinchange){
            setVisible(false);
            new PinChange(card_number, pin_number).setVisible(true);
        }
        
        else if(e.getSource()== exit)
            System.exit(0);
    }
    
//    public static void main(String[] args) {
//        new Transaction("","");
//    }
}
