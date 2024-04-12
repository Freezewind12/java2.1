package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Bus;
import model.Fuel;
import model.Purchase;
import model.Tractor;
import model.Vehicle;


public class mainService {
	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	public static ArrayList<Purchase> allPurchases = new ArrayList<Purchase>();
	public static void main(String[] arhs) {
	Bus bus1 = new Bus("Mercedes", 10000, 2, Fuel.diesel, 60, true);
    Bus bus2 = new Bus("Volvo", 12000, 3, Fuel.petrol, 45, false);
    Tractor tractor1 = new Tractor("RAM", 54321, 2, Fuel.petrol, "None", false);
    Tractor tractor2 = new Tractor("John Deere", 45000, 1, Fuel.diesel, "4WD", true);
	
	allVehicles.addAll(Arrays.asList(bus1, bus2, tractor1, tractor2));
	for(Vehicle tempV : allVehicles) {
		System.out.println(tempV.getClass().getName() + " -> " + tempV);
		}
	Purchase p1 = new Purchase("123456789", new ArrayList<Vehicle>(Arrays.asList(bus2)));
	Purchase p2 = new Purchase("987654321", new ArrayList<Vehicle>(Arrays.asList(tractor2)));
	allPurchases.addAll(Arrays.asList(p1, p2));
	for(Purchase tempP: allPurchases) {
		System.out.println(tempP);
	}
	System.out.println("Get bus by ID: " + getBusById(0));
	System.out.println("Get bus by VehicleCode: " + getBusByVehicleCode("1_Volvo"));
	deleteBusById(0);
	System.out.println(getAllBusses());
	
}
	
	
	//Functions
	public static Bus getBusById(int id) {
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Bus && vehicle.getID() == id) {
                return (Bus) vehicle;
            }
        }
        return null;
    }
    
    public static Bus getBusByVehicleCode(String vehicleCode) {
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Bus && vehicle.getVehicleCode().equals(vehicleCode)) {
                return (Bus) vehicle;
            }
        }
        return null;
    }
    public static List<Bus> getAllBusses() {
        List<Bus> allBusses = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Bus) {
                allBusses.add((Bus) vehicle);
            }
        }
        return allBusses;
    }
    public static void updateBusById(int id, float price, int quantity, Fuel type, int numberOfSeats) throws Exception {
    	for(Vehicle tempV: allVehicles) {
    		if(tempV.getID() == id && tempV instanceof Bus) {
    			Bus tempBus = (Bus)tempV;
    			tempBus.setPrice(price);
    			tempBus.setQuantity(quantity);
    			tempBus.setFuel(type);
    			tempBus.setNumberOfSeats(numberOfSeats);
    			return;
    		}
    	}
    	throw new Exception("There is no Bus with " + id + " id");
    }
    public static void deleteBusById(int id) {
    	allVehicles.removeIf(vehicle -> vehicle instanceof Bus && vehicle.getID() == id);
    }
    public void createNewBus(Bus newBus) {
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Bus && vehicle.getID() == newBus.getID()) {
                return;
            }
        }
        allVehicles.add(newBus);
    }
    public List<String> showVehiclesIfPriceLessThan10000() {
        List<String> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getPrice() < 10000) {
                filteredVehicles.add(vehicle.toString());
            }
        }
        return filteredVehicles;
    }
}
