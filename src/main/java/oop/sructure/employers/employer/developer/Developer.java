package oop.sructure.employers.employer.developer;

import oop.sructure.sprint.Task;
import oop.sructure.employers.devTypes.DevType;
import oop.sructure.employers.employer.Employer;

import java.util.List;

public interface Developer extends Employer {
    void setDevType(DevType devType);
    DevType getDevType();
    public Task completeTask(List<Task> tasks);
}
