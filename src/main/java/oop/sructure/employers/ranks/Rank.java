package oop.sructure.employers.ranks;

public enum Rank {
    JUNIOR (400) ,
    MIDDLE (300),
    SENIOR(200);

    private double performance;


    Rank(double performance) {
        this.performance = performance;
    }


    public double getPerformance() {
        return performance;
    }
}
