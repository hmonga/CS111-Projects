public class Car{
   private double gas; 
   private int mileage; 
   private String color; 
   private int numDoors; 
   
   public Car(double gas, int mileage, String color, int numDoors){
    this.gas = gas; 
    this.mileage = mileage; 
    this.color = color; 
    this.numDoors = numDoors; 
    }

    public double getGas(){
    return gas;
    }
    
    public int getMileage(){
    return mileage;
    }

    public String getColor(){
    return color; 
    }

    public int getNumDoors(){
    return numDoors; 
    }

    public void fillGas(int gallonsAdded){
        if(gas + gallonsAdded > 1)
            System.out.println("Error");

    gas +=  gallonsAdded; 
    }

    public void goForDrive(int milesDriven){
    mileage += milesDriven; 
    gas -= (0.01 * milesDriven); 
    }

    public static void main(String[] args){
        Car c = new Car(1, 2000, "Blue", 4); 
        System.out.println(c.getGas());  
        c.goForDrive(20); 
        System.out.println(c.getGas());  
    }
}

