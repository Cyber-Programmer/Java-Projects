package BMS_fh;
import java.io.*;
import java.util.ArrayList;

public class Account_fh implements Serializable{
    private static final long serialVersionUID = 1489903382239455221l;
    static int ac_no = 0; //to give separate and sequenced id numbers to each new account
    String Ac_number;
    private float Amount;
    Client_fh ACholder; //to store owner details of the account
    public static ArrayList<Account_fh> accounts=new ArrayList<>();
    public void add_to_filea() throws IOException, ClassNotFoundException {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\BMS_fh\\Account.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(accounts);
        oos.close();
        fos.close();
    }

    public void file_to_arraylista() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\BMS_fh\\Account.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        accounts=(ArrayList<Account_fh>) ois.readObject();
        ois.close();
        fis.close();
    }
    public Account_fh(){
        this.Amount= 0;
        this.ACholder = null;
        this.Ac_number = null;
    }

    public Account_fh(float amount,Client_fh cli) throws IOException, ClassNotFoundException { //construtor to assign unique account no and to assign the given owner details plus amount
        this.Acno_Manager();
        this.Ac_number = "AC" + ac_no;
        BMS_GUI bmsa = new BMS_GUI();
        bmsa.updateOutput("Your account no is "+Ac_number);
        ac_no++;
        this.ACholder = cli;
        this.Amount = amount;
    }
    @Override
    public String toString() { //to display account details while using client tostring as well
        return "\nAccount Number: " + Ac_number + "\nAccount Holder: " + ACholder + ", \nAmount: " + Amount;
    }
    public void add_account(Account_fh a)
    {
        accounts.add(a);
    }
    public void all_accounts() throws IOException, ClassNotFoundException {
        for (Account_fh temp: accounts)
        {
            BMS_GUI bms = new BMS_GUI();
            bms.updateOutput(String.valueOf(temp));
        }
    }


    //getters and setters
    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

    public String getAc_number() {
        return Ac_number;
    }

    public void setAc_number(String ac_number) {
        Ac_number = ac_number;
    }

    public float withdraw(float amount){ //calculations for withdrawing amount this one is called in client to decide from which account we want to withdrawthis.file_to_arraylista();
        if (amount <= this.Amount) {
            this.Amount -= amount;
        } else {
            this.Amount = 0f;
        }
        return this.Amount;
    }

    public float deposit(float amount) { //calculations for depositing amount this one is called in client to decide from which account we want to deposit
        this.Amount += amount;
        return Amount;
    }
    private void Acno_Manager(){//that when the code is run 2nd time and so on id's remain in sequence
        if(accounts.size()<1){
            ac_no = 0;
        }
        else{
            ac_no = accounts.size();
        }
    }
}

