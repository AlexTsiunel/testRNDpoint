package task4.app;/*
4.Напишите приложение на Java\Groovy, которое решает следующую задачу:
Имеется массив строк. Необходимо определить строку, которая встречается
чаще всего и вывести количество слов в данной строке.
 */

import java.util.List;
import java.util.Map;

public class startApp {

    public static void main(String[] args) {

        String[] testArray = new String[]{
                null,
                null,
                "a b cc",
                "d kl jnkj",
                "vg ncvkj xk",
                " kjk jhu lkl",
                null,
                null,
                null,
                null,
                "hu dser jioj hjghjg jhii",
                "sc scdsd ",
                "a b cc",
                "a b cc",
                " kjk jhu lkl",
                "hu dser jioj hjghjg jhii",
                "hu dser jioj hjghjg jhii"
        };

        Map<String, Integer> unsortedStringMap = MyString.ArrayToUnsortedMap(testArray);
        Map<String, Integer> sortedStringMap = MyString.SortedMap(unsortedStringMap);
        List<String> listOfMostRepeatingLines = MyString.getListOfMostRepeatingLines(sortedStringMap);
        MyString.showResult(listOfMostRepeatingLines);

    }
}
