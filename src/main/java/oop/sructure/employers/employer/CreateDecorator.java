package oop.sructure.employers.employer;

interface CreateDecorator {
    // EmployerImpl create();

    EmployerImpl createDecorator(Employer employer) throws EmpException;

    // EmployerImpl createRank(Employer employer, Rank rank) throws EmpException;*/
}
