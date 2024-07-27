/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtual.classroom.management.system;/**
 *
 * @author 91807
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class VirtualClassroomManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String clsCode,cc;
        Classroom foundClassroom;
        String password;
        String clsName,teacherName,studName,title;
        List<Classroom> classrooms = new ArrayList<>();
        int x=99;
        Teacher[] teachers;
        teachers = new Teacher[5];
        teachers[0] = new Teacher("Dr. Smith", 1, "smith");
        teachers[1] = new Teacher("Mrs. Johnson", 2, "johnson");
        teachers[2] = new Teacher("Mr. Brown", 3, "brown");
        teachers[3] = new Teacher("Ms. Davis", 4, "davis");
        teachers[4] = new Teacher("Dr. Wilson", 5, "wilson");
        Scanner scanner = new Scanner(System.in);
        
       // Classroom classroom = new Classroom("CS101", "Introduction to Computer Science");
      //  Teacher teacher = new Teacher("Dr. Smith", 1);
       // Student student = new Student("John Doe", 123);
       // Assignments assignment = new Assignments("Homework 1", "Complete chapter 1");
       while(true){
        System.out.println("1. Teacher Login");
        System.out.println("2. Student Login");
        //int option = scanner.nextInt();
        int option = Integer.parseInt(scanner.nextLine());
        if(option==1)
        {
           System.out.print("Enter teacher ID: ");
                int teacherId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter password: ");
                password = scanner.nextLine();

                Teacher loggedInTeacher = null;
                for (Teacher t : teachers) {
                    if (t.getId() == teacherId && t.login(password)) {
                        loggedInTeacher = t;
                        break;
                    }
                }

                if (loggedInTeacher == null) {
                    System.out.println("Invalid credentials. Please try again.");
                    continue;
                }
        
            while(true)
            {
                System.out.println("LOGIN SUCCESSFUL!!");
            System.out.println("1.Create Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Post Assignment");
            System.out.println("5. Post Marks");
            System.out.println("6. Remove Assignments");
            System.out.println("7. Schedule Classes");
            System.out.println("8.Remove a schedule");
            System.out.println("9.Mark Attendance");
            System.out.println("10.View Student attendance");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int t=scanner.nextInt();
            switch (t)
            {
                case 1:
                {    
                    System.out.println("CREATE CLASSROOM");
                    System.out.println("Enter the following details");
                    System.out.println("---------------------------");
                    System.out.println("Enter the Class Code");
                    cc=scanner.nextLine();
                    System.out.println("Enter the Class Name");
                    clsName=scanner.nextLine();
                    System.out.println("Enter the Teacher Name");
                    teacherName=scanner.nextLine();
                    Classroom c1;
                    c1 = new Classroom(cc,clsName,teacherName);
                    classrooms.add(c1);
                    System.out.println("Classroom created Successfully. Here's the details");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Class Name : "+clsName);
                    System.out.println("Teacher Name : "+teacherName);
                    break;
                }
                case 2:
                {
                    x++;
                    System.out.println("Enter the following details");
                    System.out.println("Enter the Class Code of the classroom to add the student to:");
                    cc = scanner.nextLine();
                    foundClassroom = null;
                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }
                    System.out.println("Enter student name");
                    studName=scanner.nextLine();
                    Student s1=new Student(studName,x);
                    foundClassroom.addStudent(s1);
                    System.out.println("Student added Successfully. Here's the details");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Student Name : "+studName);
                   // System.out.println("Teacher Name : "+teacherName);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the Class Code of the classroom to remove the student from:");
                    cc=scanner.nextLine();
                    foundClassroom = null;
                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }

                    System.out.print("Enter student ID to remove: ");
                    int studId = Integer.parseInt(scanner.nextLine());
                    foundClassroom.removeStudent(studId);
                    System.out.println("Student removed successfully.");
                    break;
                }
                case 4:
                {
                    System.out.println("Enter the Class Code of the classroom to post the assignment to:");
                    cc = scanner.nextLine();
                    foundClassroom = null;
                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }
                    System.out.println("Enter the following details for the assignment");
                    System.out.print("Enter assignment title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter assignment description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter date of submission: ");
                    String dateOfSubmission = scanner.nextLine();
                    Assignments assignment = new Assignments(title, description, dateOfSubmission);
                    foundClassroom.postAssignment(assignment);
                    System.out.println("Assignment posted successfully.");
                   // System.out.println("Classroom created Successfully. Here's the details");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Assignment title : "+title);
                    System.out.println("Description : "+description);
                    System.out.println("Date of submission : "+dateOfSubmission);
                    break;
                }
                case 6:
                {
                    System.out.println("Enter the Class Code of the classroom to remove the assignment from:");
                    cc = scanner.nextLine();
                    foundClassroom = null;

                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }

                    System.out.print("Enter assignment title to remove: ");
                    title = scanner.nextLine();
                    foundClassroom.removeAssignment(title);
                    System.out.println("Assignment removed successfully.");
                    break;
                
                }
                case 7:
                {
                    System.out.println("Enter the Class Code of the classroom to schedule the class for:");
                    cc = scanner.nextLine();
                    foundClassroom = null;

                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }
                    System.out.println("Enter the following details for scheduling the class");
                    System.out.print("Enter date of the class (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time of the class (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter topics to be covered: ");
                    String topics = scanner.nextLine();
                    Schedule schedule = new Schedule(date, time, topics);
                    foundClassroom.scheduleClass(schedule);
                    System.out.println("Class scheduled successfully.");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Date : "+date);
                    System.out.println("Time: "+time);
                    System.out.println("Topics : "+topics);
                    break;
                }
                case 8:
                {
                    System.out.println("Enter the Class Code of the classroom to remove the schedule from:");
                    cc = scanner.nextLine();
                    foundClassroom = null;

                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }

                    System.out.print("Enter date of the class (YYYY-MM-DD) to remove: ");
                    String removeDate = scanner.nextLine();
                    System.out.print("Enter time of the class (HH:MM) to remove: ");
                    String removeTime = scanner.nextLine();
                    foundClassroom.removeSchedule(removeDate, removeTime);
                    System.out.println("Schedule removed successfully.");
                    break;
                }
                case 9:
                {
                    System.out.println("Enter the Class Code of the classroom to mark attendance for:");
                    cc = scanner.nextLine();
                    foundClassroom = null;

                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }

                    List<Integer> absentees = new ArrayList<>();
                    System.out.println("Enter student IDs of absentees (type 'done' when finished):");
                    while (true) {
                        System.out.print("Enter student ID: ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("done")) {
                            break;
                        }
                        try {
                            int studentId = Integer.parseInt(input);
                            absentees.add(studentId);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid student ID or 'done'.");
                        }
                    }

                    foundClassroom.markAttendance(absentees);
                    System.out.println("Attendance marked successfully.");
                    break;
                }
                case 10:
                {
                    System.out.println("Enter the Class Code of the classroom to view attendance for:");
                    cc = scanner.nextLine();
                    foundClassroom = null;

                    for (Classroom cls : classrooms) {
                        if (cls.getClassCode().equals(cc)) {
                            foundClassroom = cls;
                            break;
                        }
                    }

                    if (foundClassroom == null) {
                        System.out.println("Classroom not found. Please create the classroom first.");
                        break;
                    }

                    foundClassroom.viewAttendance();
                    break;
                }
                case 11:
                {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
            }
            }
        }
       
       }
    }
    
}
