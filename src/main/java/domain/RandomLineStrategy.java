package domain;

import java.util.*;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();

    @Override
    public List<Point> generate(int count) {
        List<Boolean> bridges = new ArrayList<>();
        boolean lastBridge = false;
        for (int i = 0; i < count - 1; i++) {
            lastBridge = random.nextBoolean() && !lastBridge;
            bridges.add(lastBridge);
        }
        return convertToPoints(bridges);
    }

    private List<Point> convertToPoints(List<Boolean> bridges) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, false, bridges.get(0)));
        for (int i = 1; i < bridges.size(); i++) {
            points.add(new Point(i, bridges.get(i - 1), bridges.get(i)));
        }
        points.add(new Point(bridges.size(), bridges.get(bridges.size() - 1), false));
        return points;
    }
}
