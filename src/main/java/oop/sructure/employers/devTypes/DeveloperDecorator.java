package oop.sructure.employers.devTypes;

import oop.sructure.employers.employer.developer.Developer;
import oop.sructure.employers.employer.developer.DeveloperImpl;
import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.ranks.Rank;


public abstract class DeveloperDecorator extends DeveloperImpl implements Developer {

    protected Developer developer;


    public DeveloperDecorator(Developer developer) {
        super(developer.getName());
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
    public double getPerformance() {
        return developer.getPerformance();
    }
}
