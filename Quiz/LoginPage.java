
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
  JButton next, Exit;
  JTextField fname;

  LoginPage() {
    setLayout(null);
    getContentPane().setBackground(new Color(224, 224, 224));

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/main.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 400, 500);
    add(image);

    JLabel heading = new JLabel("MindMingle");
    heading.setBounds(480, 60, 500, 60);
    heading.setFont(new Font("Broadway", Font.BOLD, 40));
    heading.setForeground(new Color(0, 102, 204));
    add(heading);

    JLabel name = new JLabel("Enter your name");
    name.setBounds(540, 140, 200, 20);
    name.setFont(new Font("Mangolian Baiti", Font.BOLD, 18));
    name.setForeground(new Color(0, 102, 204));
    add(name);

    fname = new JTextField();
    fname.setBounds(510, 200, 200, 25);
    fname.setFont(new Font("Times New Roman", Font.BOLD, 15));
    add(fname);

    next = new JButton("next");
    next.setBounds(460, 250, 120, 25);
    next.setBackground(new Color(255, 102, 178));
    next.setForeground(Color.WHITE);
    next.addActionListener(this);
    add(next);

    Exit = new JButton("Exit");
    Exit.setBounds(600, 250, 120, 25);
    Exit.setBackground(new Color(255, 102, 178));
    Exit.setForeground(Color.WHITE);
    Exit.addActionListener(this);
    add(Exit);

    setSize(800, 500);
    setLocation(240, 100);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
      String name = fname.getText();
      setVisible(false);
      new Rules(name);

    } else if (ae.getSource() == Exit) {
      setVisible(false);
    }
  }

  public static void main(String[] args) {
    new LoginPage();
  }
}