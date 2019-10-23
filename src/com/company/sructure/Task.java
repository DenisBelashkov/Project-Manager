package com.company.sructure;


import com.company.sructure.employers.EmployerInterface;
import com.company.sructure.employers.devTypes.DevType;

public class Task {
    private String name; // формат?
    private String description;
    private int devTime; // время разработки -- или в днях/часах, или старт финиш, =< спринта
    private DevType devType;
    private int priority; // чем больше, тем приоритетнее. В принципе, имеет смысл отделньым классом, чтобы не было меньше нуля
    private Status status;
    private int deadline;



    private EmployerInterface employer; // имеет ли смысл делать одну задачу для кучки разработчиков? TODO зменить на дева

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDevTime() {
        return devTime;
    }

    public void setDevTime(int devTime) {
        this.devTime = devTime;
    }

    public DevType getDevType() {
        return devType;
    }

    public void setDevType(DevType devType) {
        this.devType = devType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public EmployerInterface getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerInterface employer) {
        this.employer = employer;
    }

    public Task(String name, String description, int devTime, DevType devType, int priority, Status status, int deadline, EmployerInterface employer) {
        this.name = name;
        this.description = description;
        this.devTime = devTime;
        this.devType = devType;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
        this.employer = employer;
    }

    public Task(String name, String description, int devTime, DevType devType, int priority, Status status, int deadline) {
        this(name, description, devTime, devType, priority, status, deadline, null);
    }
/*
    public Task(String name, int priority) {
        this(name, "Blablabla", 0, DevType.ANDROID, priority);
    }*/

    public void print(){
        System.out.print("TaskID: " + name);
        System.out.print(" "+"TaskDevTime: "+devTime);
        System.out.print(" "+ status);
        System.out.println(" "+"Employer: "+employer.getName());
    }

    public void addEmployer() {

    }

    public void removeEmployer() {

    }


}
