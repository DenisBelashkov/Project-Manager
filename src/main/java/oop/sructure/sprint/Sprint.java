package oop.sructure.sprint;

import com.google.gson.annotations.SerializedName;
import oop.sructure.employers.employer.Employer;
import oop.sructure.employers.employer.analyst.Analyst;
import oop.sructure.employers.employer.developer.Developer;
import oop.sructure.employers.employer.tester.Tester;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Sprint extends Thread {
    long start = System.currentTimeMillis();

    @SerializedName("name")
    private String sprintName; // в формате 1.11, 1.12, etc

    private volatile List<Task> openTaskList;
    private volatile List<Task> devTaskList;
    private volatile List<Task> prodTaskList;

    // todo тут, по-хорошему, нужен словарь, но хз, с ним мороки больше
    // private List<Employer> employers;

    @SerializedName("development_time")
    private int timeDev; //дедлайн?
    private int progress = 0;
    private List<Analyst> analysts;
    private List<Developer> developers;
    private List<Tester> testers;
    private List<Employer> employers = new ArrayList<>();

    //private Date startDate;
    //private Date finalDate;
    public Sprint() {
    }

    // public long getCurrentDay() {
  /*      return currentDay;
    }*/

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    public Sprint(String name, int timeDev, int currentDay) {
        this.sprintName = name;
        this.timeDev = timeDev;

    }

    public Sprint(String name, List<Task> openTaskList, List<Task> devTaskList, List<Task> prodTaskList, int timeDev, int currentDay, List<Analyst> analysts, List<Developer> developers, List<Tester> testers) {
        this.sprintName = name;
        this.openTaskList = openTaskList;
        this.devTaskList = devTaskList;
        this.prodTaskList = prodTaskList;
        this.timeDev = timeDev;
        this.analysts = analysts;
        this.developers = developers;
        this.testers = testers;
    }

    public Sprint(String name, List<Task> openTaskList, List<Task> devTaskList, List<Task> prodTaskList, int timeDev, List<Analyst> analysts, List<Developer> developers, List<Tester> testers) {
        this.sprintName = name;
        this.openTaskList = openTaskList;
        this.devTaskList = devTaskList;
        this.prodTaskList = prodTaskList;
        this.timeDev = timeDev * 2400;
        this.analysts = analysts;
        this.developers = developers;
        this.testers = testers;
        employers.addAll(analysts);
        employers.addAll(testers);
        employers.addAll(developers);
        for (Employer employer : employers) {
            employer.setSprint(this);
        }
    }

    private void createTasks(Stack<String> names) {
        while (!names.empty())

            for (Analyst analyst : analysts) {

                openTaskList.add(analyst.generateTask(names));
/*
                printSprint(openTaskList);
*/
            }
    }

    private void prodTasks() {

        int i = 2000;//как сделать так, чтобы они постоянно обновляли информацию?

        while (!devTaskList.isEmpty()) {

            if (devTaskList != null) {
                for (Tester tester : testers) {
                    prodTaskList.add(tester.prodTask(devTaskList));

                }
            }

        }
    }

    private void devTasks() {

        while (!openTaskList.isEmpty()) {


            if (openTaskList != null) {
                for (Developer developer : developers) {
                    devTaskList.add(developer.completeTask(openTaskList));

                }
            }

        }
    }

    public void printSprint(List<Task> tasks) {


        if ((tasks != null) && !tasks.isEmpty()) {


            for (Task task2 : tasks) {
                if (task2 != null)
/*
                if (task2.getAbsDevTime() <= i)
*/
                    task2.print();
            }
        }

    }

    @Override
    public void run() {
/*        long currentDay = System.currentTimeMillis() - start;

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < currentDay; i += 2400) {
            printSprint(openTaskList);
            printSprint(devTaskList);
            printSprint(prodTaskList);
        }*/
    }

    public void start(int n) {
        // run();


        Stack<String> names = new Stack<>();
        for (int i = n; i > 0; i--) {
            String name = i + "";
            names.push(name);
            //     System.out.println("kfkfkf");
        }

        AtomicInteger i = new AtomicInteger();//как сделать так, чтобы они постоянно обновляли информацию?
/*
        printSprint(openTaskList);
        printSprint(devTaskList);
        printSprint(prodTaskList);*/
/*

        Thread thread = new Thread(() -> {
            while (i.get() <= timeDev) {
                System.out.println(timeDev);
                //sprint.printSprint(sprint.getDevTaskList());
                System.out.println("День разработки: " + i);
                printSprint(openTaskList);
                System.out.println();
                printSprint(devTaskList);
                System.out.println();
                printSprint(prodTaskList);
                System.out.println();
                i.addAndGet(2400);
               progress += 2400;
                try {
                    Thread.sleep(2400);
                } catch (InterruptedException e) {
                    Thread.currentThread().stop();

                }
            }
        });

        thread.setDaemon(true);

        thread.start();

*/

        if (!names.empty()) {
            createTasks(names);
        }
        System.out.println();
        if (openTaskList != null && !openTaskList.isEmpty()) {
            devTasks();

        }
        System.out.println();
        if (!devTaskList.isEmpty()) {
            prodTasks();
        }

/*while (!openTaskList.isEmpty() || !names.empty()){
    for
}*/

        /* printSprint(openTaskList, currentDay);*/

        /*
        for (int i = 1; i < timeDev + 1; i++) {
            print("День разработки: " + i);
            currentDay = i;
            if (!names.empty()) {
                createTasks(names);
            }
            printSprint(openTaskList, currentDay);
    *//*        if (!openTaskList.isEmpty()) {
                devTasks();
                //     printSprint(devTaskList, currentDay);
            }*//*


         *//*
            prodTasks(i);

            printSprint(prodTaskList, i);*//*

        }*/


    }

    private static void print(String str) {
        System.out.println(str);
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String name) {
        this.sprintName = name;
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
        return sprintName;
    }
}
