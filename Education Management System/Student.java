package Inheritence;

public class Student extends Person{
    String studentID;
    String enrolledSemester;

    public Student(String name, String year_of_birth, String studentID, String enrolledSemester) {
        super(name, year_of_birth);
        this.studentID = "Stu"+studentID;
        this.enrolledSemester = "Sem"+enrolledSemester;
    }
    public void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Year Of Birth: "+date_of_birth);
        System.out.println("StudentID: "+studentID);
        System.out.println("Semester: "+enrolledSemester);

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", enrolledSemester='" + enrolledSemester + '\'' +
                ", name='" + name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}
