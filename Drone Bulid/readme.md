# Pharmadrone Utilization 

## Installation
<p> Download a bulid. Make sure the Tello-SDK bulid included is in the bulidpath of the Pharmadrone System code</p>
<p>Make sure your Tello Drone is already connected through Wi-Fi before running the app.</p>

## Running and Use
The username and password required for the log in is the AdminLogin.java file. Please use it to log in.

You are then greeted to the main screen, where Deliveries take place.

### Main Screen
![image](https://github.com/cdav202/CS420/assets/143133593/5fc94497-ebf6-4309-ac09-bb1d7ac9b186)

Before attempting delivery, make sure your drone is fully charged and in a safe place for liftoff.
In the textbox above, enter a 6-digit sequence for each direction (forward, back, left, right, up, down), with integers (0, or 20 to 250). Anything outside of that range will be set to 0 to assure the drone doesn't stop mid-flight due to error. It should be writtern like this: 20,20,20,20,20,20(see Demo Videos in Project Proposal Folder). Once ready, hit the deliver button, and the drone will take off. If for some reason you want the drone to stop and return for an emergency, hit the Return button. Otherwise, the drone will arrive at its destintation and return on its own. The Message Log will track and inform you of every movement the drone makes for troubleshooting purposes. Once the drone has returned, please press Archive.

### Archive
![image](https://github.com/cdav202/CS420/assets/143133593/7dbebda4-989c-45a0-a04b-eae11c664c1e)

![image](https://github.com/cdav202/CS420/assets/143133593/7e14f45e-4111-41b5-9827-969b6cfca8f1)
After a successful delivery, please input the client's infomation. Hit enter, and a page in the Archive is made. The Archives are earsed upon logout, so please make sure a secondary copy (screenshot, written copies, etc) is created before logging out.

### More Infomation
For more infomation, including demo excecutions, UML documentations, and more, please visit the Project Proposal folder.
