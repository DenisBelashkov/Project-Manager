package oop.sructure.employers.employer.tester;

import oop.sructure.employers.employer.EmpType;
import oop.sructure.sprint.Task;
import oop.sructure.sprint.Status;
import oop.sructure.employers.employer.EmployerImpl;

import java.util.List;
import java.util.Random;

public class TesterImpl extends EmployerImpl implements Tester {
    private volatile List<Task> tasks;
    private Task task;

    public TesterImpl(String name) {
        super(name);
        super.setEmpType(EmpType.TESTER);
    }

    public Task prodTask(List<Task> taskList) {

        this.tasks = taskList;
        run();
        return this.task;
    }

    public void choseTask(List<Task> tasks) {
        //выбирает задачи только в разработке и меняет на продакшн
        // могут отправить задачу обратно разрабам-девелоперам
    }

    @Override
    public void run() {
        synchronized (tasks) {
            //   System.out.println(tasks);
            int timeWork = (int) ((int) this.getRank().getPerformance() + Math.random() * 100);
            if (tasks != null && !tasks.isEmpty() && getSprint().getProgress()<getSprint().getTimeDev()) {
                try {
                    sleep(timeWork);
                    task = tasks.get(0);
                    tasks.remove(0);

                    if (task != null) {
                        task.addProgress(timeWork);
                        task.setStatus(Status.DONE);
                        task.setEmployer(this);
                         task.print();
                        //getSprint().printSprint(getSprint().getProdTaskList());

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
/*
if (tasks == null) {
stop();*/
        }
    }
}


