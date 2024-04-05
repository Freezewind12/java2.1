package model;

public class Bus extends Vehicle{
	private int numberOfSeats;
	private boolean hasBaggageDivision;

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		if(numberOfSeats > 5 && numberOfSeats < 300) 
			this.numberOfSeats = numberOfSeats;
		else
			this.numberOfSeats = 5;
	}
	public boolean isHasBaggageDivision() {
		return hasBaggageDivision;
	}
	public void setHasBaggageDivision(boolean hasBaggageDivision) {
		this.hasBaggageDivision = hasBaggageDivision;
	}
	// Constructors
	public Bus() {
		super();
		setNumberOfSeats(5);
		setHasBaggageDivision(false);
	}
	public Bus(String title, float price, int quantity, Fuel fuel, int numberOfSeats, boolean hasBaggageDivision) {
		super(title, price, quantity, fuel);
		setNumberOfSeats(numberOfSeats);
		setHasBaggageDivision(hasBaggageDivision);
	}
	// toString
	public String toString()
	{
		return super.toString() + " seats: " + getNumberOfSeats() + " baggage division: " + isHasBaggageDivision();
	}
}
