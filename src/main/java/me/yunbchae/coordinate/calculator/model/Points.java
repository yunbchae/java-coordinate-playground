package me.yunbchae.coordinate.calculator.model;

import me.yunbchae.coordinate.calculator.view.Renderable;

import java.util.Collections;
import java.util.List;

public abstract class Points implements Renderable {

    protected final List<Point> points;

    protected Points(List<Point> points) {
        validate(points);
        this.points = Collections.unmodifiableList(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    protected abstract void validate(List<Point> points);

}
