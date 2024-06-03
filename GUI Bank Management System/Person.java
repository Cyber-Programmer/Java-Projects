package BMS_fh;
import java.io.*;
import java.util.ArrayList;

public class Person implements Serializable {
    //default type attributes
    private static final long serialVersionUID = 7490408158506300493L;

    String Name;
    String CNIC;
    String Phone_no;
    public static ArrayList<Person> persons=new ArrayList<>();
    public Person(){
        this.Name = null;
        this.CNIC = null;
        this.Phone_no = null;
    }

    public Person(String n,String cn,String ph){
        this.Name = n;
        this.CNIC = cn;
        this.Phone_no = ph;
    }
    //getter and setter for all the attributes
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }
    @Override
    public String toString() { //to display person details
        return "Name= " + Name+
                "\nCNIC= " + CNIC+
                "\nPhone_no= " + Phone_no;
    }
    public void add_person(Person p)
    {
        persons.add(p);
    }
    public void all_person() throws IOException, ClassNotFoundException {
        for (Person temp: persons)
        {
            BMS_GUI bms = new BMS_GUI();
            bms.updateOutput(String.valueOf(temp));
        }
    }
    public void add_to_file() throws IOException, ClassNotFoundException {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\BMS_fh\\Person.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(persons);
        oos.close();
        fos.close();
    }

    public void file_to_arraylist() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("C:\\Users\\PMLS\\IdeaProjects\\Java Projects Sem 3\\src\\BMS_fh\\Person.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        persons=(ArrayList<Person>) ois.readObject();
        ois.close();
        fis.close();
    }
    public void search_person(String Cnic) throws IOException, ClassNotFoundException {
        BMS_GUI bms = new BMS_GUI();
        for (Person temp: persons) {
            if (temp.CNIC.equals(Cnic)) {
                bms.updateOutput("Person Found ");
                bms.updateOutput(String.valueOf(temp));
            }
            else{
                bms.updateOutput("No such person exists.");
            }
        }
    }
}


