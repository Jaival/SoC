import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.Math;

public class Logic extends UnicastRemoteObject implements Interface {
    private static final long serialVersionUID = 1L;

    protected Logic() throws RemoteException {
    }

    public double Addition(double a, double b) {
        return a + b;
    }

    public double Subtraction(double a, double b) {

        if (a < b) {
            return b - a;
        } else {
            return a - b;
        }
    }

    public double Multiplication(double a, double b) {
        return a * b;
    }

    public double Division(double a, double b) {
        return a / b;
    }

    public double Square_Root(double a) {
        return Math.sqrt(a);
    }

    public double Log(double a) {
        return Math.log(a);
    }
}