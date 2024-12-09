import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Узагальнений клас для літака.
 */
abstract class Aircraft {
    private String model;
    private double fuelConsumption; // літрів на 100 км
    private double range; // км

    public Aircraft(String model, double fuelConsumption, double range) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.range = range;
    }

    public String getModel() {
        return model;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getRange() {
        return range;
    }

    public abstract int getCapacity();

    public abstract double getCargoCapacity();
}