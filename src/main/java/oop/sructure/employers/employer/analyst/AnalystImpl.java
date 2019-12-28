package oop.sructure.employers.employer.analyst;

import com.fasterxml.jackson.annotation.JsonIgnore;
import oop.sructure.sprint.Task;
import oop.sructure.employers.devTypes.DevType;
import oop.sructure.sprint.Status;
import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.employer.EmployerImpl;

import java.util.Random;
import java.util.Stack;

public class AnalystImpl extends EmployerImpl implements Analyst {
    @JsonIgnore
    private Random random = new Random();
    @JsonIgnore
    private Stack<String> namesStack;
/*
    private int timeWork = (int) (getPerformance() * 1000 * Math.random());
*/


    @JsonIgnore

    private String description = "Сделай или сдохни / do or die / место для вашей рекламы"; // продумать генерацию описания. Массив слов в случайной последовательности?
    @JsonIgnore

    private DevType devType = DevType.ANDROID; // todo сделать свич с рандомайзом
    @JsonIgnore
    private Task task;

    public AnalystImpl(String name) {
        super(name);
    }


    @Override
    public EmpType getEmpType() {
        return EmpType.ANALYST;
    }


    @Override
    public Task generateTask(Stack<String> names) {
        this.namesStack = names;


        if (!namesStack.empty()) {
            run();
            return task;
        }

        return null;

    }


    @Override
    public void run() {
        synchronized (namesStack) {
            int deadline = (int) (Math.random() * 1000 + 1000);
            int timeWork = (int) ((int) this.getRank().getPerformance() + Math.random() * 100);

            if (!namesStack.empty())
                try {
                    sleep(timeWork);
                    task = new Task(namesStack.pop(), description, timeWork, devType, 0, Status.OPEN, deadline, this);
                       task.print();

                    /*System.out.println(timeWork + super.getNameEmployer());
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
