import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Formula1ChampionshipManager implements ChampionshipManager, java.io.Serializable{
    public static Scanner scanner;
    public static ArrayList<Formula1Driver> formula;
    public static ArrayList<RaceInfo> race;

    static {
        scanner = new Scanner(System.in);
        formula = new ArrayList<>();
        race = new ArrayList<>();
    }

    @Override
    public void addDriver() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------------Add a new formula 1 driver--------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");

        boolean isThere = false;    // this is to check whether there is a team already

        if (!isThere) {
            do {
                System.out.println("Enter the team name : ");
                String teamName = scanner.next();
                for (Formula1Driver driver : formula) {
                    if (teamName.equals(driver.getDriverName())) {
                        System.out.println("The team you selected already exists");
                        isThere = true;
                    }
                }
                if (!isThere) {
                    System.out.println("Enter a driver name : ");
                    String driverName = scanner.next();
                    System.out.println("Enter the driver location : ");
                    String driverLocation = scanner.next();

                    Formula1Driver newDriver = new Formula1Driver(driverName, driverLocation, teamName);
                    formula.add(newDriver);
                    System.out.println("\nTeam Successfully added");
                    isThere = true;
                }
            } while (!isThere);
        }
        scanner.nextLine();
        System.out.println();
    }

    @Override
    public void deleteDriver() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("---------------Delete an existing formula 1 driver--------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");

        boolean isThere = false;    // this is to see whether there is a team already 
        if (!isThere) {
            do {
                System.out.println("Enter the team name : ");
                String teamName = scanner.next();
                int i = 0;
                while (i < formula.size()) {
                    if (teamName.equals(formula.get(i).getDriverTeam())) {
                        formula.remove(i);
                        System.out.println("** Team successfully removed **");
                        isThere = true;
                    }
                    i++;
                }
                if (!isThere) {
                    System.out.println("Team doesn't exist");
                    isThere = true;
                }
            } while (!isThere);
        }
        scanner.nextLine();
        System.out.println();
    }

    @Override
    public void changeDetail() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("---------------------Change driver team-------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");

        boolean isThere = false;
        if (!isThere) {
            do {
                System.out.println("Enter the team name : ");
                String teamName = scanner.next();
                for (Formula1Driver formula1Driver : formula) {
                    if (teamName.equals(formula1Driver.getDriverTeam())) {
                        isThere = true;
                    }
                }
                if (isThere) {
                    System.out.println("Enter driver name : ");
                    String name = scanner.next();
                    System.out.println("Enter the driver's location : ");
                    String location = scanner.next();

                    Formula1Driver driver = new Formula1Driver(name, location, teamName);
                    formula.add(driver);
                    System.out.println("Team successfully added.");
                } else {
                    System.out.println("The team you selected is not existing.");
                    break;
                }
            } while (!isThere);
        }
        scanner.nextLine();
        System.out.println();
    }

    @Override
    public void displayDriver() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------Display the formula 1 driver statistics-------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");
        race.stream().map(raceInfo -> raceInfo.getRaceDate() + " - "
                + raceInfo.getRaceDriver() + " - "
                + raceInfo.getRacePosition()).forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void displayStatistics() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("---------------Display all the formula 1 drivers----------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");

        ArrayList<Formula1Driver> sortedDrivers = new ArrayList<>();
        sortedDrivers = formula;
        bubbleSort(sortedDrivers, formula.size());

        System.out.printf("%-19s%-20s%-20s%-20s%-22s%-22s%-22s%-29s\n","Driver's Team ","Driver's Name","Driver's Location","First Places","Second Places","Third Places","Driver's Points","No of Races");


        for (Formula1Driver driver : sortedDrivers) {
            System.out.printf("%-19s%-20s%-20s%-20s%-22s%-22s%-22s%-29s\n",
                    driver.getDriverTeam(),
                    driver.getDriverName(),
                    driver.getDriverLocation(),
                    driver.getFirstPlace(),
                    driver.getSecondPlace(),
                    driver.getThirdPlace(),
                    driver.getDriverPoints(),
                    driver.getDriverRaces());
        }

        System.out.println();
        System.out.println("Do you want to return to the main menu? (Y,y): ");
        String choice = scanner.next();
        switch (choice) {
            case "":
                break;
        }
        System.out.println();
    }

    @Override
    public void addData() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("-----------------------Add a race data--------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");
        boolean isThere = false;
        if (!isThere) {
            do {
                System.out.println("Enter the race date (DD/MM/YYYY)");
                String raceDate = scanner.next();
                for (RaceInfo raceInfo : race) {
                    if (raceDate.equals(raceInfo.getRaceDate())) {
                        System.out.println("The race you entered already exist.");
                        isThere = true;
                    }
                }
                if (!isThere) {
                    boolean teamIsThere = true;
                    ArrayList<String> raceDriverData = new ArrayList<>();
                    ArrayList<Integer> raceDriverPosition = new ArrayList<>();
                    while (teamIsThere) {
                        System.out.println("Enter the team name : ");
                        String teamName = scanner.next();
                        for (Formula1Driver driver : formula) {
                            if (teamName.equals(driver.getDriverTeam())) {
                                teamIsThere = true;
                            }
                        }

                        if (teamIsThere) {
                            raceDriverData.add(teamName);

                            System.out.println("Enter the team position : ");
                            int position = Integer.parseInt(scanner.next());
                            raceDriverPosition.add(position);
                            IntStream.range(0, formula.size()).filter(i -> teamName.equals(formula.get(i).getDriverTeam())).forEach(i -> formula.get(i).setResults(position));

                            System.out.println("Driver details successfully added! \nDo you want to add another driver (Y/N)");
                            String choice = scanner.next();
                            if (choice.equalsIgnoreCase("N")) {
                                teamIsThere = false;
                            }
                            RaceInfo raceData = new RaceInfo(raceDate, raceDriverData, raceDriverPosition);
                            System.out.println();
                            race.add(raceData);
                            isThere = true;
                        } else {
                            System.out.println("The team you selected doesn't exist.");
                        }
                    }
                }
            } while (!isThere);
        }
        System.out.println();
    }



    @Override
    public void exit() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------------------------Exit------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("Thank you for using the application. Have a great day!");
        System.exit(0);
    }

    private ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> event;
        event = new ArrayList<Integer>();
        stringArray.forEach(stringValue -> {
            try {
                event.add(Integer.parseInt(stringValue));
            } catch (NumberFormatException nfe) {
                System.out.println("Couldn't pass " + nfe);
            }
        });
        return event;
    }

    static void bubbleSort(ArrayList<Formula1Driver> array, int n) {
        switch (n) {
            case 1:
                return;
        }
        IntStream.range(0, n - 1).filter(i -> array.get(i).getDriverPoints() < array.get(i + 1).getDriverPoints()).forEach(i -> {
            Formula1Driver actingArray  = array.get(i);
            array.set(i, array.get(i + 1));
            array.set(i + 1, actingArray );
        });
        bubbleSort(array, n - 1);
    }
}