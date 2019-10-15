package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car fetch(ParkingTicket ticket) {
        Car car = parkingLot.getCar(ticket);
        inValidTicketMessage(ticket);
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public ParkingTicket park(Car car) {
        ParkingLotFullMessage(car);
        return parkingLot.addCar(car);
    }

    private void inValidTicketMessage(ParkingTicket ticket){
        this.lastErrorMessage = parkingLot.isValidTicket(ticket) == true ?
                "Please provide your parking ticket." : "Unrecognized parking ticket.";
    }

    private void ParkingLotFullMessage(Car car){
        this.lastErrorMessage = parkingLot.isParkingPositionFull(car) == true? "Not enough position." : null;
    }

}
