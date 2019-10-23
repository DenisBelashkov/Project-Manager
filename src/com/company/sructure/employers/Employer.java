package com.company.sructure.employers;

import com.company.sructure.employers.ranks.Rank;

public class Employer implements EmployerInterface {

    String name;
    Rank rank;
    int performance; // производительость
    EmpType empType;

    public Employer() {

    }


    @Override
    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }

    public Employer(String name) {
        this.name = name;
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

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }
}
