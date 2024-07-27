/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;/**
 *
 * @author 91807
 */
public class Student {
    private String name;
    private String id;
    private int marks;
    private String password;
    private boolean isPresent;

    public Student(String name, String id,String password) {
        this.name = name;
        this.id = id;
        this.marks = 0;
        this.password=password;
        this.isPresent=true;
    }

    public String getName() {
        return name;
    }
    
    public boolean isPresent()
    {
        return isPresent;
    }
    public String getId() {
        return id;
    }

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

    public void viewMarks() {
        System.out.println(name + "'s Marks: " + marks);
    }
}

