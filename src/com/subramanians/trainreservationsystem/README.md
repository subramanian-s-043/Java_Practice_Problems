# Train Reservation System

## Features:

- Book multiple trains across multiple destinations.
- View booked tickets using a generated ID at the time of booking.
- Passengers can cancel tickets before the departure of the train.

## Train Java:

### Attributes:

- `trainNo`: Int
- `trainName`: String
- `trainSource`: String
- `trainDestination`: String
- `trainTravelDuration`: Time
- `trainDepature`: Time
- `trainArrival`: Time

## Passenger Java:

### Attributes:

- `passengerID`: Auto-incremented
- `passengerName`: String
- `passengerAge`: byte
- `ticketStatus`: byte
- `trainNo`: Int
- `berthPreference`: String
- `allottedSeat`: String

## Key Features:

1. **View Available Trains:**
   - View a list of available trains between the source and destination.

2. **RAC and Waiting List:**
   - Implement RAC (Reservation Against Cancellation) and Waiting List features.

3. **Cancellation Handling:**
   - Cancellation of tickets will enable passengers in RAC to utilize the freed-up seats.

4. **JSON File Storage:**
   - Utilize JSON files for saving and retrieving train availability data.
