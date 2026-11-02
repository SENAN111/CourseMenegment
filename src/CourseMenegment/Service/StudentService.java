package CourseMenegment.Service;

import CourseMenegment.Db.Repository;
import CourseMenegment.Model.Course;
import CourseMenegment.Model.Student;
import CourseMenegment.Utill.AppScanner;

import java.util.Locale;


public class StudentService {
    public  void  addStudent()
    {
        Student student = new Student();
        System.out.println("Telebenin adin daxil edin");
        String name =  AppScanner.scanner.nextLine();
        setStudentName(student,name);
        System.out.println("Telebenin soyadin daxil edin");
        String surname = AppScanner.scanner.nextLine();
        setStudentSurname(student,surname);
        System.out.println("Telebenin finkodun daxil edin");
        String fincode=AppScanner.scanner.nextLine();
        setStudentFincode(student,fincode);
        System.out.println("Telebenin yasin daxil edin");
        int age =AppScanner.scanner.nextInt();
        AppScanner.scanner.nextLine();
        setStudentAge(student,age);
        Repository.students.add(student);
    }

    public  void  setStudentName(Student student,String name)
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
                student.setName(name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase());
                yoxlama= false;

            }
        }

    }
    public  void setStudentSurname(Student student , String surname)
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
                student.setSurname(surname.substring(0,1).toUpperCase()+surname.substring(1).toLowerCase());
                yoxlama=false;
            }
        }
    }
    public void setStudentAge(Student student , int age)
    {
        boolean yoxlama=true;
        while (yoxlama)
        {
            if(age<6 || age>35)
            {
                System.out.println("Yas duzgun deil ,yeniden daxil edin");
                age= AppScanner.scanner.nextInt();
                AppScanner.scanner.nextLine();
            }
            else
            {
                student.setAge(age);
                yoxlama=false;

            }
        }

    }
    public void setStudentFincode(Student student ,  String fincode)
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
            for (Student s : Repository.students) {
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
            student.setFincode(fincode.toUpperCase());
            yoxlama=false;
        }


    }
    public  void showInfoStudent(Student student)
    {
        System.out.println("----------Telebe melumatlari----------");
        System.out.println("Telebenin adi : "+ student.getName());
        System.out.println("Telebenin soyadi : "+student.getSurname());
        System.out.println("Telebenin finkodu : "+student.getFincode());
        System.out.println("Telebenin oldugu kurslar");
        if(student.getStudentcourse()==null||student.getStudentcourse().isEmpty())
        {
            System.out.println("Telebe hecbir kursda istirak etmir");
        }
        else
        {
            for (Course course : student.getStudentcourse())
            {
                System.out.println(course.getName());
            }
        }
        System.out.println("---------------------------------------------");
    }
}
