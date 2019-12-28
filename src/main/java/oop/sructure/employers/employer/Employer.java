package oop.sructure.employers.employer;

import oop.sructure.employers.ranks.Rank;
import oop.sructure.sprint.Sprint;
import oop.sructure.sprint.Task;

import java.util.List;
import java.util.Stack;

public interface Employer {
/*
    String name;
    Rank rank;
    int performance;
 */

    void setSprint(Sprint sprint);

    String getNameEmployer();

    void setNameEmployer(String name);

    Rank getRank();

    EmpType getEmpType();

    void setRank(Rank junior);

    void setPerformance(double performance);

    double getPerformance();

    void setWorkTime(int workTime);

    int getWorkTime();


    Task generateTask(Stack<String> names);

    Task completeTask(List<Task> openTaskList);

    Task prodTask(List<Task> devTaskList);
}
