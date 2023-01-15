import Controller.DataController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        DataController dataController = new DataController();

        System.out.println("Enter space-separeted data in random arrangement");
        System.out.println("Surname, Name, Patronymic (all Cyrillic), Birth date (dd.mm.yyyy), " +
                            "Phone number (with 5-11 numbers), Gender(f or m):");

        String data = iScanner.nextLine();

        if(dataController.checkData(data) == true) {
            dataController.appendDataInFile(data);
        }
        iScanner.close();
    }
}