package Inheritence;

public abstract class Employee extends Person{
    String employeeID;
    int joiningyear;
    String jobTitle;

    public Employee(String name, String date_of_birth, String employeeID, int joiningyear, String jobTitle) {
        super(name, date_of_birth);
        this.employeeID = "Emp"+employeeID;
        this.joiningyear = joiningyear;
        this.jobTitle = jobTitle;
    }
    public abstract int CalcPay();

    @Override
    public String toString() {
        return "Name: "+name+"\n"+"Date Of Birth: "+date_of_birth+"\n"+"EmployeeID: "+employeeID+"\n" +"Job Title: "+jobTitle+"\n"+"Joining Year: "+joiningyear;

    }
}
