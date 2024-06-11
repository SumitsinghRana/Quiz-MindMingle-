import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    JLabel question, qno;
    JRadioButton obj1, obj2, obj3, obj4;
    public static int timer = 20;
    public static int ans_given = 0;
    ButtonGroup groupoption;
    String useranswers[][] = new String[10][1];
    public static int count = 0;
    JButton submit, next;
    public static int score = 0;
    String name = "";

    Quiz(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(224, 224, 224));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1000, 340);
        add(image);

        qno = new JLabel("1");
        qno.setBounds(70, 380, 50, 30);
        qno.setFont(new Font("Tahona", Font.PLAIN, 24));
        add(qno);

        question = new JLabel("This is a question");
        question.setBounds(100, 380, 900, 30);
        question.setFont(new Font("Tahona", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which Java tool can be used to profile the performance of Java applications?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JVisualVM";
        questions[0][4] = "JRE";

        questions[1][0] = "What will be the output of 'System.out.println(1 + 2 + \"3\");' in Java?";
        questions[1][1] = "33";
        questions[1][2] = "6";
        questions[1][3] = "123";
        questions[1][4] = "Error";

        questions[2][0] = "Which class is the superclass of all classes in Java?";
        questions[2][1] = "java.lang.Runtime";
        questions[2][2] = "java.lang.String";
        questions[2][3] = "java.lang.Object";
        questions[2][4] = "java.lang.Class";

        questions[3][0] = "What does the 'static' keyword mean in Java?";
        questions[3][1] = "Variable cannot be changed";
        questions[3][2] = "Method can be overridden";
        questions[3][3] = "Belongs to the class, not instances";
        questions[3][4] = "Runs on JVM startup";

        questions[4][0] = "Which of the following is not a valid Java access modifier?";
        questions[4][1] = "protected";
        questions[4][2] = "public";
        questions[4][3] = "friendly";
        questions[4][4] = "private";

        questions[5][0] = "What is the purpose of the transient keyword in Java?";
        questions[5][1] = "To make a variable final";
        questions[5][2] = "To exclude a variable from serialization";
        questions[5][3] = "To declare a variable as static";
        questions[5][4] = "To create a volatile variable";

        questions[6][0] = "What is the significance of the 'volatile' keyword in Java?";
        questions[6][1] = "Ensures visibility of changes to variables across threads";
        questions[6][2] = "Marks a variable as constant";
        questions[6][3] = "Allows method overriding";
        questions[6][4] = "Used for garbage collection";

        questions[7][0] = "Which feature of Java allows it to run on any platform?";
        questions[7][1] = "Object-oriented";
        questions[7][2] = "Platform independence";
        questions[7][3] = "Multithreading";
        questions[7][4] = "Memory management";

        questions[8][0] = "Which of the following is a thread-safe class in Java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.util.ArrayList";
        questions[8][3] = "java.util.HashMap";
        questions[8][4] = "java.util.Vector";

        questions[9][0] = "Which statement is true about Java memory management?";
        questions[9][1] = "Memory is managed by the programmer";
        questions[9][2] = "Java uses manual garbage collection";
        questions[9][3] = "Automatic garbage collection is provided by JVM";
        questions[9][4] = "Java does not support memory management";

        answers[0][1] = "JVisualVM";
        answers[1][1] = "33";
        answers[2][1] = "java.lang.Object";
        answers[3][1] = "Belongs to the class, not instances";
        answers[4][1] = "friendly";
        answers[5][1] = "To exclude a variable from serialization";
        answers[6][1] = "Ensures visibility of changes to variables across threads";
        answers[7][1] = "Platform independence";
        answers[8][1] = "java.util.Vector";
        answers[9][1] = "Automatic garbage collection is provided by JVM";

        setBounds(140, 0, 1000, 680);
        setVisible(true);

        obj1 = new JRadioButton("11");
        obj1.setBounds(140, 420, 500, 30);
        obj1.setBackground(new Color(224, 224, 224));
        obj1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(obj1);

        obj2 = new JRadioButton("11");
        obj2.setBounds(140, 460, 500, 30);
        obj2.setBackground(new Color(224, 224, 224));
        obj2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(obj2);

        obj3 = new JRadioButton("11");
        obj3.setBounds(140, 500, 500, 30);
        obj3.setBackground(new Color(224, 224, 224));
        obj3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(obj3);

        obj4 = new JRadioButton("11");
        obj4.setBounds(140, 540, 500, 30);
        obj4.setBackground(new Color(224, 224, 224));
        obj4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(obj4);

        groupoption = new ButtonGroup();
        groupoption.add(obj1);
        groupoption.add(obj2);
        groupoption.add(obj3);
        groupoption.add(obj4);

        next = new JButton("Next");
        next.setBounds(800, 500, 150, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(800, 550, 150, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            obj1.setEnabled(true);
            obj2.setEnabled(true);
            obj3.setEnabled(true);
            obj4.setEnabled(true);

            ans_given = 1;

            if (groupoption.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoption.getSelection().getActionCommand();
            }

            if (groupoption.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoption.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoption.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoption.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left-" + timer + " sec";
        g.setColor(new Color(0, 153, 76));
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if (timer > 0 && timer <= 10) {
            g.setColor(Color.RED);
            g.setFont(new Font("Tahoma", Font.BOLD, 20));

        }

        if (timer > 0) {
            g.drawString(time, 800, 470);
        } else {
            g.drawString("Times up!!", 800, 470);
        }

        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans_given == 1) {
            ans_given = 0;
            timer = 20;
        } else if (timer < 0) {
            timer = 20;
            obj1.setEnabled(true);
            obj2.setEnabled(true);
            obj3.setEnabled(true);
            obj4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (groupoption.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoption.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {
                if (groupoption.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoption.getSelection().getActionCommand();
                }
                count++;
                start(count);

            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        obj1.setText(questions[count][1]);
        obj1.setActionCommand(questions[count][1]);

        obj2.setText(questions[count][2]);
        obj2.setActionCommand(questions[count][2]);

        obj3.setText(questions[count][3]);
        obj3.setActionCommand(questions[count][3]);

        obj4.setText(questions[count][4]);
        obj4.setActionCommand(questions[count][4]);

        groupoption.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
