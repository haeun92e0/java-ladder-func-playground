package controller;

import domain.*;
import view.*;
import java.util.Arrays;
import java.util.List;

public class LadderController {
    public void run() {
        try {
            Names names = new Names(InputView.readNames());
            List<String> rewards = Arrays.asList(InputView.readRewards().split(","));
            int height = InputView.readHeight();

            Ladder ladder = new Ladder(names.size(), height, new RandomLineStrategy());
            ResultView.printLadder(names, ladder, rewards);

            LadderGameResult gameResult = new LadderGameResult(names, rewards, ladder);
            processResultQuery(gameResult, names);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void processResultQuery(LadderGameResult gameResult, Names names) {
        while (true) {
            String target = InputView.readTarget();
            ResultView.printGameResult(gameResult.getResult(target, names));
        }
    }

    public static void main(String[] args) {
        new LadderController().run();
    }
}
