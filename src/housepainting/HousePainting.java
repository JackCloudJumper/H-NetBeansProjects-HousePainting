/*
 * Project: House Painting
 * Programmer: Gregory Lee Wo
 * Date: Feb 13 2020
 * Program: HousePainting.java
 * Description: To input the cost of paint and area to paint and output the
 * total cost of the project
 */
package housepainting;

import java.util.Scanner;
import java.text.*;

public class HousePainting {
    
    public static void main(String[] args) {
        
        Scanner scanN = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        
        String yn;
        double area, pcost, ptcost, lcost;
        
        do{//Do while loop if the user wants to run the program again
            System.out.println("How many square feet do you need to paint?");
            area = scanN.nextDouble();
            System.out.println("What is the cost per gallon of paint?");
            pcost = scanN.nextDouble();
            
            /*Send the area and price per gallon to the method paintcost, 
            return total paint cost*/
            ptcost = paintcost(area, pcost);
            //Send the area to the method labourcost, return total paint cost
            lcost = labourcost(area);
            /*Send the labour cost and total paint cost to the method recipt 
            to print out a recipt for the user*/
            recipt(lcost, ptcost);
            
            //Asks the user if they want to re run the code
            System.out.println("Would you like to calculate the cost of "
                    + "another job? (Y/N)");
            yn = scanS.nextLine();
        }while(yn.equalsIgnoreCase("y"));
        
        System.out.println("Thank you for using our program.");
    }//End of main
    
    /*
    * paintcost
    * This method accepts two doubles, and calculates the total paint cost
    * @param pcost - the price per gallon of paint
    * @param area - the area of the house to be painted
    * @return totalpaintcost - the total price of the paint needed
    */
    public static double paintcost(double pcost, double area){
            double gpaint = area/115;
            double totalpaintcost = gpaint*pcost;
            return totalpaintcost;//Returns the total paint cost
    }//End paintcost
    
    /*
    * labourcost
    * This method accepts one double, and calculates the total labour cost
    * @param area - the area of the house to be painted
    * @return labourcost - the total price of the labour required
    */
    public static double labourcost(double area){
            double gpaint = area/115;
            double hours = gpaint*8;
            double lcost = hours*18;
            return lcost;//Returns the total labour cost for painting
    }//End labourcost
    
    /*
    * recipt
    * This method accepts two doubles, and prints a recipt with all costs
    * @param ptcost - the total paint cost
    * @param lcost - the total cost of labour
    */
    public static void recipt(double ptcost, double lcost){
            DecimalFormat moneys = new DecimalFormat("$0.00");
            //Format for printing the cost like money
            double tcost = ptcost+lcost;
            System.out.println("Total cost of paint: "+moneys.format(ptcost));
            System.out.println("Total cost of labout: "+moneys.format(lcost));
            System.out.println("Total cost overall "+moneys.format(tcost));
    }//End recipt
}//End class