package oop.sructure.employers.employer;

import oop.sructure.employers.devTypes.DevType;
import oop.sructure.employers.ranks.Rank;

public interface Create {
    // EmployerImpl create();

    EmployerImpl createEmployer(EmpType empType, String name) throws EmpException;
    EmployerImpl createDeveloper(Employer employer, DevType devType) throws EmpException;
    EmployerImpl createRank(Employer employer, Rank rank) throws EmpException;
}
