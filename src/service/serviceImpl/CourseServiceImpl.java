package service.serviceImpl;

import database.Database;
import database.GenerateId;
import models.Course;
import models.Group;
import service.CourseService;
import service.GroupService;

import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {
    public static Course newCourse(){
        Scanner scanner= new Scanner(System.in);

        Course course=new Course();

        course.setId(GenerateId.lessonId());
        System.out.println("Give Lesson name:");
        course.setLessonName(scanner.nextLine());
        System.out.println("Give lesson description:");
        course.setLessonDescription(scanner.nextLine());

        Database.lessons.add(course);

        return course;
    }

    @Override
    public String addLessonToGroup(String gName) {
        GroupService groupService=new GroupServiceImpl();

        if(groupService.getGroupByName(gName)!=null){
            Course course=newCourse();
            groupService.getGroupByName(gName).getCourses().add(course);
            return "Lesson "+course.getLessonName()+" added successfully to group "+gName;
        }
        return "There is no such group.";
    }

    @Override
    public Course getLessonByName(String lName) {
        for(Course l:Database.lessons){
            if(l.getLessonName().equals(lName)){
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllLessonsByGroupName(String gName) {
        for (Group g:Database.groups){
            if(g.getGroupName().equals(gName)){
                return g.getCourses();
            }
        }
        return null;
    }

    @Override
    public String deleteLesson(String lName) {
        Course targetLesson=null;

        for(Course l:Database.lessons){
            if(l.getLessonName().equals(lName)){
                targetLesson=l;
            }
        }

        if(targetLesson!=null){
            Database.lessons.remove(targetLesson);
            for(Group g:Database.groups){
                if(g.getCourses().contains(targetLesson)){
                    g.getCourses().remove(targetLesson);
                }
            }
            return targetLesson.getLessonName()+" is deleted.";
        }

        return "There is no such lesson.";
    }
}
