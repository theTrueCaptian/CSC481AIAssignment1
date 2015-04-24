/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package singleneuronassignment1;

import java.util.Arrays;

/**
 *
 * Maeda Hanafi
 * CSC481
 * Assignment 1
 */
public class Network {
    Neuron neuron;
    double learningConstant = 0.001;

    public static double XOR_INPUT[][] = { { 0.0, 0.0 },
                                            { 1.0, 0.0 },
                                            { 0.0, 1.0 },
                                            { 1.0, 1.0 } };
    public static double XOR_IDEAL[] = { 0.0, 1.0, 1.0, 0.0 };
    
    public static double OR_INPUT[][] = { { 0.0, 0.0 },
                                            { 1.0, 0.0 },
                                            { 0.0, 1.0 },
                                            { 1.0, 1.0 } };
    public static double OR_IDEAL[] = { 0.0, 1.0, 1.0, 1.0};

    public static double AND_INPUT[][] = { { 0.0, 0.0 },
                                            { 1.0, 0.0 },
                                            { 0.0, 1.0 },
                                            { 1.0, 1.0 } };
    public static double AND_IDEAL[] = {  0.0 , 0.0, 0.0, 1.0};

    public Network(){
        neuron = new Neuron(0);
        System.out.println("AND TRAINING **************************************************************************");
        train(AND_INPUT, AND_IDEAL);

        neuron = new Neuron(0);
        System.out.println("OR TRAINING **************************************************************************");
        train(OR_INPUT, OR_IDEAL);

        neuron = new Neuron(0);
        System.out.println("XOR TRAINING **************************************************************************");
        train(XOR_INPUT, XOR_IDEAL);
    }
 
    public static void main(String[] args) {
        new Network();
    }

    public void train(double arrInput[][], double arrIdeal[]){
        int epoch = 0;
        double ACTUAL[] = new double[4];
        //loop until the network leaerns
        while(epoch<10){
            System.out.println("TRAINING SESSION--------------------------------------------------------------");
            //iterate through all possible inputs
            for(int i=0; i<arrInput.length; i++){
                ACTUAL[i] = neuron.fire(arrInput[i][0], arrInput[i][1]);
                double changeWeight1 = calculateChangeWeight(arrIdeal[i], ACTUAL[i], arrInput[i][0]);
                double changeWeight2 = calculateChangeWeight(arrIdeal[i], ACTUAL[i], arrInput[i][1]);
                double changeBias = calculateChangeWeight(arrIdeal[i], ACTUAL[i], 1);
                System.out.println("inputs:"+arrInput[i][0]+", "+arrInput[i][1]+"; output:"+ACTUAL[i]+
                        "; changeW1:"+changeWeight1+"; weight:"+neuron.getWeight1()+
                        "; changeW2:"+changeWeight2+"; weight:"+neuron.getWeight2()+
                        "; changeBias:"+changeBias+"; bias:"+neuron.getBias());
                neuron.changeBias(changeBias);
                neuron.changeWeight1(changeWeight1);
                neuron.changeWeight2(changeWeight2);

            }
            if(equals(arrIdeal, ACTUAL)){
                System.out.println("LEARNED!!!!");
                break;
            }
            epoch++;
        }

    }
    public boolean equals(double arr1[], double arr2[]){
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    public double calculateChangeWeight(double desiredOutput, double actualOutput, double input){
        return (learningConstant * (desiredOutput - actualOutput) * input);
    }
}
