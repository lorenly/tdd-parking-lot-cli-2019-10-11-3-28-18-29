package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }

    public ParkingTicket addCar(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        cars.put(parkingTicket, car);
        return getAvailableParkingPosition() < 0 ? parkingTicket : null;
    }

    public Car getCar(ParkingTicket ticket){
        Car car = cars.get(ticket);
        cars.remove(ticket);
        return car;
    }

    public boolean isValidTicket(ParkingTicket ticket){
        return ticket == null ? true : false;
    }

    public boolean isParkingPositionFull(Car car){
        return addCar(car) == null ? true : false;
    }
}
