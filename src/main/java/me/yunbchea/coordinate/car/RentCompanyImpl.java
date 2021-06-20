package me.yunbchea.coordinate.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RentCompanyImpl implements RentCompany {

    private final List<Car> cars = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompanyImpl();
    }

    public void addCar(Car car) {
        cars.add(Objects.requireNonNull(car));
    }

    public String generateReport() {
        return cars.stream()
                .map(Car::generateReport)
                .collect(Collectors.joining());
    }
}
