package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="train_ticket")
public class TrainTicketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String passengerName;
	private String trainName;
	private String sourceStation;
	private String destinationStation;
	private String dateOfTravel;
	private int numberOfSeats;
}
