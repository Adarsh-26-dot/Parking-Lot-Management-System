import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingManager manager = new ParkingManager();

        // Load vehicles from file
        manager.setVehicles(FileManager.loadFromFile());

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("      PARKING LOT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Search Vehicle");
            System.out.println("4. View All Vehicles");
            System.out.println("5. Available Slots");
            System.out.println("6. Daily Revenue");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid Input!");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Vehicle Number: ");
                    String number = sc.nextLine();

                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();

                    String type;

                    while (true) {

                        System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
                        type = sc.nextLine();

                        if (type.equalsIgnoreCase("Car") ||
                                type.equalsIgnoreCase("Bike") ||
                                type.equalsIgnoreCase("Truck"))
                            break;

                        System.out.println("Invalid Vehicle Type!");

                    }

                    int hours;

                    do {

                        System.out.print("Enter Parking Hours: ");
                        hours = sc.nextInt();

                        if (hours <= 0)
                            System.out.println("Hours must be greater than 0.");

                    } while (hours <= 0);

                    int slot = manager.allocateSlot();

                    if (slot == -1) {

                        System.out.println("Parking Lot Full!");

                        break;

                    }

                    Vehicle vehicle;

                    switch (type.toLowerCase()) {

                        case "car":
                            vehicle = new car(number, owner, slot, hours);
                            break;

                        case "bike":
                            vehicle = new bike(number, owner, slot, hours);
                            break;

                        default:
                            vehicle = new truck(number, owner, slot, hours);

                    }

                    manager.parkVehicle(vehicle);

                    break;

                case 2:

                    System.out.print("Enter Vehicle Number: ");
                    number = sc.nextLine();

                    if (manager.removeVehicle(number))
                        System.out.println("Vehicle Removed Successfully.");
                    else
                        System.out.println("Vehicle Not Found.");

                    break;

                case 3:

                    System.out.print("Enter Vehicle Number: ");
                    number = sc.nextLine();

                    manager.displayVehicle(number);

                    break;

                case 4:

                    manager.displayVehicles();

                    break;

                case 5:

                    manager.displayAvailableSlots();

                    break;

                case 6:

                    manager.displayRevenue();

                    break;

                case 7:

                    FileManager.saveToFile(manager.getVehicles());

                    break;

                case 8:

                    FileManager.saveToFile(manager.getVehicles());

                    System.out.println("\nThank you for using Parking Lot Management System.");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 8);

        sc.close();

    }

}