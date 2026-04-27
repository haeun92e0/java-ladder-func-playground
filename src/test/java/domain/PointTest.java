package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    @DisplayName("오른쪽으로 연결된 경우 인덱스가 1 증가한다")
    void move_right() {
        Point point = new Point(1, false, true);
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("왼쪽으로 연결된 경우 인덱스가 1 감소한다")
    void move_left() {
        Point point = new Point(1, true, false);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("연결되지 않은 경우 현재 인덱스를 유지한다")
    void move_stay() {
        Point point = new Point(1, false, false);
        assertThat(point.move()).isEqualTo(1);
    }
}
