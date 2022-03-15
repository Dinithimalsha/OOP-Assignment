public class Formula1Driver extends Driver implements java.io.Serializable{

    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int driverPoints;
    private int driverRaces;

    public Formula1Driver (String driverName, String driverLocation, String driverTeam) {
        super (driverName, driverLocation, driverTeam);
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.driverPoints = 0;
        this.driverRaces = 0;
    }

    public Formula1Driver (String driverName, String driverLocation, String driverTeam, int firstPlace, int secondPlace, int thirdPlace, int driverPoints, int driverRaces) {
        super (driverName, driverLocation, driverTeam);
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
        this.driverPoints = driverPoints;
        this.driverRaces = driverRaces;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getDriverPoints() {
        return driverPoints;
    }

    public int getDriverRaces() {
        return driverRaces;
    }

    public void setDriverRaces(int driverRaces) {
        this.driverRaces = driverRaces;
    }

    public void setResults(int position) {
        switch (position) {
            case 1 -> {
                this.driverPoints += 25;
                this.firstPlace += 1;
                this.driverRaces += 1;
            }
            case 2 -> {
                this.driverPoints += 18;
                this.secondPlace += 1;
                this.driverRaces += 1;
            }
            case 3 -> {
                this.driverPoints += 15;
                this.thirdPlace += 1;
                this.driverRaces += 1;
            }
            case 4 -> {
                this.driverPoints += 12;
                this.driverRaces += 1;
            }
            case 5 -> {
                this.driverPoints += 10;
                this.driverRaces += 1;
            }
            case 6 -> {
                this.driverPoints += 8;
                this.driverRaces += 1;
            }
            case 7 -> {
                this.driverPoints += 6;
                this.driverRaces += 1;
            }
            case 8 -> {
                this.driverPoints += 4;
                this.driverRaces += 1;
            }
            case 9 -> {
                this.driverPoints += 2;
                this.driverRaces += 1;
            }
            case 10 -> {
                this.driverPoints += 1;
                this.driverRaces += 1;
            }
            case 0 -> {
                this.driverPoints += 0;
                this.driverRaces += 0;
            }
            default -> {
                this.driverPoints += 0;
                this.driverRaces += 1;
            }
        }
    }

}
