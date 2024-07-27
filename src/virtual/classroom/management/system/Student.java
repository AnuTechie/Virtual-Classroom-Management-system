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
    private int id;
    private int marks;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.marks = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
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

