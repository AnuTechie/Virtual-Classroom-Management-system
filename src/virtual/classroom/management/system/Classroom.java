/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.util.Map;
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
    private HashMap<Integer, HashMap<Student, String>> assignmentSubmissions;
    private int tid;
   

    public Classroom(String classCode, String className,String teacherName,int tid) {
        this.classCode = classCode;
        this.className = className;
        this.teacherName=teacherName;
        this.numberOfStudents = 0;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.schedules = new ArrayList<>();
        this.assignmentSubmissions = new HashMap<>();
        this.tid=tid;
       
    }

    public String getClassCode() {
        return classCode;
    }

    public int getTid(){
        return tid;
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
    
    public String getTeacherName()
    {
        return teacherName;
    }
    
    public ArrayList<Assignments> getAssignments() {
        return assignments;
    }
    
    public void postAssignment(Assignments assignment) {
        assignments.add(assignment);
    }
    
    public void submitAssignment(int assignCode, Student student, String content) {
        assignmentSubmissions.computeIfAbsent(assignCode, k -> new HashMap<>()).put(student, content);
    }
    
    public boolean getSubmissions(int assignCode) {
        HashMap<Student, String> submissions = assignmentSubmissions.get(assignCode);
        if (submissions == null || submissions.isEmpty()) {
            System.out.println("No submissions found for assignment code: " + assignCode);
            return false;
        }

        System.out.println("Submissions for assignment code " + assignCode + ":");
        for (Map.Entry<Student, String> entry : submissions.entrySet()) {
            Student student = entry.getKey();
            String content = entry.getValue();
            System.out.println("Student ID: " + student.getId() + ", Content: " + content);
        }
        return true;
    }
    
    public boolean hasStudentSubmittedAssignment(int assignCode, String studId) {
        HashMap<Student, String> submissions = assignmentSubmissions.get(assignCode);
        if (submissions == null) {
            return false;
        }
        for (Student student : submissions.keySet()) {
            if (student.getId().equals(studId)) {
                return true;
            }
        }
        return false;
    }
    
    public void addStudent(Student student) {
        students.add(student);
        numberOfStudents++;
       
    }
    
    public void removeStudent(String studentId) {
        students.removeIf(student -> (student.getId() == null ? studentId == null : student.getId().equals(studentId)));
        numberOfStudents--;
    }
    
    public void addAssignment(Assignments assignment) {
        assignments.add(assignment);
    }
    
    public void removeAssignment(int assignId) {
        assignments.removeIf(assignment -> assignment.getAssignId()==(assignId));
    }
    
    public void scheduleClass(Schedule schedule) {
        schedules.add(schedule);
    }
    
    public void removeSchedule(int Id) {
        schedules.removeIf(schedule -> schedule.getId()==(Id));
    }

     
     public List<Schedule> getSchedules() {
        return schedules;
    }
     
      public void markAttendance(List<String> absentees) {
        for (Student student : students) {
            if (absentees.contains(student.getId())) {
                student.setAttendance(classCode, false);
            } else {
                student.setAttendance(classCode, true);
            }
        }
        viewAttendance();
    }
       public void viewAttendance() {
        int presentCount = 0;
        int absentCount = 0;
        System.out.println("Attendance for Classroom: " + className);
        for (Student student : students) {
            boolean isPresent = student.isPresent(classCode);
            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Attendance: " + (isPresent ? "Present" : "Absent"));
            if (isPresent) {
                presentCount++;
            } else {
                absentCount++;
            }
        }
        System.out.println("Total Present: " + presentCount);
        System.out.println("Total Absent: " + absentCount);
    }
     public void displayScheduleDetails() {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available for this classroom.");
            return;
        }
        System.out.println("Schedules for Classroom: " + className);
        for (Schedule schedule : schedules) {
            System.out.println("Date: " + schedule.getDate());
            System.out.println("Time: " + schedule.getTime());
            System.out.println("Topics: " + schedule.getTopics());
            System.out.println("-------------------------");
        }
    }
     public void displayStudentDetails() {
        if (students.isEmpty()) {
            System.out.println("No students available in this classroom.");
            return;
        }
        System.out.println("Classroom Name: " + className);
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
           // System.out.println("Marks: " + student.getMarks());
            System.out.println("-------------------------");
        }
    }
    
    
    public void displayAssignmentDetails() {
        if (assignments.isEmpty()) {
            System.out.println("No assignments available for this classroom.");
            return;
        }
        System.out.println("Assignments for Classroom: " + className);
        for (Assignments assignment : assignments) {
            System.out.println("Assignment ID : "+assignment.getAssignId());
            System.out.println("Title: " + assignment.getTitle());
            System.out.println("Description: " + assignment.getDescription());
            System.out.println("Date of Submission: " + assignment.getDateOfSubmission());
            System.out.println("-------------------------");
        }
    }
    public boolean foundAssignment(int assignCode)
    {
         if (assignments.isEmpty()) {
            System.out.println("No assignments available for this classroom.");
            return false;
        }
        for (Assignments assignment : assignments)
        {
            if(assignment.getAssignId()==assignCode)
            {
                return true;
            }
        }
        return false; 
    }
   
    public void deleteSubmittedAssignment(int assignCode, Student student) {
        HashMap<Student, String> submissions = assignmentSubmissions.get(assignCode);
        if (submissions != null && submissions.remove(student) != null) {
            System.out.println("Assignment submission deleted successfully.");
        } else {
            System.out.println("Submission not found for the given assignment code.");
        }
    }
    
    public void displayMarks(int assignCode, String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                int marks = student.getMarks(assignCode);
                if (marks != -1) {
                    System.out.println("Marks for assignment code " + assignCode + ": " + marks);
                } else {
                    System.out.println("No marks found for assignment code " + assignCode + " for student ID " + studentId);
                }
                return;
            }
        }
        System.out.println("Student ID not found in this classroom.");
    }
    
    public void viewAssignments() {
        for (Assignments assignment : assignments) {
            System.out.println("Assignment Title: " + assignment.getAssignmentTitle());
            System.out.println("Description: " + assignment.getDescription());
        }
    }
}


