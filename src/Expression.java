import java.util.*;
import java.lang.Math;
import java.math.*;
import java.text.DecimalFormat;
class Operator{
    char op;
    char ass;
    int in_precedence;
    int out_precedence;
    void assign(char o){
        op = o;
        if(o == '+'||o== '-'){
            ass = 'L';
            in_precedence = 2;
            out_precedence = 1;
        }
        else if(o == '*' || o == '/'){
            ass = 'L';
            in_precedence = 4;
            out_precedence = 3;
        }
        else if(o == '^'){
            ass = 'R';
            in_precedence = 5;
            out_precedence = 6;
        }
        else if(o == '('){
            ass = 'L';
            in_precedence = 0;
            out_precedence = 7;
        }
        else if(o == ')'){
            ass= 'L';
            in_precedence = -2;
            out_precedence = 0;
        }
    }
    Operator(){ }
}
//Precedence and associativity table
class ptable{
    Operator op[];
    int size;
    ptable(){
        char[] operators = new char[]{'+', '-','*','/','^' };
        size = operators.length;
        op = new Operator[size];
        for(int i= 0; i < size; ++i){
            op[i] = new Operator();
            op[i].assign(operators[i]);
        }
    }
    Operator get(char c){
        int i= 0;
        for(i = 0; i < size; i++){
            if(op[i].op == c){
                break;
            }
        }
        if(i < size)        return op[i];
        else                return op[size-1];
    }
    BigDecimal do_airthmatic(BigDecimal x1, BigDecimal x2, char o, int precision){
        BigDecimal value = new BigDecimal("0");
        if(o == op[0].op)      value = x1.add(x2);
        else if(o == op[1].op) value = x1.subtract(x2);
        else if(o == op[2].op) value = x1.multiply(x2);
        else if(o == op[3].op) value = x1.divide(x2,precision,RoundingMode.HALF_UP);
        else if(o == op[4].op) value = new BigDecimal( Math.pow(x1.doubleValue(), x2.doubleValue()) );
        return value;
    }
}

public class Expression{
    Stack<Character> st;   //For the postfix conversion
    Stack<BigDecimal>  evst;  //For the evaluation
    ptable pt;
    String postfix;
    String exp;
    //Set the expression to semi computer code
    Expression(){
        st = new Stack<Character>();
        evst = new Stack<BigDecimal>();
        pt = new ptable();
        postfix = "";
        exp = "";
    }
    void set(String s){
        exp = "";
        exp += '('; //push_back('(');
        for(int i= 0; i < s.length(); ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                exp += 'N'; //push_back('N');
                exp += s.charAt(i);     //push_back(s[i]);
                int j = i+1;
                for(j = i+1; j < s.length(); ++j){
                    if(s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        exp += s.charAt(j); //push_back(s[j]);
                    }
                    else if(s.charAt(j) == '.'){
                        exp += s.charAt(j); //push_back(s[j]);
                    }
                    else break;
                }
                i = j-1;
                exp += 'n'; //push_back('n');
            }
            else if(s.charAt(i) != ' '){
                exp += s.charAt(i); //push_back(s[i]);
            }
        }
        exp += ')';    //push_back(')');
        //System.out.println(exp);
        convert();
    }
    //Convert to postfix;
    void convert(){
        postfix = "";
        for(int i= 0; i < exp.length() ;++i){
            if(exp.charAt(i) == 'N'){
                int j = i+1;
                postfix += 'N';  //.push_back('N');
                while(j < exp.length() && exp.charAt(j) != 'n'){
                    postfix += exp.charAt(j);   //.push_back(exp[j]);
                    j++;
                }
                postfix += 'n'; //.push_back('n');
                i = j;
            }
            else if(exp.charAt(i) == '('){
                st.push('(');
            }
            else if(exp.charAt(i) == ')'){
                while(st.peek() != '('){
                    postfix += st.pop(); //.push_back( st.pop() );
                }
                st.pop();
            }
            else{
                char top = st.peek(); //stack_top();
                Operator top_op = new Operator();
                Operator curr = pt.get(exp.charAt(i));
                if(top != '(')     top_op = pt.get(top);
                while(st.peek() != '(' && top_op.in_precedence >=  curr.out_precedence){
                    char ope = st.pop();
                    postfix += ope; //.push_back(ope );
                    if(st.peek() == '(')  break;
                    else top_op = pt.get(st.peek());
                }
                st.push(exp.charAt(i));
            }
        }
        while(!st.empty()){
            char ope = st.pop();
            postfix += ope; //.push_back(ope);
        }
    }
    BigDecimal to_num(String num){
        BigDecimal value = new BigDecimal(num);
        return value;
    }
    BigDecimal evaluate(int precision){
        BigDecimal value = new BigDecimal("0");
        //System.out.println(postfix);
        for(int i = 0;i < postfix.length(); ++i){
            if(postfix.charAt(i) == 'N'){
                int j = i+1;
                String num = "";
                while(j < postfix.length() && postfix.charAt(j) != 'n'){
                    num += postfix.charAt(j); //push_back(postfix[j]);
                    j++;
                }
                i = j;
                evst.push( to_num(num) );
            }
            else{
                BigDecimal x2 = evst.pop();
                BigDecimal x1 = evst.pop();
                if(postfix.charAt(i) == '/' && x2.doubleValue() == 0){
                    System.out.println("Can't divide by zero");
                    return new BigDecimal(-1);
                }
                BigDecimal result = pt.do_airthmatic(x1,x2,postfix.charAt(i), precision);
                System.out.println(x1 + " " + postfix.charAt(i) + " "+x2 + " : " + result);
               // cout<<x1<<" "<<postfix[i]<<" "<<x2<<" : "<<result<<endl;
                evst.push(result);
            }
        }
        value = evst.pop();
        return value;
    }
    String getpostfix(){ return postfix;   }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String s = sc.nextLine();

        System.out.println("Enter the precision if the expression contains division (0 if it doesn't have): ");
        int precision = sc.nextInt();
        Expression e = new Expression();
        e.set(s);

        System.out.println("Expression: "+s);
        BigDecimal x = e.evaluate(precision);
        System.out.println("The result of the expression is: " + x);
    }
}
class Financial_calculators {
    public static void main(String[] args){
        DecimalFormat df2 = new DecimalFormat("#.##");
        System.out.print("Enter Type of Calculator: ");
        Scanner sc = new Scanner(System.in);
        String want = sc.nextLine();
        switch (want) {
            case "Compound Interest": {
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
            case "Post Tax Return": {
                System.out.print("Interest rate: ");
                double i = sc.nextDouble();
                System.out.print("Tax rate: ");
                double t = sc.nextDouble();
                System.out.println(i - (i * t / 100));
                break;
            }
            case "Inflation": {
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
            case "Purchasing Power": {
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
            case "Compounded Annual Growth Rate": {
                System.out.print("Enter investment's ending/maturity value: ");
                double FV = sc.nextDouble();
                System.out.print("Enter investment's beginning/opening value: ");
                double PV = sc.nextDouble();
                System.out.print("Number of years: ");
                double n = sc.nextDouble();
                System.out.println(df2.format((Math.pow((FV/PV),(1/n)) - 1)*100));
                break;
            }
            case "Loan EMI": {
                System.out.print("Enter Loan Amount: ");
                double A = sc.nextDouble();
                System.out.print("Enter Interest Rate: ");
                double R = sc.nextDouble();
                R =R/1200;
                System.out.print("Number of years: ");
                double N = sc.nextDouble();
                N=N*12;
                double fur = Math.pow(1+R,N);
                System.out.println(df2.format((A*R)*fur/(fur-1)));
                break;
            }
            case "SIP": {
                System.out.print("Regular monthly investment: ");
                double R = sc.nextDouble();
                System.out.print("Enter Interest Rate: ");
                double i = sc.nextDouble();
                i = i/1200;
                System.out.print("Number of years: ");
                double n = sc.nextDouble();
                n = n*12;
                double fur = Math.pow(i+1,n)-1;
                System.out.println(df2.format(R*(fur/i)*(1+i)));
                break;
            }
        }
    }
}