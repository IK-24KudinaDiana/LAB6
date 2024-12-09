import java.util.ArrayList;

/**
 * Клас для тестування роботи типізованої колекції LinkedListAircraft.
 */
public class TestLinkedListAircraft {
    public static void main(String[] args) {
        // Створення типізованої колекції на основі LinkedListAircraft
        LinkedListAircraft<Aircraft> aircraftList = new LinkedListAircraft<>();

        // Додавання об'єктів літаків до колекції
        PassengerAircraft passengerAircraft = new PassengerAircraft("Boeing 737", 3.5, 5000, 180);
        CargoAircraft cargoAircraft = new CargoAircraft("Antonov AN-124", 5.2, 4500, 120000);
        MilitaryAircraft militaryAircraft = new MilitaryAircraft("F-16", 6.0, 2500, 1);

        aircraftList.add(passengerAircraft); // Додавання пасажирського літака
        aircraftList.add(cargoAircraft);    // Додавання вантажного літака
        aircraftList.add(militaryAircraft); // Додавання військового літака

        // Перевірка розміру списку
        System.out.println("Розмір списку: " + aircraftList.size());

        // Перевірка, чи міститься конкретний літак у списку
        System.out.println("Містить Boeing 737? " + aircraftList.contains(passengerAircraft));

        // Виведення всіх літаків у списку
        System.out.println("\nВміст списку:");
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.getModel() + " - Дальність: " + aircraft.getRange() + " км");
        }

        // Видалення літака зі списку
        aircraftList.remove(cargoAircraft);
        System.out.println("\nПісля видалення Antonov AN-124:");

        // Повторний вивід вмісту списку
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.getModel() + " - Дальність: " + aircraft.getRange() + " км");
        }

        // Перетворення колекції у масив
        Aircraft[] aircraftArray = aircraftList.toArray(new Aircraft[0]);
        System.out.println("\nВміст у масиві:");
        for (Aircraft aircraft : aircraftArray) {
            System.out.println(aircraft.getModel());
        }

        // Отримання літака за індексом
        System.out.println("\nЛітак за індексом 0: " + aircraftList.get(0).getModel());

        // Тестування конструктора з колекцією
        ArrayList<Aircraft> aircraftCollection = new ArrayList<>();
        aircraftCollection.add(passengerAircraft); // Додавання літака до стандартної колекції
        aircraftCollection.add(militaryAircraft);  // Додавання іншого літака до стандартної колекції

        // Створення нового списку на основі існуючої колекції
        LinkedListAircraft<Aircraft> newAircraftList = new LinkedListAircraft<>(aircraftCollection);

        // Вивід розміру нового списку
        System.out.println("Розмір нового списку: " + newAircraftList.size());
    }
}
