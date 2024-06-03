package BMS_fh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

class Forms implements ActionListener {
    User user = new User();
    JFrame frame;
    JLabel l1, l2, l3,l4;
    JButton bnt1, bnt2;
    Font font = new Font("Arial", Font.BOLD, 20);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    int attempts = 3;

    public Forms() {
        Container c = new Container();
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Form");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBounds(150,50,500,500);
        frame.getContentPane().setBackground(new Color(0x123456));
        ImageIcon image = new ImageIcon("loginn.png");
        frame.setIconImage(image.getImage());
        bnt1 = new JButton("Open Login Form");
        bnt1.setBounds(100, 50, 250, 75);
        bnt1.setFont(font);
        bnt1.setCursor(cursor);
        bnt1.addActionListener(this);
        frame.add(bnt1);
        bnt2 = new JButton("Open Signup Form");
        bnt2.setBounds(100, 150, 250, 75);
        bnt2.setFont(font);
        bnt2.setCursor(cursor);
        bnt2.addActionListener(this);
        frame.add(bnt2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bnt1) {
            frame.setVisible(false);
            JFrame login = new JFrame();
            login.setVisible(true);
            login.setTitle("Login Form");
            login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            login.setLayout(null);
            login.setResizable(false);
            login.getContentPane().setBackground(Color.BLUE);
            login.setSize(500, 500);

            l1 = new JLabel("UserName");
            l2 = new JLabel("Password");

            l1.setFont(new Font("MV Boli", Font.PLAIN, 20));
            l2.setFont(new Font("MV Boli", Font.PLAIN, 20));
            l1.setForeground(Color.lightGray);
            l2.setForeground(Color.lightGray);

            JTextField usernameField = new JTextField();
            JPasswordField passwordField = new JPasswordField();

            l1.setBounds(50, 100, 150, 30);
            usernameField.setBounds(200, 100, 200, 30);

            l2.setBounds(50, 150, 150, 30);
            passwordField.setBounds(200, 150, 200, 30);

            login.add(l1);
            login.add(usernameField);
            login.add(l2);
            login.add(passwordField);

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(200, 200, 100, 30);
            loginButton.setFont(font);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        user.file_to_arraylist();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    String username = usernameField.getText();
                    char[] password = passwordField.getPassword();
                    boolean state = user.search_user(username,password);
                    if (state==true) {
                        JOptionPane.showMessageDialog(login, "Login Successful");
                        login.dispose();
                        try {
                            BMS_GUI bms_gui = new BMS_GUI();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        attempts--;
                        if (attempts <= 0) {
                            JOptionPane.showMessageDialog(login, "You have reached the login attempts limit. Contact Support.");
                            login.dispose();
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(login, "Incorrect username or password. Attempts left: " + attempts);
                        }
                    }
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(320, 200, 100, 30);
            cancelButton.setFont(font);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    login.dispose();
                    frame.setVisible(true);
                }
            });

            login.add(loginButton);
            login.add(cancelButton);
            JCheckBox showPasswordCheckbox = new JCheckBox("Show Password");
            showPasswordCheckbox.setBounds(200, 250, 150, 30);
            login.add(showPasswordCheckbox);

            showPasswordCheckbox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    int state = e.getStateChange();
                    if (state == ItemEvent.SELECTED) {
                        passwordField.setEchoChar((char) 0); // Show password
                    } else {
                        passwordField.setEchoChar('*'); // Hide password
                    }
                }
            });
        } else if (e.getSource() == bnt2) {
            frame.setVisible(false);
            JFrame signup = new JFrame();
            signup.setVisible(true);
            signup.setTitle("Signup Form");
            signup.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            signup.setLayout(null);
            signup.setResizable(false);
            signup.getContentPane().setBackground(Color.DARK_GRAY);
            signup.setSize(500, 500);

            l1 = new JLabel("UserName");
            l2 = new JLabel("Password");
            l3 = new JLabel("Phone No.");
            l4 = new JLabel("CNIC");

            Font font = new Font("MV Boli", Font.PLAIN, 20);
            l1.setFont(font);
            l2.setFont(font);
            l3.setFont(font);
            l4.setFont(font);

            l1.setForeground(Color.white);
            l2.setForeground(Color.white);
            l3.setForeground(Color.white);
            l4.setForeground(Color.white);

            JTextField usernameField = new JTextField();
            JTextField phonenoField = new JTextField();
            JTextField CNICField = new JTextField();
            JPasswordField passwordField = new JPasswordField();

            l1.setBounds(50, 100, 150, 30);
            usernameField.setBounds(200, 100, 200, 30);

            l2.setBounds(50, 150, 150, 30);
            passwordField.setBounds(200, 150, 200, 30);

            l3.setBounds(50,200,150,30);
            phonenoField.setBounds(200,200,200,30);

            l4.setBounds(50,250,150,30);
            CNICField.setBounds(200, 250, 200, 30);

            signup.add(l1);
            signup.add(usernameField);
            signup.add(l2);
            signup.add(passwordField);
            signup.add(l3);
            signup.add(phonenoField);
            signup.add(l4);
            signup.add(CNICField);

            JButton signupButton = new JButton("Signup");
            signupButton.setBounds(200, 375, 100, 30);
            signupButton.setFont(font);
            signupButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    char[] password = passwordField.getPassword();
                    String phoneno = phonenoField.getText();
                    String CNIC = CNICField.getText();
                    User u1 = new User(username,password,phoneno,CNIC);
                    boolean state = u1.search_user(username,password);
                    if (state==false) {
                        try {
                            u1.adduser(u1);
                            user.add_to_file();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(signup, "Signup Successful");
                        signup.dispose();
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(signup, "Username already taken");
                    }
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(320, 375, 100, 30);
            cancelButton.setFont(font);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    signup.dispose();
                    frame.setVisible(true);
                }
            });

            signup.add(signupButton);
            signup.add(cancelButton);
            JCheckBox showPasswordCheckbox = new JCheckBox("Show Password");
            showPasswordCheckbox.setBounds(200, 280, 150, 30);
            signup.add(showPasswordCheckbox);

            showPasswordCheckbox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    int state = e.getStateChange();
                    if (state == ItemEvent.SELECTED) {
                        passwordField.setEchoChar((char) 0); // Show password
                    } else {
                        passwordField.setEchoChar('*'); // Hide password
                    }
                }
            });
        }
    }
}

