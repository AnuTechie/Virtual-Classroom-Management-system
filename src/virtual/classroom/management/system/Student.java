/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 91807
 */
public class Student {
    private final String name;
    private final String id;
   // private int marks;
    private final String password;
    private ArrayList<String> rooms;
    private boolean isPresent;
    private HashMap<Integer, Integer> marks;
     private HashMap<String, Boolean> attendance;
    

    public Student(String name, String id,String password) {
        this.name = name.trim();
        this.id = id.trim();
        this.password=password.trim();
        this.isPresent=true;
        this.rooms = new ArrayList<>();
        this.marks = new HashMap<>();
        this.attendance=new HashMap<>();
    }

    public String getName() {
        return name;
    }
    public boolean login(String password) {
        return this.password.equals(password);
    }
    public boolean isPresent()
    {
        return isPresent;
    }
    public String getId() {
        return id;
    }
    
    public void setAttendance(String classCode, boolean isPresent) {
        attendance.put(classCode, isPresent);
    }
    public boolean isPresent(String classCode) {
        return attendance.getOrDefault(classCode, true); // Default to true if not found
    }
    public String getPassword(String id)
    {
        return password;
    }
    
    public void postDoubts() {
        System.out.println(name + " has posted doubts.");
    }

    public void submitAssignment(Classroom classroom, Assignments assignment) {
        classroom.getAssignments().stream()
            .filter(a -> a.getAssignmentTitle().equals(assignment.getAssignmentTitle()))
            .forEach(a -> a.submit());
        System.out.println(name + " has submitted the assignment: " + assignment.getAssignmentTitle());
    }
    
    public void addRoom(String room) {
        rooms.add(room);
    }
    
    public void setMarks(int assignCode, int marks) {
        this.marks.put(assignCode, marks);
    }
    
    public int getMarks(int assignCode) {
        return this.marks.getOrDefault(assignCode, -1); // -1 indicates no marks
    }
    
    public ArrayList<String> getRooms() {
        return rooms;
    }
    
    public void viewMarks() {
        System.out.println(name + "'s Marks: " + marks);
    }
}

