import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас Авіакомпанія.
 */
class Airline {
    private List<Aircraft> fleet;

    public Airline() {
        fleet = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        fleet.add(aircraft);
    }

    public int getTotalCapacity() {
        return fleet.stream().mapToInt(Aircraft::getCapacity).sum();
    }

    public double getTotalCargoCapacity() {
        return fleet.stream().mapToDouble(Aircraft::getCargoCapacity).sum();
    }

    public void sortAircraftByRange() {
        fleet.sort(Comparator.comparingDouble(Aircraft::getRange));
    }

    public List<Aircraft> findAircraftByFuelConsumption(double min, double max) {
        List<Aircraft> result = new ArrayList<>();
        for (Aircraft aircraft : fleet) {
            if (aircraft.getFuelConsumption() >= min && aircraft.getFuelConsumption() <= max) {
                result.add(aircraft);
            }
        }
        return result;
    }

    public void printFleet() {
        for (Aircraft aircraft : fleet) {
            System.out.println(aircraft.getModel() + " - " + aircraft.getRange() + " km");
        }
    }
}