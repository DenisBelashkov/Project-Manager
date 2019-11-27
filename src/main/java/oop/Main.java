package oop;

import oop.sructure.sprint.Sprint;
import oop.sructure.sprint.Task;
import oop.sructure.employers.devTypes.AndroidDeveloper;
import oop.sructure.employers.employer.EmpException;
import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.employer.EmployerFactory;
import oop.sructure.employers.employer.analyst.Analyst;
import oop.sructure.employers.employer.developer.Developer;
import oop.sructure.employers.employer.tester.Tester;
import oop.sructure.employers.ranks.Junior;
import oop.sructure.employers.ranks.Middle;
import oop.sructure.employers.ranks.RankDecorator;
import oop.sructure.employers.ranks.Senior;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws EmpException {

        // todo делать ли класс с методами, который использует одновременно все эти паттерны и делает в одной строчке кода то, что делают четыре нижних?
        // todo надо ли в классе AndroidDeveloper использовать поле не Developer, a Employer?

        Employer an1 = EmployerFactory.createEmployer(EmpType.ANALYST, "Evgeniy Kravchenko");
        RankDecorator senAn1 = new Senior(an1);

        Employer an2 = EmployerFactory.createEmployer(EmpType.ANALYST, "Vlad Tulinov");
        RankDecorator juAn2 = new Junior(an2);

        List<Analyst> analysts = new LinkedList<>();
        analysts.add((Analyst) an1);
        analysts.add((Analyst) an2);

        Employer emp1 = EmployerFactory.createEmployer(EmpType.DEVELOPER, "Artem Kondratkov");

        AndroidDeveloper dev1 = new AndroidDeveloper((Developer) emp1);
        dev1 = new AndroidDeveloper(dev1);
        RankDecorator midDev1 = new Middle(dev1);

        Employer emp2 = EmployerFactory.createEmployer(EmpType.DEVELOPER, "Liza Bulavina");

        AndroidDeveloper dev2 = new AndroidDeveloper((Developer) emp2);
        dev2 = new AndroidDeveloper(dev2);
        RankDecorator senDev2 = new Senior(dev2);

        List<Developer> developers = new LinkedList<>();
/*        developers.add((Developer) midDev1);
        developers.add((Developer) senDev1);*/

       developers.add( dev1);
       print(dev1.getRank().toString());
        developers.add( dev2);



        Employer qa1 = EmployerFactory.createEmployer(EmpType.TESTER, "Anna Yanshina");
        RankDecorator senQa1 = new Senior(qa1);

        Employer qa2 = EmployerFactory.createEmployer(EmpType.TESTER, "Vlad Sobolev");
        RankDecorator juQa2 = new Junior(qa2);

        List<Tester> testers = new LinkedList<>();
        testers.add((Tester) qa1);
        testers.add((Tester) qa2);

        List<Task> open = new LinkedList<>();
        List<Task> dev = new LinkedList<>();
        List<Task> prod = new LinkedList<>();

        Sprint sprint = new Sprint("r",open,dev,prod,10,analysts,developers,testers);
        sprint.start(5);



    }

    private static void print(String str) {
        System.out.println(str);
    }
}
