/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author 91807
 */
public class Classroom {
    private final String classCode;
    private final String className;
    private int numberOfStudents;
    private String teacherName;
    public ArrayList<Student> students;
    private ArrayList<Assignments> assignments;
    private List<Schedule> schedules;
    private Map<Student, Boolean> attendance;

    public Classroom(String classCode, String className,String teacherName) {
        this.classCode = classCode;
        this.className = className;
        this.teacherName=teacherName;
        this.numberOfStudents = 0;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.schedules = new ArrayList<>();
        this.attendance = new HashMap<>();
    }

    public String getClassCode() {
        return classCode;
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public ArrayList<Assignments> getAssignments() {
        return assignments;
    }
    public void postAssignment(Assignments assignment) {
        assignments.add(assignment);
    }

    public void addStudent(Student student) {
        students.add(student);
        numberOfStudents++;
    }
    
    public void removeStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }
    
    public void addAssignment(Assignments assignment) {
        assignments.add(assignment);
    }
    
    public void removeAssignment(String title) {
        assignments.removeIf(assignment -> assignment.getTitle().equals(title));
    }
    
    public void scheduleClass(Schedule schedule) {
        schedules.add(schedule);
    }
    
    public void removeSchedule(String date, String time) {
        schedules.removeIf(schedule -> schedule.getDate().equals(date) && schedule.getTime().equals(time));
    }

     
     public List<Schedule> getSchedules() {
        return schedules;
    }
     
    public void markAttendance(List<Integer> absentees) {
        for (Student student : students) {
            attendance.put(student, !absentees.contains(student.getId()));
        }
    }
    public void viewAttendance() {
        System.out.println("Attendance for Classroom: " + className);
        int presentCount = 0;
        int absentCount = 0;
        for (Map.Entry<Student, Boolean> entry : attendance.entrySet()) {
            Student student = entry.getKey();
            boolean isPresent = entry.getValue();
            if (isPresent) {
                presentCount++;
            } else {
                absentCount++;
            }
            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Present: " + isPresent);
        }
        System.out.println("Total Present: " + presentCount);
        System.out.println("Total Absent: " + absentCount);
    }
    public void viewAssignments() {
        for (Assignments assignment : assignments) {
            System.out.println("Assignment Title: " + assignment.getAssignmentTitle());
            System.out.println("Description: " + assignment.getDescription());
        }
    }
}


