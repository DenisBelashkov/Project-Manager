package oop.sructure.sprint;


import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.devTypes.DevType;

import java.util.Random;

public class Task {
    private Sprint sprint; // спринт, к которому относится задача
    private String name; // формат?
    private String description;
    private int devTime; // относительное время разработки от начала работы над таской, до завершения
    private int absDevTime; // абсолютное время разработки от начала работы над спринтом до завершения таски
    private DevType devType; // тип разработки
    private int priority; // чем больше, тем приоритетнее. В принципе, имеет смысл отделньым классом, чтобы не было меньше нуля
    private Status status; // в каком состоянии сейчас задача -- только создана, в разработке, завершена
    private int deadline; // время, за которое нужно сделать таск -- определяет аналитик
    private int progress = 0;


    private Employer employer; // имеет ли смысл делать одну задачу для кучки разработчиков? TODO зменить на дева
    Random random = new Random();
    int i = random.nextInt((100000)+1000);

    public Task(String name, String description, int devTime, DevType devType, int priority, Status status, int deadline, Employer employer) {
        this.name = name;
        this.description = description;
        this.devTime = devTime;
        this.devType = devType;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
        this.employer = employer;
        progress+=devTime;


    }

    public Task(String name, String description, DevType devType, int priority, Status status, int deadline) {

        this(name, description, 0, devType, priority, status, deadline, (Employer) null);
    }



    public void addDevTime(int devTime) {
        this.devTime += devTime;
    }

    public void addAbsDevTime(int absDevTime) {
        this.absDevTime += absDevTime;
    }

    public void addProgress(int time) {
        progress += time;
    }

/*
    public Task(String name, int priority) {
        this(name, "Blablabla", 0, DevType.ANDROID, priority);
    }*/

    public void print() {
        System.out.print("TaskID: " + name);
        System.out.print(" " + "Progress: " + progress);
        System.out.print(" " + "Deadline: " + deadline);
        System.out.print(" " + status);
        System.out.println(" " + "Employer: " + employer.getNameEmployer());
    }

    public void addEmployer() {

    }

    public void removeEmployer() {

    }


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

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public int getAbsDevTime() {
        return absDevTime;
    }

    public void setAbsDevTime(int absDevTime) {
        this.absDevTime = absDevTime;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
