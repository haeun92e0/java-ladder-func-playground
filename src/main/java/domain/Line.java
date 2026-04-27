package domain;

import java.util.*;

public class Line {
    private final List<Point> points;

    public Line(int count, LineStrategy strategy) {
        this.points = strategy.generate(count);
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() { return Collections.unmodifiableList(points); }
}
