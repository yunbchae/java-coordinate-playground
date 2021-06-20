package me.yunbchea.coordinate.car;

public class Sonata extends CarImpl {

    private static final double FUEL_EFFICIENCY = 10;

    public Sonata(double tripDistance) {
        super(FUEL_EFFICIENCY, tripDistance);
    }

    @Override
    protected String getName() {
        return "Sonata";
    }
}
