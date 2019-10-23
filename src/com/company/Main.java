package com.company;

import com.company.sructure.Sprint;
import com.company.sructure.employers.*;
import com.company.sructure.employers.devTypes.AndroidDeveloper;
import com.company.sructure.employers.devTypes.BackendDeveloper;
import com.company.sructure.employers.devTypes.IOSDeveloper;
import com.company.sructure.employers.devTypes.DevType;
import com.company.sructure.employers.ranks.Junior;
import com.company.sructure.employers.ranks.RankDecorator;

import java.util.*;

public class Main {

    public static void main(String[] args) throws EmpException {
       // EmployerInterface dev = new Employer("ff");

        EmployerInterface  dev = EmployerFactory.createEmployer(EmpType.DEVELOPER,"ff");
        dev = new Junior(dev);
        print(" "+dev.getPerformance());
        print(dev.getName());
        dev = new AndroidDeveloper((DeveloperInterface) dev);

        print(" "+ dev.getDevType();





    }



    private static void print(String str) {
        System.out.println(str);
    }

}

        /*


        // write your code here

        Analyst an1 = new Analyst("Artem Kondratkov");
       // an1.setPerformance(2);
        Analyst an2 = new Analyst("Evgen Kravchenko");
       // an2.setPerformance(1);

        Developer dev1 = new Developer("Anatol Udarcsev"); // видел реализацию, где
        // создается new BackendDeveloper, а в нем уже содержатся методы, которые меняются исходный компонент
        BackendDeveloper bd1 = new BackendDeveloper(dev1);
        dev1.setDevType(DevType.BACK_END);
        dev1.setPerformance(2);
      EmployerInterface dev2 = new Developer("Liz Bulavina");
       //  dev2 = new AndroidDeveloper(dev2);// todo делать фабрику!!!!!!!
     //   AndroidDeveloper ad1 = new AndroidDeveloper(dev2);
       // dev2.setDevType(DevType.ANDROID);
      //  dev2.setPerformance(1);
        Developer dev3 = new Developer("Ann Yanshina");
        IOSDeveloper id1 = new IOSDeveloper(dev3);
        dev3.setDevType(DevType.IOS);
        dev3.setPerformance(3);

        Tester test1 = new Tester("Vlad Sobol");
       // test1.setPerformance(2);
        Tester test2 = new Tester("Vlad Tool");
      //  test1.setPerformance(1);

        List<Analyst> analysts = new LinkedList<>();
        analysts.add(an1);
        analysts.add(an2);

        List<Developer> developers = new LinkedList<>();

        developers.add(dev1); // при попытке добавить сюда декоратор -- не получается. В чем проблема?
        //developers.add(dev2);

        List<Tester> testers = new LinkedList<>();

        testers.add(test1);
        testers.add(test2);

        List<EmployerInterface> employers = new LinkedList<>();
        employers.addAll(analysts);
        employers.addAll(developers);
        employers.addAll(testers);
        Sprint sprint = new Sprint("OOP", employers, 10, analysts, developers, testers);
      //  System.out.println();
      //  System.out.println("Project: " + sprint.getName());

        // sprint.createTasks(5);

        int n  = 5;
sprint.start(n);


            /*
            if ((sprint.getDevTaskList() != null) && !sprint.getDevTaskList().isEmpty()) {

                for (Task task2 : sprint.getDevTaskList()) {
                    if (task2.getDevTime() < i)
                        task2.print();
                }
            }

             */
            /*
            if ((sprint.getProdTaskList() != null) & !sprint.getProdTaskList().isEmpty()) {

                for (Task task2 : sprint.getProdTaskList()) {
                    if (task2.getDevTime() < i)
                        task2.print();
                }
            }

             */




        /*

        System.out.println();
        for (Task tempTask : sprint.getTaskList()) {
            tempTask.print();
        }

        System.out.println();

        sprint.devTasks();

        for (Task tempTask : sprint.getTaskList()) {
            tempTask.print();
        }

        System.out.println();

        sprint.prodTasks();

        for (Task tempTask : sprint.getTaskList()) {
            tempTask.print();
        }

        System.out.println();
*/




