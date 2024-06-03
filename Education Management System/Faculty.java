package Inheritence;

import java.util.ArrayList;

public class Faculty extends Employee{
    ArrayList<String> course_list = new ArrayList<>();

    public Faculty(String name, String date_of_birth, String employeeID, int joiningyear, String jobTitle) {
        super(name, date_of_birth, employeeID, joiningyear, jobTitle);
    }
    public int CalcPay()
    {
        int yearofservice = 2023 - joiningyear;
        int pay = yearofservice * 4000;
        return pay;
    }

    public void setCourse_list(String course)
    {

                course_list.add(course);
                System.out.println("Course Added Successfully.");


    }

    public void getCourse_list()
    {
        System.out.println(course_list.toString());
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "course_list=" + course_list +
                ", employeeID='" + employeeID + '\'' +
                ", joiningyear=" + joiningyear +
                ", jobTitle='" + jobTitle + '\'' +
                ", name='" + name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}
