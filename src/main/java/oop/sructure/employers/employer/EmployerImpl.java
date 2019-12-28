package oop.sructure.employers.employer;

import oop.sructure.employers.ranks.Rank;
import oop.sructure.sprint.Sprint;
import oop.sructure.sprint.Task;

import java.util.List;
import java.util.Stack;

public class EmployerImpl extends Thread implements Employer {//empImpl
//extends Thread
    String name;
    Rank rank;
    double performance; // производительость
    EmpType empType;
    int workTime = 0;
    Sprint sprint;

    public EmployerImpl() {

    }
    public EmployerImpl(String name) {
        this.name = name;
    }

    public int getWorkTime() {
        return workTime;
    }

    @Override
    public Task generateTask(Stack<String> names) {
        return null;
    }

    @Override
    public Task completeTask(List<Task> openTaskList) {
        return null;
    }

    @Override
    public Task prodTask(List<Task> devTaskList) {
        return null;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }


    @Override
    public void setSprint(Sprint sprint) {
        this.sprint=sprint;
    }

    public Sprint getSprint() {
        return sprint;
    }

    @Override
    public String getNameEmployer() {
        return name;
    }

    @Override
    public void setNameEmployer(String name) {
        this.name = name;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }
}
