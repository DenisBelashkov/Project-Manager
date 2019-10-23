package com.company.sructure.employers.devTypes;

import com.company.sructure.employers.DeveloperInterface;
import com.company.sructure.employers.EmpType;
import com.company.sructure.employers.ranks.Rank;


public abstract class DeveloperDecorator implements DeveloperInterface {

    protected DeveloperInterface developer;


    public DeveloperDecorator(DeveloperInterface developer) {
        super();
        this.developer = developer;
    }

    @Override
    public DevType getDevType() {
        return developer.getDevType();
    }

    @Override
    public String getName() {
        return developer.getName();
    }

    @Override
    public Rank getRank() {
        return developer.getRank();
    }

    @Override
    public EmpType getEmpType() {
        return developer.getEmpType();
    }


    @Override
    public void setDevType(DevType devType) {
        developer.setDevType(devType);
    }

    @Override
    public void setRank(Rank rank) {
        developer.setRank(rank);
    }

    @Override
    public void setPerformance(int performance) {
        developer.setPerformance(performance);
    }

    @Override
    public int getPerformance() {
        return developer.getPerformance();
    }
}
