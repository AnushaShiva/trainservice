package com.example.trainservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.trainservice.entity.TrainDetails;
import com.example.trainservice.service.TrainService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TrainController.class})
@ExtendWith(SpringExtension.class)
class TrainControllerTest {
    @Autowired
    private TrainController trainController;

    @MockBean
    private TrainService trainService;

    /**
     * Method under test: {@link TrainController#getById(Long)}
     */
    @Test
    void testGetById() throws Exception {
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
        when(trainService.getById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/traindetails/get/{tId}", 1L);
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"train_id\":\"Train id\",\"train_name\":\"Train name\",\"departure_station\":\"Departure station\",\"arrival"
                                        + "_station\":\"Arrival station\",\"departure_time\":\"Departure time\",\"arrival_time\":\"Arrival time\",\"general"
                                        + "_fare\":10.0,\"ladies_fare\":10.0,\"total_seats\":1,\"seats_left\":1,\"status\":true,\"tid\":1}"));
    }

    /**
     * Method under test: {@link TrainController#addTrainDetails(TrainDetails)}
     */
    @Test
    void testAddTrainDetails() throws Exception {
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
        when(trainService.addTrainDetails(Mockito.any())).thenReturn(trainDetails);

        TrainDetails trainDetails2 = new TrainDetails();
        trainDetails2.setArrival_station("Arrival station");
        trainDetails2.setArrival_time("Arrival time");
        trainDetails2.setDeparture_station("Departure station");
        trainDetails2.setDeparture_time("Departure time");
        trainDetails2.setGeneral_fare(10.0d);
        trainDetails2.setLadies_fare(10.0d);
        trainDetails2.setSeats_left(Integer.valueOf(1));
        trainDetails2.setStatus(true);
        trainDetails2.setTId(1L);
        trainDetails2.setTotal_seats(Integer.valueOf(1));
        trainDetails2.setTrain_id("Train id");
        trainDetails2.setTrain_name("Train name");
        String content = (new ObjectMapper()).writeValueAsString(trainDetails2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/traindetails/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("train details added successfully saved"));
    }

    /**
     * Method under test: {@link TrainController#get()}
     */
    @Test
    void testGet() throws Exception {
        when(trainService.getTrainDetails()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/traindetails/getAll");
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainController#get()}
     */
    @Test
    void testGet2() throws Exception {
        when(trainService.getTrainDetails()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/traindetails/getAll");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainController#deleteById(Long)}
     */
    @Test
    void testDeleteById() throws Exception {
        doNothing().when(trainService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/traindetails/delete/{tId}", 1L);
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("trainDetails deleted successfully "));
    }

    /**
     * Method under test: {@link TrainController#deleteById(Long)}
     */
    @Test
    void testDeleteById2() throws Exception {
        doNothing().when(trainService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/traindetails/delete/{tId}", 1L);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("trainDetails deleted successfully "));
    }

    /**
     * Method under test: {@link TrainController#searchTrain(String, String)}
     */
    @Test
    void testSearchTrain() throws Exception {
        when(trainService.getTrainbySearch(Mockito.any(), Mockito.any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/traindetails/search")
                .param("arrival", "foo")
                .param("departure", "foo");
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TrainController#Update(Long, TrainDetails)}
     */
    @Test
    void testUpdate() throws Exception {
        when(trainService.updateTrainbyId(Mockito.any())).thenReturn("2020-03-01");

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
        String content = (new ObjectMapper()).writeValueAsString(trainDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/traindetails/update/{tId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(trainController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }
}

