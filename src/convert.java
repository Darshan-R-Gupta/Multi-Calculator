public class convert
{   //made all the methods static
    public static void main(String[] args)
    {
     
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
        int binary[] = new int[40];
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

    //Hexadecimal To Binary
    public static int hexToBin(String hex)
    {
        int dec = convert.hexToDec(hex);
        convert.decToBin(dec);
        return 0;

    }

    //Binary To Hexadecimal
    public static String binToHex(int bin)
    {
        int dec = binToDec(bin);
        String hex = decToHex(dec);
        return hex;
    }
}
