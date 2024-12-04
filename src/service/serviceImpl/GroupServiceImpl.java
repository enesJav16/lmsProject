package service.serviceImpl;

import database.Database;
import database.GenerateId;
import models.Group;
import models.Student;
import service.GroupService;

import java.util.List;
import java.util.Scanner;

public class GroupServiceImpl implements GroupService {

    @Override
    public void addNewGroup() {
        Group g=new Group();
        g.setId(GenerateId.groupId());
        System.out.println("Type group name:");
        g.setGroupName(new Scanner(System.in).nextLine());
        System.out.println("Type group description:");
        g.setDescription(new Scanner(System.in).nextLine());

        Database.groups.add(g);

        System.out.println(g);
        System.out.println("Group "+g.getGroupName()+" is added." );
    }

    @Override
    public Group getGroupByName(String name) {
        for(Group g:Database.groups){
            if(g.getGroupName().equals(name)){
                return g;
            }
        }
        return null;
    }

    @Override
    public void updateGroupByName(String n, String nn) {
        if(checkGroup(n)){
            getGroupByName(n).setGroupName(nn);
            System.out.println(getGroupByName(nn));
        }else {
            System.out.println("There is no such group.");
        }
    }

    @Override
    public List<Group> getAllGroups() {
        return Database.groups;
    }

    @Override
    public void addNewStudentToGroup(String gName) {
        if(checkGroup(gName)){
            Student s=new Student();
            Long id=0L;
            if(!getGroupByName(gName).getStudents().isEmpty()){
                for (Student st : getGroupByName(gName).getStudents()) {
                    id= st.getId();
                }
            }
            s.setId(++id);

            Student ss=StudentServiceImpl.newStudent();

            s.setFirstName(ss.getFirstName());
            s.setLastName(ss.getLastName());
            s.setEmail(ss.getEmail());
            s.setPassword(ss.getPassword());
            s.setGender(ss.getGender());
            Database.students.add(s);
            int index=Database.students.indexOf(s);

            getGroupByName(gName).getStudents().add(Database.students.get(index));

            System.out.println("Student "+s.getFirstName()+" is successfully added to group "+gName);
        }else {
            System.out.println("There is no such group.");
        }
    }

    @Override
    public String deleteGroup(String gName) {
        for(Group g:Database.groups){
            if( g.getGroupName().equals(gName)){
                Database.groups.remove(g);
                return g.getGroupName()+" is deleted.";
            }
        }
        return "There is no such group";
    }

    public static boolean checkGroup(String n){
        for(Group g:Database.groups){
            if(g.getGroupName().equals(n)){
                return true;
            }
        }
        return false;
    }
}
