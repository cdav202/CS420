package Drone;
import java.util.Scanner;
public class Drone {
  private String location;
  private boolean isConnected;
  private boolean isFlying;
  private String clientName;
  private String clientAddress;
  private String prescription;
  private int batteryLevel;

  // Constructor
  public Drone() {
    this.location = " Launch Zone ";
    this.isConnected = false;
    this.isFlying = false;
    this.clientName = "";
    this.clientAddress = "";
    this.prescription = "";
    this.batteryLevel = 100;
  }

  // This method connect the drone to Wi-Fi
  private void connect() {
    System.out.println("Connecting to Wi-Fi ....");
    // Stimulate wifi connection process
    if (Math.random() < 0.9) {// 90% success rate
      System.out.println("The Drone is connected through Wi-Fi");
      this.isConnected = true;
    } else {
      System.out.println("Failed to connected to Wifi. Retrying...");
      retryWifiConnection();
    }
  }

  // This method detect the initial starting point
  public void detectInitialStartingPoint() {
    System.out.println("Initial Starting point detected: " + location);
  }

  // This method is used for the drone to fly to a given destination
  public void flyTo(String endPoint) {
    if (isConnected) {
      System.out.println("Preparing to fly to " + endPoint);
      System.out.println("The Drone is Flying from: " + location + "to " + endPoint);
      // Stimulate Flying
      this.location = endPoint;
      this.isFlying = true;
      System.out.println("Drone has arrived at: " + endPoint);
    } else {
      System.out.println("Cannot fly. Please connect to Wi-Fi first. ");
    }
  }

  // This method is for landing safely
  public void land() {
    if (isFlying) {
      System.out.println("Landing the Drone at: " + location);
      this.isFlying = false;
    } else {
      System.out.println("The Drone is landing at: " + location);
    }

  }

  // This method is to display messages concerning the drone's movement
  public void displayMessage(String message) {
    System.out.println(message);
  }

  // This method is for storing the client data
  public void dataStoredClient(String name, String address, String prescription) {
    this.clientName = name;
    this.clientAddress = address;
    this.prescription = prescription;
    System.out.println("The Client data has been stored successfully!");
  }

  // This method is only to be accessible by the manager and is used to clear
  // client data
  public void clientDataCleared(String managerID) {
    // Here we are checking to see if managerID is valid or not
    if (managerID.equals("1234")) {
      if (!clientName.isEmpty()) {
        this.clientName = "";
        this.clientAddress = "";
        this.prescription = "";
        System.out.println("This Client data has been cleared sucessfully!");
      } else {
        System.out.println("No client data to clear");
      }
    } else {
      System.out.println("Access denied Invalid manager ID Please Try again!!!");
    }
  }

  // Additional Methods >>>>
  /// Method to return to launch zone
  public void returnToLaunchZone() {
    flyTo("Launch Zone");
  }

  private void retryWifiConnection() {
    // Stimulate retrying Wifi connection
    System.out.println("Retrying WiFi connection...");
    if (Math.random() < 0.8) {
      System.out.println("Wifi connection established!");
      this.isConnected = true;
    } else {
      System.out.println("Failed to establish Wi-Fi connection. Please try again later.");
    }
  }

  /// Check Battery level..
  public void checkBatteryLevel() {
    System.out.println("Battery level is sufficient.");
  }

  // This is the main class to stimulate the drone operations
  public static void main(String[] args) {
    Drone droneDelivery = new Drone();
    Scanner scanner = new Scanner(System.in);

    // Connecting to the drone
    droneDelivery.connect();
    // Detecting the initial starting point
    droneDelivery.detectInitialStartingPoint();
    // Stimulate user input for destination.
    System.out.println("Please Enter the destination coordinates: ");
    String endPoint = scanner.nextLine();
    // Perform flight to Final Destination
    droneDelivery.flyTo(endPoint);
    // Perform Landing
    droneDelivery.land();
    // Stored client data
    droneDelivery.dataStoredClient("Bob", "123 Main Avenue", "Medicine B");
    // Stimulate managing client information by manager destination
    System.out.println("Please enter the manager ID to clear client data: ");
    String managerID = scanner.nextLine();
    droneDelivery.clientDataCleared(managerID);
    scanner.close();

  }

}
