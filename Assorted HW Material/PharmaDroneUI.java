package pharmaDrone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class PharmaDroneUI extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField coordinateTextBox;
  private JFrame frame;
  private ArchiveInfoInsertion reportArchiveInfoPage = new ArchiveInfoInsertion();
  private TDrone tDrone;
  // private Archive MainArc;

  /**
   * Launch the application.
   */
  public static void NewFrame() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          PharmaDroneUI frame = new PharmaDroneUI();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public JFrame getF() {
    return frame;
  }

  /**
   * Create the frame.
   */
  public PharmaDroneUI() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel droneMap = new JPanel();
    droneMap.setForeground(new Color(0, 0, 0));
    droneMap.setBackground(new Color(0, 0, 0));
    droneMap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    droneMap.setBounds(10, 41, 764, 160);
    contentPane.add(droneMap);
    droneMap.setLayout(null);

    // creates and adds a grid to the droneMap
    Grid newGrid = new Grid();
    newGrid.setBounds(0, 0, 764, 160);
    droneMap.add(newGrid);

    // creates a home icon where the pharmacy is located
    PharmaIcon homeIcon = new PharmaIcon();
    homeIcon.setBounds(0, 0, 764, 160);
    droneMap.add(homeIcon);

    // creates a drone location icon
    // FIX AS FIXED POINTS ARE FOR TESTING
    DroneIcon droneIcon = new DroneIcon(300, 300);
    droneIcon.setBounds(0, 0, 764, 160);
    droneMap.add(droneIcon);

    // creates a destinationIcon
    destinationIcon destinationIconn = new destinationIcon(300, 300);
    destinationIconn.setBounds(0, 0, 764, 160);
    droneMap.add(destinationIconn);

    JButton deliverButton = new JButton("Deliver\r\n");
    deliverButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
    deliverButton.setBounds(210, 316, 100, 50);
    contentPane.add(deliverButton);

    coordinateTextBox = new JFormattedTextField();
    coordinateTextBox.setBackground(new Color(255, 255, 255));
    coordinateTextBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
    coordinateTextBox.setHorizontalAlignment(SwingConstants.CENTER);
    coordinateTextBox.setText("\r\n");
    coordinateTextBox.setBounds(10, 239, 300, 35);
    contentPane.add(coordinateTextBox);
    coordinateTextBox.setColumns(10);

    JButton logoutButton = new JButton("Logout");
    logoutButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
    logoutButton.setBounds(10, 11, 100, 21);
    contentPane.add(logoutButton);
    // creates the Login Page
    logoutButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        contentPane.setVisible(true);
        AdminLogin login = new AdminLogin();
        login.NewFrame();
      }
    });

    JPanel seperator = new JPanel();
    seperator.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    seperator.setBackground(new Color(170, 171, 191));
    seperator.setBounds(340, 212, 4, 210);
    contentPane.add(seperator);

    JButton returnButton = new JButton("Return\r\n");
    returnButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
    returnButton.setBounds(10, 316, 100, 50);
    contentPane.add(returnButton);

    Label coordinateLabel = new Label("Please enter coordinates:");
    coordinateLabel.setBounds(10, 212, 145, 21);
    contentPane.add(coordinateLabel);

    Label messageLogBox = new Label("Message Log:");
    messageLogBox.setBounds(350, 212, 76, 21);
    contentPane.add(messageLogBox);

    JButton archiveButton = new JButton("Archive");
    archiveButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
    archiveButton.setBounds(674, 11, 100, 21);
    contentPane.add(archiveButton);
    // creates the ArchiveInfo Page
    archiveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        contentPane.setVisible(true);

        reportArchiveInfoPage.getF().setVisible(true);
      }
    });

    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(354, 239, 420, 183);
    contentPane.add(scrollPane_1);

    JTextPane messageBox = new JTextPane();
    scrollPane_1.setViewportView(messageBox);
    messageBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
    // Initialize TDrone
    tDrone = new TDrone();
    // Action listener for the deliver button
    deliverButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Get coordinates input and split
        String[] coordinatesText = coordinateTextBox.getText().trim().split("\\s+");
        try {
          // Check if each coordinate is within the specified range
          List<Integer> coordinates = new ArrayList<>();
          for (String coord : coordinatesText) {
            int value = Integer.parseInt(coord);
            if (value < 20 || value > 500) {
              throw new NumberFormatException();
            }
            coordinates.add(value);
          }
          // Check if exactly 6 coordinates are provided
          if (coordinates.size() != 6) {
            throw new NumberFormatException();
          }
          // Take off the drone and deliver
          tDrone.takeOff();
          tDrone.deliver(coordinates.toArray(new Integer[0]));
          // Set delivery coordinates for report creation
          reportArchiveInfoPage.setDeliveryCoordinates(coordinates);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(contentPane,
              "Invalid coordinates. Please enter 6 integers between 20 and 500 separated by spaces.");
        }
      }
    });
  }
}
