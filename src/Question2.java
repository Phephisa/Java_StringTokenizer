import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;
/*Phephisa Methula 18000797*/

public class Question2 {
    public static void main(String[] args) {

        //Array List to store Question2Class objects
        ArrayList<Question2Class> cars = new ArrayList<Question2Class>();

        try{
            //initialise file object
            File lapTimes = new File("E:/BIUST Software Engineering L200/Lab6/src/laps.txt");
            //initialise Scanner
            Scanner scan = new Scanner(lapTimes);

            //read through file, ignore first 2 lines
            //line variable keeps track of first two lines of input so we can ignore them
            int line = 1;
            while(scan.hasNextLine()){

                //skip first and second lines
                if ((line == 1) || (line==2)){
                    //consume the lines, but do nothing. This makes sure that the scan.hasNextLine() used in the loop iterates to the next line
                    scan.nextLine();
                    //increment variable
                    line++;
                    continue;
                }

                //store values using string tokeniser separated by spaces
                StringTokenizer details = new StringTokenizer(scan.nextLine(), " ");

                //array to store values from string tokeniser

                ArrayList<String> detailsArray = new ArrayList<String>();

                //loop through string tokeniser and add details to
                while(details.hasMoreTokens()){
                    //add detail to details array
                    detailsArray.add(details.nextToken());
                }

                //initialise Question2Class object by sending parameters: make, model, year, time
                Question2Class car = new Question2Class(detailsArray.get(0), detailsArray.get(1), Integer.parseInt(detailsArray.get(2)), Double.parseDouble(detailsArray.get(3)));

                //add car object to list of car objects
                cars.add(car);

                System.out.println("\n");

            }

        }catch(IOException ex){
            //print exception details if caught
            System.out.println(ex.getMessage() + ex.getStackTrace());
        }

        //variable to hold sum of all times, fastest speed and oldest year
        int sumTime = 0;
        double fastest = cars.get(0).getTime();
        int oldest = cars.get(0).getYear();

        //initialise indexes of the fastest and oldest car object as 0, i.e the first in the cars array list
        int fastestIndex = 0;
        int oldestIndex = 0;

        //loop through cars array list and make calculations
        int index =0;
        for (Question2Class car: cars){

            //check is current car is older than recorded oldest
            if (car.getYear() < oldest){
                //if older, update cars array list index to the index of the current car
                oldestIndex = index;
                //update oldest value to new oldest
                oldest = car.getYear();
            }

            //check if current car is faster than recorded fastest
            if (car.getTime() < fastest){
                //if faster, update index of fastest car to current car's inde
                fastestIndex = index;
                //update oldest value to new oldest
                fastest = car.getTime();
            }

            //add current car's time to the sum
            sumTime += car.getTime();

            //increment index for next object
            index++;
        }

        //calculate avergae time
        double avgTime = sumTime / cars.size();

        //Print results
        System.out.println("\nOldest Car Details:");
        System.out.println(cars.get(oldestIndex).toString());

        System.out.println("\nFastest Car Details:");
        System.out.println(cars.get(fastestIndex).toString());

        System.out.print("\nAverage Time is: " + avgTime);

    }
}
