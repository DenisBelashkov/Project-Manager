package com.company.sructure.employers.ranks;

import com.company.sructure.employers.Employer;
import com.company.sructure.employers.EmployerInterface;

public class Middle extends RankDecorator{

    public Middle(EmployerInterface employer) {
        super(employer);
        employer.setRank(Rank.MIDDLE);
        employer.setPerformance(Rank.MIDDLE.getPerformance());
    }

    @Override
    public Rank getRank() {
        return Rank.MIDDLE;
    }

    @Override
    public int getPerformance() {
        return Rank.MIDDLE.getPerformance();
    }
}
