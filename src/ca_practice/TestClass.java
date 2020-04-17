package ca_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    public static ArrayList<Car> getCarsFromFile(String path){
        ArrayList<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            for (String line; (line = reader.readLine()) != null;) {
                String[] values = line.split(",");
                cars.add(new Car(values[0], values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]), (values[4].charAt(0)), Double.parseDouble(values[5])));
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(-2);
        }

        return cars;
    }

    public static void menu(){
        System.out.println("Please press 1 to display the list of cars");
        System.out.println("Please press 2 if you want to calculate the most expensive car(s)");
        System.out.println("Please press 3 to show the import duties");
        System.out.println("Please press 4 to quit");
    }

    public static int menuInput(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void main(String[] args) {

        ArrayList<Car> cars = getCarsFromFile("files/cars.txt");

        CarDB car_col = new CarDB();

        for (Car car: cars){
            car_col.addCar(car.getMake(), car.getModel(), car.getPurchase_price(), car.getShipping_cost(), car.getPort().charAt(0), car.getSelling_price());
        }

        while (true){
            menu();
            int user_choice = menuInput();

            switch (user_choice){
                case 1:{
                    try {
                        car_col.displayList();
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                }
                case 2:{
                    car_col.calcMostExpensive();
                    break;
                }
                case 3:{
                    car_col.calcImportDuty();
                    break;
                }
                case 4:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Your input must be between 1 and 4.");
                    break;
                }
            }
        }

    }
}
