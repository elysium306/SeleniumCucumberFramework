package Core_Java;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        students.put(20052446, "Mamatwelijan");
        students.put(20052346, "Daily");
        students.put(20061278, "Wang Shuang");

        System.out.println(students.keySet() + " : " + students.values());

        for(int i = 0; i < 3; i++){
            System.out.println("Second student in the database is "+students.get(1));
    }
        
    } 
}
