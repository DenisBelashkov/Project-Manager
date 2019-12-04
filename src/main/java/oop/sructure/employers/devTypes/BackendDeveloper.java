package oop.sructure.employers.devTypes;

import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.employer.developer.Developer;


public class BackendDeveloper extends DeveloperDecorator {


    public BackendDeveloper(Developer developer) {
        super(developer); 
        developer.setDevType(DevType.BACK_END);
    }
    public BackendDeveloper(Employer employer) {
        super((Developer) employer);
        developer.setDevType(DevType.BACK_END);
    }
    @Override
    public DevType getDevType() {
        return DevType.BACK_END;
    }




}