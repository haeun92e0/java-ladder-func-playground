package controller;

import domain.*;
import view.*;
import java.util.Arrays;
import java.util.List;

public class LadderController {
    public void run() {
        runWithExceptionHandling(this::executeGame);
    }

    private void executeGame(){
        Names names = new Names(InputView.readNames());
        List<String> rewards = Arrays.asList(InputView.readRewards().split(","));
        int height = InputView.readHeight();

        Ladder ladder = new Ladder(names.size(), height, new RandomLineStrategy());
        ResultView.printLadder(names, ladder, rewards);

        LadderGameResult gameResult = new LadderGameResult(names, rewards, ladder);
        processResultQuery(gameResult, names);
    }

    private void processResultQuery(LadderGameResult gameResult, Names names) {
        //결과를 계속 물어보는 루프
        while (true) {
            String target = InputView.readTarget(); //결과를 알고싶은 사용자 입력받기
            ResultView.printGameResult(gameResult.getResult(target, names)); //결과 보여줌
        }
    }

    private void runWithExceptionHandling(Runnable runnable){
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            run();
        } catch (Exception e) {
            System.out.println("[ERROR] 예상치 못한 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new LadderController().run();
    }
}
