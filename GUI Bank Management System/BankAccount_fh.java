package BMS_fh;
import java.io.IOException;
import java.util.Scanner;

public class BankAccount_fh {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bank_fh bank = new Bank_fh();
        System.out.printf("\t\t\t\t\u001B[35m %s😎 \u001B[0m\n",bank);
        Scanner sc =new Scanner(System.in);
        Person person = new Person();
        Client_fh client1 = new Client_fh();
        Account_fh acc = new Account_fh();
        person.file_to_arraylist();
        client1.file_to_arraylistc();
        acc.file_to_arraylista();
        while(true){
            System.out.println("""
                    What you want to do?
                    1. Open the account
                    2. Withdraw
                    3. Deposit
                    4. Check Balance
                    5. Add Account
                    6. Search Account
                    7. Remove Client
                    8. Search client details
                    9. Display All clients
                    10. Search person existence
                    11. Diaplay All accounts
                    12. Exit
                    """);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("\nEnter the name please: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("\nEnter the CNIC: ");
                    String cnic = sc.nextLine();
                    System.out.print("\nEnter the phone no: ");
                    String no = sc.nextLine();
                    System.out.print("\nEnter the amount you want to keep in the account: ");
                    float amount = sc.nextFloat();
                    Person person1 = new Person(name, cnic, no);
                    person1.add_person(person1);
                    client1 = bank.addClient(person1);
                    Account_fh account1 = bank.addAccount(amount, client1);
                    break;

                case 2:
                    System.out.print("\nEnter the Account no: ");
                    sc.nextLine();
                    String acc_no = sc.nextLine();
                    System.out.print("\nEnter the amount you want to withdraw: ");
                    float amount_tw = sc.nextFloat();
                    client1.withdraw(amount_tw, acc_no);
                    break;
                case 3:
                    System.out.print("\nEnter the Account no: ");
                    sc.nextLine();
                    String accno = sc.nextLine();
                    System.out.print("\nEnter the amount you want to deposit: ");
                    float amounttw = sc.nextFloat();
                    client1.deposit(amounttw, accno);
                    break;
                case 4:
                    System.out.print("Enter the Client ID: ");
                    sc.nextLine();
                    String CLIid = sc.nextLine();
                    System.out.println("Your balance is: "+bank.totalAmount(CLIid));
                    break;
                case 5:
                    System.out.print("\nEnter the Cnic: ");
                    sc.nextLine();
                    String cl_cnic = sc.nextLine();
                    System.out.print("\nEnter the ID: ");
                    String id = sc.nextLine();
                    System.out.print("\nEnter the amount you want to keep in account: ");
                    float amountt= sc.nextFloat();
                    sc.nextLine();
                    Client_fh cc = bank.searchCustomerDetail(cl_cnic);
                    if(cc==null){
                        System.out.println("This client doesn't exists in bank.");
                    }
                    else{
                        Account_fh account3 = bank.addAccount(amountt,cc);
                    }
                    break;
                case 6:
                    System.out.print("\nEnter the account no: ");
                    sc.nextLine();
                    String accNO = sc.nextLine();
                    Account_fh racc = bank.searchAccount(accNO);
                    if(racc==null){
                        System.out.println("No such account exists");
                    }
                    else{
                        System.out.println(racc);
                    }
                    break;
                case 7:
                    System.out.print("\nEnter Client ID: ");
                    sc.nextLine();
                    String Id = sc.nextLine();
                    boolean answer = bank.removeClient(Id);
                    if(answer==true){
                        System.out.println("Client has been removed successfully");
                    }
                    else{
                        System.out.println("This client doesn't exists");
                    }
                    break;
                case 8:
                    System.out.print("\nEnter the Cnic: ");
                    sc.nextLine();
                    String cnn = sc.nextLine();
                    Client_fh c = bank.searchCustomerDetail(cnn);
                    if(c==null){
                        System.out.println("Client not found");
                    }
                    else{
                        System.out.println(c);
                    }
                    break;
                case 9:
                    client1.all_clients();
                    break;
                case 10:
                    System.out.print("Enter the person CNIC: ");
                    sc.nextLine();
                    String nic = sc.nextLine();
                    person.search_person(nic);
                    break;
                case 11:
                    acc.all_accounts();
                    break;
                case 12:
                    person.add_to_file();
                    client1.add_to_filec();
                    acc.add_to_filea();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option chosen");
                    return;
            }
        }
    }

}

