import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
public class MainMenu extends JFrame implements ActionListener {
  private JPanel panel ;
  private JLabel titleLable;
  private JButton addButton;
  private JButton searchButton;
  private JButton exitButton;
  public static List<UserInterface> users = new ArrayList<>();

  public MainMenu(){
    setTitle("Add user data");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500,400);

    titleLable = new JLabel("Main Menu", SwingConstants.CENTER);
    titleLable.setForeground(Color.black);
    titleLable.setFont(new Font ("", Font.BOLD, 25));

    addButton = new JButton("Add user");
    searchButton= new JButton("Search users");
    exitButton = new JButton("Exit");

    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 1));
    panel.setBorder(new EmptyBorder(20, 15, 15, 15));

    addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    addButton.setFont(new Font ("Arial",Font.PLAIN, 15));
    searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    searchButton.setFont(new Font ("Arial",Font.PLAIN, 15));
    exitButton .setAlignmentX(Component.CENTER_ALIGNMENT);
    exitButton.setFont(new Font ("Arial",Font.PLAIN, 15));

    addButton.addActionListener(this);
    searchButton.addActionListener(this);
    exitButton.addActionListener(this);
    panel.add(addButton);
    panel.add(searchButton);
    panel.add(exitButton);

    add (titleLable,BorderLayout.NORTH ) ;
    add (panel,BorderLayout.CENTER ) ;
    setVisible(true) ;
  }
  @Override
    public void actionPerformed ( ActionEvent e ) {
    String actionCommand = e.getActionCommand () ;
    System.out.println(actionCommand);
    if ( actionCommand.equals ("Add user") ) {
      new Add();
    } else if ( actionCommand.equals ("Search users") ) {
      new Search();
    }
    else if (actionCommand.equals("Exit")) {
      System.exit (0);
    }
  }
    public static void main ( String [] args ) {
      new MainMenu () ;
    }
}
