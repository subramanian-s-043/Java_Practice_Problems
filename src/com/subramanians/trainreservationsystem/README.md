Train Reservation System

Features:
•	Can able to book multiple trains across multiple destination.
•	Any person can view their booked ticket using an ID generated at the time of booking.
•	The passenger only able to cancel the ticket before the departure of the train.
Train Java:
•	trainNo: Int
•	trainName: String
•	trainSource: String
•	trainDestination: String
•	trainTravelDuration: Time
•	trainDepature: Time
•	trainArrival: Time

Passenger Java:
•	passengerID: Auto-incremented
•	passengerName: String
•	passengerAge: byte
•	ticketStatus: byte
•	trainNo: Int
•	berthPreference: String
•	allottedSeat: String

Phase-I:
•	Able to view list of available trains between source and destination
•	implement RAC , Waiting List features.
•	The cancellation of ticket, will enable the passengers in RAC to make use of it.
•	Use json files to save and retrieve the train availability.
Phase-II:
•	Will able to book ticket across different trains and different dates.
•	Running status of train updated based on dates.
•	Migration from json to MySql database. 

//ideas
	create admin and user view
	make admin to add trains and routes, save it as json file format
	retrive and show the details from the same file.
