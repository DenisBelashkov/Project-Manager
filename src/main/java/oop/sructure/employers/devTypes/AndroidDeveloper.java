package oop.sructure.employers.devTypes;

import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.employer.developer.Developer;

public class AndroidDeveloper extends DeveloperDecorator {


    public AndroidDeveloper(Developer developer) {
        super(developer);
        developer.setDevType(DevType.ANDROID);
    }

    public AndroidDeveloper(Employer employer) {
        super((Developer) employer);
        developer.setDevType(DevType.ANDROID);
    }

    // @Override
    public DevType getDevType() {
        return DevType.ANDROID;
    }

    /*
    @Override
    public DevType getDevType() {
       return DevType.ANDROID;
    }

 */



}
