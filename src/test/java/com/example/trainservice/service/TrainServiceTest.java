package com.example.trainservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.trainservice.entity.TrainDetails;
import com.example.trainservice.exception.TrainDetailsNotFoundException;
import com.example.trainservice.repo.TrainRepo;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrainService.class})
@ExtendWith(SpringExtension.class)
class TrainServiceTest {
    @MockBean
    private TrainRepo trainRepo;

    @Autowired
    private TrainService trainService;

    /**
     * Method under test: {@link TrainService#addTrainDetails(TrainDetails)}
     */
    @Test
    void testAddTrainDetails() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        when(trainRepo.save(Mockito.<TrainDetails>any())).thenReturn(trainDetails);

        TrainDetails details = new TrainDetails();
        details.setArrival_station("Arrival station");
        details.setArrival_time("Arrival time");
        details.setDeparture_station("Departure station");
        details.setDeparture_time("Departure time");
        details.setGeneral_fare(10.0d);
        details.setLadies_fare(10.0d);
        details.setSeats_left(Integer.valueOf(1));
        details.setStatus(true);
        details.setTId(1L);
        details.setTotal_seats(Integer.valueOf(1));
        details.setTrain_id("Train id");
        details.setTrain_name("Train name");
        assertSame(trainDetails, trainService.addTrainDetails(details));
        verify(trainRepo).save(Mockito.<TrainDetails>any());
    }

    /**
     * Method under test: {@link TrainService#addTrainDetails(TrainDetails)}
     */
    @Test
    void testAddTrainDetails2() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        when(trainRepo.save(Mockito.<TrainDetails>any())).thenReturn(trainDetails);
        TrainDetails details = mock(TrainDetails.class);
        when(details.getTrain_id()).thenReturn("");
        doNothing().when(details).setArrival_station(Mockito.<String>any());
        doNothing().when(details).setArrival_time(Mockito.<String>any());
        doNothing().when(details).setDeparture_station(Mockito.<String>any());
        doNothing().when(details).setDeparture_time(Mockito.<String>any());
        doNothing().when(details).setGeneral_fare(Mockito.<Double>any());
        doNothing().when(details).setLadies_fare(Mockito.<Double>any());
        doNothing().when(details).setSeats_left(Mockito.<Number>any());
        doNothing().when(details).setStatus(Mockito.<Boolean>any());
        doNothing().when(details).setTId(Mockito.<Long>any());
        doNothing().when(details).setTotal_seats(Mockito.<Number>any());
        doNothing().when(details).setTrain_id(Mockito.<String>any());
        doNothing().when(details).setTrain_name(Mockito.<String>any());
        details.setArrival_station("Arrival station");
        details.setArrival_time("Arrival time");
        details.setDeparture_station("Departure station");
        details.setDeparture_time("Departure time");
        details.setGeneral_fare(10.0d);
        details.setLadies_fare(10.0d);
        details.setSeats_left(Integer.valueOf(1));
        details.setStatus(true);
        details.setTId(1L);
        details.setTotal_seats(Integer.valueOf(1));
        details.setTrain_id("Train id");
        details.setTrain_name("Train name");
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.addTrainDetails(details));
        verify(details).getTrain_id();
        verify(details).setArrival_station(Mockito.<String>any());
        verify(details).setArrival_time(Mockito.<String>any());
        verify(details).setDeparture_station(Mockito.<String>any());
        verify(details).setDeparture_time(Mockito.<String>any());
        verify(details).setGeneral_fare(Mockito.<Double>any());
        verify(details).setLadies_fare(Mockito.<Double>any());
        verify(details).setSeats_left(Mockito.<Number>any());
        verify(details).setStatus(Mockito.<Boolean>any());
        verify(details).setTId(Mockito.<Long>any());
        verify(details).setTotal_seats(Mockito.<Number>any());
        verify(details).setTrain_id(Mockito.<String>any());
        verify(details).setTrain_name(Mockito.<String>any());
    }

    /**
     * Method under test: {@link TrainService#getTrainDetails()}
     */
    @Test
    void testGetTrainDetails() {
        when(trainRepo.findAll()).thenReturn(new ArrayList<>());
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.getTrainDetails());
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrainDetails()}
     */
    @Test
    void testGetTrainDetails2() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("details not avaliable");
        trainDetails.setArrival_time("details not avaliable");
        trainDetails.setDeparture_station("details not avaliable");
        trainDetails.setDeparture_time("details not avaliable");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("details not avaliable");
        trainDetails.setTrain_name("details not avaliable");

        ArrayList<TrainDetails> trainDetailsList = new ArrayList<>();
        trainDetailsList.add(trainDetails);
        when(trainRepo.findAll()).thenReturn(trainDetailsList);
        List<TrainDetails> actualTrainDetails = trainService.getTrainDetails();
        assertSame(trainDetailsList, actualTrainDetails);
        assertEquals(1, actualTrainDetails.size());
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrainDetails()}
     */
    @Test
    void testGetTrainDetails3() {
        when(trainRepo.findAll()).thenThrow(new TrainDetailsNotFoundException("An error occurred", "An error occurred"));
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.getTrainDetails());
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#delete(Long)}
     */
    @Test
    void testDelete() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        Optional<TrainDetails> ofResult = Optional.of(trainDetails);
        doNothing().when(trainRepo).deleteById(Mockito.<Long>any());
        when(trainRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        trainService.delete(1L);
        verify(trainRepo).findById(Mockito.<Long>any());
        verify(trainRepo).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainService#delete(Long)}
     */
    @Test
    void testDelete2() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        Optional<TrainDetails> ofResult = Optional.of(trainDetails);
        doThrow(new TrainDetailsNotFoundException("An error occurred", "An error occurred")).when(trainRepo)
                .deleteById(Mockito.<Long>any());
        when(trainRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.delete(1L));
        verify(trainRepo).findById(Mockito.<Long>any());
        verify(trainRepo).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainService#delete(Long)}
     */
    @Test
    void testDelete3() {
        doNothing().when(trainRepo).deleteById(Mockito.<Long>any());
        when(trainRepo.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.delete(1L));
        verify(trainRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainService#updateTrainbyId(TrainDetails)}
     */
    @Test
    void testUpdateTrainbyId() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        when(trainRepo.save(Mockito.<TrainDetails>any())).thenReturn(trainDetails);

        TrainDetails traindetails = new TrainDetails();
        traindetails.setArrival_station("Arrival station");
        traindetails.setArrival_time("Arrival time");
        traindetails.setDeparture_station("Departure station");
        traindetails.setDeparture_time("Departure time");
        traindetails.setGeneral_fare(10.0d);
        traindetails.setLadies_fare(10.0d);
        traindetails.setSeats_left(Integer.valueOf(1));
        traindetails.setStatus(true);
        traindetails.setTId(1L);
        traindetails.setTotal_seats(Integer.valueOf(1));
        traindetails.setTrain_id("Train id");
        traindetails.setTrain_name("Train name");
        assertEquals("Train Details updated Successfully ", trainService.updateTrainbyId(traindetails));
        verify(trainRepo).save(Mockito.<TrainDetails>any());
    }

    /**
     * Method under test: {@link TrainService#updateTrainbyId(TrainDetails)}
     */
    @Test
    void testUpdateTrainbyId2() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        when(trainRepo.save(Mockito.<TrainDetails>any())).thenReturn(trainDetails);

        TrainDetails traindetails = new TrainDetails();
        traindetails.setArrival_station("Arrival station");
        traindetails.setArrival_time("Arrival time");
        traindetails.setDeparture_station("Departure station");
        traindetails.setDeparture_time("Departure time");
        traindetails.setGeneral_fare(10.0d);
        traindetails.setLadies_fare(10.0d);
        traindetails.setSeats_left(Integer.valueOf(1));
        traindetails.setStatus(true);
        traindetails.setTId(null);
        traindetails.setTotal_seats(Integer.valueOf(1));
        traindetails.setTrain_id("Train id");
        traindetails.setTrain_name("Train name");
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.updateTrainbyId(traindetails));
    }

    /**
     * Method under test: {@link TrainService#getTrainbySearch(String, String)}
     */
    @Test
    void testGetTrainbySearch() {
        when(trainRepo.findAll()).thenReturn(new ArrayList<>());
        assertTrue(trainService.getTrainbySearch("Departure", "Arrival").isEmpty());
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrainbySearch(String, String)}
     */
    @Test
    void testGetTrainbySearch2() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");

        ArrayList<TrainDetails> trainDetailsList = new ArrayList<>();
        trainDetailsList.add(trainDetails);
        when(trainRepo.findAll()).thenReturn(trainDetailsList);
        assertTrue(trainService.getTrainbySearch("Departure", "Arrival").isEmpty());
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrainbySearch(String, String)}
     */
    @Test
    void testGetTrainbySearch3() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");

        TrainDetails trainDetails2 = new TrainDetails();
        trainDetails2.setArrival_station("Departure");
        trainDetails2.setArrival_time("Departure");
        trainDetails2.setDeparture_station("Departure");
        trainDetails2.setDeparture_time("Departure");
        trainDetails2.setGeneral_fare(0.5d);
        trainDetails2.setLadies_fare(0.5d);
        trainDetails2.setSeats_left(Integer.valueOf(1));
        trainDetails2.setStatus(false);
        trainDetails2.setTId(2L);
        trainDetails2.setTotal_seats(Integer.valueOf(1));
        trainDetails2.setTrain_id("Departure");
        trainDetails2.setTrain_name("Departure");

        ArrayList<TrainDetails> trainDetailsList = new ArrayList<>();
        trainDetailsList.add(trainDetails2);
        trainDetailsList.add(trainDetails);
        when(trainRepo.findAll()).thenReturn(trainDetailsList);
        assertTrue(trainService.getTrainbySearch("Departure", "Arrival").isEmpty());
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#getTrainbySearch(String, String)}
     */
    @Test
    void testGetTrainbySearch4() {
        when(trainRepo.findAll()).thenThrow(new TrainDetailsNotFoundException("An error occurred", "An error occurred"));
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.getTrainbySearch("Departure", "Arrival"));
        verify(trainRepo).findAll();
    }

    /**
     * Method under test: {@link TrainService#getById(Long)}
     */
    @Test
    void testGetById() {
        TrainDetails trainDetails = new TrainDetails();
        trainDetails.setArrival_station("Arrival station");
        trainDetails.setArrival_time("Arrival time");
        trainDetails.setDeparture_station("Departure station");
        trainDetails.setDeparture_time("Departure time");
        trainDetails.setGeneral_fare(10.0d);
        trainDetails.setLadies_fare(10.0d);
        trainDetails.setSeats_left(Integer.valueOf(1));
        trainDetails.setStatus(true);
        trainDetails.setTId(1L);
        trainDetails.setTotal_seats(Integer.valueOf(1));
        trainDetails.setTrain_id("Train id");
        trainDetails.setTrain_name("Train name");
        Optional<TrainDetails> ofResult = Optional.of(trainDetails);
        when(trainRepo.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<TrainDetails> actualById = trainService.getById(1L);
        assertSame(ofResult, actualById);
        assertTrue(actualById.isPresent());
       // verify(trainRepo).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TrainService#getById(Long)}
     */
    @Test
    void testGetById2() {
        when(trainRepo.findById(Mockito.<Long>any()))
                .thenThrow(new TrainDetailsNotFoundException("An error occurred", "An error occurred"));
        assertThrows(TrainDetailsNotFoundException.class, () -> trainService.getById(1L));
        verify(trainRepo).findById(Mockito.<Long>any());
    }
}

