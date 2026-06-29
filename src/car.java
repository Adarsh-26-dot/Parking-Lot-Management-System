public class car extends Vehicle {

    public car(String vehicleNumber,
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

        return hoursParked * 50;

    }

    @Override
    public String getVehicleType() {

        return "Car";

    }

}