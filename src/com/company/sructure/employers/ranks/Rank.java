package com.company.sructure.employers.ranks;

public enum Rank {
    JUNIOR (1) ,
    MIDDLE (2),
    SENIOR(3);

    private int performance;


    Rank(int performance) {
        this.performance = performance;
    }


    public int getPerformance() {
        return performance;
    }
}
