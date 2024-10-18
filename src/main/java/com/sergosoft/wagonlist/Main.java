package com.sergosoft.wagonlist;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;
import com.sergosoft.railwaymanager.railwaycar.passenger.ComfortType;
import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create and Add Railway Cars
        System.out.println("=== Create and Add Railway Cars ===");

        RailwayCarList railwayCarList = new RailwayCarList();

        // Create several PassengerRailwayCar objects
        PassengerRailwayCar car1 = new PassengerRailwayCar(20, 3, 200, 30, 10000f, 120, ComfortType.PLATSKART);
        PassengerRailwayCar car2 = new PassengerRailwayCar(25, 4, 220, 25, 12000f, 130, ComfortType.LUX);
        PassengerRailwayCar car3 = new PassengerRailwayCar(22, 3, 210, 28, 11000f, 140, ComfortType.COUPE);

        // Add railway cars to the list
        railwayCarList.add(car1);
        railwayCarList.add(car2);
        railwayCarList.add(car3);

        System.out.println("Added 3 railway cars.");

        // Print the list size
        System.out.println("Size of RailwayCarList: " + railwayCarList.size());
        System.out.println("---------------------------------------------\n");

        // Access and Modify Railway Cars
        System.out.println("=== Access and Modify Railway Cars ===");

        // Get elements by index
        System.out.println("First railway car: " + railwayCarList.get(0));
        System.out.println("Second railway car: " + railwayCarList.get(1));

        // Add an element at a specific index
        PassengerRailwayCar car4 = new PassengerRailwayCar(23, 3, 215, 27, 11500f, 135, ComfortType.COUPE);
        railwayCarList.add(1, car4); // Add car4 at index 1
        System.out.println("Added new car at index 1: " + railwayCarList.get(1));

        // Remove element by index
        PassengerRailwayCar removedCar = (PassengerRailwayCar) railwayCarList.remove(2); // Remove car at index 2
        System.out.println("Removed car at index 2: " + removedCar);

        // Check if a specific car exists in the list
        System.out.println("Does the list contain car1? " + railwayCarList.contains(car1));

        // Find the index of an element
        System.out.println("Index of car4: " + railwayCarList.indexOf(car4));

        // Print the list size after operations
        System.out.println("Size of RailwayCarList after operations: " + railwayCarList.size());
        System.out.println("---------------------------------------------\n");

        // Add Collection of Railway Cars
        System.out.println("=== Add Collection of Railway Cars ===");

        // Add a collection of railway cars to the list
        PassengerRailwayCar car5 = new PassengerRailwayCar(24, 3, 225, 29, 12500f, 150, ComfortType.LUX);
        PassengerRailwayCar car6 = new PassengerRailwayCar(19, 2, 190, 35, 10500f, 100, ComfortType.COUPE);
        List<PassengerRailwayCar> additionalCars = Arrays.asList(car5, car6);
        railwayCarList.addAll(additionalCars);

        System.out.println("Added 2 more cars to the list.");
        System.out.println("---------------------------------------------\n");

        // Display All Cars in the List
        System.out.println("=== Display All Cars in the List ===");
        System.out.println("List of all railway cars:");
        for (RailwayCar car : railwayCarList) {
            System.out.println(car);
        }
        System.out.println("---------------------------------------------\n");

        // Sublist Example
        System.out.println("=== Sublist Example ===");

        System.out.println("Sublist (from index 1 to 3):");
        List<RailwayCar> sublist = railwayCarList.subList(1, 3);
        for (RailwayCar car : sublist) {
            System.out.println(car);
        }
        System.out.println("---------------------------------------------\n");

        // Convert List to Array
        System.out.println("=== Convert List to Array ===");

        PassengerRailwayCar[] carArray = railwayCarList.toArray(new PassengerRailwayCar[0]);
        System.out.println("Array of railway cars:");
        for (PassengerRailwayCar car : carArray) {
            System.out.println(car);
        }
        System.out.println("---------------------------------------------\n");

        // Clear the List
        System.out.println("=== Clear the List ===");

        railwayCarList.clear();
        System.out.println("Size of RailwayCarList after clearing: " + railwayCarList.size());
    }
}
