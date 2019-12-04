package oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import oop.sructure.converter.CustomConverter;
import oop.sructure.employers.devTypes.DevType;
import oop.sructure.employers.ranks.*;
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
import oop.sructure.utils.Logs;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws EmpException {

        // todo делать ли класс с методами, который использует одновременно все эти паттерны и делает в одной строчке кода то, что делают четыре нижних?
        // todo надо ли в классе AndroidDeveloper использовать поле не Developer, a Employer?


        //   Employer dev1 = EmployerFactory.createEmployer(EmpType.DEVELOPER,"dddd", DevType.ANDROID, Rank.JUNIOR);

        Employer an1 = EmployerFactory.createEmployer(EmpType.ANALYST, "Evgeniy Kravchenko", Rank.SENIOR);
        Employer an2 = EmployerFactory.createEmployer(EmpType.ANALYST, "Vlad Tulinov", Rank.JUNIOR);

        List<Analyst> analysts = new LinkedList<>();
        analysts.add((Analyst) an1);
        analysts.add((Analyst) an2);


//todo проблема -- как сделать динамически меняющийся метод, чтобы он принимал на вход любой класс?
        Employer dev1 = EmployerFactory.createEmployer(EmpType.DEVELOPER, "Artem Kondratkov", DevType.ANDROID, Rank.MIDDLE);
        Employer dev2 = EmployerFactory.createEmployer(EmpType.DEVELOPER, "Denis Belashkov", DevType.ANDROID, Rank.SENIOR);

        List<Developer> developers = new LinkedList<>();
        developers.add((Developer) dev1);
        developers.add((Developer) dev2);
print(((Developer) dev1).getDevType()+"");

        Employer qa1 = EmployerFactory.createEmployer(EmpType.TESTER, "Anna Yanshina", Rank.SENIOR);
        Employer qa2 = EmployerFactory.createEmployer(EmpType.TESTER, "Vlad Sobolev", Rank.JUNIOR);

        List<Tester> testers = new LinkedList<>();
        testers.add((Tester) qa1);
        testers.add((Tester) qa2);

        List<Task> open = new LinkedList<>();
        List<Task> dev = new LinkedList<>();
        List<Task> prod = new LinkedList<>();

        Sprint sprint = new Sprint("r", open, dev, prod, 10, analysts, developers, testers);
        sprint.start(5);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Sprint.class, new CustomConverter());
        Gson gson = builder.create();



        String JSON =gson.toJson(sprint);
        print(JSON);
/*Employer employer = gson.fromJson(JSON,Employer.class);*/
        Logs.createLog(JSON);
        print(Logs.readLog().toString());

    }

    private static void print(String str) {
        System.out.println(str);
    }
}
