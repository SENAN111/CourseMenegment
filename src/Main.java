import CourseMenegment.Db.Repository;
import CourseMenegment.Model.Course;
import CourseMenegment.Service.AdminService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        adminService.addStudent();
        Course java = new Course("Java","Backend","Nurlan","Memmedov");
        Repository.courses.add(java);
        adminService.studentAddCourse();


    }
}