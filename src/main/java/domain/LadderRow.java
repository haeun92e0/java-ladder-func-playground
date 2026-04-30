package domain;

import java.util.*;

public class LadderRow {
    private final List<LadderStep> points;

    public LadderRow(int count, LadderRowStrategy strategy) {
        this.points = strategy.generate(count);
    }// count수만큼 가로줄 생성

    public int move(int index) {
        return points.get(index).positionAfterMoving();
    }

    public List<LadderStep> getPoints() { return Collections.unmodifiableList(points); }
}
