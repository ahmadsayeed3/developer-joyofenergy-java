package uk.tw.energy.service;

import uk.tw.energy.domain.ElectricityReading;

import java.util.List;
import java.util.Optional;

public interface MeterReadingService {

    Optional<List<ElectricityReading>> getReadings(String smartMeterId);

    void storeReadings(String smartMeterId, List<ElectricityReading> electricityReadings);
}
