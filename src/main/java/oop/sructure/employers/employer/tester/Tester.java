package oop.sructure.employers.employer.tester;

import oop.sructure.sprint.Task;
import oop.sructure.employers.employer.Employer;

import java.util.List;

public interface Tester extends Employer {

    Task prodTask(List<Task> tasks);
}