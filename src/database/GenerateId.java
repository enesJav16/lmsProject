package database;

public class GenerateId {
    public static Long groupId=0L;
    public static Long lessonId=0L;
    public static Long groupId(){
        return ++groupId;
    }
    public static Long lessonId(){
        return ++lessonId;
    }
}
