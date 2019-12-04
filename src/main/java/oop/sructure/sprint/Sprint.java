package oop.sructure.sprint;

import oop.sructure.employers.employer.analyst.Analyst;
import oop.sructure.employers.employer.developer.Developer;
import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.employer.tester.Tester;

import java.util.*;

public class Sprint {


    private String name; // в формате 1.11, 1.12, etc

    private List<Task> openTaskList;
    private List<Task> devTaskList;
    private List<Task> prodTaskList;

    // todo тут, по-хорошему, нужен словарь, но хз, с ним мороки больше
    // private List<Employer> employers;
    private int timeDev; //дедлайн?
    private int currentDay = 1;
    private List<Analyst> analysts;
    private List<Developer> developers;
    private List<Tester> testers;

    //private Date startDate;
    //private Date finalDate;
    public Sprint() {
    }

    public int getCurrentDay() {
        return currentDay;
    }
    public Sprint(String name, int timeDev, int currentDay) {
        this.name = name;
        this.timeDev = timeDev;
        this.currentDay = currentDay;

    }
    public Sprint(String name, List<Task> openTaskList, List<Task> devTaskList, List<Task> prodTaskList, int timeDev, int currentDay, List<Analyst> analysts, List<Developer> developers, List<Tester> testers) {
        this.name = name;
        this.openTaskList = openTaskList;
        this.devTaskList = devTaskList;
        this.prodTaskList = prodTaskList;
        this.timeDev = timeDev;
        this.currentDay = currentDay;
        this.analysts = analysts;
        this.developers = developers;
        this.testers = testers;
    }

    public Sprint(String name, List<Task> openTaskList, List<Task> devTaskList, List<Task> prodTaskList, int timeDev, List<Analyst> analysts, List<Developer> developers, List<Tester> testers) {
        this.name = name;
        this.openTaskList = openTaskList;
        this.devTaskList = devTaskList;
        this.prodTaskList = prodTaskList;
        this.timeDev = timeDev;
        this.analysts = analysts;
        this.developers = developers;
        this.testers = testers;
    }

    private void createTasks(Stack<String> names) {
        for (Analyst analyst : analysts) {
            //  print(analyst.getWorkTime() + "an");
            if (analyst.getWorkTime() == 0) {
                if (!names.empty()) {
                    Task newTask = analyst.generateTask(names);
                    newTask.addAbsDevTime(currentDay + newTask.getDevTime());
                    openTaskList.add(newTask);
                }
            }
            if (analyst.getWorkTime() > 0) {
                analyst.setWorkTime(analyst.getWorkTime() - 1);
            }
        }
    }

    private void devTasks() {
        Task tempTask;
        // if (openTaskList != null |)) {
        //  print("hghghgh");
        for (Developer developer : developers) {
            // print(developer.getWorkTime()+"hghghgh");
            if (developer.getWorkTime() == 0) {
                for (Task task : openTaskList) {
                    //    print(developer.getWorkTime()+"hghghgh");

                    if (task.getAbsDevTime() <= currentDay) { // так как выводится инфомрация на утро n дня, разработчик модет взять ее этим же утром
                        tempTask = task;// возможно глобальный косяк
                        tempTask.setEmployer(developer);
                        devTaskList.add(developer.completeTask(tempTask));

                        //tempTask.addAbsDevTime(tempTask.getDevTime());

                        openTaskList.remove(task);


                        print(developer.getWorkTime() + " " + developer.getName());
                        break;
                    }
                }
            }


            if (developer.getWorkTime() > 0) {
                print(developer.getWorkTime() + "dev");
                developer.setWorkTime(developer.getWorkTime() - 1); // шибка тут}
            }

        }
        // }
    }


    private void prodTasks(int i) {
        Task tempTask = null;

        if ((devTaskList != null) || !devTaskList.isEmpty()) {

            for (Tester tester : testers) {
                if (tester.getWorkTime() == 0)
                    for (Task task : devTaskList) {
                        if (task.getDevTime() < i) {
                            tempTask = task;
                            tempTask.addAbsDevTime(currentDay);
                            tempTask.setEmployer(tester);
                            devTaskList.remove(task);
                            tester.setWorkTime(tester.getWorkTime() - 1);
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
                if (task2.getAbsDevTime() <= i)
                    task2.print();
            }
        }

    }

    public void start(int n) {
        Stack<String> names = new Stack<>();
        for (int i = n; i > 0; i--) {
            String name = i + "";
            names.push(name);
            //     System.out.println("kfkfkf");
        }
        for (int i = 1; i < timeDev + 1; i++) {
            print("День разработки: " + i);
            currentDay = i;
            if (!names.empty()) {
                createTasks(names);
            }
            printSprint(openTaskList, currentDay);
            if (!openTaskList.isEmpty()) {
                devTasks();
                printSprint(devTaskList, currentDay);
            }


/*
            prodTasks(i);

            printSprint(prodTaskList, i);*/

        }
    }

    private static void print(String str) {
        System.out.println(str);
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

/*    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }*/

    public int getTimeDev() {
        return timeDev;
    }

    public void setTimeDev(int timeDev) {
        this.timeDev = timeDev;
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


    @Override
    public String toString() {
        return name;
    }
}
