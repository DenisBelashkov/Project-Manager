package oop.sructure.employers.ranks;

import oop.sructure.employers.employer.Employer;

public class Senior extends RankDecorator {

    public Senior(Employer employer) {
        super(employer);
        employer.setRank(Rank.SENIOR);
        employer.setPerformance(Rank.SENIOR.getPerformance());
    }

    @Override
    public Rank getRank() {
        return Rank.SENIOR;
    }

    @Override

    public double getPerformance() {
        return Rank.SENIOR.getPerformance();
    }
}

