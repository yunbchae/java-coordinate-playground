package me.yunbchea.coordinate.car;

public class K5 extends CarImpl {

    private static final double FUEL_EFFICIENCY = 13;

    public K5(double tripDistance) {
        super(FUEL_EFFICIENCY, tripDistance);
    }

    @Override
    protected String getName() {
        return "K5";
    }
}
