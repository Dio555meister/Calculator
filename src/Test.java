import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 /*       Scanner sc = new Scanner(System.in);
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += sc.nextLine();
            System.out.println(str);
        }*/


        /*String text = " любит меня.";
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int n = 0;
        while (n < 10) {
            System.out.println(name + text);
            n++;
        }*/

///////////////////////////////////////////////////////
        //int age = 19;

       int ageUser = scanner.nextInt();
        if (ageUser < 18) {
            System.out.println(" Вы еще ребенок");
        } else {
            System.out.println(" Вы  взрослый");
        }
    }
}