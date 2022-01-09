package task4.app;

import java.util.*;
import java.util.stream.Collectors;

public class MyString {

    public static Map<String, Integer> ArrayToUnsortedMap(String[] array) {
        Map<String, Integer> map = null;
        if (array != null) {
            map = new HashMap<>();
            int count = 1;
            for (int i = 0; i < array.length; i++) {
                if (!map.containsKey(array[i]) && array[i] != null) {
                    for (int j = array.length - 1; j > i; j--) {
                        if (array[i].equals(array[j])) {
                            count++;
                        }
                    }
                    map.put(array[i], count);
                    count = 1;
                }
            }
        }
        return map;
    }

    public static Map<String, Integer> SortedMap(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sortedMap = null;
        if (unsortedMap != null){
            sortedMap = unsortedMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));
        }

        return  sortedMap;
    }

    public static List<String> getListOfMostRepeatingLines(Map<String, Integer> sortedMap) {
        List<String> result = null;
        if (sortedMap != null && sortedMap.size() != 0) {
            result = new ArrayList<>();
            int maxRepeatCounter = sortedMap.values().iterator().next();
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                if (entry.getValue() == maxRepeatCounter) {
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }


    private static int numberOfWords(String s) {
        if (s != null) {
            s = s.strip();
            return (s.length() - s.replaceAll(" ", "").length()) + 1;
        }
        return 0;
    }

    public static void showResult(List<String> listOfMostRepeatingLines) {
        if (listOfMostRepeatingLines != null) {
            System.out.printf("Колличество строк которые встречаются в массиве чаще всего: %d\n",
                    listOfMostRepeatingLines.size());
            for (String line : listOfMostRepeatingLines) {
                System.out.printf("В строке - \"%s\", содержится слов: %d\n ",
                        line, MyString.numberOfWords(line));
            }
        }else {
            System.out.println("Массив не содержит строк");
        }
    }
}

