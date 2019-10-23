package com.company.sructure.employers;

public class EmployerFactory {

    public static Employer createEmployer(EmpType empType, String name) throws EmpException {
        switch (empType){
            case DEVELOPER:
                return new Developer(name);//todo возможно сотрудник, но с другими параметрами
            case TESTER:
                return new Tester(name);
            case ANALYST:
                return new Analyst(name);
            default:
                throw new EmpException();
    }
}}
