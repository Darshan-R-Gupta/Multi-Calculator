import Converters.convert;
import Financial.*;
import Expression.*;
import Mathematics.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
//        convert c = new convert();
//        Expression e = new Expression();
//        Financial_calculators f = new Financial_calculators();
//        Menu m = new Menu();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.flush();
            System.out.println("----------------------------------");
            System.out.println("Choose: ");
            System.out.println("1. Expression Calculation");
            System.out.println("2. Digital Converters");
            System.out.println("3. Financial Calculators");
            System.out.println("4. Other Math formulae");
            System.out.println("5. Exit");
            System.out.println("----------------------------------");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            try {
                switch(choice){
                    case 1: {
                        Expression.start();
                        break;
                    }
                    case 2:{
                        convert.start();
                        break;
                    }
                    case 3:{
                        Financial_calculators.start();
                        break;
                    }
                    case 4:{
                        Menu.start();
                        break;
                    }
                    case 5:{
                        break;
                    }
                    default:{
                        System.out.println("Invalid Choice! Please enter between 1-5");
                        break;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Oops :( Something went wrong, Please try again");
            }
        }while(choice != 5);

    }
}
