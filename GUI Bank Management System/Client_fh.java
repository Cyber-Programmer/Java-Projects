package BMS_fh;
import java.io.*;
import java.util.ArrayList;
public class Client_fh implements Serializable {
    private static final long serialVersionUID = -8803220322956606331L;
    static int ID = 0;//to give separate and sequenced id numbers to each new client
    Person cl_per;//the person details of client
    String person_id;
    Account_fh acc_global = new Account_fh();
    public static ArrayList<Client_fh> clients=new ArrayList<>();
    public void add_to_filec() throws IOException, ClassNotFoundException {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\BMS_fh\\Client.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(clients);
        oos.close();
        fos.close();
    }

    public void file_to_arraylistc() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\BMS_fh\\Client.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        clients=(ArrayList<Client_fh>) ois.readObject();
        ois.close();
        fis.close();
    }
    public Client_fh(){
        this.cl_per = null;
        this.person_id = null;
    }
    public void PersonDetails(Person p) throws IOException, ClassNotFoundException { //to make person a client
        this.cl_per = p;
        this.id_manager();
        this.person_id = "PER"+ID;
        ID++;
        BMS_GUI bmsGui = new BMS_GUI();
        bmsGui.updateOutput("Your ID is "+ this.person_id);
        bmsGui.updateOutput("Client Added successfully");
    }

    @Override
    public String toString() { //to display client details while using person tostring as well
        return "\nperson_id= " + person_id+
                "\n" + cl_per.toString();
    }
    public void add_client(Client_fh c)
    {
        clients.add(c);
    }
    public void all_clients() throws IOException, ClassNotFoundException {
        if(clients.size()<1){
            BMS_GUI bmsGui = new BMS_GUI();
            bmsGui.updateOutput("There isn't any client in the bank.");
        }
        for (Client_fh temp: clients)
        {
            BMS_GUI bms = new BMS_GUI();
            bms.updateOutput(String.valueOf(temp));
        }
    }
    public float totalAmount(String per_id){ //check person ids of the accounts and give total amount present in bank of the person id
        float total_am = 0;
        for (Account_fh ele: acc_global.accounts) {
            if(ele.ACholder.person_id.equals(per_id)){
                total_am += ele.getAmount();
            }
        }
        return total_am;
    }
    public void withdraw(float amount, String accNo) throws IOException, ClassNotFoundException { //check given account details and call account class method accordingly, then display the required message
        for (Account_fh ele:acc_global.accounts) {
            if(ele.getAc_number().equals(accNo)){
                float amo = ele.withdraw(amount);
                if(amo==0){
                    BMS_GUI bmsGui = new BMS_GUI();
                    bmsGui.updateOutput("Insufficient balance.");
                }
                else{
                acc_global.setAmount(amo);
                BMS_GUI bmsGui = new BMS_GUI();
                bmsGui.updateOutput("The amount of "+amount+" has been withdrawn from "+accNo+" Now the remaining balance is "+(int) amo);
            }
            }
        }
    }
    public void deposit(float amount, String accNo) throws IOException, ClassNotFoundException { //check given account details and call account class method accordingly, then display the required message
        for (Account_fh ele: acc_global.accounts) {
            if(ele.getAc_number().equals(accNo)){
                float amo = ele.deposit(amount);
                ele.setAmount(amo);
                BMS_GUI bmsGui = new BMS_GUI();
                bmsGui.updateOutput("The amount of "+amount+" has been deposited to "+accNo+" Now the balance is "+(int) amo);
            }
        }
    }
    private void id_manager(){//that when the code is run 2nd time and so on id's remain in sequence
        if(clients.size()<1){
            ID = 0;
        }
        else{
            ID = clients.size();
        }
   }
}

