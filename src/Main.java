import database.Database;
import enums.Gender;
import models.Course;
import models.Group;
import models.Student;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Course lesson1=new Course(1L,"Lesson1","Lesson1 description");
//        Course lesson2=new Course(2L,"Lesson2","Lesson2 description");
//        Course lesson3=new Course(3L,"Lesson3","Lesson3 description");
//        Course lesson4=new Course(4L,"Lesson4","Lesson4 description");
//
//        ArrayList<Course>lessons1=new ArrayList<>();
//        lessons1.add(lesson1);
//        lessons1.add(lesson2);
//        ArrayList<Course>lessons2=new ArrayList<>();
//        lessons2.add(lesson3);
//        lessons2.add(lesson4);
//
//
//        Student student1=new Student(1L,"Student1","Student1 lastName","student1@mail","12345", Gender.MALE);
//        Student student2=new Student(2L,"Student2","Student2 lastName","student2@mail","12345", Gender.MALE);
//        Student student3=new Student(3L,"Student3","Student3 lastName","student3@mail","12345", Gender.FEMALE);
//
//        ArrayList<Student>students1=new ArrayList<>();
//        students1.add(student1);
//        ArrayList<Student>students2=new ArrayList<>();
//        students2.add(student2);
//        students2.add(student3);
//
//        Group group1=new Group(1L,"Group1","Group1 description",lessons1,students1 );
//        Group group2=new Group(2L,"Group2","Group2 description",lessons2,students2 );

        User user1=new User(1L,"admin@","admin123");
        Database.users.add(user1);


        Start.start();

    }
}