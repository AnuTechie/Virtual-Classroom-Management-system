/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;
/**
 *
 * @author 91807
 */
public class Teacher {
    private String name;
    private int id;
    private String password;

    public Teacher(String name, int id,String password) {
        this.name = name;
        this.id = id;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public String getPassword()
    {
        return password;
    }
    public boolean login(String password) {
        return this.password.equals(password);
    }
    public void postAssignment(Classroom classroom, Assignments assignment) {
        classroom.addAssignment(assignment);
        System.out.println("Assignment posted: " + assignment.getAssignmentTitle());
    }

}


