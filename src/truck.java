public class truck extends Vehicle {

    public truck(String vehicleNumber,
                 String ownerName,
                 int parkingSlot,
                 int hoursParked) {

        super(vehicleNumber,
                ownerName,
                parkingSlot,
                hoursParked);

    }

    @Override
    public double calculateParkingFee() {

        return hoursParked * 100;

    }

    @Override
    public String getVehicleType() {

        return "Truck";

    }

}