package subway.domain.weight;

public enum WeightCode {
    TIME("분"),
    DISTANCE("km");

    private final String message;
    
    WeightCode(String message) {
        this.message = message;
    }
}
