package models;

import enums.Gender;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;


    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String email, String password, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Student(String firstName, String lastName, String email, String password, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "\n\t\tid        :" + id +
                "\n\t\tfirstName :" + firstName +
                "\n\t\tlastName  :" + lastName +
                "\n\t\temail     :" + email +
                "\n\t\tpassword  :" + password +
                "\n\t\tgender    :" + gender+
                "\n\t\t^^^^^^^^^^^^^^^^^^^^^^^^^^";
    }
}
