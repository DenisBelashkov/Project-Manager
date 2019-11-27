package oop.sructure.employers.devTypes;

import oop.sructure.employers.employer.developer.Developer;

public class AndroidDeveloper extends DeveloperDecorator {


    public AndroidDeveloper(Developer developer) {
        super(developer);
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
