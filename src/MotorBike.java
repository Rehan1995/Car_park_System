import java.io.Serializable;

public class MotorBike extends Vehicle implements Serializable {
	private int engineSize;

	MotorBike(String plate_id, String brand, String date, String time,
			int engineSize, boolean isOccupied, String type, long timeMil) {
		setPlateId(plate_id);
		setBrand(brand);
		setDate(date);
		setTime(time);
		setEngineSize(engineSize);
		setVehicleType(type);
		setTimeMil(timeMil);
	}

	public int getEngineSize() {
		return engineSize;

	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public void setPlateId(String plateId) {
		this.plate_id = plateId;

	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void date() {

	}

	public String getPlateId() {
		return this.plate_id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setDate(String date) {
		this.date = date;

	}

	public String getDate() {
		return date;

	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;

	}

	public void setVehicleType(String type) {
		this.vehicle_type = type;
	}

	public String getVehicleType() {
		return vehicle_type;
	}

	public void setTimeMil(long time) {
		this.timeMil = time;
	}

	public long getTimeMil() {
		return timeMil;
	}
}
