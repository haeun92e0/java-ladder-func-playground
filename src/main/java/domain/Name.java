package domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
        this.name = name.trim();
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        return Objects.equals(name, ((Name) o).name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }
}
