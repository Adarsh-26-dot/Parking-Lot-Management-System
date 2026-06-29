import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "vehicles.txt";

    // Save Vehicles
    public static void saveToFile(ArrayList<Vehicle> vehicles) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Vehicle v : vehicles) {

                writer.write(
                        v.getVehicleType() + "," +
                                v.getVehicleNumber() + "," +
                                v.getOwnerName() + "," +
                                v.getParkingSlot() + "," +
                                v.getHoursParked());

                writer.newLine();

            }

            System.out.println("Vehicle records saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving data.");

        }

    }

    // Load Vehicles
    public static ArrayList<Vehicle> loadFromFile() {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        File file = new File(FILE_NAME);

        try {

            if (!file.exists()) {

                file.createNewFile();

                return vehicles;

            }

        } catch (IOException e) {

            System.out.println("Unable to create file.");

            return vehicles;

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String type = data[0];
                String number = data[1];
                String owner = data[2];
                int slot = Integer.parseInt(data[3]);
                int hours = Integer.parseInt(data[4]);

                Vehicle vehicle;

                switch (type.toLowerCase()) {

                    case "car":
                        vehicle = new car(number, owner, slot, hours);
                        break;

                    case "bike":
                        vehicle = new bike(number, owner, slot, hours);
                        break;

                    case "truck":
                        vehicle = new truck(number, owner, slot, hours);
                        break;

                    default:
                        continue;

                }

                vehicles.add(vehicle);

            }

        } catch (IOException e) {

            System.out.println("Error while reading file.");

        }

        return vehicles;

    }

}