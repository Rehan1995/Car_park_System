import java.io.Serializable;

public abstract class Vehicle implements Serializable {

	protected String plate_id;
	protected String brand;
	protected String date;
	protected String time;
	protected boolean isOccupied;
	protected String vehicle_type;
	protected long timeMil;

	public boolean isOccupied() {
		return isOccupied;

	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;

	}

	abstract void setPlateId(String plate_id);

	abstract void setBrand(String brand);

	abstract String getPlateId();

	abstract String getBrand();

	abstract void setDate(String date);

	abstract String getTime();

	abstract String getDate();

	abstract void setTime(String time);

	abstract void setVehicleType(String type);

	abstract String getVehicleType();

	abstract void setTimeMil(long time);

	abstract long getTimeMil();

}
