package oop.sructure.employers.employer;

import oop.sructure.employers.ranks.Rank;

public class EmployerImpl implements Employer {//empImpl

    String name;
    Rank rank;
    double performance; // производительость
    EmpType empType;
    int workTime = 0;

    public EmployerImpl() {

    }
    public EmployerImpl(String name) {
        this.name = name;
    }

    public int getWorkTime() {
        return workTime;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
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
