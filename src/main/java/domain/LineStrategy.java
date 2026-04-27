package domain;

import java.util.List;

public interface LineStrategy {
    List<Point> generate(int count);
}
