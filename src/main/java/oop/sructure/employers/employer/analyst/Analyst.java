package oop.sructure.employers.employer.analyst;

import oop.sructure.sprint.Task;
import oop.sructure.employers.employer.Employer;

import java.util.Stack;

public interface Analyst extends Employer {

    Task generateTask(Stack<String> names);
}
