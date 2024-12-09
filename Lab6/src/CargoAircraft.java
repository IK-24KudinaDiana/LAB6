/**
 * Вантажний літак.
 */
class CargoAircraft extends Aircraft {
    private double cargoCapacity;

    public CargoAircraft(String model, double fuelConsumption, double range, double cargoCapacity) {
        super(model, fuelConsumption, range);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public int getCapacity() {
        return 0; // Вантажний літак не перевозить пасажирів.
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }
}