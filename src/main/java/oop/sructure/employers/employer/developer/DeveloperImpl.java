package oop.sructure.employers.employer.developer;


import oop.sructure.sprint.Task;
import oop.sructure.employers.devTypes.DevType;
import oop.sructure.sprint.Status;
import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.employer.EmployerImpl;

import java.util.List;
import java.util.Random;

public class DeveloperImpl extends EmployerImpl implements Developer {

    private  List<Task> tasks;
    private Task task;
    private DevType devType;

    public DeveloperImpl(String name) {
        super(name);
    }

    @Override
    public EmpType getEmpType() {
        return EmpType.DEVELOPER;
    }

    @Override
    public DevType getDevType() {
        return devType;
    }

    @Override
    public void setDevType(DevType devType) {
        this.devType = devType;
    }

    @Override
    public Task completeTask(List<Task> tasks) {
        this.tasks = tasks;
        run();
        return this.task;
    }

    @Override
    public void run() {
        synchronized (tasks) {
            int timeWork = (int) ((int) this.getRank().getPerformance() + Math.random() * 100);
            if (tasks != null & !tasks.isEmpty())
                try {


                    sleep(timeWork);
                    task = tasks.get(0);
                    tasks.remove(0);

                    if (task != null) {
                        task.addProgress(timeWork);
                        task.setStatus(Status.IN_DEV);
                        task.setEmployer(this);
                           task.print();
                        // getSprint().printSprint(getSprint().getDevTaskList());


                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
