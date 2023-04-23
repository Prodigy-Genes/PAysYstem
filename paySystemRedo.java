import java.util.Scanner;
import java.io.*;

public class paySystemRedo {
public static void main(String[] args) {
final int numberofemployees=2;
Scanner read=new Scanner(System.in);
String[] SeniorStaff={"JOHN","ROSE","CYNTHIA","GEORGE","EMMANUEL","STEPHEN","ALFRED"};
String[] names0fstaff=new String[numberofemployees];
int[] hoursWorked=new int[numberofemployees];
int[] numberofchildren=new int[numberofemployees];
double[] allgrosspay=new double[numberofemployees];
double[] allexpenses=new double[numberofemployees];
double[] allnetpay=new double[numberofemployees];

double totalnetpay=0;
double totalexpenses=0;
double averagenetpay=0;
for(int i=0;i<numberofemployees;i++){
    System.out.print("ENTER NAME: ");
    names0fstaff[i]=read.next();
    System.out.print("\nENTER HOURS WORKED FOR "+names0fstaff[i]+": ");
    hoursWorked[i]=read.nextInt();
    for(String n_name:SeniorStaff){
        if(n_name==names0fstaff[i]){
            if(hoursWorked[i]>40){
                allgrosspay[i]=(hoursWorked[i]-40)*1.5*50+hoursWorked[i]*50;
            }
            else{
                allgrosspay[i]=hoursWorked[i]*50;
            }
        }
        else{
            if(hoursWorked[i]>40){
                allgrosspay[i]=0.25*((hoursWorked[i]-40)*1.5*50+hoursWorked[i]*50);
            }
            else{
                allgrosspay[i]=0.7*(hoursWorked[i])*50;
            }
        }
    }
    System.out.print("ENTER NUMBER OF CHILDREN FOR "+names0fstaff[i]+" : ");
    numberofchildren[i]=read.nextInt();
    if(numberofchildren[i]>3){
        allexpenses[i]=(0.15*allgrosspay[i])+(0.01*allgrosspay[i])+(0.03*allgrosspay[i])+((numberofchildren[i]-3)*1);
    }
    else{
        allexpenses[i]=(0.15*allgrosspay[i])+(0.01*allgrosspay[i])+(0.03*allgrosspay[i]);
    }
    allnetpay[i]=allgrosspay[i]-allexpenses[i];
    totalnetpay+=allnetpay[i];
    totalexpenses+=allexpenses[i];
}
averagenetpay=totalnetpay/2;

try{
PrintWriter writer = new PrintWriter("output");
        writer.println("BELOW ARE THE RESULTS OF THE PAYROLL SYSTEM:");
            writer.println("NAME\tHOURS WORKED\tGROSS PAY\tEXPENSES\tNET PAY");
    for (int i = 0; i < numberofemployees; i++) {
        writer.println(names0fstaff[i] + "\t" + hoursWorked[i] + "\t\t" + allgrosspay[i] + "\t" + allexpenses[i] + "\t" + allnetpay[i]);
    }

    writer.println("TOTAL NET PAY FOR ALL EMPLOYEES: $" + totalnetpay);
    writer.println("TOTAL EXPENSES FOR ALL EMPLOYEES: $" + totalexpenses);
    writer.println("AVERAGE NET PAY FOR ALL EMPLOYEES: $" + averagenetpay);

    writer.close();
}
catch(IOException e){
    System.out.println("Error Writing To Output File");
}
    read.close();
}



}    

