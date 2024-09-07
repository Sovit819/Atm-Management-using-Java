
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    int ranint;
    JTextField namefield, fnamefield, phonefield, emailfield, addressfield, cityfield, countryfield, pincodefield;
    JDateChooser datechoose;
    JRadioButton male, female, others, married, unmarried, other;
    JButton next;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ranno = new Random();
        ranint = Math.abs(ranno.nextInt(9999));
        
        JLabel formno = new JLabel("APPLICATION FORM NO : "+ranint);
        formno.setFont(new Font("Time Roman", Font.BOLD, 19));
        formno.setBounds(480, 30, 300, 20);
        formno.setForeground(Color.RED);
        add(formno);
        
        JLabel persondet = new JLabel("Page 1: Personal Details");
        persondet.setFont(new Font("Arial", Font.BOLD, 16));
        persondet.setBounds(260, 80, 200, 20);
        add(persondet);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Time Roman", Font.BOLD, 18));
        name.setBounds(80,140,100,20);
        add(name);
        
        namefield = new JTextField();
        namefield.setFont(new Font("Arial",Font.PLAIN, 16));
        namefield.setBounds(300, 140, 300, 22);
        add(namefield);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Time Roman", Font.BOLD, 18));
        dob.setBounds(80,180,150,20);
        add(dob);
        
        datechoose = new JDateChooser();
        Calendar calendar = Calendar.getInstance();
        //To get current date as system date i.e as of JVM
        Date currentDate = calendar.getTime();
        datechoose.setMaxSelectableDate(currentDate); 
        datechoose.setBounds(300, 180, 300, 22);
        add(datechoose);
        
        JLabel fname = new JLabel("Father's name:");
        fname.setFont(new Font("Time Roman", Font.BOLD, 18));
        fname.setBounds(80,220,150,20);
        add(fname);
        
        fnamefield = new JTextField();
        fnamefield.setFont(new Font("Arial", Font.PLAIN, 16));
        fnamefield.setBounds(300, 220, 300, 22);
        add(fnamefield);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Time Roman", Font.BOLD, 18));
        gender.setBounds(80,260,100,20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,260,80,20);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400,260,80,20);
        female.setBackground(Color.WHITE);
        add(female);
        
        others = new JRadioButton("Other");
        others.setBounds(500,260,80,20);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup genderbtn = new ButtonGroup();
        genderbtn.add(male);
        genderbtn.add(female);
        genderbtn.add(others);
        
        JLabel phone = new JLabel("Phone Number:");
        phone.setFont(new Font("Time Roman", Font.BOLD, 18));
        phone.setBounds(80,300,200,20);
        add(phone);
        
        phonefield = new JTextField();
        phonefield.setFont(new Font("Arial", Font.PLAIN, 16));
        phonefield.setBounds(300, 300, 300, 22);
        add(phonefield);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Time Roman", Font.BOLD, 18));
        email.setBounds(80,340,200,20);
        add(email);
        
        emailfield = new JTextField();
        emailfield.setFont(new Font("Arial", Font.PLAIN, 16));
        emailfield.setBounds(300, 340, 300, 22);
        add(emailfield);
        
        JLabel maritalstat = new JLabel("Marital Status:");
        maritalstat.setFont(new Font("Time Roman", Font.BOLD, 18));
        maritalstat.setBounds(80,380,150,20);
        add(maritalstat);
        
        married = new JRadioButton("Married");
        married.setBounds(300,380,100,20);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,380,100,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Others");
        other.setBounds(500,380,100,20);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup marriedbtn = new ButtonGroup();
        marriedbtn.add(married);
        marriedbtn.add(unmarried);
        marriedbtn.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Time Roman", Font.BOLD, 18));
        address.setBounds(80,420,150,20);
        add(address);
        
        addressfield = new JTextField();
        addressfield.setFont(new Font("Arial", Font.PLAIN, 16));
        addressfield.setBounds(300, 420, 300, 22);
        add(addressfield);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Time Roman", Font.BOLD, 18));
        city.setBounds(80,460,150,20);
        add(city);
        
        cityfield = new JTextField();
        cityfield.setFont(new Font("Arial", Font.PLAIN, 16));
        cityfield.setBounds(300, 460, 300, 22);
        add(cityfield);
        
        JLabel country = new JLabel("Country:");
        country.setFont(new Font("Time Roman", Font.BOLD, 18));
        country.setBounds(80,500,150,20);
        add(country);
        
        countryfield = new JTextField();
        countryfield.setFont(new Font("Arial", Font.PLAIN, 16));
        countryfield.setBounds(300, 500, 300, 22);
        add(countryfield);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Time Roman", Font.BOLD, 18));
        pincode.setBounds(80,540,150,20);
        add(pincode);
        
        pincodefield = new JTextField();
        pincodefield.setFont(new Font("Arial", Font.PLAIN, 16));
        pincodefield.setBounds(300, 540, 300, 22);
        add(pincodefield);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.CYAN);
        next.setBounds(600, 600, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,700);
        setLocation(400,80);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String Application_no = Integer.toString(ranint);  // can be converted into string using "" + infront of ranint
        String Name = namefield.getText();
        String Date_of_Birth = ((JTextField)datechoose.getDateEditor().getUiComponent()).getText();
        String Father_Name = fnamefield.getText();
        String Gender = null;
        if(male.isSelected())
            Gender = "Male";
        else if(female.isSelected())
            Gender = "Female";
        else if(others.isSelected())
            Gender = "Other";
        String Phone = phonefield.getText();
        String Email = emailfield.getText();
        String Marital_Status = null;
        if(married.isSelected())
            Marital_Status = "Married";
        else if(unmarried.isSelected())
            Marital_Status = "Unmarried";
        else if(other.isSelected())
            Marital_Status = "Others";
        String Address = addressfield.getText();
        String City = cityfield.getText();
        String Country = countryfield.getText();
        String Pincode = pincodefield.getText();
        
        try{
            if(Name.isBlank())
                JOptionPane.showMessageDialog(namefield, "Name is required");
            else if(Date_of_Birth.isBlank())
                JOptionPane.showMessageDialog(datechoose, "DOB is required");
            else if(Father_Name.isBlank())
                JOptionPane.showMessageDialog(fnamefield, "Father's name is required");
            else if(Phone.isBlank())
                JOptionPane.showMessageDialog(fnamefield, "Phone number is required");
            else if(Email.isBlank())
                JOptionPane.showMessageDialog(emailfield, "Father's name is required");
            else if(Address.isBlank())
                JOptionPane.showMessageDialog(addressfield, "Father's name is required");
            else if(Pincode.isBlank())
                JOptionPane.showMessageDialog(pincodefield, "Father's name is required");
            else{
                Connec c = new Connec();
                String query = "insert into signup values('"+Application_no+"', '"+Name+"', '"+Date_of_Birth+"', '"+Father_Name+"', '"+Gender+"', '"+Phone+"', '"+Email+"', '"+Marital_Status+"', '"+Address+"', '"+City+"','"+Country+"', '"+Pincode+"')";
                c.s.executeUpdate(query);
                
                if(e.getSource()==next){
                  
                    setVisible(false);                    
                    new SignupTwo(Application_no).setVisible(true);
                }
            }
            
        }
        
        catch(Exception e1){
            System.out.println(e1);
        }
    }
    
//    public static void main(String args[]){
//        new SignupOne();
//    }
}


