

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class calcu implements ActionListener
{
    JFrame frame;
    JLabel l1,l2,l3;
    Container c;
    TextField t1,t2,t3;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    int a,b,result;
    public calcu()
    {
        frame=new JFrame();
        frame.setVisible(true);
//        frame.setSize(500,500);
//        frame.setLocation(150,50);
        frame.setTitle("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150,50,750,750);
        c=frame.getContentPane();
        Color col=new Color(33, 49, 127);
        c.setBackground(col);
        c.setLayout(null);
        frame.setResizable(false);
        l1=new JLabel("Enter 1st Number: ");
        l1.setBounds(150,50,150,50);
        c.add(l1);
        l1.setForeground(Color.WHITE);
        Font f=new Font("Arial",Font.BOLD,15);
        l1.setFont(f);
        //l1.setText("Hello");
        t1=new TextField();
        t1.setBounds(350,50,150,50);
        c.add(t1);
        Font f1=new Font("Arial",Font.BOLD,35);
        t1.setFont(f1);

        l2=new JLabel("Enter 2nd Number: ");
        l2.setBounds(150,150,150,50);
        c.add(l2);
        l2.setForeground(Color.WHITE);
        l2.setFont(f);

//        JPasswordField p=new JPasswordField();
//        p.setBounds(250,150,150,50);
//        c.add(p);
//        p.setFont(f1);
//        p.setEchoChar('#');
//        p.setEchoChar((char) 0);

        t2=new TextField();
        t2.setBounds(350,150,150,50);
        c.add(t2);
        t2.setFont(f1);

        l3=new JLabel("Expected Output:");
        l3.setBounds(150,250,150,50);
        c.add(l3);
        l3.setForeground(Color.WHITE);
        l3.setFont(f);

        t3=new TextField();
        t3.setBounds(350,250,150,50);
        c.add(t3);
        t3.setFont(f1);
        t3.setEditable(false);

        Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
        btn1=new JButton("+");
        btn1.setBounds(150,350,75,75);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        c.add(btn1);
        btn1.addActionListener(this);
       // btn1.setEnabled(false);

        btn2=new JButton("-");
        btn2.setBounds(250,350,75,75);
        btn2.setFont(f1);
        btn2.setCursor(cursor);
        c.add(btn2);
        btn2.addActionListener(this);


        btn3=new JButton("x");
        btn3.setBounds(350,350,75,75);
        btn3.setFont(f1);
        btn3.setCursor(cursor);
        c.add(btn3);
        btn3.addActionListener(this);


        btn4=new JButton("/");
        btn4.setBounds(450,350,75,75);
        btn4.setFont(f1);
        btn4.setCursor(cursor);
        c.add(btn4);
        btn4.addActionListener(this);

        btn5=new JButton("x^");
        btn5.setBounds(150,450,75,75);
        btn5.setFont(f1);
        btn5.setCursor(cursor);
        c.add(btn5);
        btn5.addActionListener(this);
        // btn1.setEnabled(false);

        btn6=new JButton("|x|");
        btn6.setBounds(250,450,75,75);
        btn6.setFont(f1);
        btn6.setCursor(cursor);
        c.add(btn6);
        btn6.addActionListener(this);


        btn7=new JButton("C");
        btn7.setBounds(350,450,75,75);
        btn7.setFont(f1);
        btn7.setCursor(cursor);
        c.add(btn7);
        btn7.addActionListener(this);


        btn8=new JButton("P");
        btn8.setBounds(450,450,75,75);
        btn8.setFont(f1);
        btn8.setCursor(cursor);
        c.add(btn8);
        btn8.addActionListener(this);
    }


    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=a+b;
            t3.setText(String.valueOf(result));
            c.setBackground(Color.cyan);

        }
        if(e.getSource()==btn2)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=a-b;
            t3.setText(String.valueOf(result));
            c.setBackground(Color.BLUE);
        }
        if(e.getSource()==btn3)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=a*b;
            t3.setText(String.valueOf(result));
            c.setBackground(Color.RED);
        }
        if(e.getSource()==btn4)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=a/b;
            t3.setText(String.valueOf(result));
            c.setBackground(Color.PINK);
        }
        if(e.getSource()==btn5)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result= (int) Math.pow(a,b);
            t3.setText(String.valueOf(result));
            c.setBackground(Color.DARK_GRAY);

        }
        if(e.getSource()==btn6)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            result=a%b;
            t3.setText(String.valueOf(result));
            c.setBackground(Color.ORANGE);
        }
        if(e.getSource()==btn7)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());
            if (b > a) {
                t3.setText("Syntax Error.");
            }
            else if (a < 0 || b < 0) {
                t3.setText("Invalid Input.");
            }
            else
            {
                result=factorial(a) / (factorial(b) * factorial(a - b));
                t3.setText(String.valueOf(result));
                c.setBackground(Color.MAGENTA);
            }

        }
        if(e.getSource()==btn8)
        {
            a= Integer.parseInt(t1.getText());
            b=Integer.parseInt(t2.getText());

            if (b > a) {
                t3.setText("Syntax Error.");
            } else if (a < 0 || b < 0) {
                t3.setText("Invalid Input.");
            } else
            {
                result=factorial(a) / factorial(a - b);
                t3.setText(String.valueOf(result));
                c.setBackground(Color.white);

            }


        }
    }
}

public class calcgui
{
    public static void main(String[] args)

    {
        calcu cal =new calcu();
    }
}
