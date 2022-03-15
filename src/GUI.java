import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import static javax.swing.BorderFactory.createEmptyBorder;

public class GUI extends JFrame implements Serializable{

    public ArrayList<Formula1Driver> drivers = new ArrayList<>();
    public ArrayList<RaceInfo> races = new ArrayList<>();


    public GUI(Formula1ChampionshipManager formula) {

        // start of the driver table
        drivers = formula.formula;

        JLabel fl = new JLabel("The Driver Table");
        fl.setFont(new Font("Arial", Font.PLAIN, 20));
        fl.setBounds(30, 10, 900, 40);
        add(fl);

        String[] driverColums; // Making the columns in the table
        driverColums = new String[]{"Team", "Name", "Location", "First Place", "Second Place", "Third Place", "Points", "No of Races"};
        DefaultTableModel DTM = new DefaultTableModel(driverColums, 0) {
            @Override
            public Class getColumnClass(int column) {
                return switch (column) {
                    case 0, 1, 2 -> String.class;
                    default -> Integer.class;
                };
            }
        };

        JTable driverTable = new JTable(DTM);
        driverTable.setEnabled(false);
        driverTable.setRowHeight(30);

        TableRowSorter<TableModel> TRS = new TableRowSorter<>(driverTable.getModel());
        driverTable.setRowSorter(TRS);

        JScrollPane sp1 = new JScrollPane(driverTable);  // scrollPane1 = sp1
        sp1.setBounds(10, 60, 860, 250);
        sp1.setBorder(createEmptyBorder());
        add(sp1);

        DTM.setRowCount(0);

        drivers.stream().map(driver -> new Object[]{driver.getDriverTeam(),
                driver.getDriverName(),
                driver.getDriverLocation(),
                driver.getFirstPlace(),
                driver.getSecondPlace(),
                driver.getThirdPlace(),
                driver.getDriverPoints(),
                driver.getDriverRaces()}).forEach(DTM::addRow);

        // The race table starts here
        races = formula.race;

        JLabel rl1 = new JLabel("The Races Table");
        rl1.setFont(new Font("Arial", Font.PLAIN, 20));
        rl1.setBounds(30, 300, 900, 40);
        add(rl1);

        String[] racesColumns;
        racesColumns = new String[]{"Date", "Name", "Positions"};
        DefaultTableModel racesTM = new DefaultTableModel(racesColumns, 0);

        JTable raceTable = new JTable(racesTM);
        raceTable.setEnabled(false);
        raceTable.setRowHeight(30);

        JScrollPane scrollPane2 = new JScrollPane(raceTable);
        scrollPane2.setBounds(10, 350, 860, 250);
        scrollPane2.setBorder(createEmptyBorder());
        add(scrollPane2);

        System.out.println(races);

        for (RaceInfo raceInfo : races) {
            Object[] race;
            race = new Object[]{raceInfo.getRaceDate(),
                    raceInfo.getRaceDriver(),
                    raceInfo.getRacePosition()};
            racesTM.addRow(race);
        }
    }
}
