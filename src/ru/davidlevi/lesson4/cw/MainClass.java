package ru.davidlevi.lesson4.cw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Урок 4. Связанные списки
 */
public class MainClass {
    public static void main(String[] args) {
        RelatedList<Cat> list = new RelatedList<>();
        list.insert(new Cat(1, "Barsik"));
        list.insert(new Cat(2, "Murzik"));
        list.insert(new Cat(4, "Kissik"));
        System.out.println(list); // [(A: 4, N: Kissik), (A: 2, N: Murzik), (A: 1, N: Barsik)]
        System.out.println(list.remove()); // (A: 4, N: Kissik)
        System.out.println(list); // [(A: 2, N: Murzik), (A: 1, N: Barsik)]
        System.out.println(list.contains(new Cat(2, "Murzik"))); // true

//        Map<String, String> map = new HashMap<>();
//        Set<Map.Entry<String, String>> set = map.entrySet();
//        Iterator<Map.Entry<String, String>> iter = set.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next().getKey() + iter.next().getValue());
//        }
    }
}
