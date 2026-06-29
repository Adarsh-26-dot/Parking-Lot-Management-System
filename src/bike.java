public class bike extends Vehicle {

    public bike(String vehicleNumber,
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

        return hoursParked * 20;

    }

    @Override
    public String getVehicleType() {

        return "Bike";

    }

}