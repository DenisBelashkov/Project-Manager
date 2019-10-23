package com.company.sructure.employers.devTypes;

import com.company.sructure.employers.Developer;
import com.company.sructure.employers.DeveloperInterface;

public class IOSDeveloper extends DeveloperDecorator {


    public IOSDeveloper(DeveloperInterface developer) {
        super(developer);
        developer.setDevType(DevType.IOS);
    }

    @Override
    public DevType getDevType() {
        return DevType.IOS;
    }


}
