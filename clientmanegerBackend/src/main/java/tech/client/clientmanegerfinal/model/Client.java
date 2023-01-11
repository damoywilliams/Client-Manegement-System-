package tech.client.clientmanegerfinal.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
    private String Firstname;
    private String Lastname;

    private String casediscription;
    private String  email;

    private Boolean iscaseopen;
    private String imageurl;

    private String  phonenumber;

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getCaseDiscription() {
        return casediscription;
    }

    public void setCaseDiscription(String caseDiscription) {
        casediscription = caseDiscription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCaseOpen() {
        return iscaseopen;
    }

    public void setCaseOpen(Boolean caseOpen) {
        iscaseopen = caseOpen;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Lastname='" + phonenumber+ '\'' +
                ", casediscription='" + casediscription + '\'' +
                ", email='" + email + '\'' +
                ", caseopen=" + iscaseopen +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
