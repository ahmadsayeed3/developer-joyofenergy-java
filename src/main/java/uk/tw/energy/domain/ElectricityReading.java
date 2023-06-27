package uk.tw.energy.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

public class ElectricityReading {

    @NotNull(message = "time can't be null")
    private Instant time;

    @NotNull(message = "reading can't be null")
    private BigDecimal reading; // kW

    public ElectricityReading() { }

    public ElectricityReading(Instant time, BigDecimal reading) {
        this.time = time;
        this.reading = reading;
    }

    public BigDecimal getReading() {
        return reading;
    }

    public Instant getTime() {
        return time;
    }
}
