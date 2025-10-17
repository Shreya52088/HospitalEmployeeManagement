import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Add extends JFrame implements ActionListener {

        private JPanel panel;
        private JLabel titleLabel;
        private JLabel name;
        private JLabel email;
        private JLabel password;
        private JLabel specialization;
        private JLabel bloodType;
        private JLabel isDoctor;

        private JTextField nameTxt;
        private JTextField emailTxt;
        private JTextField passTxt;
        private JTextField specTxt;
        private JTextField BloodTypeTxt;
        private JTextArea allUserTxt;
        private JButton addButton;
        private JButton backButton;
        private JCheckBox isDoctorCheckBox;
        
        public Add(){
          super("Hospital Management System");

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(500, 500);

            titleLabel = new JLabel("Add user Infomation", SwingConstants.CENTER);
            titleLabel.setForeground(Color.BLUE);
            titleLabel.setFont (new Font ("", Font.BOLD, 20));

            name = new JLabel("Name: ");
            email = new JLabel("Email:");
            password = new JLabel("Password:");
            specialization = new JLabel("Doctor(Specialization): ");
            bloodType = new JLabel("BloodType(Patient):");
            isDoctor = new JLabel("IS Doctor ? ");

            nameTxt = new JTextField();
            emailTxt = new JTextField();
            passTxt = new JTextField();
            specTxt = new JTextField();
            BloodTypeTxt = new JTextField();
            allUserTxt = new  JTextArea();
            isDoctorCheckBox = new JCheckBox();

            addButton = new JButton("Add user");
            backButton = new JButton("Back to Main page");

            panel = new JPanel();
            panel.setBackground(new Color(213, 227, 189));
            panel.setLayout(new GridLayout(4,1));


            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(6,2));
            inputPanel.add(name); inputPanel.add(nameTxt);
            inputPanel.add(email); inputPanel.add(emailTxt);
            inputPanel.add(password); inputPanel.add(passTxt);
            inputPanel.add(specialization); inputPanel.add(specTxt);
            inputPanel.add(bloodType); inputPanel.add(BloodTypeTxt);
            inputPanel.add(isDoctor);inputPanel.add(isDoctorCheckBox);            
            panel.add(inputPanel);

            JPanel btnPanel = new JPanel();
            btnPanel.add(addButton);
            btnPanel.add(backButton);
            panel.add(btnPanel);
            panel.add(allUserTxt);

            allUserTxt.append("User Infomation:\n");
            for(UserInterface u : Database.users){
              allUserTxt.append(u.toString());
            }

            addButton.addActionListener(this);
            backButton.addActionListener(this);

            this.add(titleLabel, BorderLayout.NORTH);
            this.add(panel, BorderLayout.CENTER);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e){
          String actionCommand = e.getActionCommand();
          System.out.println(actionCommand);
          String name = nameTxt.getText();
          String  email = emailTxt.getText();
          String password = passTxt.getText();
          if (actionCommand.equals("Add user")) {
            try{
              if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Please enter the required infomation First!");
              }
              if (password.length() < 8) {
                  throw new IllegalArgumentException("Password must be at least 8 characters long.");
              }
              if (!email.contains("@") || !email.contains(".")) {
                  throw new IllegalArgumentException("Invalid email address.");
              }
              
              UserInterface d;
              if (isDoctorCheckBox.isSelected()) {
                d = new Doctor(nameTxt.getText(),emailTxt.getText(), passTxt.getText(), specTxt.getText());
              }else{
                d = new Patient(nameTxt.getText(),emailTxt.getText(), passTxt.getText(), BloodTypeTxt.getText());
              }  
                Database.users.add(d);
                allUserTxt.append(d.toString());
                JOptionPane.showMessageDialog(this, "Successfully added Users");
                nameTxt.setText("");
                emailTxt.setText("");
                passTxt.setText("");
                specTxt.setText("");
                BloodTypeTxt.setText("");
                isDoctorCheckBox.setSelected(false);
            
            }catch(IllegalArgumentException ex){
              JOptionPane.showMessageDialog(this, ex.getMessage());
            }
          }
          else if(actionCommand.equals("Back to Main page")) {
            dispose();
            new MainMenu();
          }
        }
    public static void main(String[] args) {
      new Add();
    }
}

