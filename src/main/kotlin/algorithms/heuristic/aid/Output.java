package algorithms.heuristic.aid;

import java.time.Duration;

public class Output {

    private final Duration duration;

    public Output(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return this.duration;
    }
}
