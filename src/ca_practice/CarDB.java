package ca_practice;

import java.awt.*;

public class CarDB {
    Car[] cars = new Car[9];
    Double[] total_cost;
    int i = 0;

    public void addCar(String make, String model, Double purchase_price, Double shipping_cost, char port, Double selling_price){
        Car car = new Car(make, model, purchase_price, shipping_cost, port, selling_price);
        cars[i] = car;
        i++;
    }

    public void displayList(){
        System.out.printf("%s%n", "CARS");
        for (int i = 0; i < cars.length; i++){
            System.out.printf("No: %d |Make: %-25s |Model: %-25s |Purchase price: €%-25.2f |Shipping cost: €%-25.2f |Port: %-25s |Selling price: €%-25.2f%n",
                    i+1, cars[i].getMake(), cars[i].getModel(), cars[i].getPurchase_price(), cars[i].getShipping_cost(), cars[i].getPort(), cars[i].getSelling_price());
        }

    }

    public void calcMostExpensive() {
        int counter = 0;
        double highest_cost = cars[0].getSelling_price();
        for (Car car : cars) {
            if (car.getSelling_price() > highest_cost) {
                highest_cost = cars[counter].getSelling_price();
            }
            counter++;
        }

        System.out.println("Most expensive cars");
        for(Car car: cars){
            if (car.getSelling_price() == highest_cost){
                System.out.printf("%-25s at €%.2f%n", car.getModel(), car.getSelling_price());
            }
        }
    }

    public void calcImportDuty(){

        final double VAT = 0.23;
        final double BROKER_FEE = 120.00;
        double port_duty_pc = 0;
        double unloading_fee = 0;
        double port_duty_cost;
        double vat_cost = 0;
        double import_cost = 0;
        double total_cost_car = 0;
        total_cost = new Double[cars.length];

        int counter = 0;

        System.out.printf("%-25s %-25s %-25s %-25s%n", "Model", "Cost", "Import cost", "Total cost");

         for (Car car: cars){
            if (car.getPort().equals("Osaka")){
                port_duty_pc = 0.10;
                unloading_fee = 100.00;
            } else if (car.getPort().equals("Tokyo")){
                port_duty_pc = 0.15;
                unloading_fee = 150.00;
            }

            port_duty_cost = (car.getPurchase_price() + car.getShipping_cost()) * port_duty_pc;
            vat_cost = (car.getPurchase_price() + car.getShipping_cost() + port_duty_cost) * VAT;
            import_cost = (port_duty_cost + vat_cost + unloading_fee + BROKER_FEE);
            total_cost_car = car.getPurchase_price() + car.getShipping_cost() + import_cost;

            total_cost[counter] = total_cost_car;

             System.out.printf("%-25s €%-25.2f €%-25.2f €%-25.2f%n", car.getModel(), car.getPurchase_price(), import_cost, total_cost_car);

             counter++;
        }
     }
}
