/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;

import java.util.ArrayList;

/**
 *
 * @author 91807
 */
public class Student {
    private final String name;
    private final String id;
    private int marks;
    private final String password;
    private ArrayList<String> rooms;
    private boolean isPresent;
    

    public Student(String name, String id,String password) {
        this.name = name.trim();
        this.id = id.trim();
        this.marks = 0;
        this.password=password.trim();
        this.isPresent=true;
       // this.doubts=[];
        this.rooms = new ArrayList<>();
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
    /*public String getDoubts()
    {
        return doubts;
    }*/
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void setAttendance(boolean isPresent) {
        this.isPresent = isPresent;
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
    
    public ArrayList<String> getRooms() {
        return rooms;
    }
     
     
    /*public void addClassroom(Classroom classroom) {
        if (!classrooms.contains(classroom)) {
            classrooms.add(classroom);
        }
    }

    // Remove a classroom from the student's list
    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    // Get the list of classrooms
    public List<Classroom> getClassrooms() {
        return classrooms;
    }*/
    public void viewMarks() {
        System.out.println(name + "'s Marks: " + marks);
    }
}

