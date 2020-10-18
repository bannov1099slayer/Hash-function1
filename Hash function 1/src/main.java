import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {

    public static void main(String[] args) throws IOException {

        final String input = new String( Files.readAllBytes(Paths.get("data.txt")), "UTF-8");
        int[] array = new int[255];//массив для чисел аски символов
        char[] dividedstring = input.toCharArray();//буквы разбитой строки
//----------------------------------------------------------------------------------------------------------------------
// разбиение входной строки на числовые аски значения
        byte[] bytes = input.getBytes("windows-1251");
        for (int v = 0; v < bytes.length; v++){
            //  System.out.println(bytes[v]);
            array[v] = bytes[v];// записываем в массив array аски-значения символов строки
            System.out.println("["+array[v]+"]");
        }
        // System.out.println(bytes[0]);
//----------------------------------------------------------------------------------------------------------------------
// вывод исходной строки посимвольно
        for (int i = 0; i < dividedstring.length; i++) {
            System.out.print("[" + dividedstring[i] + "] ");
        }
//----------------------------------------------------------------------------------------------------------------------
        System.out.print("\nHash function H(x) = y ");
        System.out.println("\nx is ["+input+"]");
//----------------------------------------------------------------------------------------------------------------------
//формула
        double result1;//результат хэш-функции
        double a = array[0];
        double b = array[1];
        int c = array[2];
        int d = array[3];
        int f = array[4];
        for (int x = 5; x < array.length; x++){
            f = f+array[x];
        }
        if( Math.abs(a) >=10){
            a = Math.round(array[0]/10);
            //  System.out.println(a);
        }
        if( Math.abs(b) >=10){
            b = Math.round(array[1]/10);
            //  System.out.println(b);
        }
        if ( Math.abs(c) >=10){
            c = Math.round(array[2]/10);
            //  System.out.println(c);
        }
        if ( Math.abs(d) >=10){
            d = Math.round(array[3]/10);
            //  System.out.println(d);
        }
        //System.out.println("a="+a+"b="+b+"c="+c+"d="+d);
        if (a <=0 || b<=0 || c <=0 || d <= 0 || f <=0){
            a = Math.abs(a);
            b = Math.abs(b);
            c = Math.abs(c);
            d = Math.abs(d);
            f = Math.abs(f);

            //  System.out.println("a="+a+"b="+b+"c="+c+"d="+d);

            result1 = Math.pow(a/10,b/10)+(a*100*b*100)+ Math.pow((c+d),(a/2))+f;

        }
        else {result1 = Math.pow(a/10,b/10)+ Math.pow((c+d),(a/2))+f;
        }
        result1 = (int)Math.round(result1);
        System.out.println("f="+f);
        System.out.println("y = "+result1);
//----------------------------------------------------------------------------------------------------------------------
    }
}
