package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Group {
    private Long id;
    private String groupName;
    private String description;
    private ArrayList<Course>courses=new ArrayList<>();
    private ArrayList<Student>students=new ArrayList<>();

    public Group() {
    }

    public Group(Long id, String groupName, String description, ArrayList<Course> courses, ArrayList<Student> students) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.courses = courses;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Student>getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "\nid          :" + id +
                "\ngroupName   :" + groupName +
                "\ndescription :" + description +
                "\ncourses     :" + courses +
                "\nstudents    :" + students +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
