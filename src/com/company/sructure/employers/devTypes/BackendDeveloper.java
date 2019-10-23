package com.company.sructure.employers.devTypes;

import com.company.sructure.employers.Developer;
import com.company.sructure.employers.DeveloperInterface;


public class BackendDeveloper extends DeveloperDecorator {


    public BackendDeveloper(DeveloperInterface developer) {
        super(developer); 
        developer.setDevType(DevType.BACK_END);
    }

    @Override
    public DevType getDevType() {
        return DevType.BACK_END;
    }




}