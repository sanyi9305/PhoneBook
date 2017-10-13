/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sannyi
 */
public class Person {

    private final SimpleStringProperty lastname;
    private final SimpleStringProperty firstname;
    private final SimpleStringProperty email;
    private final SimpleStringProperty id;

    public Person() {
        this.firstname = new SimpleStringProperty("");
        this.lastname = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.id = new SimpleStringProperty("");
    }

    public Person(String lastname, String firstname, String email) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.id = new SimpleStringProperty("");
        
    }
 public Person(Integer id, String lastname, String firstname, String email) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.id = new SimpleStringProperty(String.valueOf(id));
    }
    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lname) {
        lastname.set(lname);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String fname) {
        firstname.set(fname);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String eemail) {
        email.set(eemail);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String Id) {
        id.set(Id);
    }
}
