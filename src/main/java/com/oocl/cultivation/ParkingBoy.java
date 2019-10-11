package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.getCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.addCar(car);
    }

    public void isValidTicket(ParkingTicket ticket){
        Car car = new Car();
        this.lastErrorMessage = parkingLot.checkParkingPosition(car) == true ?
                "Not enough position." : parkingLot.checkValidTicket(ticket) == true ?
                "Unrecognized parking ticket." :  "Please provide your parking ticket.";
    }

}
