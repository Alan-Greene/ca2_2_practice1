package ca_practice;

public class Car {
    private String make, model;
    private Double purchase_price, shipping_cost, selling_price;
    private char port;

    public Car(String make, String model, Double purchase_price, Double shipping_cost, char port, Double selling_price){
        this.make = make;
        this.model = model;
        this.purchase_price = purchase_price;
        this.shipping_cost = shipping_cost;
        this.selling_price = selling_price;
        this.port = port;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public Double getShipping_cost() {
        return shipping_cost;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public String getPort() {
        String port;

        if (this.port == 'o' || this.port == 'O'){
            port = "Osaka";
        } else if (this.port == 't' || this.port == 'T') {
            port = "Tokyo";
        } else {
            port = "Error";
        }
        return port;
    }
}
