package singleneuronassignment1;

/**
 * CSC481
 * Assignment 1
 */
public class Neuron {
    //set the weights 
    private double weight1 = 0, weight2 = 0, bias = 0;
    private double threshold;

    //the threshold for this assignment is 0
    public Neuron(double threshold){
        this.threshold = threshold;
        System.out.println("Initial Weights: "+ weight1 +", "+weight2);
   }
    
    public int fire(double input1, double input2){
        double total = input1*weight1 + input2*weight2 + bias;
        if(total>=threshold)
            return 1; //FIRE!!!!
        else
            return 0;//don't fire 
    }

    public void changeWeight1(double inWeight){
        weight1 = inWeight + weight1;
    }

    public void changeWeight2(double inWeight){
        weight2 = inWeight+weight2;
    }

    public void changeBias(double inWeight){
        bias = inWeight+bias;
    }

    public double getWeight1(){
        return weight1;
    }

    public double getWeight2(){
        return weight2;
    }

    public double getBias(){
        return bias;
    }
}
