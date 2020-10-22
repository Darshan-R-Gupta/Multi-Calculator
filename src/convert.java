public class convert
{   //made all the methods static
    public static void main(String[] args) {
        System.out.println();
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
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }
}
