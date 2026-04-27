package domain;

import java.util.*;
import java.util.stream.*;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int width, int height, LineStrategy strategy) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(width, strategy))
                .collect(Collectors.toList());
    }

    public int climb(int start) {
        int current = start;
        for (Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public List<Line> getLines() { return lines; }
}
