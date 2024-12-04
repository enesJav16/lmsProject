import database.Database;
import models.User;
import service.CourseService;
import service.GroupService;
import service.StudentService;
import service.serviceImpl.CourseServiceImpl;
import service.serviceImpl.GroupServiceImpl;
import service.serviceImpl.StudentServiceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    static boolean check1 = false;
    static boolean check2 = false;
    static boolean check3 = false;


    static void time() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        int hour = time.getHour();
        String greeting;

        if (hour >= 6 && hour < 12) {
            greeting = "Good morning!";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good afternoon!";
        } else if (hour >= 18 && hour < 22) {
            greeting = "Good evening!";
        } else {
            greeting = "Good night!";
        }

        System.out.println(greeting + " Time: " + time.format(format));
    }

    private static void userCheck() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (!check1) {
            try {
                System.out.println("If you registered type 1, if forget your password and want to change it type 2.");
                int inputOne = scanner1.nextInt();
                switch (inputOne) {
                    case 1 -> {
                        System.out.println("Type email: ");
                        String userEmailInput = scanner.nextLine();
                        System.out.println("Type password: ");
                        String userPasswordInput = scanner.nextLine();

                        boolean userEmailCheck = false;
                        boolean userPasswordCheck = false;
                        for (User u : Database.users) {
                            if (u.getEmail().equals(userEmailInput)) {
                                userEmailCheck = true;
                                if (u.getPassword().equals(userPasswordInput)) {
                                    userPasswordCheck = true;
                                }
                            }
                        }
                        if (userPasswordCheck && userEmailCheck) {
                            check1 = true;
                            check2 = true;
                        } else {
                            System.out.println("Incorrect email or password.");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Give correct format.");
                scanner1.nextLine();
            }
        }
    }

    public static void start() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        GroupService groupService = new GroupServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();

        time();
        userCheck();

        while (check2) {
            try {
                System.out.println("====================================");
                System.out.println("====================================");
                System.out.println("What do you want to do:");
                System.out.println("""
                        ====================================
                        1.  Add new group
                        2.  Get group by name
                        3.  Update group name
                        4.  Get all groups
                        5.  Add new student to group
                        6.  Update student
                        7.  Find student by first name
                        8.  Get all student by group name
                        9.  Get all student's lesson
                        10. Delete Student
                        11. Add new lesson to group
                        12. Get lesson by name
                        13. Get all lessons by group name
                        14. Delete lesson
                        15. Delete group
                        """);
                int input = scanner1.nextInt();
                switch (input) {
                    case 1 -> groupService.addNewGroup();
                    case 2 -> {
                        System.out.println("Type group name:");
                        String name = scanner.nextLine();
                        if (GroupServiceImpl.checkGroup(name)) {
                            System.out.println(groupService.getGroupByName(name));
                        } else {
                            System.out.println("There is no such group.");
                        }
                    }
                    case 3 -> {
                        System.out.println("Type group name:");
                        String n = scanner.nextLine();
                        System.out.println("Type new name:");
                        String nn = scanner.nextLine();
                        groupService.updateGroupByName(n, nn);
                    }
                    case 4 -> System.out.println(Arrays.toString(groupService.getAllGroups().toArray()));
                    case 5 -> {
                        System.out.println("To which group you want to add Student.");
                        String gName = scanner.nextLine();
                        groupService.addNewStudentToGroup(gName);
                    }
                    case 6 -> {
                        System.out.println("Type email:");
                        String studentEmailInput = scanner.nextLine();
                        System.out.println("Type password:");
                        String studentPasswordInput = scanner.nextLine();
                        if (StudentServiceImpl.checkStudentCredentials(studentEmailInput, studentPasswordInput)) {
                            studentService.updateStudent(studentEmailInput);
                        } else {
                            System.out.println("Incorrect email or password.");
                        }
                    }
                    case 7 -> {
                        System.out.println("Type first name");
                        String sNameInput = scanner.nextLine();
                        if (studentService.findStudentByName(sNameInput) != null) {
                            System.out.println(studentService.findStudentByName(sNameInput));
                        } else {
                            System.out.println("There is no such student.");
                        }
                    }
                    case 8 -> {
                        System.out.println("Type group name:");
                        String gNameInput = scanner.nextLine();
                        if (studentService.getAllStudentsByGroupName(gNameInput) != null) {
                            System.out.println(studentService.getAllStudentsByGroupName(gNameInput));
                        } else {
                            System.out.println("There is no such group.");
                        }
                    }
                    case 9 -> {
                        System.out.println("Type students email");
                        String sEmailInput = scanner.nextLine();
                        if (studentService.getStudentsLessons(sEmailInput) != null) {
                            System.out.println(studentService.getStudentsLessons(sEmailInput));
                        } else {
                            System.out.println("There is no student with such email.");
                        }
                    }
                    case 10 -> {
                        System.out.println("Type email of student you want to delete.");
                        String sEmailInput = scanner.nextLine();
                        System.out.println(studentService.deleteStudent(sEmailInput));
                    }
                    case 11 -> {
                        System.out.println("Type group name:");
                        String gNameInput = scanner.nextLine();
                        System.out.println(courseService.addLessonToGroup(gNameInput));
                    }
                    case 12 -> {
                        System.out.println("Type lesson name:");
                        String lNameInput = scanner.nextLine();
                        if (courseService.getLessonByName(lNameInput) != null) {
                            System.out.println(courseService.getLessonByName(lNameInput));
                        } else {
                            System.out.println("There is no lesson with such name.");
                        }
                    }
                    case 13 -> {
                        System.out.println("Type group name:");
                        String gNameInput = scanner.nextLine();
                        if (courseService.getAllLessonsByGroupName(gNameInput) != null) {
                            System.out.println(courseService.getAllLessonsByGroupName(gNameInput));
                        } else {
                            System.out.println("There is no such group.");
                        }
                    }
                    case 14 -> {
                        System.out.println("Type lesson name you want to delete:");
                        String lNameInput = scanner.nextLine();
                        System.out.println(courseService.deleteLesson(lNameInput));
                    }
                    case 15 -> {
                        System.out.println("Type group name you want to delete:");
                        String gNameInput = scanner.nextLine();
                        System.out.println(groupService.deleteGroup(gNameInput));
                    }

                    case 20 -> System.out.println(Database.students);

                }
            } catch (InputMismatchException e) {
                System.out.println("Give correct format");
                scanner1.nextLine();

            }
        }
    }
}
