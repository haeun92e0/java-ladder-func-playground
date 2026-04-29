package domain;

import java.util.*;

public class RandomLineStrategy implements LineStrategy {//사다리 한 줄을 랜덤으로 만들되, 가로줄이 겹치지 않게 생성한다
    private final Random random = new Random();

    @Override
    public List<Point> generate(int count) {//count만큼 사다리 줄 생성
        List<Boolean> bridges = new ArrayList<>(); //사다리 한 행에 가로 연결이 있는지 없는지를 나타내는 리스트 ex. true,false,true
        boolean lastBridge = false; //이전 가로줄의 상태를 저장, true다음엔 true가 나오지 않게
        for (int i = 0; i < count - 1; i++) {
            lastBridge = random.nextBoolean() && !lastBridge; //and 연산으로 처음 0-1부분은 random으로 가로줄 생성
            bridges.add(lastBridge);
        }
        return convertToPoints(bridges); //bridges > point로 변환
    }

    private List<Point> convertToPoints(List<Boolean> bridges) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, false, bridges.get(0)));
        for (int i = 1; i < bridges.size(); i++) {
            points.add(new Point(i, bridges.get(i - 1), bridges.get(i)));
        }
        points.add(new Point(bridges.size(), bridges.get(bridges.size() - 1), false)); //마지막 점은 오른쪽 가로줄 없음
        return points;
    }
}
//높이 하나짜리 사다리 조각 만듦
