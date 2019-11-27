package oop.sructure.employers.ranks;

public enum Rank {
    JUNIOR (4) ,
    MIDDLE (3),
    SENIOR(2);

    private double performance;


    Rank(double performance) {
        this.performance = performance;
    }


    public double getPerformance() {
        return performance;
    }
}
