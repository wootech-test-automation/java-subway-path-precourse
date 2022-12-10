package subway.domain.weight;

public class Weight {
    private final int number;

    public Weight(final String input) {
        this.number = Integer.parseInt(input);
    }

    public int value() {
        return number;
    }
}
