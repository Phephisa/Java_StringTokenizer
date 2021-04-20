import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*Phephisa Methula 18000797 */




































public class Question1{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //create file too write to
        File file = new File(".E:/BIUST Software Engineering L200/Lab6/src/report.txt");

        try {
            //create file to write to. If already existing, deny request
            if (file.createNewFile()) {
                System.out.println("File created ");
            } else {
                System.out.println("it Exists");
            }


            FileWriter writer = new FileWriter(file);   //file writer
            writer.write("STUDENT REPORT");         //writing in first line

            //take in details and write to file
            System.out.print("Students name: ? ");
            writer.write("Student Name: \n" + input.nextLine());

            System.out.print("Student ID: ? ");
            writer.write("Student ID: \n" + input.nextLong());

            //consume overflow before taking department
            input.nextLine();
            System.out.print("Enter department: ");
            writer.write("Department: \n" + input.nextLine());

            //stars and academic performance hading
            //creating 60 stars
            writer.write("\n\n" + new String(new char[60]).replace("\0","*"));
            writer.write("ACADEMIC PERFORMANCE \n\n");


            //loop exits if user types "exit" for the module code
            do {

                //get module details
                System.out.print("\n\nEnter module code: ");
                String modC = input.nextLine();

                if (modC.equalsIgnoreCase("exit")) { //breaker function
                    break;
                }

                System.out.print("Enter module name: ");
                String mod_name = input.nextLine();

                System.out.print("Enter mark: ");
                double mark = input.nextDouble();
                input.nextLine(); //change to next line

               //aligning
                int n = 40 - mod_name.length();
                //String for spaces
                String blanks = new String(new char[n]);
                //replace null values
                blanks = blanks.replace("\0", " ");

                //write details to report
                writer.write("\n\n" +modC.toUpperCase() + "   " + mod_name + blanks + mark + "%");
            } while (true);

            //write sign-off
            writer.write("Remarks: ");

            //get comment about student, write it to the file
            System.out.println("Comments: ");
            writer.write("\n"+input.nextLine());


            writer.close();
            input.close(); //closing scanner and writer

        } catch (IOException ex) {
            System.out.println(ex.getMessage() + ex.getStackTrace());
        }

        System.out.println("Open document for results");

    }
}
