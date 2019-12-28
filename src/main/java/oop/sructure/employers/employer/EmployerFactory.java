package oop.sructure.employers.employer;

import oop.sructure.employers.devTypes.*;
import oop.sructure.employers.employer.analyst.AnalystImpl;
import oop.sructure.employers.employer.developer.Developer;
import oop.sructure.employers.employer.developer.DeveloperImpl;
import oop.sructure.employers.employer.tester.TesterImpl;
import oop.sructure.employers.ranks.Junior;
import oop.sructure.employers.ranks.Middle;
import oop.sructure.employers.ranks.Rank;
import oop.sructure.employers.ranks.Senior;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;


public abstract class EmployerFactory {

    private static Map<EmpType, CreateEmployer> empTypeCreateMap = new HashMap<>();// а как блин эту мапу заполнять? Ну, типа, я могу в этом классе, но это тупо, не?
    private static Map<DevType, CreateDecorator> devTypeCreateMap = new HashMap<>();
    private static Map<Rank, CreateDecorator> rankCreateMap = new HashMap<>();
static {

}
    private static void createMaps() {
        if (empTypeCreateMap.isEmpty()) {
            CreateEmployer createDeveloper = DeveloperImpl::new;
            CreateEmployer createTester = TesterImpl::new;
            CreateEmployer createAnalyst = AnalystImpl::new;
            empTypeCreateMap.put(EmpType.DEVELOPER, createDeveloper);
            empTypeCreateMap.put(EmpType.TESTER, createTester);
            empTypeCreateMap.put(EmpType.ANALYST, createAnalyst);

            CreateDecorator createAndroid = AndroidDeveloper::new;
            CreateDecorator createIOS = IOSDeveloper::new;
            CreateDecorator createBackend = BackendDeveloper::new;


  /*      CreateDecorator createAndroid = (employer) -> new  AndroidDeveloper((Developer) employer);
        CreateDecorator createIOS = (employer) -> new IOSDeveloper((Developer) employer);
        CreateDecorator createBackend = (employer) -> new BackendDeveloper((Developer) employer);*/

            devTypeCreateMap.put(DevType.ANDROID, createAndroid);
            devTypeCreateMap.put(DevType.IOS, createIOS);
            devTypeCreateMap.put(DevType.BACK_END, createBackend);

            CreateDecorator createSenior = Senior::new;
            CreateDecorator createMiddle = Middle::new;
            CreateDecorator createJunior = Junior::new;
            rankCreateMap.put(Rank.SENIOR, createSenior);
            rankCreateMap.put(Rank.MIDDLE, createMiddle);
            rankCreateMap.put(Rank.JUNIOR, createJunior);
        }
    }


    public static Employer createEmployer(EmpType empType, String name, DevType devType, Rank rank) throws EmpException {
        createMaps();
        Employer employer = empTypeCreateMap.get(empType).createEmployer(name);
        devTypeCreateMap.get(devType).createDecorator(employer);
        rankCreateMap.get(rank).createDecorator(employer);
        return employer;

/*      Employer employer = Create.createEmployer(empType, name);
        Create.createDeveloper(employer, devType);
        Create.createRank(employer, rank);
        return employer;*/
    }

    public static Employer createEmployer(EmpType empType, String name, Rank rank) throws EmpException {
        createMaps();
        Employer employer = empTypeCreateMap.get(empType).createEmployer(name);
        rankCreateMap.get(rank).createDecorator(employer);
        return employer;
    }

    private static Create action = new Create() { //а где стрелочки юзать?..


        public EmployerImpl createEmployer(EmpType empType, String name) throws EmpException {


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


        @Override
        public EmployerImpl createDeveloper(Employer employer, DevType devType) throws EmpException {
            switch (devType) {
                case ANDROID:
                    return new AndroidDeveloper((Developer) employer) {
                    };
                case BACK_END:
                    return new BackendDeveloper((Developer) employer) {
                    };
                case IOS:
                    return new IOSDeveloper((Developer) employer) {
                    };
                default:
                    throw new EmpException();
            }
        }

        @Override
        public EmployerImpl createRank(Employer employer, Rank rank) throws EmpException {
            employer.setRank(rank);

            switch (rank) {
                case SENIOR:
                    return new Senior(employer) {
                    };
                case MIDDLE:
                    return new Middle(employer) {
                    };
                case JUNIOR:
                    return new Junior(employer) {
                    };
                default:
                    throw new EmpException();
            }
        }


    };
}



