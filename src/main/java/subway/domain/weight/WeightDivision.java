package subway.domain.weight;

public class WeightDivision {
    private final Weight time;
    private final Weight distance;

    public WeightDivision(final String input) {
        var splitStr = input.split("/");
        this.time = new Weight(splitStr[1]);
        this.distance = new Weight(splitStr[0]);
    }

    public int getValue(WeightCode weightCode) {
        if (WeightCode.TIME == weightCode) {
            return time.value();
        }
        return distance.value();
    }

}
