package Inheritence;

public class Administration extends Employee{
    public Administration(String name, String date_of_birth, String employeeID, int joiningyear, String jobTitle) {
        super(name, date_of_birth, employeeID, joiningyear, jobTitle);
    }

    public int CalcPay()
    {
        int yearofservice = 2023 - joiningyear;
        int pay = yearofservice * 5000;
        return pay;
    }

    public void setJobTitle(String title)
    {
        jobTitle = title;
    }
    public String getJobTitle()
    {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "Administration{" +
                "employeeID='" + employeeID + '\'' +
                ", joiningyear=" + joiningyear +
                ", jobTitle='" + jobTitle + '\'' +
                ", name='" + name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}


