package com.example.trainservice.service;

import com.example.trainservice.entity.TrainDetails;
import com.example.trainservice.exception.TrainDetailsNotFoundException;
import com.example.trainservice.repo.TrainRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
	@Autowired
	TrainRepo trainRepo;

	public TrainDetails addTrainDetails(TrainDetails details) {
		if (details.getTrain_id().isEmpty()) {
			throw new TrainDetailsNotFoundException("id + id", "No Trains Available !");
		}
		return trainRepo.save(details);
	}

	public List<TrainDetails> getTrainDetails() {
		List<TrainDetails> train = trainRepo.findAll();
		if (train.isEmpty()) {
			throw new TrainDetailsNotFoundException("details not avaliable", "trainDetails not found for this id");
		}
		return train;
	}

	public void delete(Long tId) throws TrainDetailsNotFoundException {
		if (trainRepo.findById(tId).isPresent()) {
			trainRepo.deleteById(tId);
		} else {
			throw new TrainDetailsNotFoundException("we can not found details for ", "this given tId" + tId);
		}

	}

	public String updateTrainbyId(TrainDetails traindetails) throws TrainDetailsNotFoundException {
		if (traindetails.getTId() == null) {
			throw new TrainDetailsNotFoundException("id not found", "trainDetails not found !");
		} else {
			trainRepo.save(traindetails);
		}
		return "Train Details updated Successfully ";
	}

	public List<TrainDetails> getTrainbySearch(String departure, String arrival) {
		List<TrainDetails> trains = new ArrayList<>();
		List<TrainDetails> SearchList = new ArrayList<>();

		trainRepo.findAll().forEach(trains::add);

		for (TrainDetails t : trains) {
			if (t.getDeparture_station().equals(departure) && t.getArrival_station().equals(arrival)) {
				SearchList.add(t);

			}
		}
		return SearchList;
	}

	public Optional<TrainDetails> getById(Long tId) throws TrainDetailsNotFoundException {
		if (trainRepo.findById(tId).isEmpty()) {
			throw new TrainDetailsNotFoundException("trainDetails not found !", "id +id");
		} else {
			return trainRepo.findById(tId);
		}
	}
}
