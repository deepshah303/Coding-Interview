package model;

/**
 * @author Deep Shah
 * 
 * Model class which will store all the information about Signal
 *
 */
public class SignalConfig {

	private String epcId;
	private String locationName;
	private int waitingPeriod;
	private int noOfPedestrainsAllowed;

	public SignalConfig(String epcId, String locationName, int waitingPeriod, int noOfPedestrainsAllowed) {
		super();
		this.epcId = epcId;
		this.locationName = locationName;
		this.waitingPeriod = waitingPeriod;
		this.noOfPedestrainsAllowed = noOfPedestrainsAllowed;
	}

	public String getEpcId() {
		return epcId;
	}

	public void setEpcId(String epcId) {
		this.epcId = epcId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(int waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	public int getNoOfPedestrainsAllowed() {
		return noOfPedestrainsAllowed;
	}

	public void setNoOfPedestrainsAllowed(int noOfPedestrainsAllowed) {
		this.noOfPedestrainsAllowed = noOfPedestrainsAllowed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Location : "+getLocationName()+ 
				"Waiting period: " +getWaitingPeriod() + 
				"Number of Pedestrains Allowed: " +getNoOfPedestrainsAllowed();
	}

}
