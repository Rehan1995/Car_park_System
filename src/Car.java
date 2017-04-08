import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

	private int doors;
	private String color;

	Car(String plate_id, String brand, String date, String time, int doors,
			String color, boolean isOccupied, String type, long timeMil) {
		setPlateId(plate_id);
		setBrand(brand);
		setDate(date);
		setTime(time);
		setColor(color);
		setDoors(doors);
		setOccupied(isOccupied);
		setVehicleType(type);
		setTimeMil(timeMil);
	}

	public void setPlateId(String plate_id) {
		this.plate_id = plate_id;

	}

	public void setBrand(String brand) {
		this.brand = brand;

	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDoors(int doors) {
		this.doors = doors;

	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTime(String Time) {
		this.time = Time;
	}

	public void setVehicleType(String type) {
		this.vehicle_type = type;
	}

	public void setTimeMil(long time) {
		this.timeMil = time;
	}

	public String getPlateId() {
		return this.plate_id;

	}

	public String getBrand() {
		return this.brand;
	}

	public int getDoors() {
		return doors;
	}

	public String getColor() {
		return color;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public long getTimeMil() {
		return timeMil;
	}

	String getVehicleType() {
		return vehicle_type;
	}
}
