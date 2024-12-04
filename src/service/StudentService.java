package service;

import models.Course;
import models.Student;

import java.util.List;

public interface StudentService {
    void updateStudent(String sEmail);
    Student findStudentByName(String name);
    List<Student> getAllStudentsByGroupName(String gName);
    String deleteStudent(String sEmail);
    List<Course>getStudentsLessons(String sEmail);
}
