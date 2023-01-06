import Exception.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // создаем объект типа сканер
        System.out.println(" Введите пример "); // выводим в консоль запрос
        String input = scanner.nextLine();  //объявили переменную input типа String. Cчитываем  с консоли введенную строку методом сканера nextLine().Присваиваем ее переменной input

        if (check(input.toCharArray())) {
            System.out.println(rimCalc(input.toCharArray())); // вызов римского калькулятора
        } else {
            System.out.println(calcArab(input.toCharArray())); // вызов метода calcArab  и передаем туда массив символов строки input
        }


    }
    private static boolean check (char [] arr){
        int countOperand  = 0;
        char operand = ' ';

        for ( char c : arr){
            if (c == '+' ||c == '-' || c =='/'|| c =='*'){
               countOperand++;
            }
            if (countOperand>1){
                throw  new WrongFormatException();
            }
        }

        for (char c : arr) { //проходимся циклом по массиву
            if (c == '+' ||c == '-' || c =='/'|| c =='*'){ // если встречается один из этих символов
                operand = c; // присваиваем в операнд этот символ
            }
        }

        if (operand == ' '){
            throw new NotMathOperException();
        }


        for (char c : arr) {
            if (Character.isDigit(c)){
                return false;
            }
        }return true;

    }

    private static String calcArab(char[] c) { // метод вызывающий арабский калькулятор
        for (char c1 : c) {
            for (RimEnum value : RimEnum.values()) {
                if (String.valueOf(c1).equals(value.name())){
                    throw new DeffernfFormatException();
                }
            }
        }

        int n1 = 0; // создаем переменную n1  и приравниваем ее к 0
        int n2  = 0; // создаем переменную n2  и приравниваем ее к 0
        if (c.length<3){
            throw new NotMathOperException();
        }
        String operand = String.valueOf(c[2]); // делаем из арифм  символа массива строку и присваиваем переменной операнд

        if (Character.isDigit(c[0])) { // проверяет, является ли  первый символ числом
            n1 = Integer.parseInt(String.valueOf(c[0])); //делаем первый символ массива строкой, затем переводим в число и присваиваем n1
            operand = String.valueOf(c[2]); // переводим операнд в строку
        } else {
            throw  new NotMathOperException();
        }

        if (Character.isDigit((c[1]))) { // проверяет, является ли второй символ числом
            n1 = Integer.parseInt(String.valueOf(c[0]) + String.valueOf(c[1])); //делаем из первого и второго символа строки, а затем числа
            operand = String.valueOf(c[3]); //делаем из операнда строку( при условии, что первое число двухзначное, т.е 10. 10 +) тогда операнд третий симввол)
        } else {

        }

        if (n1 > 9) { //  если первое число больше 9, т.е 10
            if (Character.isDigit(c[5])) { // проверяет, является ли 5 символ числом
                n2 = Integer.parseInt(String.valueOf(c[5])); //делаем 5 символ массива строкой, а потом переводим в число
                if (c.length > 6 ) { // если длина символьного массива больше или равно 6
                    if (Character.isDigit(c[6])) { //если 6  символ массива число
                        n2 = Integer.parseInt(String.valueOf(c[5]) + String.valueOf(c[6])); // переводим 5 и 6 символы в строки, складываем, а потом в числа
                    }else {
                        System.out.println("не число второе число 2 цифра");
                    }
                }
            }else {
                System.out.println("ексепшен не является числом 2 чисто");
            }

        } else {
            if (c.length < 5){
                throw new NotMathOperException();
            }
            if (Character.isDigit(c[4])) { // если 4 символ массива является числом
                n2 = Integer.parseInt(String.valueOf(c[4])); // переводим 4 символ в строку, а затем в число
                if (c.length > 5) { // если длина символьного массива больше 5
                    if (Character.isDigit(c[5])) { // если 5 символ является числом
                        n2 = Integer.parseInt(String.valueOf(c[4]) + String.valueOf(c[5])); // переводим 4 и 5 символы в строки, складываем их и переводим в число
                    }
                }
            }
        }
        String answer = "";  // результат решения

        if (n1<=10 & n2<=10 && n1>0 && n2 > 0){ // условия свич кейса
            switch (operand) {
                case "+" -> {
                    answer = String.valueOf(n1 + n2);
                }
                case "-" -> {
                    answer = String.valueOf(n1 - n2);
                }
                case "*" -> {
                    answer = String.valueOf(n1 * n2);
                }
                case "/" -> {
                    answer = String.valueOf(n1 / n2);
                }
                default -> {
                    //ексепшен операнда
                }

            }

        }else {
            throw new NotMathOperException();
        }

        return answer;

    }

    private static String rimCalc(char [] c ){ // метод римского каль-ра, принимает массив символов в параметры
        String n1 = ""; //  строка для первого римского числа
        String n2 = ""; // строка для второго римского числа
        String opernd = ""; //  строка арифм. знака
        int s = 0;

        for (int i = 0; i < c.length; i++) { // циклом проходимся по массиву символов и ищем пробел. Ищет первое римское  число
            if (c[i] == ' '){ //  если мы нашли пробел
                break;
            }else {
                n1+= String.valueOf(c[i]); // добавляем символ пока не встретим пробел
            }
        }

        for (int i = 0; i < c.length; i++) { //  находим знак, после того как мы нашли пробел
            if (c[i] == ' '){ //  если мы нашли пробел
                if (i + 1 < c.length){ // находим есть ли после пробела след. ячейка
                    opernd = String.valueOf(c[i+1]); // если после проела есть знак, то мы его записываем
                    break;
                }
            }
        }


        for (int i = 0; i < c.length; i++) { // прибавляем к s 1  каждый раз когда встретим пробел. Как только s = 2 это значит мы нашли второе число
            if (s == 2){ //  если  будет равно 2
                n2 += String.valueOf(c[i]); //  тогда записываем очередное число в ячейку
            }
            if (c[i] == ' '){ // если встретим пробел, то добавляем к s +1
                s++; // прибавляем каждый раз к s 1  пока s  не будет равно 2
            }


        }

        int s1 = 0; // присваиваем из энама числа в эти переменные
        int s2 = 0; // присваиваем из энама числа в эти переменные

        for (RimEnum value : RimEnum.values()) { // проходимся по массиву энами и присваиваем эти значения в переменную value, которую создали
            if (n1.equals(value.name())){ //если n1 = названию энама
                s1 = value.getNumber(); // тогда мы присваиваем переменной s1 номер этого энама
             break;
            }

        }

        for (RimEnum value : RimEnum.values()){ // проходимся по массиву энами и присваиваем эти значения в переменную value, которую создали
            if (n2.equals(value.name())){ //если n1 = названию энама
                s2 = value.getNumber();  // тогда мы присваиваем переменной s1 номер этого энама
                break;
            }
        }


        String answer = ""; // ответ

        if (s1<=10 & s2<=10 && s1>0 && s2 > 0){ // условия проверки ( не больше 10 и больше 0)
            switch (opernd) { // проверяем операнд
                case "+" -> { // если + то складываем
                    answer = String.valueOf(s1 + s2);
                }
                case "-" -> {
                    answer = String.valueOf(s1 - s2);
                }
                case "*" -> {
                    answer = String.valueOf(s1 * s2);
                }
                case "/" -> {
                    answer = String.valueOf(s1 / s2);
                }
                default -> {
                    //ексепшен операнда
                }

            }

        }else {
            throw new NotMathOperException();
        }

      for (RimEnum r: RimEnum.values()){
         if ( r.getNumber() == Integer.parseInt(answer)){
             return r.name();

         }
      }

        throw new NegativeNumberException();

    }
}

