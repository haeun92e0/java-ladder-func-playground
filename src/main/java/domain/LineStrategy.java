package domain;

import java.util.List;

public interface LineStrategy {
    List<LadderStep> generate(int count);
}
