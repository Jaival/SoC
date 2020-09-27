import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] argv) throws RemoteException {
        Logic calculator = new Logic();

        int port = 8089;

        try { // special exception handler for registry creation
            LocateRegistry.createRegistry(port);
            System.out.println("Java RMI registry created.");
        } catch (RemoteException e) {
            // do nothing, error means registry already exists
            System.out.println("Java RMI registry already exists.");
        }

        String hostname = "192.168.29.15";

        String bindLocation = "//" + hostname + ":" + port + "/Calculator";
        try {
            Naming.bind(bindLocation, calculator);
            System.out.println(" Server is ready at:" + bindLocation);
        } catch (RemoteException | MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}