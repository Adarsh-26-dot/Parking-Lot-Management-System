public abstract class Vehicle {

    protected String vehicleNumber;
    protected String ownerName;
    protected int parkingSlot;
    protected int hoursParked;

    public Vehicle(String vehicleNumber,
                   String ownerName,
                   int parkingSlot,
                   int hoursParked) {

        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.parkingSlot = parkingSlot;
        this.hoursParked = hoursParked;
    }

    // Abstract Method (Polymorphism)
    public abstract double calculateParkingFee();

    public abstract String getVehicleType();

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    // Setters
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    @Override
    public String toString() {

        return String.format(
                "%-15s %-20s %-10s %-8d %-8d ₹%.2f",
                vehicleNumber,
                ownerName,
                getVehicleType(),
                parkingSlot,
                hoursParked,
                calculateParkingFee());

    }

}