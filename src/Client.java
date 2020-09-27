import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String remoteHostName = "192.168.29.15";
        int remotePort = 8089;
        String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Calculator";

        Interface calculator = null;
        try {
            System.out.println("Connecting to client at:" + connectLocation);
            calculator = (Interface) Naming.lookup(connectLocation);
        } catch (MalformedURLException | RemoteException | NotBoundException e1) {
            e1.printStackTrace();
        }

        double result = 0;
        double a, b = 0;
        double select = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            assert calculator != null;

            System.out.println("Enter\n" +
                    "1:For Addition\n" +
                    "2:For Subtraction\n" +
                    "3:For Multiplication\n" +
                    "4:For Division\n" +
                    "5:For Square Root\n" +
                    "6:For Log\n");
            select = scanner.nextInt();

            if (select == 5 || select == 6) {
                System.out.println("Enter your number:");
                a = scanner.nextInt();
            } else {
                System.out.println("Enter your number 1:");
                a = scanner.nextInt();
                System.out.println("Enter your number 2:");
                b = scanner.nextInt();
            }

            if (select == 1) {
                result = calculator.Addition(a, b);
                System.out.println("answer:" + result);
            } else if (select == 2) {
                result = calculator.Subtraction(a, b);
                System.out.println("answer:" + result);
            } else if (select == 3) {
                result = calculator.Multiplication(a, b);
                System.out.println("answer:" + result);
            } else if (select == 4) {
                result = calculator.Division(a, b);
                System.out.println("answer:" + result);
            } else if (select == 5) {
                result = calculator.Square_Root(a);
                System.out.println("answer:" + result);
            } else if (select == 6) {
                result = calculator.Log(a);
                System.out.println("answer:" + result);
            }

        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
        System.out.println("Result is :" + result);

    }
}