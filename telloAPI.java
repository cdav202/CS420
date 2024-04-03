package tello;

//Main class representing the pharmacy system
public class telloAPI {

  // Method to initiate the delivery service
  public void makeDeliveryService() {
      TelloDrone drone = new TelloDrone();
      drone.takeOff();
      drone.deliver(new int[]{0, 0}, new int[]{10, 10}); // Example coordinates for delivery
      drone.returnHome(new int[]{10, 10}, new int[]{0, 0}); // Return to home coordinates
      drone.land();
      drone.finishDelivery();
  }
}

//Class representing the Tello drone for delivery operations
class TelloDrone {
  // Tello drone API integration methods and attributes
  // Need methods based on Tello API documentation

  // Need methods to make the drone take off
  public void takeOff() {
      // Implementation using Tello API
      System.out.println("Tello drone taking off.");
      // Tello API command for takeoff
      sendCommand("takeoff");
  }

  // Method to deliver to a specified destination
  public void deliver(int[] home, int[] dest) {
      // Implementation using Tello API
      System.out.println("Tello drone delivering from " + arrayToString(home) + " to " + arrayToString(dest));
      // Tello API commands to fly the drone to the destination
      flyTo(dest[0], dest[1]);
  }

  // Method to make the drone return home
  public void returnHome(int[] now, int[] home) {
      // Implementation using Tello API
      System.out.println("Tello drone returning home from " + arrayToString(now) + " to " + arrayToString(home));
      // Tello API commands to fly the drone back to the home location
      flyTo(home[0], home[1]);
  }

  // Method to make the drone land
  public void land() {
      // Implementation using Tello API
      System.out.println("Tello drone landing.");
      // Tello API command for landing
      sendCommand("land");
  }

  // Method to finish the delivery process
  public void finishDelivery() {
      // Implementation to perform any necessary actions to complete the delivery
      System.out.println("Delivery completed.");
  }

  // Utility method to convert integer array to string
  private String arrayToString(int[] arr) {
      return "[" + arr[0] + ", " + arr[1] + "]";
  }

  // Method to send commands to the Tello drone
  private void sendCommand(String command) {
      // Implementation to send command to Tello drone
      // May have to use UDP socket to send command to Tello drone
  }

  // Method to fly the drone to specified coordinates
  private void flyTo(int x, int y) {
      // Implementation using Tello API
      System.out.println("Tello drone flying to coordinates: (" + x + ", " + y + ")");
      // Tello API commands to fly the drone to the specified coordinates
  }
}

//Class representing the log for storing drone information
class Log {
  private StringBuilder messBoard; // StringBuilder to store log messages

  // Constructor for Log class
  public Log() {
      messBoard = new StringBuilder();
  }

  // Method to check delivery status
  public int checkStatus(int[] A, int[] B) {
      // Implementation to calculate delivery status
      // Placeholder return value
      return 0;
  }

  // Method to write a message to the log
  public void writeToLog(String message) {
      // Implementation to append message to the log
      messBoard.append(message).append("\n");
  }

  // Method to clear the log
  public void clearLog() {
      // Implementation to clear the log
      messBoard.setLength(0);
  }

  // Method to get the log content
  public String getLogContent() {
      // Implementation to return the log content
      return messBoard.toString();
  }
}

