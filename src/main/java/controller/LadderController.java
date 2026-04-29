package controller;

import domain.*;
import view.*;
import java.util.Arrays;
import java.util.List;

public class LadderController {
    public void run() {
        try {
            Names names = new Names(InputView.readNames()); //이름입력받기
            List<String> rewards = Arrays.asList(InputView.readRewards().split(","));
            //사다리결과입력받기
            int height = InputView.readHeight();//높이 입력받기(line 개수)

            Ladder ladder = new Ladder(names.size(), height, new RandomLineStrategy()); //사다리생성
            ResultView.printLadder(names, ladder, rewards); //사다리 출력

            LadderGameResult gameResult = new LadderGameResult(names, rewards, ladder);
            processResultQuery(gameResult, names);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void processResultQuery(LadderGameResult gameResult, Names names) {
        //결과를 계속 물어보는 루프
        while (true) {
            String target = InputView.readTarget(); //결과를 알고싶은 사용자 입력받기
            ResultView.printGameResult(gameResult.getResult(target, names)); //결과 보여줌
        }
    }

    public static void main(String[] args) {
        new LadderController().run();
    }
}
