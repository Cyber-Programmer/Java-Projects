package BMS_fh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


class BMS_GUI implements ActionListener {
    Bank_fh bank = new Bank_fh();
    Person person = new Person();
    Client_fh client1 = new Client_fh();
    Account_fh acc = new Account_fh();
    JFrame MainFrame;
    Container c;
    JButton Opentheaccount, Withdraw, Deposit, Check_Balance, Add_Account, Search_Account, Remove_Client, Search_client_details,
            Display_All_clients,Search_person_existence, Display_All_accounts, Exit;
    public BMS_GUI() throws IOException, ClassNotFoundException {
        person.file_to_arraylist();
        client1.file_to_arraylistc();
        acc.file_to_arraylista();
        MainFrame = new JFrame();
        MainFrame.setVisible(true);
        MainFrame.setTitle("Silk Bank ✨");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setLocation(0,0);
        MainFrame.setBounds(150,50,870,580);
        c=MainFrame.getContentPane();
        c.setBackground(Color.PINK);
        c.setLayout(null);
        MainFrame.setResizable(false);
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\etienne-martin-2_K82gx9Uk8-unsplash (1).jpg").getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        contentPane.setLayout(null);

        Opentheaccount = new JButton("Open the account");
        Withdraw = new JButton("Withdraw");
        Deposit = new JButton("Deposit");
        Check_Balance = new JButton("Check Balance");
        Add_Account = new JButton("Add Account");
        Search_Account = new JButton("Search Account");
        Remove_Client = new JButton("Remove Client");
        Search_client_details = new JButton("Search Client Details");
        Display_All_clients = new JButton("Display All Clients");
        Search_person_existence = new JButton("Search Person Existence");
        Display_All_accounts = new JButton("Display All Accounts");
        Exit = new JButton("Exit");

        Opentheaccount.setBounds(250, 20, 150, 50);
        Withdraw.setBounds(250, 90, 150, 50);
        Deposit.setBounds(250, 160, 150, 50);
        Check_Balance.setBounds(250, 230, 150, 50);
        Add_Account.setBounds(250, 300, 150, 50);
        Search_Account.setBounds(250, 370, 150, 50);
        Remove_Client.setBounds(450, 20, 150, 50);
        Search_client_details.setBounds(450, 90, 150, 50);
        Display_All_clients.setBounds(450, 160, 150, 50);
        Search_person_existence.setBounds(450, 230, 150, 50);
        Display_All_accounts.setBounds(450, 300, 150, 50);
        Exit.setBounds(450, 370, 150, 50);

        contentPane.add(Opentheaccount);
        contentPane.add(Withdraw);
        contentPane.add(Deposit);
        contentPane.add(Check_Balance);
        contentPane.add(Add_Account);
        contentPane.add(Search_Account);
        contentPane.add(Remove_Client);
        contentPane.add(Search_client_details);
        contentPane.add(Display_All_clients);
        contentPane.add(Search_person_existence);
        contentPane.add(Display_All_accounts);
        contentPane.add(Exit);

        MainFrame.setContentPane(contentPane);
        Color gold = new Color(115, 109, 102);
        Opentheaccount.setBackground(gold);
        Withdraw.setBackground(gold);
        Deposit.setBackground(gold);
        Check_Balance.setBackground(gold);
        Add_Account.setBackground(gold);
        Search_Account.setBackground(gold);
        Remove_Client.setBackground(gold);
        Search_client_details.setBackground(gold);
        Display_All_clients.setBackground(gold);
        Search_person_existence.setBackground(gold);
        Display_All_accounts.setBackground(gold);
        Exit.setBackground(gold);

        Opentheaccount.addActionListener(this);
        Withdraw.addActionListener(this);
        Deposit.addActionListener(this);
        Check_Balance.addActionListener(this);
        Add_Account.addActionListener(this);
        Search_Account.addActionListener(this);
        Remove_Client.addActionListener(this);
        Search_client_details.addActionListener(this);
        Display_All_clients.addActionListener(this);
        Search_person_existence.addActionListener(this);
        Display_All_accounts.addActionListener(this);
        Exit.addActionListener(this);
    }
    protected void updateOutput(String message) {
        JOptionPane.showMessageDialog(MainFrame, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Opentheaccount) {
            MainFrame.setVisible(false);
            JFrame Frame1 = new JFrame("Open Account");
            Frame1.setVisible(true);
            Frame1.setBounds(150,50,500,500);
            c=Frame1.getContentPane();
            c.setBackground(new Color(0x6ADC2E));
            c.setLayout(null);
            Frame1.setResizable(false);

            JPanel contentPane = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image img = new ImageIcon("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\etienne-martin-2_K82gx9Uk8-unsplash (1).jpg").getImage();
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
            contentPane.setLayout(null);
            JTextField nameField = new JTextField();
            JTextField cnicField = new JTextField();
            JTextField phoneField = new JTextField();
            JTextField amountField = new JTextField();

            JLabel nameLabel = new JLabel("Name");
            JLabel cnicLabel = new JLabel("CNIC");
            JLabel phoneLabel = new JLabel("Phone no");
            JLabel amountLabel = new JLabel("Amount");
            JButton addButton = new JButton("Add");
            JButton cancelButton = new JButton("Cancel");

            Font font = new Font("MV Boli", Font.PLAIN, 20);
            nameLabel.setFont(font);
            cnicLabel.setFont(font);
            phoneLabel.setFont(font);
            amountLabel.setFont(font);

            nameLabel.setForeground(Color.WHITE);
            cnicLabel.setForeground(Color.WHITE);
            phoneLabel.setForeground(Color.WHITE);
            amountLabel.setForeground(Color.WHITE);

            Frame1.add(nameField);
            Frame1.add(nameLabel);
            Frame1.add(cnicField);
            Frame1.add(cnicLabel);
            Frame1.add(phoneLabel);
            Frame1.add(phoneField);
            Frame1.add(amountLabel);
            Frame1.add(amountField);
            Frame1.add(addButton);
            Frame1.add(cancelButton);

            nameLabel.setBounds(50, 50, 200, 30);
            nameField.setBounds(250, 50, 200, 30);
            cnicLabel.setBounds(50, 100, 200, 30);
            cnicField.setBounds(250, 100, 200, 30);
            phoneLabel.setBounds(50, 150, 200, 30);
            phoneField.setBounds(250, 150, 200, 30);
            amountLabel.setBounds(50, 200, 250, 30);
            amountField.setBounds(250, 200, 200, 30);
            addButton.setBounds(150, 250, 100, 30);
            cancelButton.setBounds(270, 250, 100, 30);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String cnic = cnicField.getText();
                    String phone = phoneField.getText();
                    float amount = Float.parseFloat(amountField.getText());

                    Person person1 = new Person(name, cnic, phone);
                    person1.add_person(person1);
                    try {
                        client1 = bank.addClient(person1);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        Account_fh account1 = bank.addAccount(amount, client1);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    updateOutput("Account opened for: " + client1.cl_per.getName());

                    Frame1.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Frame1.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Withdraw) {
            MainFrame.setVisible(false);
            JFrame Frame2 = new JFrame("Withdraw");
            Frame2.setVisible(true);
            Frame2.setBounds(150,50,500,500);
            c=Frame2.getContentPane();
            c.setBackground(new Color(0x08626E));
            c.setLayout(null);
            Frame2.setResizable(false);

            JTextField accountField = new JTextField();
            JTextField amountField = new JTextField();
            Font font = new Font("MV Boli", Font.PLAIN, 20);

            JLabel accountLabel = new JLabel("Account no");
            JLabel amountLabel = new JLabel("Amount to withdraw");
            JButton withdrawButton = new JButton("Withdraw");
            withdrawButton.setForeground(Color.BLACK);
            JButton cancelButton = new JButton("Cancel");
            cancelButton.setForeground(Color.BLACK);

            accountLabel.setFont(font);
            amountLabel.setFont(font);

            accountLabel.setForeground(Color.WHITE);
            amountLabel.setForeground(Color.WHITE);

            Frame2.add(accountField);
            Frame2.add(amountField);
            Frame2.add(accountLabel);
            Frame2.add(amountLabel);
            Frame2.add(withdrawButton);
            Frame2.add(cancelButton);

            accountLabel.setBounds(50, 50, 200, 30);
            accountField.setBounds(250, 50, 200, 30);
            amountLabel.setBounds(50, 100, 200, 30);
            amountField.setBounds(250,100,200,30);
            withdrawButton.setBounds(150, 150, 100, 30);
            cancelButton.setBounds(270, 150, 100, 30);

            withdrawButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String account_no = accountField.getText();
                    float amount = Float.parseFloat(amountField.getText());
                    Account_fh account1 = bank.searchAccount(account_no);
                    updateOutput("Amount Withdrawn. New Balance: " + account1.withdraw(amount));

                    Frame2.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Frame2.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Deposit) {
            MainFrame.setVisible(false);
            JFrame Frame3 = new JFrame("Deposit");
            Frame3.setVisible(true);
            Frame3.setBounds(150,50,500,500);
            c=Frame3.getContentPane();
            c.setBackground(new Color(0x6413B0));
            c.setLayout(null);
            Frame3.setResizable(false);

            JTextField accountField = new JTextField();
            JTextField amountField = new JTextField();
            Font font = new Font("MV Boli", Font.PLAIN, 20);

            JLabel accountLabel = new JLabel("Account no");
            accountLabel.setForeground(Color.WHITE);
            JLabel amountLabel = new JLabel("Amount to deposit");
            amountLabel.setForeground(Color.WHITE);
            JButton depositButton = new JButton("Deposit");
            depositButton.setForeground(Color.BLACK);
            JButton cancelButton = new JButton("Cancel");
            cancelButton.setForeground(Color.BLACK);

            accountLabel.setFont(font);
            amountLabel.setFont(font);

            Frame3.add(accountField);
            Frame3.add(amountField);
            Frame3.add(accountLabel);
            Frame3.add(amountLabel);
            Frame3.add(depositButton);
            Frame3.add(cancelButton);

            accountLabel.setBounds(50, 50, 200, 30);
            accountField.setBounds(250, 50, 200, 30);
            amountLabel.setBounds(50, 100, 200, 30);
            amountField.setBounds(250,100,200,30);
            depositButton.setBounds(150, 150, 100, 30);
            cancelButton.setBounds(270, 150, 100, 30);

            depositButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String account_no = accountField.getText();
                    float amount = Float.parseFloat(amountField.getText());
                    Account_fh account1 = bank.searchAccount(account_no);
                    updateOutput("Amount Deposited. New Balance: " + account1.deposit(amount));
                    Frame3.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Frame3.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Check_Balance) {
            MainFrame.setVisible(false);
            JFrame checkBalanceFrame = new JFrame("Check Balance");
            checkBalanceFrame.setVisible(true);
            checkBalanceFrame.setBounds(150, 50, 400, 200);
            Container c = checkBalanceFrame.getContentPane();
            c.setBackground(new Color(0x9A2D40));
            c.setLayout(null);
            checkBalanceFrame.setResizable(false);

            JLabel clientIdLabel = new JLabel("Client ID");
            Font font = new Font("MV Boli", Font.PLAIN, 20);
            clientIdLabel.setFont(font);
            clientIdLabel.setForeground(Color.WHITE);
            clientIdLabel.setBounds(50, 50, 150, 30);
            c.add(clientIdLabel);

            JTextField clientIdField = new JTextField();
            clientIdField.setBounds(200, 50, 150, 30);
            c.add(clientIdField);

            JButton checkButton = new JButton("Check");
            checkButton.setBounds(150, 100, 100, 30);
            checkButton.setBackground(Color.pink);
            c.add(checkButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(270, 100, 100, 30);
            cancelButton.setBackground(Color.pink);
            c.add(cancelButton);

            checkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String clientId = clientIdField.getText();
                    float balance = bank.totalAmount(clientId);
                    updateOutput("Your balance is: " + balance);
                    checkBalanceFrame.setVisible(false);
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkBalanceFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Add_Account) {
            MainFrame.setVisible(false);
            JFrame addAccountFrame = new JFrame("Add Account");
            addAccountFrame.setVisible(true);
            addAccountFrame.setBounds(150, 50, 400, 300);
            Container c = addAccountFrame.getContentPane();
            c.setBackground(new Color(0x4B5718));
            c.setLayout(null);
            addAccountFrame.setResizable(false);
            Font font = new Font("MV Boli", Font.PLAIN, 20);

            JLabel cnicLabel = new JLabel("CNIC");
            cnicLabel.setFont(font);
            cnicLabel.setForeground(Color.WHITE);
            cnicLabel.setBounds(50, 50, 150, 30);
            c.add(cnicLabel);

            JTextField cnicField = new JTextField();
            cnicField.setBounds(200, 50, 150, 30);
            c.add(cnicField);

            JLabel idLabel = new JLabel("ID");
            idLabel.setFont(font);
            idLabel.setForeground(Color.WHITE);
            idLabel.setBounds(50, 100, 150, 30);
            c.add(idLabel);

            JTextField idField = new JTextField();
            idField.setBounds(200, 100, 150, 30);
            c.add(idField);

            JLabel amountLabel = new JLabel("Amount");
            amountLabel.setForeground(Color.WHITE);
            amountLabel.setFont(font);
            amountLabel.setBounds(50, 150, 150, 30);
            c.add(amountLabel);

            JTextField amountField = new JTextField();
            amountField.setBounds(200, 150, 150, 30);
            c.add(amountField);

            JButton addButton = new JButton("Add");
            addButton.setBounds(150, 200, 100, 30);
            addButton.setBackground(new Color(2, 62, 100));
            c.add(addButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(270, 200, 100, 30);
            cancelButton.setBackground(new Color(20, 16, 44));
            c.add(cancelButton);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cnic = cnicField.getText();
                    String id = idField.getText();
                    float amount = Float.parseFloat(amountField.getText());

                    Client_fh client = bank.searchCustomerDetail(cnic);
                    if (client == null) {
                        updateOutput("This client doesn't exist in the bank.");
                    } else {
                        try {
                            Account_fh account = bank.addAccount(amount, client);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        updateOutput("Account added for: " + client.cl_per.getName());
                        addAccountFrame.setVisible(false);
                    }
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addAccountFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Search_Account) {
            JFrame searchAccountFrame = new JFrame("Search Account");
            MainFrame.setVisible(false);
            searchAccountFrame.setVisible(true);
            searchAccountFrame.setBounds(150, 50, 400, 200);
            Container c = searchAccountFrame.getContentPane();
            c.setBackground(new Color(69, 222, 89));
            c.setLayout(null);
            searchAccountFrame.setResizable(false);

            Font font = new Font("MV Boli", Font.PLAIN, 20);
            JLabel accountNoLabel = new JLabel("Account Number:");
            accountNoLabel.setFont(font);
            accountNoLabel.setForeground(Color.WHITE);
            accountNoLabel.setBounds(50, 50, 200, 30);
            c.add(accountNoLabel);

            JTextField accountNoField = new JTextField();
            accountNoField.setBounds(250, 50, 100, 30);
            c.add(accountNoField);

            JButton searchButton = new JButton("Search");
            searchButton.setBounds(150, 100, 100, 30);
            searchButton.setBackground(new Color(119, 253, 9)); // Steel Blue
            c.add(searchButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(270, 100, 100, 30);
            cancelButton.setBackground(new Color(204, 100, 56));
            c.add(cancelButton);

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String accountNo = accountNoField.getText();
                    Account_fh racc = bank.searchAccount(accountNo);
                    if (racc == null) {
                        updateOutput("No such account exists");
                    } else {
                        updateOutput(racc.toString());
                        searchAccountFrame.setVisible(false);
                    }
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchAccountFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Remove_Client) {
            JFrame removeClientFrame = new JFrame("Remove Client");
            MainFrame.setVisible(false);
            removeClientFrame.setVisible(true);
            removeClientFrame.setBounds(150, 50, 400, 200);
            Container c = removeClientFrame.getContentPane();
            c.setBackground(new Color(0x185748));
            c.setLayout(null);
            removeClientFrame.setResizable(false);

            JLabel clientIdLabel = new JLabel("Client ID");
            Font font = new Font("MV Boli", Font.PLAIN, 20);
            clientIdLabel.setFont(font);
            clientIdLabel.setForeground(Color.WHITE);
            clientIdLabel.setBounds(50, 50, 200, 30);
            c.add(clientIdLabel);

            JTextField clientIdField = new JTextField();
            clientIdField.setBounds(150, 50, 100, 30);
            c.add(clientIdField);

            JButton removeButton = new JButton("Remove");
            removeButton.setBounds(100, 100, 100, 30);
            removeButton.setBackground(Color.YELLOW);
            c.add(removeButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(230, 100, 100, 30);
            cancelButton.setBackground(Color.YELLOW);
            c.add(cancelButton);

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String clientId = clientIdField.getText();
                    boolean answer = bank.removeClient(clientId);
                    if (answer) {
                        updateOutput("Client has been removed successfully");
                        removeClientFrame.setVisible(false);
                    } else {
                        updateOutput("This client doesn't exist");
                    }
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeClientFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Search_client_details) {
            JFrame searchClientDetailFrame = new JFrame("Search Client Detail");
            MainFrame.setVisible(false);
            searchClientDetailFrame.setVisible(true);
            searchClientDetailFrame.setBounds(150, 50, 400, 200);
            Container c = searchClientDetailFrame.getContentPane();
            c.setBackground(new Color(0x1667561));
            c.setLayout(null);
            searchClientDetailFrame.setResizable(false);

            JLabel cnicSearchLabel = new JLabel("CNIC");
            Font font = new Font("MV Boli", Font.PLAIN, 20);
            cnicSearchLabel.setForeground(Color.WHITE);
            cnicSearchLabel.setFont(font);
            cnicSearchLabel.setBounds(50, 50, 200, 30);
            c.add(cnicSearchLabel);

            JTextField cnicSearchField = new JTextField();
            cnicSearchField.setBounds(150, 50, 100, 30);
            c.add(cnicSearchField);

            JButton searchButton = new JButton("Search");
            searchButton.setBounds(100, 100, 100, 30);
            searchButton.setBackground(Color.pink);
            c.add(searchButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(200, 100, 100, 30);
            cancelButton.setBackground(Color.pink);
            c.add(cancelButton);

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cnicSearch = cnicSearchField.getText();
                    Client_fh client = bank.searchCustomerDetail(cnicSearch);
                    if (client == null) {
                        updateOutput("Client not found");
                    } else {
                        updateOutput(client.toString());
                        searchClientDetailFrame.setVisible(false);
                    }
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchClientDetailFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Display_All_clients) {
            MainFrame.setVisible(false);
            try {
                client1.all_clients();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            MainFrame.setVisible(true);
        } else if (e.getSource() == Search_person_existence) {
            JFrame searchPersonFrame = new JFrame("Search Person");
            MainFrame.setVisible(false);
            searchPersonFrame.setVisible(true);
            searchPersonFrame.setBounds(150, 50, 400, 200);
            Container c = searchPersonFrame.getContentPane();
            c.setBackground(Color.YELLOW);
            c.setLayout(null);
            searchPersonFrame.setResizable(false);

            JLabel nicSearchLabel = new JLabel("CNIC");
            Font font = new Font("MV Boli", Font.PLAIN, 20);
            nicSearchLabel.setFont(font);
            nicSearchLabel.setForeground(Color.BLACK);
            nicSearchLabel.setBounds(50, 50, 200, 30);
            c.add(nicSearchLabel);

            JTextField nicSearchField = new JTextField();
            nicSearchField.setBounds(170, 50, 100, 30);
            c.add(nicSearchField);

            JButton searchButton = new JButton("Search");
            searchButton.setBounds(100, 100, 100, 30);
            searchButton.setBackground(Color.MAGENTA);
            c.add(searchButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(230, 100, 100, 30);
            cancelButton.setBackground(Color.MAGENTA);
            c.add(cancelButton);

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nicSearch = nicSearchField.getText();
                    try {
                        person.search_person(nicSearch);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    searchPersonFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchPersonFrame.setVisible(false);
                    MainFrame.setVisible(true);
                }
            });
        } else if (e.getSource() == Display_All_accounts) {
            MainFrame.setVisible(false);
            try {
                acc.all_accounts();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            MainFrame.setVisible(true);
        } else if (e.getSource() == Exit) {
            try {
                person.add_to_file();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                client1.add_to_filec();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                acc.add_to_filea();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            System.exit(0);
        }
    }
}
