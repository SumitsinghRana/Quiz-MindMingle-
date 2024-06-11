
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(224, 224, 224));
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to MindMingle");
        heading.setBounds(50, 20, 500, 30);
        heading.setFont(new Font("Broadway", Font.BOLD, 28));
        heading.setForeground(new Color(0, 102, 204));
        add(heading);

        JLabel next = new JLabel();
        next.setBounds(20, 70, 700, 350);
        next.setFont(new Font("Tahoma", Font.PLAIN, 16));
        next.setForeground(new Color(96, 96, 96));

        next.setText(
                "<html>" +
                        "1. You will be given 20 sec to answer a question."
                        + "<br><br>" +
                        "2. If you failed to answer in given time you will be jumped to next problem." + "<br><br>" +
                        "3. Life may offer many choices, but here, every question demands an answer." + "<br><br>" +
                        "4. Feel free to shed a tear, but let's keep it low-key." + "<br><br>" +
                        "5. Only the wise provide answers. Be wise, not otherwise." + "<br><br>" +
                        "6. Don't panic if your friend is acing it; they're probably just on a lucky streak."
                        + "<br><br>" +
                        "7. Gear up, brave soul; this quiz is not for the faint-hearted." + "<br><br>" +
                        "8. May you know more than Jon Snow. Good luck!" + "<br><br>" +
                        "9. No googling! Your brain is your best resource." + "<br><br>" +

                        "<html>");

        add(next);

        start = new JButton("Start");
        start.setBounds(250, 420, 100, 30);
        start.setBackground(new Color(0, 102, 204));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(400, 420, 100, 30);
        back.setBackground(new Color(0, 102, 204));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(800, 500);
        setLocation(240, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new LoginPage();
        }
    }

    public static void main(String[] args) {
        new Rules("Mister India");
    }
}
