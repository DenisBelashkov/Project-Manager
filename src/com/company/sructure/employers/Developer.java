package com.company.sructure.employers;


import com.company.sructure.Task;
import com.company.sructure.employers.devTypes.DevType;
import com.company.sructure.Status;

public class Developer extends Employer implements DeveloperInterface {
/*
    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public Rank getRank() {
        return super.rank;
    }

    @Override
    public EmpType getEmpType() {
        return super.empType;
    }
    /*
 */

    private DevType devType;

    public Developer(String name) {
        super(name);
    }

    @Override
    public DevType getDevType() {
        return devType;
    }

    @Override
    public void setDevType(DevType devType) {
        this.devType = devType;
    }

    public Task completeTask(Task task) {
        task.setDevTime(task.getDevTime() + performance);
        task.setStatus(Status.IN_DEV);
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
