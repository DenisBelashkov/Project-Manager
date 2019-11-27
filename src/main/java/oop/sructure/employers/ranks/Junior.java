package oop.sructure.employers.ranks;

import oop.sructure.employers.employer.Employer;

public class Junior extends RankDecorator {


    public Junior(Employer employer) {
        super(employer);
        employer.setRank(Rank.JUNIOR);
        employer.setPerformance(Rank.JUNIOR.getPerformance());
    }

    @Override
    public Rank getRank() {
        return Rank.JUNIOR;
    }

    @Override
    public double getPerformance() {
        return Rank.JUNIOR.getPerformance();
    }
}
