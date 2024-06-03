package Inheritence;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Administration> administrations = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();
        Student student;
        Administration administration;
        Faculty faculty;

        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("""
                    1) Open Student Menu
                    2) Open Teacher Menu
                    3) Open Admin Menu
                    4) Exit
                    """);
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                System.out.println("""
                        1) Create New Student Profile
                        2) Check Student Info
                        """);
                int opt = sc.nextInt();
                sc.nextLine();
                if (opt == 1) {
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Date Of Birth(DD/MM/YYYY): ");
                    String dob = sc.nextLine();
                    System.out.println("Enter Student ID: ");
                    String Id = sc.nextLine();
                    System.out.println("Enter Enrolled Semester: ");
                    String sem = sc.nextLine();
                    student = new Student(name,dob,Id,sem);
                    System.out.println("Profile Created Successfully.");
                    System.out.println(student);
                    students.add(student);
                } else if (opt == 2) {
                    System.out.println("Enter Student ID(Eg: Stu1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Student ele:students) {
                        if (ele.studentID.equals(Id)) {
                            System.out.println("Student Profile Found Successfully.");
                            ele.display();
                            at = 1;
                            break;
                        }

                    }
                    if (at == 0) {
                        System.out.println("Profile Doesn't Exist.");
                    }
                }
            } else if (option == 2) {
                System.out.println("""
                        1) Create New Teacher Profile
                        2) Check Teacher Info
                        3) Check Teacher Salary
                        4) Check Teacher's Courses
                        5) Add Course
                        """);
                int opt = sc.nextInt();
                sc.nextLine();
                if (opt == 1) {
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Date Of Birth(DD/MM/YYYY): ");
                    String dob = sc.nextLine();
                    System.out.println("Enter Employee ID: ");
                    String Id = sc.nextLine();
                    System.out.println("Enter Joining Year: ");
                    int jy = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Job Title: ");
                    String jt = sc.nextLine();
                    faculty = new Faculty(name,dob,Id,jy,jt);
                    System.out.println("Profile Created Successfully.");
                    faculties.add(faculty);
                } else if (opt == 2) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Faculty ele:faculties) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Teacher Profile Found Successfully.");
                            System.out.println(ele);
                            at = 1;
                            break;
                        }

                    }
                    if (at == 0)
                    {
                        System.out.println("Profile Doesn't Exist.");
                    }
                } else if (opt == 3) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    for (Faculty ele:faculties) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Teacher Profile Found Successfully.");
                            System.out.println("Salary: "+ele.CalcPay());
                        }
                        else
                        {
                            System.out.println("Profile Doesn't Exist.");
                        }
                    }
                } else if (opt == 4) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Faculty ele:faculties) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Teacher Profile Found Successfully.");
                            ele.getCourse_list();
                            at = 1;
                            break;
                        }

                    }
                    if (at == 0) {
                        System.out.println("Profile Doesn't Exist.");
                    }

                } else if (opt == 5) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Faculty ele:faculties) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Teacher Profile Found Successfully.");
                            System.out.println("How Many Courses You Want To Add? ");
                            for (int i = 0; i < sc.nextInt(); i++) {
                                sc.nextLine();
                                System.out.println("Enter Course To Add: ");
                                ele.setCourse_list(sc.nextLine());
                            }
                            ele.getCourse_list();
                            at = 1;
                            break;
                        }
                    }
                    if (at == 0) {
                        System.out.println("Profile Doesn't Exist.");
                    }
                }
            } else if (option == 3) {
                System.out.println("""
                        1) Create New Admin Profile
                        2) Check Admin Info
                        3) Check Admin Salary
                        4) Change Job Title
                        """);
                int opt = sc.nextInt();
                sc.nextLine();
                if (opt == 1) {
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Date Of Birth(DD/MM/YYYY): ");
                    String dob = sc.nextLine();
                    System.out.println("Enter Employee ID: ");
                    String Id = sc.nextLine();
                    System.out.println("Enter Joining Year: ");
                    int jy = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Job Title: ");
                    String jt = sc.nextLine();
                    administration = new Administration(name,dob,Id,jy,jt);
                    System.out.println("Profile Created Successfully.");
                    administrations.add(administration);
                } else if (opt == 2) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Administration ele:administrations) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Admin Profile Found Successfully.");
                            System.out.println(ele);
                            at = 1;
                            break;
                        }

                    }
                    if (at == 0) {
                        System.out.println("Profile Doesn't Exist.");
                    }
                } else if (opt == 3) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Administration ele:administrations) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Admin Profile Found Successfully.");
                            System.out.println("Salary: "+ele.CalcPay());
                            at = 1;
                            break;
                        }

                    }
                    if (at == 0) {
                        System.out.println("Profile Doesn't Exist.");
                    }
                } else if (opt == 4) {
                    System.out.println("Enter Employee ID(Eg: Emp1): ");
                    String Id = sc.nextLine();
                    int at = 0;
                    for (Administration ele:administrations) {
                        if (ele.employeeID.equals(Id)) {
                            System.out.println("Admin Profile Found Successfully.");
                            System.out.println(ele.getJobTitle());
                            System.out.println("Enter New Job Title: ");
                            ele.setJobTitle(sc.nextLine());
                            at = 1;
                            break;
                        }

                    }
                    if (at == 0) {
                        System.out.println("Profile Doesn't Exist.");
                    }
                }
            } else if (option == 4) {
                System.exit(0);
            }
            else
            {
                System.out.println("Enter Valid Input.");
            }
        }
    }
}
