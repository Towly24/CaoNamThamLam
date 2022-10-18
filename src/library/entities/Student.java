package library.entities;

public class Student {
    private int id;
    private String name;
    private String gmail;
    private int telephone;

    public Student() {
    }

    public Student(int id, String name, String gmail, int telephone) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
