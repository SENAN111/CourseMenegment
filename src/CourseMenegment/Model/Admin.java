package CourseMenegment.Model;

public class Admin {
    private String name;
    private String surname;
    private String fincode;

    public Admin(String name, String surname, String fincode) {
        this.name = name;
        this.surname = surname;
        this.fincode = fincode;
    }

    public Admin() {

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
}
