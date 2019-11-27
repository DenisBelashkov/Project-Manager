package oop.sructure.employers.employer;

import oop.sructure.employers.employer.analyst.AnalystImpl;
import oop.sructure.employers.employer.developer.DeveloperImpl;
import oop.sructure.employers.employer.tester.TesterImpl;

public abstract class EmployerFactory {

    public static EmployerImpl createEmployer(EmpType empType, String name) throws EmpException {

        switch (empType) {
            case DEVELOPER: // todo вместо многих кейсов дескрипшн классов
                return new DeveloperImpl(name);//todo возможно сотрудник, но с другими параметрами
            case TESTER:
                return new TesterImpl(name); //todo map с лямбдой!!!!!
            case ANALYST:
                return new AnalystImpl(name);
            default:
                throw new EmpException();
        }
    }


}
