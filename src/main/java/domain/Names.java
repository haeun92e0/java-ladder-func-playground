package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> values;

    public Names(String input) {
        this.values = Arrays.stream(input.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public int size() { return values.size(); }
    public List<Name> getValues() { return Collections.unmodifiableList(values); }
    public Name get(int index) { return values.get(index); }
}
