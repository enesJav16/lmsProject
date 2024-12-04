package service;

import models.Course;
import models.Group;

import java.util.List;

public interface CourseService {
    String addLessonToGroup(String gName);
    Course getLessonByName(String lName);
    List<Course> getAllLessonsByGroupName(String gName);
    String deleteLesson(String lName);
}
