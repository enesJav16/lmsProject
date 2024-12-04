package service.serviceImpl;

import database.Database;
import enums.Gender;
import models.Course;
import models.Group;
import models.Student;
import service.StudentService;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    public static Student newStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Type students firstname:");
        student.setFirstName(scanner.nextLine());
        System.out.println("Type students lastname:");
        student.setLastName(scanner.nextLine());
        while (true) {
            System.out.println("Type students email:");
            String studentEmailInput = scanner.nextLine();
            if (emailCheck(studentEmailInput) && uniqueEmailCheck(studentEmailInput)) {
                student.setEmail(studentEmailInput);
                break;
            } else {
                System.out.println("Email must contain '@' and must be unique.");
            }
        }
        while (true) {
            System.out.println("Type password:");
            String studentPasswordInput = scanner.nextLine();
            if (passwordCheck(studentPasswordInput)) {
                student.setPassword(studentPasswordInput);
                break;
            } else {
                System.out.println("Password must contain at least 7 symbols.");
            }
        }
        while (true) {
            System.out.println("Type gender (male/female)");
            String studentGenderInput = scanner.nextLine();
            if (studentGenderInput.equalsIgnoreCase("male")) {
                student.setGender(Gender.MALE);
                break;
            } else if (studentGenderInput.equalsIgnoreCase("female")) {
                student.setGender(Gender.FEMALE);
                break;
            } else {
                System.out.println("Give correct gender. (male/female)");
            }
        }
        return student;
    }

    private static boolean emailCheck(String e) {
        if (e.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean uniqueEmailCheck(String e) {
        for (Student s : Database.students) {
            if (s.getEmail().equals(e)) {
                return false;
            }
        }
        return true;
    }

    private static boolean passwordCheck(String p) {
        if (p.length() >= 7) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkStudent(String sEmail) {
        for (Student s : Database.students) {
            if (s.getEmail().equals(sEmail)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStudentCredentials(String e, String p) {
        boolean check = false;
        if (!Database.students.isEmpty()) {
            for (Student s : Database.students) {
                if (s.getEmail().equals(e) && s.getPassword().equals(p)) {
                    check = true;
                }
            }
        }
        return check;
    }

    @Override
    public void updateStudent(String sEmail) {
//        if (checkStudent(sEmail)) {
//            Student targetStudent = null;
//            for (Student stt : Database.students) {
//                if (stt.getEmail().equals(sEmail)) {
//                    targetStudent = stt;
//                    break;
//                }
//            }
//            if (targetStudent != null) {
//                Student s = newStudent();
//                targetStudent.setFirstName(s.getFirstName());
//                targetStudent.setLastName(s.getLastName());
//                targetStudent.setEmail(s.getEmail());
//                targetStudent.setPassword(s.getPassword());
//                targetStudent.setGender(s.getGender());
//
//                for (Group g : Database.groups) {
//                    if (g.getStudents().contains(targetStudent)) {
//                        for (Student student : g.getStudents()) {
//                            if (student.equals(targetStudent)) {
//                                student.setFirstName(s.getFirstName());
//                                student.setLastName(s.getLastName());
//                                student.setEmail(s.getEmail());
//                                student.setPassword(s.getPassword());
//                                student.setGender(s.getGender());
//                                break;
//                            }
//                        }
//                    }
//                }
//
//                System.out.println(targetStudent);
//                System.out.println("Student updated successfully.");
//            }
//
//        } else {
//            System.out.println("There is no student with such email.");
//        }

        if (checkStudent(sEmail)) {
            Student targetStudent = null;

            for (Student st : Database.students) {
                if (st.getEmail().equals(sEmail)) {
                    targetStudent = st;
                    break;
                }
            }

            if (targetStudent != null) {
                System.out.println("Updating student: " + targetStudent.getFirstName());

                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter new first name (leave empty to keep current):");
                String newFirstName = scanner.nextLine();
                if (!newFirstName.trim().isEmpty()) {
                    targetStudent.setFirstName(newFirstName);
                }

                System.out.println("Enter new last name (leave empty to keep current):");
                String newLastName = scanner.nextLine();
                if (!newLastName.trim().isEmpty()) {
                    targetStudent.setLastName(newLastName);
                }

                while (true) {
                    System.out.println("Enter new email (leave empty to keep current):");
                    String newEmail = scanner.nextLine();
                    if (newEmail.trim().isEmpty() || newEmail.equals(sEmail) || uniqueEmailCheck(newEmail)) {
                        if (!newEmail.trim().isEmpty()) {
                            targetStudent.setEmail(newEmail);
                        }
                        break;
                    } else {
                        System.out.println("Email must be unique and contain '@'. Try again.");
                    }
                }

                System.out.println("Enter new password (leave empty to keep current):");
                String newPassword = scanner.nextLine();
                if (!newPassword.trim().isEmpty()) {
                    targetStudent.setPassword(newPassword);
                }

                System.out.println("Enter new gender (male/female) (leave empty to keep current):");
                String newGender = scanner.nextLine();
                if (!newGender.trim().isEmpty()) {
                    if (newGender.equalsIgnoreCase("male")) {
                        targetStudent.setGender(Gender.MALE);
                    } else if (newGender.equalsIgnoreCase("female")) {
                        targetStudent.setGender(Gender.FEMALE);
                    } else {
                        System.out.println("Invalid gender entered. Keeping current gender.");
                    }
                }

                for (Group g : Database.groups) {
                    if (g.getStudents().contains(targetStudent)) {
                        for (Student student : g.getStudents()) {
                            if (student.equals(targetStudent)) {
                                student.setFirstName(targetStudent.getFirstName());
                                student.setLastName(targetStudent.getLastName());
                                student.setEmail(targetStudent.getEmail());
                                student.setPassword(targetStudent.getPassword());
                                student.setGender(targetStudent.getGender());
                                break;
                            }
                        }
                    }
                }

                System.out.println("Student updated successfully.");
                System.out.println(targetStudent);
            }
        } else {
            System.out.println("There is no student with such email.");
        }


    }

    @Override
    public Student findStudentByName(String name) {
        for (Student s : Database.students) {
            if (s.getFirstName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(String gName) {
        if (GroupServiceImpl.checkGroup(gName)) {
            for (Group g : Database.groups) {
                if (g.getGroupName().equals(gName)) {
                    return g.getStudents();
                }
            }
        }
        return null;

    }

    @Override
    public String deleteStudent(String sEmail) {
        Student targetStudent = null;
        for (Student s: Database.students) {
            if (s.getEmail().equals(sEmail)) {
                targetStudent = s;
            }
        }
        if (targetStudent != null) {
            for (Group g : Database.groups) {
                if (g.getStudents().contains(targetStudent)) {
                    g.getStudents().remove(targetStudent);
                    Database.students.remove(targetStudent);
                }
            }
        }
        else {
            return "There is no student with such email.";
        }
        return targetStudent.getFirstName() + " is deleted.";
    }

    @Override
    public List<Course> getStudentsLessons(String sEmail) {
        Student targetStudent = null;
        for (Student s : Database.students) {
            if (s.getEmail().equals(sEmail)) {
                targetStudent = s;
            }
        }
        if (targetStudent != null) {
            for (Group g : Database.groups) {
                if (g.getStudents().contains(targetStudent)) {
                    return g.getCourses();
                }
            }
        }
        return null;
    }
}
