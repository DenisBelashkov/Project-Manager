package com.company.sructure.employers;

import com.company.sructure.employers.ranks.Rank;

public interface EmployerInterface {
/*
    String name;
    Rank rank;
    int performance;
 */


    String getName();

    Rank getRank();

    EmpType getEmpType();

    void setRank(Rank junior);

    void setPerformance(int performance);

    int getPerformance();
}
