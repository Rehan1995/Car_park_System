import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WestministerCarParkManager implements CarParkManager {

	static int count = 0, carCount, vanCount, motorbikeCount;
	String carType;

	Scanner sc = new Scanner(System.in);
	static Vehicle[] vehicleSystem = new Vehicle[20];
	
	//Add vehicle
	public void addVehicle() { 
		String plate_id;
		String brand;
		String date;
		String color;

		try {
			if (count > 20) {
				System.out.println("Car Park is full!!");

			} else {
				System.out.println("Once again welcome to Car park !");
				DateTime time = new DateTime();
				System.out.println("Enter the vehicle number  : ");
				plate_id = sc.nextLine();
				System.out.println("Enter the brand : ");
				brand = sc.nextLine();
				System.out.println("Date (mm/dd/yyyy) : ");
				date = sc.nextLine();
				if(time.valDate(date)){
					addVehicle();
					System.out.println();
				}
				System.out.println("Please add the vehicle type");
				carType = sc.nextLine();
				int doors;

				if (carType.equalsIgnoreCase("car")) {
					carCount++;
					System.out.println(" Please enter the number of doors : ");
					doors = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter  the colour : ");
					color = sc.nextLine();
					vehicleSystem[count++] = new Car(plate_id, brand, date,
							time.getHHMM(), doors, color, true, "car",
							time.getMiliSeconds());
					System.out.println("Car has been added successfully!!");
					
				} else if (carType.equalsIgnoreCase("van")) {
					vanCount++;
					System.out
							.println("Please enter the cargo volume of the van : ");
					double volume = sc.nextDouble();
					sc.nextLine();
					vehicleSystem[count++] = new Van(plate_id, brand, date,
							time.getHHMM(), volume, true, "Van",
							time.getMiliSeconds());
					count++;
					System.out.println("Van has been added successfully!!");

				} else if (carType.equalsIgnoreCase("motorbike")) {
					motorbikeCount++;
					System.out.println("Please enter the engine capacity : ");
					int engineCapacity = sc.nextInt();
					sc.nextLine();
					vehicleSystem[count++] = new MotorBike(plate_id, brand,
							date, time.getHHMM(), engineCapacity, true,
							"motorbike", time.getMiliSeconds());
					System.out
							.println("Motorbike has been added successfully!!");

				} else {
					System.out
							.println("Vehicle type should be car, van or motorbike");
				}
			}
		}catch(NumberFormatException e){
			System.out.println("Time and Date must be digits!");
			addVehicle();
		}
		catch (Exception e) {
			System.out.println("Please enter a valid input!!");
		}
	}
	
	//Delete vehicle 
	public void deleteVehicle() {
		int index = 0;
		System.out.println("Current parking details : ");
		getVehicleParked();
		System.out.println();
		System.out
				.println("Enter the plate number to delete the the vehicle : ");
		String searchedPlateId = sc.nextLine();

		for (Vehicle vehicle : vehicleSystem) {
			if (vehicle != null) {
				if (searchedPlateId.equalsIgnoreCase(vehicle.plate_id)) {
					vehicleSystem[index] = null;
					System.out
							.println("The vehicle was successfully removed!!");
					System.out
							.println("\t Vehicle type: " + vehicle.getBrand());
					System.out.println("\t Vehicle plate Id "
							+ vehicle.getPlateId());
					System.out.println("\t Payment: " + payment(vehicle)
							+ "pounds.");
				}
			}
			index++;
		}
	}
	
	//Get the vehicle which are parked
	public void getVehicleParked() {
		System.out.println("\t\tPlateID\t\tVehicle Type\t\t\tDate \t\t\tEntry Time");
		System.out.println("\t\t---------\t\t\t-----------------\t\t\t-------\t\t\t--------------");
		for (int i = 19; i >= 0; i--) {
			if (vehicleSystem[i] != null) {
				if(vehicleSystem[i].getVehicleType().equals("motorbike")){
					System.out.println("\t\t"+vehicleSystem[i].getPlateId() + "\t\t\t"
							+ vehicleSystem[i].getVehicleType() + "\t\t\t"
							+ vehicleSystem[i].getDate() + "\t\t\t"
							+ vehicleSystem[i].getTime());
				}else{
					System.out.println("\t\t"+vehicleSystem[i].getPlateId() + "\t\t\t"
							+ vehicleSystem[i].getVehicleType() + "\t\t\t"
							+ vehicleSystem[i].getDate() + "\t\t\t"
							+ vehicleSystem[i].getTime());
				}
				
			}
		}

	}
	
	// Full details of the vehicles
	public void getDetailedVehicle() {
		int currentVehicleCount = 0;
		carCount=0;
		vanCount=0;
		motorbikeCount=0;
		for (Vehicle v : vehicleSystem) {
			if (v != null) {
				currentVehicleCount++;
				if(v.getVehicleType().equals("car")){
					carCount++;
				}else if(v.getVehicleType().equals("Van")){
					vanCount++;
				}else if(v.getVehicleType().equals("motorbike")){
					motorbikeCount++;
				}
			}
		}
		float carPer = (carCount / (float)currentVehicleCount) * 100;
		float vanPer = (vanCount / (float)currentVehicleCount) * 100;
		float motorbikePer = (motorbikeCount / (float)currentVehicleCount) * 100;
		System.out.println("The percentage of cars : " + carPer);
		System.out.println("The percentage of vans : " + vanPer);
		System.out.println("The percentage of motorbikes : " + motorbikePer);
		for (int i = 19; i >= 0; i--) {
			if (vehicleSystem[i] != null) {
				System.out.println("");
				
				System.out
						.println("Details of the vehicle which was parked at last : \n");
				System.out.println("\t \tVehicle type : "
						+ vehicleSystem[i].getVehicleType());
				System.out.println("\t\t  Vehicle plateId :"
						+ vehicleSystem[i].getPlateId());
				System.out.println("\t\t  Payment : " + payment(vehicleSystem[i]) + "  pounds");
				break;
			}
		}
	}
	
	//Search the vehicle by date
	public void getVehicleByDate() {
		System.out.println("Please enter the date to search (dd/mm/yyyy) : ");
		String searchDate = sc.nextLine();
		System.out.println("\t\tPlateId\t\t\tVehicle Type\t\t\tBrand\t\t\tDate");
		System.out.println("\t\t---------\t\t\t----------------\t\t\t--------\t\t\t-------");
		for (Vehicle v : vehicleSystem) {
			if (v != null) {
				if (searchDate.equals(v.getDate())) {
					System.out.println("\t\t"+v.getPlateId() + "\t\t\t" +v.getVehicleType()
							+ "\t\t\t" + v.getBrand() + "\t\t\t" + v.getDate());

				}
			}
		}
	}
	
	//Add the payment
	public float payment(Vehicle c) {
		float charge = 0;
		DateTime time = new DateTime();
		float hours = (time.calculateDifference(c.getTimeMil()) / (1000 * 60 * 60)) % 24;
		if (hours > 3) {
			charge = (9 + (hours - 3));
		} else if (hours <= 3) {
			charge = 3;
		}
		return charge;
	}
	
	//Save data
	public void saveData() {
		try {
			FileOutputStream fos = new FileOutputStream("Data.text");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(vehicleSystem);
		} catch (Exception e) {

		}
	}
	
	//Read data from the saved file
	public void readData() {
		try {

			FileInputStream fis = new FileInputStream("Data.text");
			ObjectInputStream ois = new ObjectInputStream(fis);
			vehicleSystem = (Vehicle[]) ois.readObject();

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		char select = 'q';
		Scanner sc = new Scanner(System.in);

		try {
			WestministerCarParkManager wcm = new WestministerCarParkManager();
			wcm.readData();
			while (select != 'q' || select != 'Q') {

			
				System.out.println("");
				System.out.println(" 				* Welcome to westminster Carpark *					");
				System.out.println("");
				System.out.println("1. Add new vehicle 													Enter[1]");
				System.out.println("2. Delete vehicle														Enter[2]");
				System.out.println("3. View the list of the vehicles whcich are currently parked			Enter[3] ");
				System.out.println("4. View detialed list of vehicles										Enter[4]");
				System.out.println("5. View vehicles by date												Enter[5]");
				System.out.println("6. Exit the programme!		(Press -Q) ");
				System.out.print("\nHey user, Please enter a choice to continue :");
				select = sc.next().toLowerCase().charAt(0);
				sc.nextLine();
	

				selection: switch (select) {
				case '1':
					wcm.addVehicle();
					break selection;

				case '2':
					wcm.deleteVehicle();
					break selection;

				case '3':
					wcm.getVehicleParked();
					break selection;

				case '4':
					wcm.getDetailedVehicle();
					break selection;

				case '5':
					wcm.getVehicleByDate();
					break selection;

				case 'q':
					wcm.saveData();
					System.out.println("Processing.....     , Ok System closed");
					System.exit(0);

				default:
					System.out.println();
					System.out.println("Please select the correct selection!!");
					System.out.println();
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
