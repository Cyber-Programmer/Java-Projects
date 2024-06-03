package BMS_fh;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank_fh {
    Client_fh global_client = new Client_fh(); //global like obj of client to use its methods in bank class at different places
    private String Bank_name = "Rich People Bank";
    Account_fh global_account = new Account_fh();

    @Override //to display welcome message to bank
    public String toString() {
        return "Welcome to "+ Bank_name;
    }

    public Client_fh addClient(Person p) throws IOException, ClassNotFoundException { //to make a client
        Client_fh clientt = new Client_fh();
        clientt.PersonDetails(p);
        clientt.add_client(clientt);
        return clientt;
    }
    public Account_fh addAccount(float amount, Client_fh c) throws IOException, ClassNotFoundException { //to open an account
        Account_fh acc = new Account_fh(amount,c);
        acc.add_account(acc);
        return acc;
    }
    public Account_fh searchAccount(String acc_no) { //to check account existence and details
        for (Account_fh ele:global_account.accounts) {
            if(ele.getAc_number().equals(acc_no)){
                return ele;
            }
        }
        return null;
    }
    public boolean removeClient(String id) {
        // Create copies of the lists to iterate and modify
        CopyOnWriteArrayList<Account_fh> accountsCopy = new CopyOnWriteArrayList<>(global_account.accounts);
        CopyOnWriteArrayList<Client_fh> clientsCopy = new CopyOnWriteArrayList<>(global_client.clients);

        for (Account_fh ac : accountsCopy) {
            if (ac.ACholder.person_id.equals(id)) {
                global_account.accounts.remove(ac);
            }
        }

        for (Client_fh ele : clientsCopy) {
            if (ele.person_id.equals(id)) {
                global_client.clients.remove(ele);
                return true;
            }
        }

        return false;
    }
    public float totalAmount(String clID) { //to get total amount of a person in bank while using total amount method of client
        float total_amount = global_client.totalAmount(clID);
        return total_amount;
    }
    public Client_fh searchCustomerDetail(String CNIC){ //to check client details
        Client_fh ecl = null;
        for (Client_fh ele:global_client.clients) {
            if(ele.cl_per.getCNIC().equals(CNIC)){
                ecl = ele;
            }
        }
        return ecl;
    }
}

