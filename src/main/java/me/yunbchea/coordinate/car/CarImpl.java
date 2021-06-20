package me.yunbchea.coordinate.car;

public abstract class CarImpl implements Car {

    private static final String REPORT_FORMAT = "%s : %.0f리터" + System.getProperty("line.separator");

    private final double distancePerLiter;
    private final double tripDistance;

    protected CarImpl(double distancePerLiter, double tripDistance) {
        this.distancePerLiter = distancePerLiter;
        this.tripDistance = tripDistance;
    }

    protected abstract String getName();

    private double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }

    @Override
    public String generateReport() {
        return String.format(REPORT_FORMAT, getName(), getChargeQuantity());
    }
}
