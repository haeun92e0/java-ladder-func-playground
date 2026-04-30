package domain;

public class Point {//현재 위치에서 왼쪽으로 갈지, 오른쪽으로 갈지, 그대로 갈지를 판단하는 역할
    private final int index;
    private final boolean left;
    private final boolean right;

    public Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public int positionAfterMoving() {
        if (left) return index - 1;
        if (right) return index + 1;
        return index; //left,right가 둘다 true가 아니면 인덱스 그대로
    }

    public boolean isRight() { return right; }//isRight메서드로 라인 생성할 때 충돌을 방지한다 (가로줄 겹침 방지)
}
