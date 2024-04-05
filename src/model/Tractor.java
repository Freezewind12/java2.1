package model;

public class Tractor extends Vehicle{
	private String additionalTechniques;
	private boolean isOnlyLargeTires;
	
	public String getAdditionalTechniques() {
		return additionalTechniques;
	}
	public void setAdditionalTechniques(String additionalTechniques) {
		if(additionalTechniques != null  && additionalTechniques.matches("[A-Za-z 0-9]{1,20}"))
			this.additionalTechniques = additionalTechniques;
		else
			this.additionalTechniques = "Undefinied";
	}
	public boolean isOnlyLargeTires() {
		return isOnlyLargeTires;
	}
	public void setOnlyLargeTires(boolean isOnlyLargeTires) {
		this.isOnlyLargeTires = isOnlyLargeTires;
	}
	// Constructors
	public Tractor() {
		super();
		setAdditionalTechniques("Technique");
		setOnlyLargeTires(false);
	}
	public Tractor(String title, float price, int quantity, Fuel fuel, String additionalTechniques, boolean isOnlyLargeTires) {
		super(title, price, quantity, fuel);
		setAdditionalTechniques(additionalTechniques);
		setOnlyLargeTires(isOnlyLargeTires);
	}
	// toString
	public String toString()
	{
		return super.toString() + " additional techniques: " + getAdditionalTechniques() + " large tires: " + isOnlyLargeTires();
	}
}
