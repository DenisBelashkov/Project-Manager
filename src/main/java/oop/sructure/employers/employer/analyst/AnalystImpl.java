package oop.sructure.employers.employer.analyst;

import oop.sructure.sprint.Task;
import oop.sructure.employers.devTypes.DevType;
import oop.sructure.sprint.Status;
import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.employer.EmployerImpl;

import java.util.Random;
import java.util.Stack;

public class AnalystImpl extends EmployerImpl implements Analyst{


    public AnalystImpl(String name) {
        super(name);
    }


    @Override
    public EmpType getEmpType() {
        return EmpType.DEVELOPER;
    }


    @Override
    public Task generateTask(Stack<String> names) {

        Random random = new Random();

        String description = "Сделай или сдохни / do or die / место для вашей рекламы"; // продумать генерацию описания. Массив слов в случайной последовательности?

        int deadline = random.nextInt(10) + 1;


        DevType devType = DevType.ANDROID; // todo сделать свич с рандомайзом

        Task task = new Task(names.pop(), description, 0, devType, 0, Status.OPEN, deadline, this);
        task.addDevTime((int) Math.ceil(getPerformance()));
       // task.addAbsDevTime((int) Math.ceil(getPerformance()));
        setWorkTime((int) Math.ceil(getPerformance()));


        return task;

    }





}
