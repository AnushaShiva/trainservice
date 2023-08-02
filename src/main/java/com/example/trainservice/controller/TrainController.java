package com.example.trainservice.controller;

import com.example.trainservice.entity.TrainDetails;
import com.example.trainservice.exception.TrainDetailsNotFoundException;
import com.example.trainservice.service.TrainService;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/traindetails")
@Slf4j
public class TrainController {

    @Autowired
    TrainService trainService;

    @ApiOperation(value = "Get specific train by id in the System ", response = TrainDetails.class, tags = "getById")
    @GetMapping("/get/{tId}")
    public Optional<TrainDetails> getById(@PathVariable Long tId) throws TrainDetailsNotFoundException {
        
        return 	trainService.getById(tId);
    }

    //  add traindetails;
    @PostMapping("/")
    public String addTrainDetails(@RequestBody TrainDetails details) {
        log.info("adding details");
        trainService.addTrainDetails(details);
        return "train details added successfully saved";
    }
    @ApiOperation(value = "Get List of trains  in the System ", response = Iterable.class, tags = "getTrains")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @GetMapping("/getAll")
    public List<TrainDetails> get() {
        return trainService.getTrainDetails();
    }

    @DeleteMapping("/delete/{tId}")
    public String deleteById(@PathVariable Long tId) throws TrainDetailsNotFoundException  {
        trainService.delete(tId);
        return "trainDetails deleted successfully ";
    }

    @PutMapping("/update/{tId}")
    public String Update(@PathVariable Long tId, @RequestBody TrainDetails traindetails) throws TrainDetailsNotFoundException  {
        return trainService.updateTrainbyId(traindetails);

    }


    // Search Train Details by Departure and Arrival Station

    @GetMapping("/search")
    public List<TrainDetails> searchTrain(@PathParam(value="departure")  String departure, @PathParam(value="arrival") String arrival)
    {
        return trainService.getTrainbySearch(departure, arrival);
    }


}
