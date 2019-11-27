package oop.sructure.employers.ranks;

import oop.sructure.employers.employer.Employer;

public class Middle extends RankDecorator{

    public Middle(Employer employer) {
        super(employer);
        employer.setRank(Rank.MIDDLE);
        employer.setPerformance(Rank.MIDDLE.getPerformance());
    }

    @Override
    public Rank getRank() {
        return Rank.MIDDLE;
    }

    @Override
    public double getPerformance() {
        return Rank.MIDDLE.getPerformance();
    }
}
