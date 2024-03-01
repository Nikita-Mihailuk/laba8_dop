import java.util.Scanner;
class Complexnumbers{
    double a;
    double b;
    Complexnumbers(double a, double b){
        this.a = a;
        this.b = b;
    }
    public  void sum(Complexnumbers z2){
       double res = a + z2.a;
       double resI = b + z2.b;
       if (resI < 0) System.out.printf("Сумма комплесных чисел = %f%f i\n\n", res, resI);
       else System.out.printf("Сумма комплесных чисел = %f+%f i\n\n", res, resI);
    }
    public void sub(Complexnumbers z2){
        double res = a - z2.a;
        double resI = b - z2.b;
        if (resI < 0) System.out.printf("Разность комплесных чисел = %f%f i\n\n", res, resI);
        else System.out.printf("Разность комплесных чисел = %f+%f i\n\n", res, resI);
    }
    public void multiplication(Complexnumbers z2){
        double res = a * z2.a - b * z2.b;
        double resI = b * z2.a + a * z2.b;
        if (resI < 0) System.out.printf("Произведение комплесных чисел = %f%f i\n\n", res, resI);
        else System.out.printf("Произведение комплесных чисел = %f+%f i\n\n", res, resI);
    }
    public void division(Complexnumbers z2){
        double res = (a * z2.a + b * z2.b) / (z2.a * z2.a + z2.b * z2.b) ;
        double resI = (b * z2.a - a * z2.b) / (z2.a * z2.a + z2.b * z2.b);
        if (resI < 0) System.out.printf("Частное комплесных чисел = %f%f i\n\n", res, resI);
        else System.out.printf("Частное комплесных чисел = %f+%f i\n\n", res, resI);
    }
    public void pairing(){
        if(b < 0) System.out.printf("Обртно сопряженное комплексное число = %f+%f i\n\n", a, -b);
        else System.out.printf("Обртно сопряженное комплексное число = %f-%f i\n\n", a, b);
    }
    public void exponentiation(double n){
        double r = Math.pow(Math.sqrt(a * a + b * b), n);
        double fi = n * Math.atan2(b, a);
        double res = r * Math.cos(fi);
        double resI = r * Math.sin(fi);
        if (resI < 0) System.out.printf("Комплексное число в степени %f = %f%f i\n\n", n,  res, resI);
        else System.out.printf("Комплексное число в степени %f = %f+%f i\n\n", n,  res, resI);
    }
    public void root (double n){
        double r = Math.pow(Math.sqrt(a * a + b * b), 1/n);
        for (double k = 0; k < n; k++){
            double fi = (Math.atan2(b, a) + 2 * Math.PI * k) / n;
            double res = r * Math.cos(fi);
            double resI = r * Math.sin(fi);
            if (resI < 0) System.out.printf("Комплексное число в степени корня %f, при к = %f = %f%f i\n", n, k, res, resI);
            else System.out.printf("Комплексное число в степени корня %f, при к = %f = %f+%f i\n", n, k, res, resI);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое комплексное число:\nВведите a: ");
        double a1 = in.nextDouble();
        System.out.print("Введите b: ");
        double b1 = in.nextDouble();
        Complexnumbers z1 = new Complexnumbers(a1, b1);

        System.out.print("Введите второе комплексное число:\nВведите a: ");
        double a2 = in.nextDouble();
        System.out.print("Введите b: ");
        double b2 = in.nextDouble();
        Complexnumbers z2 = new Complexnumbers(a2, b2);

        z1.sum(z2);
        z1.sub(z2);
        z1.multiplication(z2);
        z1.division(z2);
        z1.pairing();
        System.out.print("Введите степень: ");
        double n = in.nextDouble();
        z1.exponentiation(n);
        System.out.print("Введите степень корня: ");
        double n1 = in.nextDouble();
        z1.root(n1);
    }
}