package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Bus;
import model.Fuel;
import model.Tractor;
import model.Vehicle;


public class mainService {
	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	public static void main(String[] arhs) {
	Bus bus1 = new Bus("Mercedes", 10000, 2, Fuel.diesel, 60, true);
	Tractor tractor1 = new Tractor("RAM", 54321, 2, Fuel.petrol, "None", false);
	allVehicles.addAll(Arrays.asList(bus1, tractor1));
	for(Vehicle tempV : allVehicles) {
		System.out.println(tempV.getClass().getName() + " -> " + tempV);
		}
	}	
}
