package CourseMenegment.Model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private  String name;
    private String surname;
    private String fincode;
    private int age;
    List<Course> studentcourse;
    private  static  int count=1;

    public Student( String name, String surname, String fincode, int age) {
        this.id = count++;
        this.name = name;
        this.surname = surname;
        this.fincode = fincode;
        this.age = age;
        this.studentcourse = new ArrayList<>();
    }
    public  Student()
    {
        this.id=count++;
        this.studentcourse = new ArrayList<>();
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFincode() {
        return fincode;
    }

    public void setFincode(String fincode) {
        this.fincode = fincode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getStudentcourse() {
        return studentcourse;
    }

    public void setStudentcourse(List<Course> studentcourse) {
        this.studentcourse = studentcourse;
    }

}
