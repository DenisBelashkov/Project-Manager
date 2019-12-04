package oop.sructure.employers.employer;

import oop.sructure.employers.ranks.Rank;

public interface Employer {
/*
    String name;
    Rank rank;
    int performance;
 */


    String getName();

    Rank getRank();

    EmpType getEmpType();

    void setRank(Rank junior);

    void setPerformance(double performance);

    double getPerformance();

    void setWorkTime(int workTime);

    int getWorkTime();



}
