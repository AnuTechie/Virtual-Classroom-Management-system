/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtual.classroom.management.system;/**
 *
 * @author 91807
 */
import java.util.ArrayList;
import java.util.Iterator;
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
        Student foundStudent=null;
        String password,stuId,content;
        String clsName,teacherName = null,studId,title;
        List<Classroom> classrooms = new ArrayList<>();
        int x=0,y=0,assignId,ch,count;
        Teacher[] teachers;
        teachers = new Teacher[5];
        teachers[0] = new Teacher("Dr. Smith", 1, "smith");
        teachers[1] = new Teacher("Mrs. Johnson", 2, "johnson");
        teachers[2] = new Teacher("Mr. Brown", 3, "brown");
        teachers[3] = new Teacher("Ms. Davis", 4, "davis");
        teachers[4] = new Teacher("Dr. Wilson", 5, "wilson");
        
        Student[] students;
        students=new Student[5];
        students[0]= new Student("Anu","CS67","anu");
        students[1]=new Student("Brindha","CS68","brindha");
        students[2]=new Student("Chathriya","CS69","chathriya");
        students[3]=new Student("Devi","CS70","devi");
        students[4]=new Student("Evans","CS71","evans");
        
        Scanner scanner = new Scanner(System.in);
        boolean exit1=false,exit2,exit3;
        
       
       while(!exit1){
        System.out.println("1. Teacher Login");
        System.out.println("2. Student Login");
        System.out.println("3. Exit");
        
        //scanner.nextLine();
        int option = scanner.nextInt();
        switch(option)
        {
           case 1:
           {
               System.out.print("Enter teacher ID: ");
               
               int teacherId = scanner.nextInt();
               scanner.nextLine();
               System.out.print("Enter password: ");
               // password = scanner.nextLine();
                password = scanner.nextLine().trim();
                Teacher loggedInTeacher = null;
                for (Teacher t : teachers) {
                    if (t.getId() == teacherId && t.login(password)) {
                        loggedInTeacher = t;
                        teacherName=t.getName();
                        System.out.println("LOGIN SUCCESSFUL!!");
                        break;
                    }
                }

                if (loggedInTeacher == null) {
                    System.out.println("Invalid credentials. Please try again.");
                    continue;
                }
                exit2=false;
            while(!exit2)
            {   
            System.out.println("1.Create Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Post Assignment");
            System.out.println("5. Post Marks");
            System.out.println("6. Remove Assignments");
            System.out.println("7. Schedule Classes");
            System.out.println("8. Remove a schedule");
            System.out.println("9. Mark Attendance");
            System.out.println("10.View Student attendance");
            System.out.println("11.Display Schedule details");
            System.out.println("12.Display Student details");
            System.out.println("13.Display Assignment details");  
            System.out.println("14.Remove classroom");
            System.out.println("15.Display classroom details");
            System.out.println("16.Exit");
            System.out.println("17.View Submitted Assignments");
            System.out.print("Choose an option: ");
            int t=scanner.nextInt();
            switch (t)
            {
                case 1:
                {    
                    System.out.println("CREATE CLASSROOM");
                    System.out.println("Enter the following details");
                    System.out.println("---------------------------");
                    scanner.nextLine();
                    System.out.println("Enter the Class Code");
                    cc=scanner.nextLine();
                    System.out.println("Enter the Class Name");
                    clsName=scanner.nextLine();
                  //  System.out.println("Enter the Teacher Name");
                    //teacherName=scanner.nextLine();
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
                    System.out.println("Student List as follows");
                    for(Student s : students) {
                        System.out.println("NAME  : " + s.getName());
                        System.out.println("ROLLNO: " + s.getId());
                        System.out.println("------------------------");
                    }
                    System.out.println("Enter the following details");
                    scanner.nextLine(); // Consume newline
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

                    System.out.println("Enter student roll number:");
                    studId = scanner.nextLine();
                    foundStudent = null;

                    for (Student s1 : students) {
                        if (s1.getId().equals(studId)) {
                            foundStudent = s1;
                            break;
                        }
                    }

                    if (foundStudent == null) {
                        System.out.println("Student not found in the student list.");
                        break;
                    }

                    boolean alreadyAdded = false;
                    for (Student s : foundClassroom.getStudents()) {
                        if (s.getId().equals(foundStudent.getId())) {
                            alreadyAdded = true;
                            break;
                        }
                    }

                    if (alreadyAdded) {
                        System.out.println("Student already added to this classroom.");
                    } else {
                        foundClassroom.addStudent(foundStudent);
                        System.out.println("Student added successfully. Here's the details:");
                        System.out.println("Class Code : " + cc);
                        System.out.println("Student Name : " + foundStudent.getName());
                    }
                    break;
                }

                case 3:
                {
                    scanner.nextLine();
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
                    //int studId = Integer.parseInt(scanner.nextLine());
                    foundStudent=null;
                    studId=scanner.nextLine();
                    for (Student s1 : students) {
                        if (s1.getId().equals(studId)) {
                            foundStudent = s1;
                            break;
                        }
                    }

                    if (foundStudent == null) {
                        System.out.println("Student not found in the student list.");
                        break;
                    }
                    else
                    {
                        foundClassroom.removeStudent(studId);
                        System.out.println("Student removed successfully.");
                    }
                    break;
                }
                case 4:
                {
                    x++;
                    scanner.nextLine();
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
                   // scanner.nextLine();
                    System.out.print("Enter assignment title: ");
                    title = scanner.nextLine();
                   // scanner.nextLine();
                    System.out.print("Enter assignment description: ");
                    String description = scanner.nextLine();
                   // scanner.nextLine();
                    System.out.print("Enter date of submission: ");
                    String dateOfSubmission = scanner.nextLine();
                    Assignments assignment = new Assignments(title, description, dateOfSubmission,x);
                    foundClassroom.postAssignment(assignment);
                    System.out.println("Assignment posted successfully.");
                   // System.out.println("Classroom created Successfully. Here's the details");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Assignment id : "+x);
                    System.out.println("Assignment title : "+title);
                    System.out.println("Description : "+description);
                    System.out.println("Date of submission : "+dateOfSubmission);
                    break;
                }
                case 6:
                {
                    scanner.nextLine();
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
                    
                    System.out.print("Enter assignment id to remove: ");
                    assignId = scanner.nextInt();
                    foundClassroom.removeAssignment(assignId);
                    System.out.println("Assignment removed successfully.");
                    break;
                
                }
                case 7:
                {
                    y++;
                    scanner.nextLine();
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
                  //  scanner.nextLine();
                    System.out.print("Enter date of the class (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                   // scanner.nextLine();
                    System.out.print("Enter time of the class (HH:MM): ");
                    String time = scanner.nextLine();
                  //  scanner.nextLine();
                    System.out.print("Enter topics to be covered: ");
                    String topics = scanner.nextLine();
                    Schedule schedule = new Schedule(date, time, topics,y);
                    foundClassroom.scheduleClass(schedule);
                    System.out.println("Class scheduled successfully.");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Schedule ID : "+y);
                    System.out.println("Date : "+date);
                    System.out.println("Time: "+time);
                    System.out.println("Topics : "+topics);
                    
                    break;
                }
                case 8:
                {
                    scanner.nextLine();
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
                   // scanner.nextLine();
                    System.out.print("Enter the schedule id : ");
                    int removeId = scanner.nextInt();
                    //scanner.nextLine();
                  //  System.out.print("Enter time of the class (HH:MM) to remove: ");
                   // String removeTime = scanner.nextLine();
                    foundClassroom.removeSchedule(removeId);
                    System.out.println("Schedule removed successfully.");
                    break;
                }
                case 9:
                {
                    //------
                    scanner.nextLine();
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
                        return;
                    }

                    List<String> absentees = new ArrayList<>();
                    boolean done = false;
                    System.out.println("Enter student IDs of absentees (type 'done' when finished):");
                    while (!done) {
                        System.out.print("Enter student ID: ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("done")) {
                            done = true;
                        } else if (absentees.contains(input)) {
                            System.out.println("Student marked absent already.");
                        } else {
                            absentees.add(input);
                        }
                    }

                    foundClassroom.markAttendance(absentees);
                    System.out.println("Attendance marked successfully.");
                    break;
   
                }
                case 10:
                {
                    scanner.nextLine();
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
                    scanner.nextLine();
                    System.out.print("Enter Class Code: ");
                    cc = scanner.nextLine();
                    boolean c=false;
                    for (Classroom classroom : classrooms) {
                        if (classroom.getClassCode().equals(cc)) {
                            classroom.displayScheduleDetails();
                            c=true;
                            break;  
                        }
                    }
                    if(!c) {
                        System.out.println("Classroom not found.");
                    }
                    break;
                }
                case 12:
                {
                    scanner.nextLine();
                    System.out.print("Enter Class Code: ");
                    cc = scanner.nextLine();
                    boolean c=false;
                    for (Classroom classroom : classrooms) {
                        if (classroom.getClassCode().equals(cc)) {
                            classroom.displayStudentDetails();
                            c=true;
                            break;  
                        }
                    }
                    if(!c) {
                        System.out.println("Classroom not found.");
                    }
                    break;
                }
                case 13:
                {
                    scanner.nextLine();
                    System.out.print("Enter Class Code: ");
                    cc = scanner.nextLine();
                    boolean c=false;
                    for (Classroom classroom : classrooms) {
                        if (classroom.getClassCode().equals(cc)) {
                            classroom.displayAssignmentDetails();
                            c=true;
                            break;  
                        }
                    }
                    if(!c) {
                        System.out.println("Classroom not found.");
                    }
                    break;
                }
                case 14:
                {
                    scanner.nextLine();
                    System.out.println("Enter the class code to remove");
                    cc=scanner.nextLine();
                    Iterator<Classroom> iterator = classrooms.iterator();
                    while (iterator.hasNext()) {
                        Classroom classroom = iterator.next();
                        if (classroom.getClassCode().equals(cc)) {
                            iterator.remove();
                            System.out.println("Classroom with Class Code " + cc + " has been removed.");
                            return;
                        }
                    }
                    System.out.println("Classroom with Class Code " + cc + " not found.");
                    break;
                }
                case 16:
                {
                    exit2=true;
                    System.out.println("Exiting...");
               
                   break;
                }
                case 15:
                {
                    if (classrooms.isEmpty()) {
                    System.out.println("No classrooms available.");
                    return;
                    }
                    for (Classroom classroom : classrooms) {
                        System.out.println("Class Code: " + classroom.getClassCode());
                        System.out.println("Class Name: " + classroom.getClassName());
                        System.out.println("Teacher Name: " + classroom.getTeacherName());
                        System.out.println("Number of Students: " + classroom.getStudents().size());
                        System.out.println("-------------------------");
                    }
                    break;
                }
                case 17:
                {
                    scanner.nextLine();
                    System.out.println("Enter the class code");
                    cc=scanner.nextLine();
                    foundClassroom = null;
                            for (Classroom cls : classrooms) {
                                if (cls.getClassCode().equals(cc)) {
                                    foundClassroom = cls;
                                    break;
                                }
                            }
                            if (foundClassroom == null) {
                                System.out.println("Classroom not found.");
                                break;
                            }
                            if(loggedInTeacher.getName().equals(foundClassroom.getTeacherName()))
                            {
                                foundClassroom.displayAssignmentDetails();
                                System.out.println("Enter assignement code");
                                int ac=scanner.nextInt();
                                if(foundClassroom.foundAssignment(ac))
                                {
                                    foundClassroom.getSubmissions(ac);
                                }
                                else
                                {
                                    System.out.println("Enter a valid code. Assignment code not found");
                                }
                            }
                            else{
                                System.out.println("You are not a teacher of this classroom");
                            }
                            break;
                }
                default:
                {
                    System.out.println("Enter correct choice!");
                }
            }
            }
            break;
           }
           case 2:
           {
               scanner.nextLine();
               System.out.print("Enter Student roll no:");
               stuId = scanner.nextLine();
              
               System.out.print("Enter password:");
               // password = scanner.nextLine();
                password = scanner.nextLine().trim();

                Student loggedInStudent = null;
                for (Student stu : students) {
                    if (stu.getId().equals(stuId) && stu.login(password))
                     {
                           loggedInStudent = stu;
                           //teacherName=stu.getName();
                           System.out.println("LOGIN SUCCESSFUL!!");
                           break;
                       }
                }

                if (loggedInStudent == null) {
                    System.out.println("Invalid credentials. Please try again.");
                    continue;
                }
                exit3=false;
                while(!exit3)
                {
                    System.out.println("1.My classrooms");
                    System.out.println("2.View schedules");
                    System.out.println("3.View Assignment details");
                    System.out.println("4.View marks");
                    System.out.println("5.Submit Assignments");
                    System.out.println("6.Post Doubts");
                    System.out.println("7.Delete Submitted Assignment");
                   /* System.out.println("8.Remove a schedule");
                    System.out.println("9.Mark Attendance");
                    System.out.println("10.View Student attendance");
                    System.out.println("11.Display Schedule details");
                    System.out.println("12.Display Student details");
                    System.out.println("13.Display Assignment details");  
                    System.out.println("14.Remove classroom");
                    System.out.println("15.Display classroom details");*/
                    System.out.println("16.Exit");
                    System.out.println("Choose your option");
                    ch=scanner.nextInt();
                    switch(ch)
                    {
                        case 1:
                        {
                            count=0;
                            System.out.println("Your Classrooms :");
                            System.out.println("-----------------");
                            for (Classroom cls : classrooms) {
                                for (Student st : cls.students) {
                                    if (st.getId().equals(loggedInStudent.getId())) {
                                        System.out.println(cls.getClassCode()+":"+cls.getClassName());
                                        count++;
                                       // loggedInStudent.addRoom(cls.getClassCode() + ": " + cls.getClassName());
                                        //rooms.add(cls.classCode + ": " + cls.className);
                                        break; // Move to the next classroom once the student is found
                                    }
                                }
                               
                            }
                            if(count==0)
                            {
                                System.out.println("You are not added to any classrooms");
                            }
                            break;
                        }
                        case 2:
                        {
                            count=0;
                            scanner.nextLine();
                            System.out.println("Enter the class code to view schedules of a classroom");
                            cc=scanner.nextLine();
                            foundClassroom = null;
                            for (Classroom cls : classrooms) {
                                if (cls.getClassCode().equals(cc)) {
                                    foundClassroom = cls;
                                    break;
                                }
                            }

                            if (foundClassroom == null) {
                                System.out.println("Classroom not found.");
                                break;
                            }
                            for (Student st : foundClassroom.students) {
                                    if (st.getId().equals(loggedInStudent.getId())) {
                                        foundClassroom.displayScheduleDetails();
                                        count++;
                                        break; // Move to the next classroom once the student is found
                                    }   
                            }
                            if(count==0)
                            {
                                System.out.println("You are not added to the classroom");
                            }
                            break;
                        }
                        case 3:
                        {
                            scanner.nextLine();
                            System.out.println("Enter the class code to view Assignments of a classroom");
                            cc=scanner.nextLine();
                            foundClassroom = null;
                            for (Classroom cls : classrooms) {
                                if (cls.getClassCode().equals(cc)) {
                                    foundClassroom = cls;
                                    break;
                                }
                            }
                            if (foundClassroom == null) {
                                System.out.println("Classroom not found.");
                                break;
                            }
                            for (Student st : foundClassroom.students) {
                                    if (st.getId().equals(loggedInStudent.getId())) {
                                        foundClassroom.displayAssignmentDetails();
                                        break; 
                                    }
                                    else
                                    {
                                        System.out.println("You're not added to the classroom");
                                    }
                            break;
                            }
                            break;
                        }
                        case 4:
                        {
                            break;
                        }
                        case 5:
                        {
                            count=0;
                            scanner.nextLine();
                            System.out.println("Enter the class code to view assignments of a classroom");
                            cc=scanner.nextLine();
                            foundClassroom = null;
                            for (Classroom cls : classrooms) {
                                if (cls.getClassCode().equals(cc)) {
                                    foundClassroom = cls;
                                    break;
                                }
                            }

                            if (foundClassroom == null) {
                                System.out.println("Classroom not found.");
                                break;
                            }
                            for (Student st : foundClassroom.students) {
                                    if (st.getId().equals(loggedInStudent.getId())) {
                                        foundClassroom.displayAssignmentDetails();
                                        count++;
                                        break; // Move to the next classroom once the student is found
                                }
                            }
                            if(count==0)
                            {
                                System.out.println("You are not added to the classroom"); 
                            }
                            else
                            {
                                System.out.println("Enter the Assignment code:");
                                int assignCode = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline

                                if (foundClassroom.foundAssignment(assignCode)) {
                                    System.out.println("Enter your content:");
                                    content = scanner.nextLine();
                                    foundClassroom.submitAssignment(assignCode, loggedInStudent, content);
                                    System.out.println("Assignment submitted successfully.");
                                }
                            break;
                        }
                            
                        }
                        case 16:
                        {
                            exit3=true;
                            break;
                        }
                    
                    }
                    
                }
               break;
           }
               
           case 3:
               exit1=true;
               break;
           default:
            System.out.println("Invalid option. Please choose either 1, 2, or 3.");
            break; 
        }
        
       }
    }
    
}
