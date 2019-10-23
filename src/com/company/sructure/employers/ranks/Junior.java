package com.company.sructure.employers.ranks;

import com.company.sructure.employers.EmpType;
import com.company.sructure.employers.Employer;
import com.company.sructure.employers.EmployerInterface;

public class Junior extends RankDecorator {


    public Junior(EmployerInterface employer) {
        super(employer);
        employer.setRank(Rank.JUNIOR);
        employer.setPerformance(Rank.JUNIOR.getPerformance());
    }

    @Override
    public Rank getRank() {
        return Rank.JUNIOR;
    }

    @Override
    public int getPerformance() {
        return Rank.JUNIOR.getPerformance();
    }
}
