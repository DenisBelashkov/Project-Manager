package com.company.sructure.employers.devTypes;

import com.company.sructure.employers.Developer;
import com.company.sructure.employers.DeveloperInterface;
import com.company.sructure.employers.EmployerInterface;

public class AndroidDeveloper extends DeveloperDecorator {


    public AndroidDeveloper(DeveloperInterface developer) {
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
