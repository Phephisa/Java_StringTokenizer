public class Question2Class {

    //instance variables
    private String make, model;
    private double time;
    private int year;

    //default constructor
    public Question2Class() {
        this.make = "";
        this.model = "";
        this.time = 0.0;
        this.year = 0;
    }

    //parameterised constructor
    public Question2Class(String make, String model, int year, double time) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.time = time;
    }

    //getters
    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public double getTime(){
        return this.time;
    }
    public int getYear(){
        return this.year;
    }

    //setters
    public void setMake(String make){
        this.make = make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setRegNo(double time){
        this.time = time;
    }
    public void setYear(int year){
        this.year = year;
    }

    //for printing object
    public String toString(){
        return "Make: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year + "\nTime: " + this.time;
    }
}
