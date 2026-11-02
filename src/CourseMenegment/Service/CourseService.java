package CourseMenegment.Service;

import CourseMenegment.Model.Course;
import CourseMenegment.Utill.AppScanner;

import java.util.Locale;

public class CourseService {
    public void setCourseName( Course course , String name)
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
                course.setName(name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase());
                yoxlama= false;

            }
        }
    }
    public void setCourseTitle(Course course , String title)
    {
        boolean yoxlama= true;
        while (yoxlama)
        {
            if(title==null || title.trim().length()<10 || title.trim().length()>100)
            {
                System.out.println("Kurs haqqinda melumati dogru daxil etmemisniz");
                title=AppScanner.scanner.nextLine();
            }
            else
            {
                course.setTitle(title.trim());
                yoxlama=false;
            }
        }
    }
    public  void  setCourseTeacherName(Course course , String teachername)
    {
        boolean yoxlama = true;
        while (yoxlama)
        {
           if(teachername==null || teachername.trim().length()<3 || teachername.trim().length()>18)
           {
               System.out.println("Ad düzgün deyil, yenidən daxil edin");
               teachername=AppScanner.scanner.nextLine();
           }
           else
           {
                teachername=teachername.trim();
               course.setCourseTeachername(teachername.substring(0,1).toUpperCase()+teachername.substring(1).toLowerCase());
               yoxlama=false;
           }
        }
    }
    public void setCourseTeacherSurname(Course course , String teachersurname)
    {
        boolean yoxlama=true;
        while (yoxlama)
        {
            if(teachersurname==null || teachersurname.trim().length()<5 || teachersurname.trim().length()>30)
            {
                System.out.println("Soyadi dogru daxil etmemisniz");
                teachersurname=AppScanner.scanner.nextLine();
            }
            else
            {
                teachersurname=teachersurname.trim();
                course.setCourseTeacherSurname(teachersurname.substring(0,1).toUpperCase()+teachersurname.substring(1).toLowerCase());
                yoxlama=false;
            }
        }
    }
}
