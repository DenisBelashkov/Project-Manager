package com.company.sructure.employers;

import com.company.sructure.Task;
import com.company.sructure.Status;

import java.util.List;
import java.util.Random;

public class Tester extends Employer {
    Random random = new Random();
    public Tester(String name) {
        super(name);
    }

    public Task prodTask(Task task) {

        task.setDevTime(task.getDevTime() + performance);

/*
        if (random.nextInt(1) == 0) {
            task.setStatus(Status.DONE);
        } else task.setStatus(Status.OPEN);
        */

        task.setStatus(Status.DONE);

        return task;
    }

    public void choseTask(List<Task> tasks) {
        //выбирает задачи только в разработке и меняет на продакшн
        // могут отправить задачу обратно разрабам-девелоперам
    }

}
