package uk.tw.energy.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uk.tw.energy.builders.MeterReadingsBuilder;
import uk.tw.energy.domain.ElectricityReading;
import uk.tw.energy.domain.MeterReadings;
import uk.tw.energy.service.MeterReadingService;
import uk.tw.energy.service.impl.MeterReadingServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class MeterReadingControllerMockitoTest {

    private static final String SMART_METER_ID = "10101010";

    @InjectMocks
    private MeterReadingController meterReadingController;

    @Mock
    private MeterReadingService meterReadingService;

    @Test
    public void givenNoMeterIdIsSuppliedWhenStoringShouldReturnErrorResponse() {
        MeterReadings meterReadings = new MeterReadings(null, Collections.emptyList());
        assertThat(meterReadingController.storeReadings(meterReadings).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void givenEmptyMeterReadingShouldReturnErrorResponse() {
        MeterReadings meterReadings = new MeterReadings(SMART_METER_ID, Collections.emptyList());
        assertThat(meterReadingController.storeReadings(meterReadings).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void givenNullReadingsAreSuppliedWhenStoringShouldReturnErrorResponse() {
        MeterReadings meterReadings = new MeterReadings(SMART_METER_ID, null);
        assertThat(meterReadingController.storeReadings(meterReadings).getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    // Hard to test using Mockito
//    @Test
//    public void givenMultipleBatchesOfMeterReadingsShouldStore() {
//        MeterReadings meterReadings = new MeterReadingsBuilder().setSmartMeterId(SMART_METER_ID)
//                .generateElectricityReadings()
//                .build();
//
//        MeterReadings otherMeterReadings = new MeterReadingsBuilder().setSmartMeterId(SMART_METER_ID)
//                .generateElectricityReadings()
//                .build();
//
//        meterReadingController.storeReadings(meterReadings);
//        meterReadingController.storeReadings(otherMeterReadings);
//
//        List<ElectricityReading> expectedElectricityReadings = new ArrayList<>();
//        expectedElectricityReadings.addAll(meterReadings.getElectricityReadings());
//        expectedElectricityReadings.addAll(otherMeterReadings.getElectricityReadings());
//
//        assertThat(meterReadingService.getReadings(SMART_METER_ID).get()).isEqualTo(expectedElectricityReadings);
//    }

//    @Test
//    public void givenMeterReadingsAssociatedWithTheUserShouldStoreAssociatedWithUser() {
//        MeterReadings meterReadings = new MeterReadingsBuilder().setSmartMeterId(SMART_METER_ID)
//                .generateElectricityReadings()
//                .build();
//
//        MeterReadings otherMeterReadings = new MeterReadingsBuilder().setSmartMeterId("00001")
//                .generateElectricityReadings()
//                .build();
//
//        meterReadingController.storeReadings(meterReadings);
//        meterReadingController.storeReadings(otherMeterReadings);
//
//        assertThat(meterReadingService.getReadings(SMART_METER_ID).get()).isEqualTo(meterReadings.getElectricityReadings());
//    }

//    @Test
//    public void givenMeterIdThatIsNotRecognisedShouldReturnNotFound() throws Exception {
//        mvc.perform(MockMvcRequestBuilders
//                        .get("/readings/read/smart-meter-0")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[*].time").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[*].reading").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[*].time").isNotEmpty())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[*].reading").isNotEmpty());
//
////        assertThat(meterReadingController.readReadings(SMART_METER_ID).getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//    }
}
