import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    private static Formula1ChampionshipManager serializeFile = new Formula1ChampionshipManager();

    public static void main(String[] args) throws IOException {
        serializeFile = new Formula1ChampionshipManager();
        Formula1ChampionshipManager formula;
        formula = new Formula1ChampionshipManager();

        do {
            System.out.println("	 ____ ____ ____ ____ ");
            System.out.println("	||M |||E |||N |||U ||");
            System.out.println("	||__|||__|||__|||__||");
            System.out.println("	|/__\\|/__\\|/__\\|/__\\|");
            System.out.println(" ");
            System.out.println("• Press 1 : Add a new formula 1 driver");
            System.out.println("• Press 2 : Delete an existing formula 1 driver");
            System.out.println("• Press 3 : Change driver team");
            System.out.println("• Press 4 : Display the formula 1 driver statistics");
            System.out.println("• Press 5 : Display all the formula 1 drivers");
            System.out.println("• Press 6 : Add a race data");
            System.out.println("• Press 7 : Save data into a file");
            System.out.println("• Press 8 : Load data from a file");
            System.out.println("• Press 9 : Start the GUI");
            System.out.println("• Press 10 : Exit");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Enter your choice : ");
            String choice;
            choice = scanner.next();
            switch (choice) {
                case "1":
                    formula.addDriver();
                    break;
                case "2":
                    formula.deleteDriver();
                    break;
                case "3":
                    formula.changeDetail();
                    break;
                case "4":
                    formula.displayDriver();
                    break;
                case "5":
                    formula.displayStatistics();
                    break;
                case "6":
                    formula.addData();
                    break;
                case "7":
                    savedToSerializedFile(serializeFile);
                    break;
                case "8":
                    readFromSerializedFile();
                    break;
                case "9":
                    // gui part
                    GUI gui = new GUI(formula);
                    gui.setLayout(null);
                    gui.setVisible(true);
                    gui.setSize(900, 1000);
                    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    break;
                case "10":
                    formula.exit();
                    break;
                default:
                    System.out.println("Invalid input! Please enter a valid input.");
                    break;
            }
        } while (true);
    }

    public static void savedToSerializedFile(Formula1ChampionshipManager serializeFile) {
        String fileName = "serializeFile.ser";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(serializeFile);

            fos.close();
            oos.close();
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public static void readFromSerializedFile() {
        try {
            FileInputStream fis = new FileInputStream("serializeFile.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            serializeFile = (Formula1ChampionshipManager) ois.readObject();
            fis.close();
            ois.close();
            System.out.println("File successfully loaded");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Sorry! reading file doesn't exist");
        }
    }
}
