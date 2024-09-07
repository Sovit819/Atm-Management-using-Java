
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JComboBox religionfield, categoryfield, incomefield, eduQualfield, occupationfield;
    JTextField citizenshipnofield,pannofield;
    JRadioButton senioryes, seniorno, existyes, existno;
    JButton next;
    String Application_no;
    
    SignupTwo(String Application_no){

        this.Application_no = Application_no;
        setLayout(null); 
        setTitle("New Application Form: page 2");
        
        JLabel additional_info = new JLabel("<html><u>Page 2 : Additional Information</u></html>");
        additional_info.setFont(new Font("Arial", Font.BOLD, 20));
        additional_info.setBounds(280,50,300,20);
        add(additional_info);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Times Roman", Font.BOLD, 18));
        religion.setBounds(80,120,100,25);
        add(religion);
        
        String religion_value[] = {"--Select--", "Hindu", "Muslim", "Buddhist", "Christian", "Others"};
        religionfield = new JComboBox(religion_value);
        religionfield.setBackground(Color.WHITE);
        religionfield.setFont(new Font("Raleway", Font.PLAIN, 16));
        religionfield.setBounds(300, 120, 300, 25);
        add(religionfield);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Times Roman", Font.BOLD, 18));
        income.setBounds(80,160,100,25);
        add(income);
        
        String income_value[] = {"--Select--","Null", "<1,00,000", "<5,00,000", "<10,00,000",">10,00,000"};
        incomefield = new JComboBox(income_value);
        incomefield.setBackground(Color.WHITE);
        incomefield.setFont(new Font("Raleway", Font.PLAIN, 16));
        incomefield.setBounds(300, 160, 300, 25);
        add(incomefield);
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Times Roman", Font.BOLD, 18));
        education.setBounds(80,200,150,20);
        add(education);        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Times Roman", Font.BOLD, 18));
        qualification.setBounds(80, 220, 150, 20);
        add(qualification);  
        
        String education_value[] = {"--Select--", "Uneducated", "School", "High School","Under-Graduation", "Graduation", "Post-Graduation","Others"};
        eduQualfield = new JComboBox(education_value);
        eduQualfield.setBackground(Color.WHITE);
        eduQualfield.setFont(new Font("Raleway", Font.PLAIN, 16));
        eduQualfield.setBounds(300, 220, 300, 25);
        add(eduQualfield);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Times Roman", Font.BOLD, 18));
        occupation.setBounds(80,260,150,25);
        add(occupation);
        
        String occupation_value[] = {"--Select--", "Salary", "Self-Employed", "Businessman","Retired","Others"};
        occupationfield = new JComboBox(occupation_value);
        occupationfield.setBackground(Color.WHITE);
        occupationfield.setFont(new Font("Raleway", Font.PLAIN, 16));
        occupationfield.setBounds(300, 260, 300, 25);
        add(occupationfield);
        
        JLabel citizenshipno = new JLabel("Citizenship Number:");
        citizenshipno.setFont(new Font("Times Roman", Font.BOLD, 18));
        citizenshipno.setBounds(80,300,200,25);
        add(citizenshipno);
        
        citizenshipnofield = new JTextField();
        citizenshipnofield.setFont(new Font("Raleway", Font.PLAIN,  16));
        citizenshipnofield.setBounds(300, 300, 300, 25);
        add(citizenshipnofield);
        
        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Times Roman", Font.BOLD, 18));
        panno.setBounds(80,340,250,25);
        add(panno);
        
        pannofield = new JTextField();
        pannofield.setFont(new Font("Raleway", Font.PLAIN,  16));
        pannofield.setBounds(300, 340, 300, 25);
        add(pannofield);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Times Roman", Font.BOLD, 18));
        senior.setBounds(80, 380, 250, 25);
        add(senior);
        
        senioryes = new JRadioButton("Yes");
        senioryes.setBackground(Color.WHITE);
        senioryes.setBounds(300, 380, 100, 25);
        add(senioryes);
        
        seniorno = new JRadioButton("No");
        seniorno.setBackground(Color.WHITE);
        seniorno.setBounds(400, 380, 100, 25);
        add(seniorno);
        
        ButtonGroup seniorbtn = new ButtonGroup();
        seniorbtn.add(senioryes);
        seniorbtn.add(seniorno);
        
        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Times Roman", Font.BOLD,18));
        existing.setBounds(80, 420, 300, 25);
        add(existing);
        
        existyes = new JRadioButton("Yes");
        existyes.setBackground(Color.WHITE);
        existyes.setBounds(300, 420, 100, 25);
        add(existyes);
        
        existno = new JRadioButton("No");
        existno.setBackground(Color.WHITE);
        existno.setBounds(400, 420, 100, 25);
        add(existno);
        
        ButtonGroup existingbtn = new ButtonGroup();
        existingbtn.add(existyes);
        existingbtn.add(existno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.CYAN);
        next.setBounds(600, 500, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,650);
        setLocation(400,100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        String Religion = (String)religionfield.getSelectedItem();
        String Income = (String)incomefield.getSelectedItem();
        String Education = (String)eduQualfield.getSelectedItem();
        String Occupation = (String)occupationfield.getSelectedItem();
        String Citizenship_Number = citizenshipnofield.getText();
        String Pan_Number = pannofield.getText();
        String Senior_Citizen = null;
        if(senioryes.isSelected())
            Senior_Citizen = "Yes";
        else if(seniorno.isSelected())
            Senior_Citizen = "No";
        
        String Existing_Account = null;
        if(existyes.isSelected())
            Existing_Account = "Yes";
        else if(existno.isSelected())
            Existing_Account = "No";
        
        try{
            Connec c = new Connec();
            String query = "INSERT into signupTwo values('"+Application_no+"','"+Religion+"', '"+Income+"', '"+Education+"', '"+Occupation+"', '"+Citizenship_Number+"', '"+Pan_Number+"', '"+Senior_Citizen+"', '"+Existing_Account+"')";
            c.s.executeUpdate(query);
            
            if(e.getSource()==next)
                setVisible(false);
                new signupThree(Application_no).setVisible(true);
                
        }
        
        catch(Exception e2){
            System.out.println(e2);
        }
    }
    
//    public static void main(String[] args){
//        
//        new SignupTwo("");
//    }
}
