package CourseMenegment.Model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private String title;
    private String courseTeachername;
    private String courseTeacherSurname;
    private List<Student>courseStudents;
    private static   int count =1;

    public Course( String name, String title, String courseTeachername, String courseTeacherSurname) {
        this.id = count++;
        this.name = name;
        this.title = title;
        this.courseTeachername = courseTeachername;
        this.courseTeacherSurname = courseTeacherSurname;
        this.courseStudents = new ArrayList<>();
    }
    public Course(){}

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseTeachername() {
        return courseTeachername;
    }

    public void setCourseTeachername(String courseTeachername) {
        this.courseTeachername = courseTeachername;
    }

    public String getCourseTeacherSurname() {
        return courseTeacherSurname;
    }

    public void setCourseTeacherSurname(String courseTeacherSurname) {
        this.courseTeacherSurname = courseTeacherSurname;
    }

    public List<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Course.count = count;
    }
}
