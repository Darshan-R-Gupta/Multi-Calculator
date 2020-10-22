package Financial;

import java.text.DecimalFormat;
import java.util.*;

public class Financial_calculators {
    public static void start() throws Exception{
        DecimalFormat df2 = new DecimalFormat("#.##");
        Scanner sc = new Scanner(System.in);
        int want = 0;
        do{
            System.out.flush();
            System.out.println("----------------------------------");
            System.out.println("Enter type of Calculator: ");
            System.out.println("1. Compound Interest");
            System.out.println("2. Post Tax Return");
            System.out.println("3. Inflation");
            System.out.println("4. Purchasing Power");
            System.out.println("5. Compounded Annual Growth Rate");
            System.out.println("6. Loan EMI");
            System.out.println("7. SIP");
            System.out.println("8. Back");
            System.out.println("9. Exit");
            System.out.println("----------------------------------");
            System.out.print("\nEnter your choice : ");
            want = sc.nextInt();
            switch (want) {
                case 1: {
                    System.out.print("Enter Principle Amount: ");
                    double p = sc.nextDouble();
                    System.out.print("Enter Annual interest rate: ");
                    double r = sc.nextDouble();
                    r = r / 100;
                    System.out.print("Enter number of years: ");
                    double t = sc.nextDouble();
                    System.out.print("Enter number of times the interest is compounded per year: ");
                    double n = sc.nextDouble();
                    System.out.println(df2.format(p * Math.pow((1 + (r / n)), n * t)));
                    break;
                }
                case 2: {
                    System.out.print("Interest rate: ");
                    double i = sc.nextDouble();
                    System.out.print("Tax rate: ");
                    double t = sc.nextDouble();
                    System.out.println(i - (i * t / 100));
                    break;
                }
                case 3: {
                    System.out.print("Present amount: ");
                    double p = sc.nextDouble();
                    System.out.print("Inflation rate: ");
                    double i = sc.nextDouble();
                    i = i / 100;
                    System.out.print("Number of years: ");
                    double t = sc.nextDouble();
                    System.out.println(df2.format(p * Math.pow(1 + i, t)));
                    break;
                }
                case 4: {
                    System.out.print("Present amount: ");
                    double p = sc.nextDouble();
                    System.out.print("Inflation rate: ");
                    double i = sc.nextDouble();
                    i = i / 100;
                    System.out.print("Number of years: ");
                    double t = sc.nextDouble();
                    System.out.println(df2.format(p / Math.pow(1 + i, t)));
                    break;
                }
                case 5: {
                    System.out.print("Enter investment's ending/maturity value: ");
                    double FV = sc.nextDouble();
                    System.out.print("Enter investment's beginning/opening value: ");
                    double PV = sc.nextDouble();
                    System.out.print("Number of years: ");
                    double n = sc.nextDouble();
                    System.out.println(df2.format((Math.pow((FV / PV), (1 / n)) - 1) * 100));
                    break;
                }
                case 6: {
                    System.out.print("Enter Loan Amount: ");
                    double A = sc.nextDouble();
                    System.out.print("Enter Interest Rate: ");
                    double R = sc.nextDouble();
                    R = R / 1200;
                    System.out.print("Number of years: ");
                    double N = sc.nextDouble();
                    N = N * 12;
                    double fur = Math.pow(1 + R, N);
                    System.out.println(df2.format((A * R) * fur / (fur - 1)));
                    break;
                }
                case 7: {
                    System.out.print("Regular monthly investment: ");
                    double R = sc.nextDouble();
                    System.out.print("Enter Interest Rate: ");
                    double i = sc.nextDouble();
                    i = i / 1200;
                    System.out.print("Number of years: ");
                    double n = sc.nextDouble();
                    n = n * 12;
                    double fur = Math.pow(i + 1, n) - 1;
                    System.out.println(df2.format(R * (fur / i) * (1 + i)));
                    break;
                }
                case 8:{
                    break;
                }
                case 9: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Invalid Choice! Please choose between 1-9");
                    break;
                }
            }
        }while(want != 8);
    }
}
