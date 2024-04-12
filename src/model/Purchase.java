package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import service.mainService;

public class Purchase {
	private String userCardNr;
	private ArrayList<Vehicle> shoppingList = new ArrayList<Vehicle>();
	private LocalDateTime dateTime= LocalDateTime.now();
	
	public String getUserCardNr() {
		return userCardNr;
	}
	public void setUserCardNr(String userCardNr) {
		if(userCardNr != null  && userCardNr.matches("[0-9]{1,20}"))
			this.userCardNr = userCardNr;
		else
			this.userCardNr = "Undefinied";;
	}
	public ArrayList<Vehicle> getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ArrayList<Vehicle> shoppingList) {
		if(shoppingList != null)
			this.shoppingList = shoppingList;
		else
			this.shoppingList = new ArrayList<Vehicle>();
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	// Constructors
	public Purchase() {
		setUserCardNr("011010101");
	}
	public Purchase(String userCardNr) {
		setUserCardNr(userCardNr);
	}
	public Purchase(String userCardNr, ArrayList<Vehicle> shoppingList) {
		setUserCardNr(userCardNr);
		setShoppingList(shoppingList);
	}
	// toString
	@Override
	public String toString() {
		return "Purchase [userCardNr=" + userCardNr + ", shoppingList=" + shoppingList + ", dateTime=" + dateTime + "]";
	}
	// Functions
	public void addVehicleToShoppingListByVehicleCode(String code, int howMany) throws Exception{
		if(code == null) throw new Exception("Code is null");
		
		for(Vehicle tempV: mainService.allVehicles) {//all vehicles in my shop
			if(tempV.getVehicleCode().equals(code))//this bus or tractor is found
			{
				if(tempV.getQuantity()- howMany < 0) {
					throw new Exception("The quantity is less than You want to buy");
				}
				else
				{
					if(tempV instanceof Bus)
					{
						Bus busFromService = (Bus)tempV;
						Bus boughtBus = new Bus(busFromService.getTitle(), busFromService.getPrice(),
								howMany,busFromService.getFuel(), busFromService.getNumberOfSeats(),
								busFromService.isHasBaggageDivision());
						shoppingList.add(boughtBus);
					}
					else if(tempV instanceof Tractor) {
						Tractor tractorFromService = (Tractor) tempV;
						Tractor boughtTractor = new Tractor(tractorFromService.getTitle(),
								tractorFromService.getPrice(),
								howMany,tractorFromService.getFuel(),
								tractorFromService.getAdditionalTechniques() , 
								tractorFromService.isOnlyLargeTires());
						shoppingList.add(boughtTractor);						
					}
				
					
					
					tempV.setQuantity(tempV.getQuantity()-howMany);
				}
				return;
			}
		}
	}
	public void removeOneVehicleFromShoppingList(String code) throws Exception{
		if(code == null) throw new Exception("Code is null");
		for(int i = 0; i < shoppingList.size(); i++) {
			if(shoppingList.get(i).getVehicleCode().equals(code)) {
				shoppingList.remove(i);
				for(Vehicle tempV: mainService.allVehicles) {
					if(tempV.getVehicleCode().equals(code)) {
						tempV.setQuantity(tempV.getQuantity()+1);
						return;
					}
				}
			}
		}
	}
	public float calculateShoppingListValue() {
		float totalValue = 0;
        for (Vehicle tempV : shoppingList) {
            totalValue += tempV.getPrice() * tempV.getQuantity();
        }
        return totalValue;
	}
}
