package service;

import models.Group;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public interface GroupService {
    void addNewGroup();
    Group getGroupByName(String name);
    void updateGroupByName(String n,String nn);
    List<Group> getAllGroups();
    void addNewStudentToGroup(String gName);
    String deleteGroup(String gName);
}
