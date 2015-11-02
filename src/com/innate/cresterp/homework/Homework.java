package com.innate.cresterp.homework;

/**
 *
 * @author Simbarashe Clever
 */
public class Homework {
    private int id;
    private String username;
    private String activation;
    private String installation;
    private String password;
    private String studentclass;
    private String subject;
    private String description;
    private String teacher;
    private String assignedDate;
    private String dueDate;
    private String wfield1;
    private String wfield2;
    private String wfield3;
    private String wfield4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getActivation() {
        return activation;
    }

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public String getInstallation() {
        return installation;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWfield1() {
        return wfield1;
    }

    public void setWfield1(String wfield1) {
        this.wfield1 = wfield1;
    }

    public String getWfield2() {
        return wfield2;
    }

    public void setWfield2(String wfield2) {
        this.wfield2 = wfield2;
    }

    public String getWfield3() {
        return wfield3;
    }

    public void setWfield3(String wfield3) {
        this.wfield3 = wfield3;
    }

    public String getWfield4() {
        return wfield4;
    }

    public void setWfield4(String wfield4) {
        this.wfield4 = wfield4;
    }
    
      public String createHTML() {
        return "<p><strong>Student: </strong>" + getUsername() + "</p>"
                + ""
                + "<p><strong>Teacher:</strong> " + getTeacher() + "</p>"
                + "<p><strong>Class:</strong> " + getStudentclass() + "</p>"
                + "<p><strong>Subject:</strong> " + getSubject() + "</p>"
                + "<p><strong>Homework:</strong> " + getDescription()+ "</p>"
            
                + "<p>&nbsp;</p>"
                + ""
                + "<p>&nbsp;</p>";

    }
}
