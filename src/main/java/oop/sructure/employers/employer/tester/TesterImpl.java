package oop.sructure.employers.employer.tester;

import oop.sructure.sprint.Task;
import oop.sructure.sprint.Status;
import oop.sructure.employers.employer.EmployerImpl;

import java.util.List;
import java.util.Random;

public class TesterImpl extends EmployerImpl implements Tester {
    Random random = new Random();

    public TesterImpl(String name) {
        super(name);
    }

    public Task prodTask(Task task) {

        task.addDevTime((int) Math.ceil(getPerformance()));

/*
        if (random.nextInt(1) == 0) {
            task.setStatus(Status.DONE);
        } else task.setStatus(Status.OPEN);
        */

        task.setStatus(Status.DONE);
        setWorkTime((int) Math.ceil(getPerformance()));

        return task;
    }

    public void choseTask(List<Task> tasks) {
        //выбирает задачи только в разработке и меняет на продакшн
        // могут отправить задачу обратно разрабам-девелоперам
    }

}
