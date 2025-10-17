import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Search extends JFrame implements ActionListener{
  private JPanel panel;
  private JLabel titleLabel;
  private JTextField nameTxt;
  private JTextArea result;
  private JButton search;
  private JButton back;


  public Search(){
    super ("Hospital Management System");
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setSize(400, 400);

    titleLabel = new JLabel("Search Users", SwingConstants.CENTER);
    titleLabel.setForeground(Color.BLUE);
    titleLabel.setFont(new Font ("", Font.BOLD,20));
    

    nameTxt = new JTextField(30);
    result = new JTextArea(10, 30);
    search = new JButton("Search");

    back = new JButton("Back to MainPage");

    panel = new JPanel();
    panel.add(nameTxt); panel.add(result);
    panel.add(search);
    search.addActionListener(this);
    back.addActionListener(this);
    panel.add(back);


    this.add(titleLabel, BorderLayout.NORTH);
    this.add(panel, BorderLayout.CENTER);
    setVisible(true);
  }

  @Override 
    public void actionPerformed(ActionEvent e){
      String actionCommand = e.getActionCommand();


      if (actionCommand.equals("Search")) {
        result.setText(""); 

        String name = nameTxt.getText();
        boolean found = false;
        for(int i = 0; i < Database.users.size(); i++){
          UserInterface u = Database.users.get(i);
          if(u.getName().equalsIgnoreCase(name)){
            found = true;
            // result .append("Name: " + u.getName() + "\n" + "Email: " + u.getEmail() + "\n" + "Password: " + u.getPassword() + "\n");
            result.append( u.toString());
            if (u instanceof Doctor) {
              Doctor d = (Doctor) u;
              result.append("Specialization:" + d.getSpecialization());
            }else if (u instanceof Patient) {
              Patient p = (Patient) u;
              result.append("BloodType: " + p.getBloodType());
            }
          }

          // if (u.getSpecialization().equalsIgnoreCase(name)) {
            
          // }
        }
        if(!found ){
          result.setText("No user found with that name ");
        }
    }
    else if (actionCommand.equals("Back to MainPage")) {
        dispose();
        new MainMenu();
      
    }
  }

public static void main(String[] args) {
  new Search();
}
}
