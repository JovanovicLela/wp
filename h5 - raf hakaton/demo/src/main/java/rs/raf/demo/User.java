package rs.raf.demo;


import java.io.Serializable;

public class User implements Serializable {

    private String firstname;

    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return this.getFirstname() + " " + this.getLastname();
    }
}
