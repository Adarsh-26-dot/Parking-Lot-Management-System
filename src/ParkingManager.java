import java.util.ArrayList;

public class ParkingManager {

    private ArrayList<Vehicle> vehicles;
    private double totalRevenue;
    private final int TOTAL_SLOTS = 20;

    public ParkingManager() {
        vehicles = new ArrayList<>();
        totalRevenue = 0;
    }

    // Allocate First Available Slot
    public int allocateSlot() {

        boolean[] occupied = new boolean[TOTAL_SLOTS + 1];

        for (Vehicle v : vehicles) {
            occupied[v.getParkingSlot()] = true;
        }

        for (int i = 1; i <= TOTAL_SLOTS; i++) {
            if (!occupied[i]) {
                return i;
            }
        }

        return -1;
    }

    // Park Vehicle
    public boolean parkVehicle(Vehicle vehicle) {

        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(vehicle.getVehicleNumber())) {
                System.out.println("Vehicle already exists!");
                return false;
            }
        }

        if (allocateSlot() == -1) {
            System.out.println("Parking Lot Full!");
            return false;
        }

        vehicles.add(vehicle);

        System.out.println("Vehicle Parked Successfully.");

        return true;
    }

    // Search Vehicle
    public Vehicle searchVehicle(String vehicleNumber) {

        for (Vehicle v : vehicles) {

            if (v.getVehicleNumber().equalsIgnoreCase(vehicleNumber))
                return v;

        }

        return null;
    }

    // Remove Vehicle
    public boolean removeVehicle(String vehicleNumber) {

        Vehicle vehicle = searchVehicle(vehicleNumber);

        if (vehicle == null)
            return false;

        totalRevenue += vehicle.calculateParkingFee();

        vehicles.remove(vehicle);

        return true;
    }

    // Display All Vehicles
    public void displayVehicles() {

        if (vehicles.isEmpty()) {

            System.out.println("No Vehicles Parked.");

            return;
        }

        System.out.printf("%-15s %-20s %-10s %-8s %-8s %-10s\n",
                "Vehicle No",
                "Owner",
                "Type",
                "Slot",
                "Hours",
                "Fee");

        for (Vehicle vehicle : vehicles) {

            System.out.println(vehicle);

        }

    }

    // Search Details
    public void displayVehicle(String vehicleNumber) {

        Vehicle vehicle = searchVehicle(vehicleNumber);

        if (vehicle == null) {

            System.out.println("Vehicle Not Found.");

        } else {

            System.out.println(vehicle);

        }

    }

    // Available Slots
    public void displayAvailableSlots() {

        System.out.println("Available Slots : "
                + (TOTAL_SLOTS - vehicles.size()));

    }

    // Revenue
    public void displayRevenue() {

        System.out.println("Today's Revenue : ₹"
                + String.format("%.2f", totalRevenue));

    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}