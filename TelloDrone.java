package telloDrone;

//import tello.sdk.TelloCommand;
//import tello.sdk.TelloConnection;
//import tello.sdk.TelloResponse;
import tellolib.communication.TelloConnection;
import tellolib.communication.TelloResponse;
import tellolib.command.TelloCommand;

public class TelloDrone {
  private boolean deliverFlag = false; // Flag to indicate if the drone is on a delivery route
  private int batteryLevel; // Drone's battery level
  private int[] destCoords; // Array of destination coordinates
  private TelloConnection connection; // Connection to the drone

  // Constructor initializes battery level and connection
  public TelloDrone() {
    batteryLevel = 70; // Assume starting battery level
    connection = new TelloConnection(); // Create a connection to the Tello drone
  }

  // Getter and setter for batteryLevel
  public int getBatteryLevel() {
    return batteryLevel;
  }

  public void setBatteryLevel(int batteryLevel) {
    this.batteryLevel = batteryLevel;
  }

  // Getter and setter for destCoords
  public int[] getDestCoords() {
    return destCoords;
  }

  public void setDestCoords(int[] destCoords) {
    this.destCoords = destCoords;
  }

  // Method to initiate delivery route
  public void delivery(int forward, int right, int left, int up) {
    // Check if the drone is already on a delivery route
    if (deliverFlag) {
      System.out.println("Drone is already on a delivery route. Cannot initiate another delivery");
      return;
    }
    // Check if the battery level is sufficient for delivery
    if (batteryLevel < 50) {
      System.out.println("Battery level is too low to initiate delivery. Please charge the drone!");
      return;
    }
    // If not already on a delivery route, take off
    if (!deliverFlag) {
      takeOff();
    }
    // Send commands to move the drone to the destination coordinates
    TelloResponse response = connection.sendCommand(new TelloCommand("forward " + forward));
    if (!response.isOk()) {
      System.out.println("Error: " + response.getMessage());
      return;
    }
    response = connection.sendCommand(new TelloCommand("right " + right));
    if (!response.isOk()) {
      System.out.println("Error: " + response.getMessage());
      return;
    }
    response = connection.sendCommand(new TelloCommand("left " + left));
    if (!response.isOk()) {
      System.out.println("Error: " + response.getMessage());
      return;
    }
    response = connection.sendCommand(new TelloCommand("up " + up));
    if (!response.isOk()) {
      System.out.println("Error: " + response.getMessage());
      return;
    }
    // Land the drone after completing the delivery
    land();
  }

  // Method to land the drone
  public void land() {
    if (!deliverFlag) {
      System.out.println("Drone is already on the ground.");
      return;
    }
    // Send command to land the drone
    TelloResponse response = connection.sendCommand(new TelloCommand("land"));
    if (!response.isOk()) {
      System.out.println("Error: " + response.getMessage());
      return;
    }
    // Update deliverFlag to indicate the drone is no longer on a delivery route
    deliverFlag = false;
  }

  // Method to take off
  public void takeOff() {
    if (deliverFlag) {
      System.out.println("Drone is already in the air. Cannot take off");
      return;
    }
    if (batteryLevel < 50) {
      System.out.println("Battery level is too low to take off. Please charge the drone!");
      return;
    }
    // Send command to take off the drone
    TelloResponse response = connection.sendCommand(new TelloCommand("takeoff"));
    if (!response.isOk()) {
      System.out.println("Error: " + response.getMessage());
      return;
    }
    // Update deliverFlag to indicate the drone is on a delivery route
    deliverFlag = true;
  }
}
