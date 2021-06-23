package me.yunbchae.coordinate.car;

public class Avante extends CarImpl {

    private static final double FUEL_EFFICIENCY = 15;

    public Avante(double tripDistance) {
        super(FUEL_EFFICIENCY, tripDistance);
    }

    @Override
    protected String getName() {
        return "Avante";
    }
}
