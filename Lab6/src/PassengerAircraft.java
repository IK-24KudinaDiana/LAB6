/**
 * Пасажирський літак.
 */
class PassengerAircraft extends Aircraft {
    private int capacity;

    public PassengerAircraft(String model, double fuelConsumption, double range, int capacity) {
        super(model, fuelConsumption, range);
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public double getCargoCapacity() {
        return 0; // Пасажирський літак не перевозить вантажі.
    }
}