import java.util.ArrayList;

public class RaceInfo implements java.io.Serializable{
    private String raceDate;
    private ArrayList<String> raceDriver = new ArrayList<>();
    private ArrayList<Integer> racePosition = new ArrayList<>();

    public RaceInfo(String raceDate, ArrayList<String> raceDriver, ArrayList<Integer> racePosition) {
        this.raceDate = raceDate;
        this.raceDriver = raceDriver;
        this.racePosition = racePosition;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public ArrayList<String> getRaceDriver() {
        return raceDriver;
    }

    public void setRaceDriver(ArrayList<String> raceDriver) {
        this.raceDriver = raceDriver;
    }

    public ArrayList<Integer> getRacePosition() {
        return racePosition;
    }

    public void setRacePosition(ArrayList<Integer> racePosition) {
        this.racePosition = racePosition;
    }
}
