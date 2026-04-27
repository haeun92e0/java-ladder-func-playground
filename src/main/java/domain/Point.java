package domain;

public class Point {
    private final int index;
    private final boolean left;
    private final boolean right;

    public Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public int move() {
        if (left) return index - 1;
        if (right) return index + 1;
        return index;
    }

    public boolean isRight() { return right; }
}
