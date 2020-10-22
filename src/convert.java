import java.util.*;
public class convert
{   //made all the methods static
    public static void main(String[] args)
    {
        System.out.println("****** Conversion Calculator ******");
        System.out.println("Pick A Choice");
        System.out.println("1 - Binary to Decimal Conversion");
        System.out.println("2 - Decimal to Binary Conversion");
        System.out.println("3 - HexaDecimal to Decimal Conversion");
        System.out.println("4 - Decimal to HexaDecimal Conversion");
        System.out.println("5 - Binary to Hexadecimal Conversion");
        System.out.println("6 - Hexadecimal to Binary Conversion");

        Scanner sc  = new Scanner(System.in);
        Scanner sca  = new Scanner(System.in);
        int choice = sc.nextInt();



        switch (choice)
        {
            case 1:
                int bin;
                System.out.println("Enter A Binary Number :");
                bin = sc.nextInt();
                while (!isBinaryNumber(bin))
                {
                    System.out.println("Enter A Binary Number only!!!");
                    bin = sc.nextInt();
                }
                System.out.print("Decimal of binary number "+ bin +" is : " + binToDec(bin));
                break;
            case 2:
                int dec;
                System.out.println("Enter A Decimal Number :");
                dec = sc.nextInt();
                System.out.print("Binary of Decimal number "+ dec +" is : ");
                decToBin(dec);
                break;
            case 3:
                String hex;
                System.out.println("Enter A Hexadecimal Number :");
                hex = sca.nextLine();
                while (!isHexadecimalNumber(hex))
                {
                    System.out.println("Enter A Hexadecimal Number only!!!");
                    hex = sca.nextLine();
                }
                System.out.print("Decimal of Hexadecimal number "+ hex +" is : "+hexToDec(hex));
                break;
            case 4:
                System.out.println("Enter A Decimal Number :");
                int deca = sc.nextInt();
                System.out.print("Hexadecimal of Decimal number "+ deca +" is : " + decToHex(deca));
                break;
            case 5:
                System.out.println("Enter A Binary Number :");
                int binary = sc.nextInt();
                while (!isBinaryNumber(binary))
                {
                    System.out.println("Enter A Binary Number only!!!");
                    binary = sc.nextInt();
                }
                System.out.print("Hexadecimal of Binary number "+ binary +" is : "+binToHex(binary));
                break;
            case 6:
                System.out.println("Enter A Hexadecimal Number :");
                String hexa = sca.nextLine();
                while (!isHexadecimalNumber(hexa))
                {
                    System.out.println("Enter A Hexadecimal Number only!!!");
                    hexa = sca.nextLine();
                }
                System.out.print("Binary of Hexadecimal number "+ hexa +" is : ");
                hexToBin(hexa);
                break;
            default:
        }
    }
    //binary to decimal
    public static int binToDec(int binary)
    {
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            }
            else
            {
                int temp = binary%10;
                decimal += temp * Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }
    //decimal to binary
    public static void decToBin(int num)
    {
        int [] binary= new int[40];
        int index = 0;
        while(num > 0)
        {
            binary[index++] = num%2;
            num = num/2;
        }

        for(int i = index-1;i >= 0;i--)
        {
                System.out.print(binary[i]);
        }
    }

    //Hexadecimal to Decimal
    public static int hexToDec(String hex)
    {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }

    //Decimal to Hexadecimal
    public static String decToHex(int num)
    {
        // calling method toHexString()
        String dec = Integer.toHexString(num);
        return dec.toUpperCase();
    }

    //Binary To Hexadecimal
    public static String binToHex(int bin)
    {
        int dec = binToDec(bin);
        String hex = decToHex(dec);
        return hex;
    }

    //Hexadecimal To Binary
    public static int hexToBin(String hex)
    {
        int dec = convert.hexToDec(hex);
        convert.decToBin(dec);
        return 0;

    }

    public static boolean isBinaryNumber(int num)
    {
        if (num == 0 || num == 1
                || num < 0) {
            return true;
        }
        while (num != 0) {
            if (num % 10 > 1) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
    public static boolean isHexadecimalNumber(String x)
    {
            String pattern = "^[0-9A-Fa-f]+$";
            if (x.matches(pattern))
            {
                return true;
            }
            else
            {
                return false;
            }

    }
}


