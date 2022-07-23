import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);                                // для личной проверки через консоль
        System.out.println(calc(sc.nextLine()));
        sc.close();
    }
    public static String calc(String input) throws IOException {            // сам метод, который принимает и возвращает строку
    String[] strArr = input.split(" ");                               // разбитие строки на массив и проверка для выброса исключения на длину массива(правильность ввода)
    if (strArr.length != 3) throw new IOException();
    if (strArr[1].length() != 1) throw new IOException();                   // проверка на количество символов в строке, из которой берется символ для функции
    int a, b, result;
    char operator = strArr[1].charAt(0);
        String [] arabicArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};                                   // создание двух массивов с арабскими и римскими числами для проверки на ввод, а также использования для вывода римских
        String [] romeArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",                            // 10
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",                               // 20
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",                     // 30
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",             // 40
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",                       // 50
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",                               // 60
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",                     // 70
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",           // 80
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",    // 90
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};                      // 100};

        ArrayList<String> romeList = new ArrayList<>(Arrays.asList(romeArr));                                        // Перевод массива в коллекцию, для использования индекса элемента в вычислениях и вывода результата
        ArrayList<String> arabicList = new ArrayList<>(Arrays.asList(arabicArr));

        if (romeList.contains(strArr[0]) && romeList.indexOf(strArr[0]) < 10 && romeList.contains(strArr[2]) && romeList.indexOf(strArr[2]) < 10) {
            a = romeList.indexOf(strArr[0]) + 1;                                                                     // различные условия для римских чисел, вызов метода для расчета(function) и выброс исключения
            b = romeList.indexOf(strArr[2]) + 1;
            if (a <= b && operator == '-' || a < b && operator == '/') throw new IOException();
            result = function(a, b, operator);
            return romeList.get(result-1);
        }
        else if (arabicList.contains(strArr[0]) && arabicList.contains(strArr[2])) {                                // аналогично для арабских
            a = Integer.parseInt(strArr[0]);
            b = Integer.parseInt(strArr[2]);
            result = function(a, b, operator);
            return String.valueOf(result);
        }
        else throw new IOException();
    }
    private static int function (int a, int b, char operator) throws IOException {                                  // метод для расчета
        return switch (operator) {
            case '*' -> a * b;
            case '/' -> a / b;
            case '+' -> a + b;
            case '-' -> a - b;
            default -> throw new IOException();                                                                     // любой символ, отличный от заданных по условию, выбрасывает исключение
        };
    }
}
