import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(300, 100, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/4374.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 300, 550);
        add(image);

        JLabel heading = new JLabel("Thank You " + name + " for playing MindMingle");
        heading.setBounds(170, 80, 700, 30);
        heading.setFont(new Font("Tahona", Font.PLAIN, 24));
        add(heading);

        JLabel pscore = new JLabel("Your score is " + score);
        pscore.setBounds(370, 200, 700, 30);
        pscore.setFont(new Font("Tahona", Font.PLAIN, 24));
        add(pscore);

        JButton again = new JButton("Play Again");
        again.setBounds(400, 300, 120, 30);
        again.setBackground(new Color(0, 102, 204));
        again.setForeground(Color.WHITE);
        again.addActionListener(this);
        add(again);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new LoginPage();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
