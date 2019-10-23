package com.company.sructure.employers.ranks;

import com.company.sructure.employers.Employer;
import com.company.sructure.employers.EmployerInterface;

public class Senior extends RankDecorator {

    public Senior(EmployerInterface employer) {
        super(employer);
        employer.setRank(Rank.SENIOR);
        employer.setPerformance(Rank.SENIOR.getPerformance());
    }

    @Override
    public Rank getRank() {
        return Rank.SENIOR;
    }

    @Override
    public int getPerformance() {
        return Rank.SENIOR.getPerformance();
    }
}

