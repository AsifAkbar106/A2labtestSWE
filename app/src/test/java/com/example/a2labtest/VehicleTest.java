package com.example.a2labtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {
    Vehicle vehicle=new Sedan();
    @Test
    public void showVehicle() {
        assertEquals("the vehicle name is sedan",vehicle.showVehicle());
    }

    @Test
    public void getWheels() {
        assertEquals(4,vehicle.wheels);
    }

    @Test
    public void getFuel() {
        vehicle.addPetrol(50);
        assertEquals(50.0,vehicle.getFuel(),0.0);
    }

    @Test
    public void getMilage() {
        vehicle.milage=50;
        assertEquals(50.0,vehicle.getMilage(),0.0);
    }

    @Test
    public void addPetrol() {
        vehicle.addPetrol(50);
        assertEquals(50,vehicle.getFuel(),0.0);
    }
    @Test
    public void drive(){
        vehicle.addPetrol(4);
        assertEquals("ran 5 miles and burnt 2l fuel",vehicle.drive());
        assertEquals("ran 5 miles and burnt 2l fuel",vehicle.drive());
        assertEquals("not enough fuel available",vehicle.drive());

    }

}