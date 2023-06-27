package uk.tw.energy.domain;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MeterReadings {

    @Valid
    @NotNull(message = "electricityReadings can't be null")
    @NotEmpty(message = "electricityReadings can't be empty")
    private List<ElectricityReading> electricityReadings;

    @NotNull(message = "smartMeterId can't be null")
    @NotEmpty(message = "smartMeterId can't be empty")
    private String smartMeterId;

    public MeterReadings() { }

    public MeterReadings(String smartMeterId, List<ElectricityReading> electricityReadings) {
        this.smartMeterId = smartMeterId;
        this.electricityReadings = electricityReadings;
    }

    public List<ElectricityReading> getElectricityReadings() {
        return electricityReadings;
    }

    public String getSmartMeterId() {
        return smartMeterId;
    }
}
