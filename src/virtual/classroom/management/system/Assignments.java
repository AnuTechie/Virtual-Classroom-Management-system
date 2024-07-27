/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package virtual.classroom.management.system;
/**
 *
 * @author 91807
 */
public class Assignments {
    private String assignmentTitle;
    private String description;
    private String dateOfSubmission;
    private int id;

    public Assignments(String assignmentTitle, String description, String dateOfSubmission,int id) {
        this.assignmentTitle = assignmentTitle;
        this.description = description;
        this.dateOfSubmission = dateOfSubmission;
        this.id=id;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }
    
     public int getAssignId() {
        return id;
    }
     
    public String getDescription() {
        return description;
    }

    public String getDateOfSubmission() {
        return dateOfSubmission;
    }
    
    public String getTitle()
    {
        return assignmentTitle;
    }
    public void submit() {
        this.dateOfSubmission = java.time.LocalDate.now().toString();
    }
}

