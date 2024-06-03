package Inheritence;

public class Person {
    String name;
    String date_of_birth;

    public Person(String name, String date_of_birth) {
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Name: "+name +"\n"+ "Date Of Birth: "+date_of_birth;
    }
}
