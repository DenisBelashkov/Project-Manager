package oop.sructure.employers.employer.developer;


import oop.sructure.sprint.Task;
import oop.sructure.employers.devTypes.DevType;
import oop.sructure.sprint.Status;
import oop.sructure.employers.employer.EmpType;
import oop.sructure.employers.employer.EmployerImpl;

public class DeveloperImpl extends EmployerImpl implements Developer {


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
    public Task completeTask(Task task) {
        task.addDevTime((int) Math.ceil(getPerformance()));
        task.addAbsDevTime((int) Math.ceil(getPerformance()));
        task.setStatus(Status.IN_DEV);
        setWorkTime((int) Math.ceil(getPerformance()));
        return task;
    }

/*
    public void chooseTask(List<Task> tasks) {


        //самый опытный выбирает самую приоритетную и OPEN  todo как сделать? Очередь и проверка на open?


        // разделение задач на блоки (до 8 дней, от 8 до 16, выше 16)
        Task task = tasks.get(1);
        // addTask(task);
        task.setStatus(Status.IN_DEV);

        // todo как реализовать моменты с временем разработки? Дать каждому задаче время на выполнение ( в днях) -- дев просрочил и все грусть печаль?
        //меняет статус таски на разработку
        Random random = new Random();
        int devTime = random.nextInt(10) + 1; // todo sdelat tak, chtoby zaviselo ot yrovnya deva
        if (devTime < task.getDeadline()) {
            // спросить, как работать с наследованием
// salary <<
        }

        task.setDevTime(devTime);
        tasks.add(task);

        //возможно просрочивает выполнение задачи и страдает
    }

    */


    // какие еще методы?


}
