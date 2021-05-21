import java.util.*;
import java.lang.*;
enum slotTiming{MORNING, AFTERNOON, EVENING, NIGHT};
enum category{CAR, BUS, TRUCK};


abstract class Vehicle{ 
	protected int registrationNumber,rental;
	protected String carName;
	protected HashMap<slotTiming, Boolean> availability = new HashMap<slotTiming, Boolean>();
	Vehicle(int registrationNumber, int rental, String carName){
		this.registrationNumber = registrationNumber;
		this.carName = carName;
		this.rental = rental;
		this.availability.put(slotTiming.MORNING, true);
		this.availability.put(slotTiming.AFTERNOON, true);
		this.availability.put(slotTiming.EVENING, true);
		this.availability.put(slotTiming.NIGHT, true);
	}
	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", rental=" + rental + ", carName=" + carName
				+ ", availability=" + availability + "]";
	}
	
	
}


class Car extends Vehicle{

	Car(int registrationNumber, int rental, String carName) {
		super(registrationNumber, rental, carName);
	}
	
}

class Bus extends Vehicle{

	Bus(int registrationNumber, int rental, String carName) {
		super(registrationNumber, rental, carName);
	}

	
}

class Truck extends Vehicle{

	Truck(int registrationNumber, int rental, String carName) {
		super(registrationNumber, rental, carName);
	}

}

public class CarRentalSystem {
	
	
	public static boolean addVehicle(ArrayList<Car> cars, ArrayList<Bus> buses,ArrayList<Truck> trucks) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter registration number ");
		int no = s.nextInt();
		s.nextLine();
		System.out.println("Enter name of vehicle ");
		String name = s.next();
		System.out.println("Enter rental of vehicle ");
		int rental = s.nextInt();
		s.nextLine();
		System.out.println("Enter category(CAR,TRUCK,BUS)");
		category cat = category.valueOf(s.next().toUpperCase());
		switch(cat) {
			case CAR:
					Car car = new Car(no,rental,name);
					cars.add(car);
					break;
			case BUS:
					Bus bus = new Bus(no,rental,name);
					buses.add(bus);
					break;
			case TRUCK:
					Truck truck = new Truck(no,rental,name);
					trucks.add(truck);
					break;
			default:
					System.out.println("Invalid category !!");
					return false;
		}
		return true;
	}
	
	
	public static Vehicle findVehicle(ArrayList<Car> cars, ArrayList<Bus> buses,ArrayList<Truck> trucks,int no, category cat) {
		Scanner s = new Scanner(System.in);
		switch(cat) {
			case CAR:
					for(Car i:cars)
					{
						if(i.registrationNumber==no) {
							return i;
						}
					}
					return null;
			case BUS:
					for(Bus i:buses)
					{
						if(i.registrationNumber==no) {
							return i;
						}
					}
					return null;
			case TRUCK:
					for(Truck i:trucks)
					{
						if(i.registrationNumber==no) {
							return i;
						}
					}
					return null;
			default:
					System.out.println("Invalid category !!");
					return null;
		}
	}
	
	public static void bookVehicle(Vehicle vehicle) {
		Scanner s = new Scanner(System.in);
		System.out.println("current status: "+vehicle.availability + "\nEnter time to book");
		
		slotTiming slot = slotTiming.valueOf(s.next().toUpperCase());
		if(vehicle.availability.get(slot))
		{
			vehicle.availability.put(slot,false);
			System.out.println("Vehicle is booked successfully !!");
			return;
		}
		else
		{
			System.out.println("Slot already booked !!");
			return;
		}
		
	}
	
	public static void freeVehicle(Vehicle vehicle) {
		Scanner s = new Scanner(System.in);
		System.out.println("current status: "+vehicle.availability + "\nEnter time for which you rented this car");
		slotTiming slot = slotTiming.valueOf(s.next().toUpperCase());
		if(!vehicle.availability.get(slot))
		{
			vehicle.availability.put(slot,true);
			System.out.println("Vehicle slot reverted thank you for renting !!");
			return;
		}
		else
		{
			System.out.println("This slot is already free !!");
			return;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Car Rental System"); 
		Scanner s = new Scanner(System.in);
		int choice=0;
		boolean statusofoperation;
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Bus> buses = new ArrayList<Bus>();
		ArrayList<Truck> trucks = new ArrayList<Truck>();
		do {
			System.out.println("\n1.Add a vehicle\n2.Find a vehicle.\n3.Book a vehicle.\n4.Remove vehicle.\n5.Exit");
			choice = s.nextInt();
			switch(choice)
			{
				case 1:
						statusofoperation = addVehicle(cars,buses,trucks);
						if(statusofoperation)
							System.out.println("Vehicle added successfully !!"+cars.size());
						else
							System.out.println("Error in adding a vehicle");
						break;
				case 2:
						System.out.println("Enter registration number ");
						int no = s.nextInt();
						s.nextLine();
						System.out.println("Enter category(CAR,TRUCK,BUS)");
						String vehicleCategory = s.next().toUpperCase();
						if(!vehicleCategory.equals("CAR") && !vehicleCategory.equals("BUS") && !vehicleCategory.equals("TRUCK")) {
							System.out.println("Invalid category");
							break;
						}
						category cat = category.valueOf(vehicleCategory);
						Vehicle vehicle = findVehicle(cars, buses, trucks,no,cat);
						if(vehicle==null)
							System.out.println("No such vehicle !!!");
						else
							System.out.println(vehicle.toString());
						break;
				case 3:
						
						System.out.println("Enter registration number ");
						no = s.nextInt();
						s.nextLine();
						System.out.println("Enter category(CAR,TRUCK,BUS)");
						vehicleCategory = s.next().toUpperCase();
						if(!vehicleCategory.equals("CAR") && !vehicleCategory.equals("BUS") && !vehicleCategory.equals("TRUCK")) {
							System.out.println("Invalid category");
							break;
						}
						cat = category.valueOf(vehicleCategory);
						vehicle = findVehicle(cars, buses, trucks,no,cat);
						if(vehicle==null)
							System.out.println("No such vehicle !!!");
						else
						{
							freeVehicle(vehicle);
							System.out.println(vehicle.toString());
						}
						break;
				case 4:
						System.out.println("Enter registration number ");
						no = s.nextInt();
						s.nextLine();
						System.out.println("Enter category(CAR,TRUCK,BUS)");
						vehicleCategory = s.next().toUpperCase();
						if(!vehicleCategory.equals("CAR") && !vehicleCategory.equals("BUS") && !vehicleCategory.equals("TRUCK")) {
							System.out.println("Invalid category");
							break;
						}
						cat = category.valueOf(vehicleCategory);
						vehicle = findVehicle(cars, buses, trucks,no,cat);
						if(vehicle==null)
							System.out.println("No such vehicle !!!");
						else
						{
							freeVehicle(vehicle);
							System.out.println(vehicle.toString());
						}
							
						break;
			}
			
		}while(choice<5);
	}

}
