package BMS_fh;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class User implements Serializable {
    protected String username;
    protected char[] password;
    protected String phoneno;
    protected String CNIC;
    protected static ArrayList<User> users = new ArrayList<>();

    public User() {
        this.username = null;
        this.password = null;
        this.CNIC = null;
        this.phoneno = null;
    }

    public User(String username, char[] password, String phoneno, String CNIC) {
        this.username = username;
        this.password = password.clone();
        this.phoneno = phoneno;
        this.CNIC = CNIC;
        System.out.println("User registered!");
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password.clone();
    }

    public void adduser(User u) {
        users.add(u);
    }

    public void add_to_file() throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\GUI\\Users.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
        fos.close();
        System.out.println("Data successfully added👍🏻");
    }

    public void file_to_arraylist() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\GUI\\Users.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = (ArrayList<User>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Array list loaded successfully👍🏻");
    }

    public boolean search_user(String name, char[] password) {
        boolean ans = false;
        for (User temp : users) {
            if (temp.username.equals(name) && Arrays.equals(temp.password, password)) {
                ans = true;
                break;  // Break out of the loop once a match is found
            }
        }
        return ans;
    }
}

