package com.example.trainservice.repo;

import com.example.trainservice.entity.TrainDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository <TrainDetails, Long> {
}
