package CourseMenegment.Service;

import CourseMenegment.Db.Repository;
import CourseMenegment.Model.Admin;
import CourseMenegment.Model.Course;
import CourseMenegment.Model.Student;
import CourseMenegment.Utill.AppScanner;

import java.util.Locale;

public class AdminService {
    public  void  setAdminName(Admin admin , String name)
    {
        boolean yoxlama = true;
        while (yoxlama)
        {
            if(name==null || name.trim().length()<3 || name.trim().length()>18)
            {
                System.out.println("Ad düzgün deyil, yenidən daxil edin");
                name= AppScanner.scanner.nextLine();
            }
            else
            {
                name=name.trim();
                admin.setName(name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase());
                yoxlama= false;

            }
        }
    }
    public  void  setAdminSurname(Admin admin , String surname)
    {
        boolean yoxlama=true;
        while (yoxlama)
        {
            if(surname==null || surname.trim().length()<5 || surname.trim().length()>30)
            {
                System.out.println("Soyad duzugun deil , yeniden daxil edin");
                surname=AppScanner.scanner.nextLine();
            }
            else
            {
                surname=surname.trim();
                admin.setSurname(surname.substring(0,1).toUpperCase()+surname.substring(1).toLowerCase());
                yoxlama=false;
            }
        }
    }
    public  void setAdminFincode(Admin admin, String fincode)
    {
        boolean yoxlama = true;
        while (yoxlama)
        {
            fincode=fincode.toUpperCase();
            if(fincode.trim().length()!=7)
            {
                System.out.println("Finkodu dogru daxil etmemisniz");
                fincode=AppScanner.scanner.nextLine();
                continue;
            }

            boolean duplicate = false;
            for (Admin s : Repository.admins) {
                if (s.getFincode().equals(fincode)) {
                    System.out.println("Bu Finkod artıq istifadə edilib, yenidən daxil edin:");
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                fincode = AppScanner.scanner.nextLine();
                continue;
            }
            admin.setFincode(fincode);
            yoxlama=false;
        }
    }
    public  void  addStudent()
    {
        StudentService studentService =  new StudentService();
        Student student = new Student();
        System.out.println("Telebenin adin daxil edin");
        String name =  AppScanner.scanner.nextLine();
        studentService.setStudentName(student,name);
        System.out.println("Telebenin soyadin daxil edin");
        String surname = AppScanner.scanner.nextLine();
       studentService.setStudentSurname(student,surname);
        System.out.println("Telebenin finkodun daxil edin");
        String fincode=AppScanner.scanner.nextLine();
       studentService.setStudentFincode(student,fincode);
        System.out.println("Telebenin yasin daxil edin");
        int age =AppScanner.scanner.nextInt();
        AppScanner.scanner.nextLine();
       studentService.setStudentAge(student,age);
        Repository.students.add(student);
    }
    public  void  deleteStudent()
    {
        System.out.println("Silmek istediyiniz telebenin finkodun daxil edin");
        String fincode = AppScanner.scanner.nextLine();
        fincode=fincode.toUpperCase();
        String fincode1=fincode;
        boolean silindi = Repository.students.removeIf(student -> student.getFincode().equals(fincode1));
        if(!silindi)
        {
            System.out.println("Bele telebe yoxdur");
        }
        else
        {
            System.out.println("Telebe silindi");
        }

    }
    public  void  showCourses()
    {
        System.out.println("**************Kurslar****************");
        for( Course course : Repository.courses)
        {
            System.out.println(course.getName()+"Tedris eden Muellim"+course.getCourseTeachername());
        }
        System.out.println("**************************************");
    }
    public  void studentAddCourse()
    {
        System.out.println("Telebinin Finkodun daxil edin");
        String searchfincode=AppScanner.scanner.nextLine();
        boolean searchstudent =  true;

            for (Student student :Repository.students)
            {
                if(student.getFincode().equalsIgnoreCase(searchfincode))
                {
                    searchstudent=false;
                    StudentService studentService = new StudentService();
                    studentService.showInfoStudent(student);
                    System.out.println("Telebeni teyin etmek istediyiniz kursun adin daxil edin");
                    String addcoursename=AppScanner.scanner.nextLine();
                    boolean searchcourse=true;
                        for (Course course : Repository.courses)
                        {
                            if(course.getName().equalsIgnoreCase(addcoursename))
                            {
                                student.getStudentcourse().add(course);
                                System.out.println("Telebe ugurla cursa teyin edildi");
                                searchcourse=false;
                                searchstudent=false;

                            }
                        }
                        if(searchcourse)
                        {
                            System.out.println("Bele kurs tapilmadi");
                            searchstudent=false;

                        }
                }
            }
            if(searchstudent)
            {
                System.out.println("Bele telebe tapilmadi");
            }
    }
}
