package oop.sructure.employers.devTypes;

import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.employer.developer.Developer;

public class IOSDeveloper extends DeveloperDecorator {


    public IOSDeveloper(Developer developer) {
        super(developer);
        developer.setDevType(DevType.IOS);
    }

    public IOSDeveloper(Employer employer) {
        super((Developer) employer);
        developer.setDevType(DevType.IOS);
    }

    @Override
    public DevType getDevType() {
        return DevType.IOS;
    }


}
