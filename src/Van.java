import java.io.Serializable;

public class Van extends Vehicle implements Serializable {

	private double cargoVolume;

	Van(String plate_id, String brand, String date, String time, double cargoVolume,
			boolean isOccupied, String type, long timeMil) {

		setPlateId(plate_id);
		setBrand(brand);
		setDate(date);
		setTime(time);
		setCargoVolume(cargoVolume);
		setOccupied(isOccupied);
		setVehicleType(type);
		setTimeMil(timeMil);
	}

	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	public void setPlateId(String plate_id) {
		this.plate_id = plate_id;

	}

	public void setBrand(String brand) {
		this.brand = brand;

	}

	public void setTimeMil(long time) {
		this.timeMil = time;
	}

	public void setDate(String date) {
		this.date = date;

	}

	public void setTime(String time) {
		this.time = time;

	}

	public void setVehicleType(String type) {
		this.vehicle_type = type;
	}

	public String getPlateId() {
		return this.plate_id;
	}

	public String getBrand() {
		return this.brand;
	}

	public String getTime() {
		return this.time;
	}

	public String getDate() {
		return this.date;
	}

	public String getVehicleType() {
		return vehicle_type;
	}

	public long getTimeMil() {
		return timeMil;
	}

	public double getCargoVolume() {
		return cargoVolume;
	}

}
