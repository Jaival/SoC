import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    double Addition(double a, double b) throws RemoteException;
    double Subtraction(double a, double b) throws RemoteException;
    double Multiplication(double a, double b) throws RemoteException;
    double Division(double a, double b) throws RemoteException;
    double Square_Root(double a) throws RemoteException;
    double Log(double a) throws RemoteException;
}