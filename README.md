# LAB6

This project implements a program that simulates the management of an airline fleet. The program allows you to create different types of aircraft (passenger, cargo, and military), and manage a fleet within an airline. It provides functionality to add aircraft, calculate total capacities, sort aircraft by range, and find aircraft based on fuel consumption.

## Content

- [Requirements](#Requirements)
- [Installation](#Installation)
- [Startup](#Startup)
- [Using](#Using)
- [Examples](#Examples)

## Requirements

- JDK 17

## Installation

1. Clone the repository:
   
    ```bash
    git clone https://github.com/IK-24KudinaDiana/LAB6.git
    ```

2. Go to the project directory:
   
    ```bash
    cd LAB6
    ```

## Startup

- Compile and run the program from the command line:

    ```bash
    javac TestLinkedListAircraft.java
    java TestLinkedListAircraft
    ```

## Using

The program simulates an airline that manages a fleet of aircraft. 

### Input
- You can create different types of aircraft (PassengerAircraft, CargoAircraft, MilitaryAircraft) and add them to an airline's fleet.
- The user can input aircraft details like model, fuel consumption, range, and capacity (depending on the type of aircraft).

### Output
- The program allows you to display the fleet of aircraft in the airline, sorted by their range.
- Calculate the total capacity of all aircraft and the total cargo capacity in the fleet.
- Find aircraft that fall within a specified fuel consumption range.

## Examples

Example of program execution:

```bash
Розмір списку: 3
Містить Boeing 737? true

Вміст списку:
Boeing 737 - Дальність: 5000.0 км
Antonov AN-124 - Дальність: 4500.0 км
F-16 - Дальність: 2500.0 км

Після видалення Antonov AN-124:
Boeing 737 - Дальність: 5000.0 км
F-16 - Дальність: 2500.0 км

Вміст у масиві:
Boeing 737
F-16

Літак за індексом 0: Boeing 737
Розмір нового списку: 2
