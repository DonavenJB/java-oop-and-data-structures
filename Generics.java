
//Author: DOnaven Bruce
import java.util.Scanner;

public class Generics // Main class
{
  public Generics() {
    // Default constructor
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    City[] cities = new City[3]; // Array to store cities
    Employee[] employees = new Employee[3]; // Array to store employees

    // Collecting Employee1 information
    System.out.println("Collecting Employee1 Information");
    System.out.print("Please enter Employee1 name: \n");
    String nameOfEmployee1 = scanner.nextLine(); // Read employee1 name
    System.out.print("Please enter Employee1 age: \n");
    int ageOfEmployee1 = scanner.nextInt(); // Read employee1 age
    scanner.nextLine(); // Consume newline
    Employee employee1 = new Employee(nameOfEmployee1, ageOfEmployee1); // Create employee1 object
    employees[0] = employee1; // Store in array

    // Collecting Employee2 information
    System.out.println("\nCollecting Employee2 Information");
    System.out.print("Please enter Employee2 name: \n");
    String nameOfEmployee2 = scanner.nextLine(); // Read employee2 name
    System.out.print("Please enter Employee2 age: \n");
    int ageOfEmployee2 = scanner.nextInt(); // Read employee2 age
    scanner.nextLine(); // Consume newline
    Employee employee2 = new Employee(nameOfEmployee2, ageOfEmployee2); // Create employee2 object
    employees[1] = employee2; // Store in array

    // Collecting Employee3 information
    System.out.println("\nCollecting Employee3 Information");
    System.out.print("Please enter Employee3 name: \n");
    String nameOfEmployee3 = scanner.nextLine(); // Read employee3 name
    System.out.print("Please enter Employee3 age: \n");
    int ageOfEmployee3 = scanner.nextInt(); // Read employee3 age
    scanner.nextLine(); // Consume newline
    Employee employee3 = new Employee(nameOfEmployee3, ageOfEmployee3); // Create employee3 object
    employees[2] = employee3; // Store in array

    // Collecting City1 information
    System.out.println("\nCollecting City1 Information");
    System.out.print("Please enter City1 name: \n");
    String nameOfCity1 = scanner.nextLine(); // Read city1 name
    System.out.print("Please enter City1 population: \n");
    int populationOfCity1 = scanner.nextInt(); // Read city1 population
    scanner.nextLine(); // Consume newline
    City city1 = new City(nameOfCity1, populationOfCity1); // Create city1 object
    cities[0] = city1; // Store in array

    // Collecting City2 information
    System.out.println("\nCollecting City2 Information");
    System.out.print("Please enter City2 name: \n");
    String nameOfCity2 = scanner.nextLine(); // Read city2 name
    System.out.print("Please enter City2 population: \n");
    int populationOfCity2 = scanner.nextInt(); // Read city2 population
    scanner.nextLine(); // Consume newline
    City city2 = new City(nameOfCity2, populationOfCity2); // Create city2 object
    cities[1] = city2; // Store in array

    // Collecting City3 information
    System.out.println("\nCollecting City3 Information");
    System.out.print("Please enter City3 name: \n");
    String nameOfCity3 = scanner.nextLine(); // Read city3 name
    System.out.print("Please enter City3 population: \n");
    int populationOfCity3 = scanner.nextInt(); // Read city3 population
    scanner.nextLine(); // Consume newline
    City city3 = new City(nameOfCity3, populationOfCity3); // Create city3 object
    cities[2] = city3; // Store in array

    // Compare employees and cities
    HighestLowest<Employee> employeeComparison = new HighestLowest<>(employees); // Comparison helper for employees
    HighestLowest<City> cityComparison = new HighestLowest<>(cities); // Comparison helper for cities

    // Get highest and lowest employees and cities
    Employee oldestEmployee = employeeComparison.getHighest(); // Oldest employee
    Employee youngestEmployee = employeeComparison.getLowest(); // Youngest employee
    City cityWithHighestPopulation = cityComparison.getHighest(); // City with highest population
    City cityWithLowestPopulation = cityComparison.getLowest(); // City with lowest population

    // Display results
    System.out.println("\nThe oldest employee is: " + oldestEmployee.getNameOfEmployee());
    System.out.println("The youngest employee: " + youngestEmployee.getNameOfEmployee());

    System.out.println("\nThe city with highest population is: " + cityWithHighestPopulation.getNameOfCity());
    System.out.println("The city with lowest population is: " + cityWithLowestPopulation.getNameOfCity());

    scanner.close(); // Close scanner
  }
}

class HighestLowest<T extends Comparable<T>> {

  private T[] theArray = null; // Backing array

  public HighestLowest(T[] anArray) {
    this.theArray = anArray; // Store reference
  }

  public T getHighest() {
    T HighestElement = null; // Current best

    for (int index = 0; index < this.theArray.length; index++) {
      if (index == 0) {
        HighestElement = this.theArray[index]; // Seed with first element
      } else if (HighestElement.compareTo(this.theArray[index]) < 0) {
        HighestElement = this.theArray[index]; // Replace on greater value
      }
    }

    return HighestElement; // Final highest
  }

  public T getLowest() {
    T LowestElement = null; // Current best

    for (int index = 0; index < this.theArray.length; index++) {
      if (index == 0) {
        LowestElement = this.theArray[index]; // Seed with first element
      } else if (LowestElement.compareTo(this.theArray[index]) > 0) {
        LowestElement = this.theArray[index]; // Replace on smaller value
      }
    }

    return LowestElement; // Final lowest
  }
}

class Employee implements Comparable<Employee> {
  public String nameOfEmployee; // Employee name
  public int ageOfEmployee; // Employee age

  public Employee(String nameInput, int ageInput) {
    this.nameOfEmployee = nameInput; // Set name
    this.ageOfEmployee = ageInput; // Set age
  }

  public String getNameOfEmployee() {
    return nameOfEmployee; // Return name
  }

  @Override
  public int compareTo(Employee employeeToCompare) {
    // Compare by age
    if (this.ageOfEmployee < employeeToCompare.ageOfEmployee) {
      return -1; // Younger
    } else if (this.ageOfEmployee > employeeToCompare.ageOfEmployee) {
      return 1; // Older
    } else {
      return 0; // Same age
    }
  }
}

class City implements Comparable<City> {
  public String nameOfCity; // City name
  public int populationOfCity; // City population

  public City(String nameInput, int populationInput) {
    this.nameOfCity = nameInput; // Set name
    this.populationOfCity = populationInput; // Set population
  }

  public String getNameOfCity() {
    return nameOfCity; // Return name
  }

  @Override
  public int compareTo(City cityToCompare) {
    // Compare by population
    if (this.populationOfCity < cityToCompare.populationOfCity) {
      return -1; // Smaller population
    } else if (this.populationOfCity > cityToCompare.populationOfCity) {
      return 1; // Larger population
    } else {
      return 0; // Same population
    }
  }
}
