import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.rmi.*;

/**
 * This class represents the object client for a
 * distributed object of class CallbackServerImpl, 
 * which implements the remote interface 
 * CallbackServerInterface.  It also accepts callback
 * from the server.
 * 
 * 
 * 
 * @author M. L. Liu
 */

public class CallbackClient {

  public static void main(String args[]) {
    try {
      int RMIPort;         
      String hostName;
      InputStreamReader is = 
        new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      System.out.println(
        "Enter the RMIRegistry host namer:");
      hostName = br.readLine();
      System.out.println(
        "Enter the RMIregistry port number:");
      String portNum = br.readLine();
      RMIPort = Integer.parseInt(portNum); 
      System.out.println(
        "Enter how many seconds to stay registered:");
      String timeDuration = br.readLine();
      int time = Integer.parseInt(timeDuration);
      String registryURL = 
        "rmi://localhost:" + portNum + "/callback";  
      // find the remote object and cast it to an 
      //   interface object
      CallbackServerInterface h =
        (CallbackServerInterface)Naming.lookup(registryURL);
      System.out.println("Lookup completed " );
      System.out.println("Server said " + h.sayHello());
      CallbackClientInterface callbackObj = 
        new CallbackClientImpl();
      // register for callback
      h.registerForCallback(callbackObj);
      System.out.println("Registered for callback.");
/*
      //activar la ventana de la interfaz grafica
      JFrame frame = new JFrame();//creamos un objeto de tipo JFrame
      frame.setTitle("Wachup");//le ponemos titulo a la ventana
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//le decimos que al cerrar la ventana se cierre el programa
      frame.setResizable(false);//le decimos que no se pueda redimensionar la ventana
      frame.setSize(400, 400);//le damos un tamaño al frame
      frame.setVisible(true);//hacemos visible la ventana

      frame.getContentPane().setBackground(Color.BLACK);//le damos color al fondo de la ventana
*/
      // activamos la ventana de la interfaz grafica
      JFrame frame = new JFrame("WACHUP");
      frame.setContentPane(new menu(frame).menuPrincipal);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      frame.setSize(400, 400);


      try {
        Thread.sleep(time * 1000);
      }
      catch (InterruptedException ex){ // sleep over
      }
      h.unregisterForCallback(callbackObj);
      System.out.println("Unregistered for callback.");
    } // end try 
    catch (Exception e) {
      System.out.println(
        "Exception in CallbackClient: " + e);
    } // end catch
  } //end main
}//end class
