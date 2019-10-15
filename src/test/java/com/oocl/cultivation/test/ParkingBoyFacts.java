package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class Story1 {
    @Test
    void should_park_car_to_parking_lot_by_parking_boy() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when

        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_fetch_car_to_parking_lot_by_parking_boy(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetch(parkingTicket);

        assertEquals(car, fetchCar);
    }

    @Test
    void should_add_multiple_car_and_fetch_car_to_parking_lot_by_parking_boy(){
        Car car = new Car();
        Car newCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);
        ParkingTicket parkingTicket2 = parkingBoy.park(newCar);
        Car fetchCar = parkingBoy.fetch(parkingTicket);
        Car fetchNewCar = parkingBoy.fetch(parkingTicket2);

        assertEquals(car, fetchCar);
        assertEquals(newCar, fetchNewCar);

    }

    @Test
    void should_return_null_when_no_ticket_is_provided(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket1 = parkingBoy.park(null);
        Car fetchCar = parkingBoy.fetch(parkingTicket1);

        assertNull(fetchCar);
    }

    @Test
    void should_return_null_when_wrong_ticket_is_provided(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = new ParkingTicket(parkingLot);
        Car fetchCar = parkingBoy.fetch(parkingTicket);

        assertNull(fetchCar);
    }


    @Test
    void should_return_null_when_ticket_has_been_used(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);

        Car fetchCar = parkingBoy.fetch(parkingTicket);
        assertNotNull(fetchCar);

        fetchCar = parkingBoy.fetch(parkingTicket);
        assertNull(fetchCar);
    }

    @Test
    void should_return_null_when_parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        IntStream.rangeClosed(0,9).forEach(num ->{
            Car car = new Car();
            parkingBoy.park(car);
        });
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        assertNull(parkingTicket);
    }

}

class story2{
    @Test
    void should_return_unrecognized_ticket_for_wrong_ticket(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);
        ParkingTicket fakeParkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(fakeParkingTicket);

        String fetch = parkingBoy.getLastErrorMessage();
        assertEquals(fetch, "Unrecognized parking ticket.");
    }

    @Test
    void should_return_provide_parking_ticket_when_no_ticket_is_provided(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(null);

        String fetch = parkingBoy.getLastErrorMessage();
        assertEquals(fetch, "Please provide your parking ticket.");
    }

    @Test
    void should_return_not_enough_position_when_parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        IntStream.rangeClosed(0,9).forEach(num ->{
            Car car = new Car();
            parkingBoy.park(car);
        });

        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        String fetch = parkingBoy.getLastErrorMessage();

        assertEquals(fetch, "Not enough position.");
    }
}

class sotry3{
    @Test
    void should_park_to_second_parking_lot_when_first_parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

    }
}
