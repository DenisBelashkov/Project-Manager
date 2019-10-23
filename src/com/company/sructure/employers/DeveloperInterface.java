package com.company.sructure.employers;

import com.company.sructure.employers.devTypes.DevType;

public interface DeveloperInterface extends EmployerInterface{
    void setDevType(DevType devType);
    DevType getDevType();
}
