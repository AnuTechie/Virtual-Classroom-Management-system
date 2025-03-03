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
        int x=0,y=0,tid = 0,temp = 0,assignId,ch,count;
        
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
                password = scanner.nextLine().trim();
                Teacher loggedInTeacher = null;
                for (Teacher t : teachers) {
                    if (t.getId() == teacherId && t.login(password)) {
                        loggedInTeacher = t;
                        teacherName=t.getName();
                        tid=t.getId();
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
                    
                    boolean classCodeExists = false;
                    for (Classroom cls : classrooms) {
                    if (cls.getClassCode().equals(cc)) {
                        classCodeExists = true;
                        break;
                    }
                    }
                    if (classCodeExists) {
                        System.out.println("Class Code already exists. Classroom creation failed.");
                    }
                    else{
                    System.out.println("Enter the Class Name");
                    clsName=scanner.nextLine();
                    Classroom c1;
                    c1 = new Classroom(cc,clsName,teacherName,tid);
                    classrooms.add(c1);
                    System.out.println("Classroom created Successfully. Here's the details");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Class Name : "+clsName);
                    System.out.println("Teacher Name : "+teacherName);
                    }
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
                    scanner.nextLine(); 
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
                    if(foundClassroom.getTid()==loggedInTeacher.getId())
                    {
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
                        
                    
                    
                    }
                    else{
                        System.out.println("You dont have permission to add student in this classroom");
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
                    if(foundClassroom.getTid()==loggedInTeacher.getId()){
                    System.out.print("Enter student ID to remove: ");
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
                }
                    else{
                        System.out.println("You dont have permission to remove student in this classroom");
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
                    if(foundClassroom.getTid()==loggedInTeacher.getId()){
                    System.out.println("Enter the following details for the assignment");
                    System.out.print("Enter assignment title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter assignment description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter date of submission: ");
                    String dateOfSubmission = scanner.nextLine();
                    Assignments assignment = new Assignments(title, description, dateOfSubmission,x);
                    foundClassroom.postAssignment(assignment);
                    System.out.println("Assignment posted successfully.");
                    System.out.println("Class Code : "+cc);
                    System.out.println("Assignment id : "+x);
                    System.out.println("Assignment title : "+title);
                    System.out.println("Description : "+description);
                    System.out.println("Date of submission : "+dateOfSubmission);
                    
                    } else{
                        System.out.println("You dont have permission to remove student in this classroom");
                    }
                    break;
                }
                case 5:
                {
                 
                   count=0;
                   scanner.nextLine();
                   System.out.println("Enter the class code to grade the assignment");
                   cc=scanner.nextLine();
                   foundClassroom=null;
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
                    
                    if (foundClassroom.getTid()==loggedInTeacher.getId()) 
                    {
                        foundClassroom.displayAssignmentDetails();
                        System.out.println("Enter assignment code:");
                        int ac = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        if (foundClassroom.foundAssignment(ac)) {
                            if(foundClassroom.getSubmissions(ac))
                            {
                                System.out.println("Enter student ID to post marks:");
                                String studentId = scanner.nextLine();
                                for (Student st : foundClassroom.students) {
                                    if (st.getId().equals(studentId)) {
                                        count++;
                                        break; 
                                }
                                }
                                if(count==0)
                                {
                                    System.out.println("Student not found in the classroom");
                                    break;
                                }
                                else{
                                if(foundClassroom.hasStudentSubmittedAssignment(ac, studentId))
                                {
                                    
                                    System.out.println("Enter marks:");
                                    int marks = scanner.nextInt();
                                    scanner.nextLine();
                                    for (Student student : students) {
                                    if (student.getId().equals(studentId)) {
                                        student.setMarks(ac, marks);
                                        System.out.println("Marks posted successfully for student ID: " + studentId);
                                       
                                    }
                                } 
                            }
                            else{
                                System.out.println("This student haven't submitted the assignment");
                            }
                            }
                        }
                        else
                        {
                            System.out.println("NO submissions found for this assignement") ;
                            break;
                        }
                        
                    } else {
                        System.out.println("Enter a valid code. Assignment code not found");
                    }
                } 
                else {
                    System.out.println("You do not have permission to grade this classroom's assignments.");
                }
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
                    if(foundClassroom.getTid()==loggedInTeacher.getId()){
                        System.out.print("Enter assignment id to remove: ");
                    assignId = scanner.nextInt();
                    foundClassroom.removeAssignment(assignId);
                    System.out.println("Assignment removed successfully.");
                        
                    }
                    else{
                        System.out.println("You dont have permission to post assignment in this classroom");
                    }
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
                    if(foundClassroom.getTid()==loggedInTeacher.getId()){
                    System.out.println("Enter the following details for scheduling the class");
                    System.out.print("Enter date of the class (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter time of the class (HH:MM): ");
                    String time = scanner.nextLine();
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
                    }
                    else{
                        System.out.println("You dont have permission to schedule classes in this classroom");
                    }
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
                   if(foundClassroom.getTid()==loggedInTeacher.getId()){
                    System.out.print("Enter the schedule id : ");
                    int removeId = scanner.nextInt();
                    foundClassroom.removeSchedule(removeId);
                    System.out.println("Schedule removed successfully.");
                   }
                   else{
                       System.out.println("You dont have permission to remove schedule in this classroom");
                   }
                    break;
                }
                case 9:
                {
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
                    }
                    if(foundClassroom.getTid()==loggedInTeacher.getId()){
                        if(foundClassroom.getNumberOfStudents()>0)
                        {
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
                        System.out.println("Attendance marked successfully.");}
                        else{
                            System.out.println("There's no students in this classroom");
                        }
                    }
                    else{
                        System.out.println("You dont have permission to mark attendance in this classroom");
                    }
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
                    if(foundClassroom.getTid()==loggedInTeacher.getId()){
                    foundClassroom.viewAttendance();
                    }
                    else{
                        System.out.println("You dont have permission to view attendance in this classroom");
                    }
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
                            
                            if(classroom.getTid()==loggedInTeacher.getId()){
                                classroom.displayScheduleDetails();
                                c=true;
                                break;
                            }   
                        }  
                        else{
                        temp=1;
                        }
                    }
                    if(!c) {
                        System.out.println("Classroom not found.");
                    }
                    if(temp==1)
                    {
                        System.out.println("You dont have permission to view");
                    }
                    break;
                }
                case 12:
                {
                    int temp1 = 0;
                    scanner.nextLine();
                    System.out.print("Enter Class Code: ");
                    cc = scanner.nextLine();
                    boolean c=false;
                    for (Classroom classroom : classrooms) {
                        if (classroom.getClassCode().equals(cc))
                        {
                            if(classroom.getTid()==loggedInTeacher.getId())
                            {
                            classroom.displayStudentDetails();
                            c=true;
                            break; 
                            }
                            else{
                             temp1=1;
                            }
                        }
                    }
                    if(!c) {
                        System.out.println("Classroom not found.");
                    }
                     if(temp1==1)
                    {
                        System.out.println("You dont have permission to view");
                    }
                    break;
                }
                case 13:
                {
                    int temp2=0;
                    scanner.nextLine();
                    System.out.print("Enter Class Code: ");
                    cc = scanner.nextLine();
                    boolean c=false;
                    for (Classroom classroom : classrooms) {
                        if (classroom.getClassCode().equals(cc))
                        {
                            if(classroom.getTid()==loggedInTeacher.getId()){
                                classroom.displayAssignmentDetails();
                            c=true;
                            break; 
                            
                            }
                            else{
                            temp2=1;
                            }
                             
                        }
                    }
                    if(!c) {
                        System.out.println("Classroom not found.");
                    }
                    if(temp2==1)
                    {
                        System.out.println("You dont have permission to view");
                    }
                    break;
                }
                case 14:
                {
                    int temp3=0;
                    scanner.nextLine();
                    System.out.println("Enter the class code to remove");
                    cc=scanner.nextLine();
                    Iterator<Classroom> iterator = classrooms.iterator();
                    while (iterator.hasNext()) {
                        Classroom classroom = iterator.next();
                        if (classroom.getClassCode().equals(cc)) {
                            if(classroom.getTid()==loggedInTeacher.getId()){
                                iterator.remove();
                            System.out.println("Classroom with Class Code " + cc + " has been removed.");
                            //return;
                            }
                            else{
                                temp3=1;
                            
                            }
                            
                        }
                    }
                    if(temp3==1)
                    {
                        System.out.println("You dont have permission to delete this classroom");
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
                            if(tid==foundClassroom.getTid())
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
              
                password = scanner.nextLine().trim();

                Student loggedInStudent = null;
                for (Student stu : students) {
                    if (stu.getId().equals(stuId) && stu.login(password))
                     {
                           loggedInStudent = stu;
                           
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
                    System.out.println("6.Exit");
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
                            count=0;
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
                                        count++;
                                        break; 
                                    }      
                            }
                            if(count==0)
                            {
                                System.out.println("You are not added to the classroom");
                            }
                            break;
                        }
                        case 4:
                        {
                            count=0;
                            scanner.nextLine();
                            System.out.println("Enter the class code to view marks of a assignment");
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
                                        System.out.println("Enter Assignemnt code");
                                        int ac=scanner.nextInt();
                                        foundClassroom.displayMarks(ac,loggedInStudent.getId());
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
                        case 6:
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
