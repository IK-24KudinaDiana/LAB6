/**
 * Військовий літак.
 */
class MilitaryAircraft extends Aircraft {
    private int capacity;

    public MilitaryAircraft(String model, double fuelConsumption, double range, int capacity) {
        super(model, fuelConsumption, range);
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public double getCargoCapacity() {
        return 0;
    }
}