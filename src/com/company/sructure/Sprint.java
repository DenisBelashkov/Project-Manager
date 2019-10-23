package com.company.sructure;

import com.company.sructure.employers.Analyst;
import com.company.sructure.employers.Developer;
import com.company.sructure.employers.EmployerInterface;
import com.company.sructure.employers.Tester;

import java.util.*;

public class Sprint {


    private String name; // в формате 1.11, 1.12, etc

    private List<Task> openTaskList = new LinkedList<>();
    private List<Task> devTaskList = new LinkedList<>();
    private List<Task> prodTaskList = new LinkedList<>();
    private List<EmployerInterface> employers;
    private int timeDev;

    private List<Analyst> analysts;
    private List<Developer> developers;
    private List<Tester> testers;
    //private Date startDate;
    //private Date finalDate;


    public List<Task> getDevTaskList() {
        return devTaskList;
    }

    public void setDevTaskList(List<Task> devTaskList) {
        this.devTaskList = devTaskList;
    }

    public List<Task> getProdTaskList() {
        return prodTaskList;
    }

    public void setProdTaskList(List<Task> prodTaskList) {
        this.prodTaskList = prodTaskList;
    }


    public List<Analyst> getAnalysts() {
        return analysts;
    }

    public void setAnalysts(List<Analyst> analysts) {
        this.analysts = analysts;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Tester> getTesters() {
        return testers;
    }

    public void setTesters(List<Tester> testers) {
        this.testers = testers;
    }

    public Sprint(String name, List<EmployerInterface> employers, int timeDev, List<Analyst> analysts, List<Developer> developers, List<Tester> testers) {
        this.name = name;

        this.employers = employers;
        this.timeDev = timeDev;

        this.analysts = analysts;
        this.developers = developers;
        this.testers = testers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Task> getOpenTaskList() {
        return openTaskList;
    }

    public void setOpenTaskList(List<Task> openTaskList) {
        this.openTaskList = openTaskList;
    }

    public List<EmployerInterface> getEmployers() {
        return employers;
    }

    public void setEmployers(List<EmployerInterface> employers) {
        this.employers = employers;
    }

    public int getTimeDev() {
        return timeDev;
    }

    public void setTimeDev(int timeDev) {
        this.timeDev = timeDev;
    }


    private void createTasks(int n, int cur) {
        // n -- количество задач

        for (Analyst analyst : analysts) {
            if (cur <= n) {
                cur++;
                analyst.generateTask(openTaskList, cur, timeDev);
            }
        }


    }

    private void devTasks(int i) {

        Task tempTask = null;
        if (openTaskList != null || !openTaskList.isEmpty()) {

            for (Developer developer : developers) {

                for (Task task : openTaskList) {

                    if (task.getDevTime() <= i) {
                        tempTask = task;
                        tempTask.setEmployer(developer);
                        openTaskList.remove(task);
                        break;
                    }

                }

                if (tempTask != null) devTaskList.add(developer.completeTask(tempTask));

            }
        }
    }


    private void prodTasks(int i) {
        Task tempTask = null;

        if ((devTaskList != null) || !devTaskList.isEmpty()) {

            for (Tester tester : testers) {

                for (Task task : devTaskList) {
                    if (task.getDevTime() < i) {
                        tempTask = task;
                        tempTask.setEmployer(tester);
                        devTaskList.remove(task);
                        break;
                    }
                }


                if (tempTask != null) prodTaskList.add(tester.prodTask(tempTask));

            }
        }
    }

    public void printSprint(List<Task> tasks, int i) {
        if ((tasks != null) && !tasks.isEmpty()) {

            for (Task task2 : tasks) {
                if (task2.getDevTime() < i)
                    task2.print();
            }
        }

    }

    public void start(int n) {
        int cur = 0;
        for (int i = 1; i < timeDev + 1; i++) {
            print("День разработки: " + i);
            if (cur <= n) {
                cur++;
                createTasks(n, cur);
            }

            printSprint(openTaskList, i);

          //  devTasks(i);

          //  printSprint(devTaskList, i);

         //   prodTasks(i);

           // printSprint(prodTaskList, i);
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }

}
