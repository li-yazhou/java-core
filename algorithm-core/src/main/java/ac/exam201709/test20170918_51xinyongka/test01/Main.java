package ac.exam201709.test20170918_51xinyongka.test01;

import java.util.HashMap;
import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-18 19:54
 */
public class Main {
    private static class Entry{
        int total = 0;
        int personNum = 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] ids = sc.nextLine().split(" ");
        String[] weights = sc.nextLine().split(" ");

        HashMap<String, Entry> map = new HashMap<>();
        for (int i = 0; i < ids.length; i ++){
            String id = ids[i];
            int weight = Integer.valueOf(weights[i]);
            Entry entry = map.get(id);
            if (entry == null){
                entry = new Entry();
                map.put(id, entry);
            }
            entry.total += weight;
            entry.personNum ++;
        }

        String candidate = ids[0];
        Entry entry = map.get(ids[0]);
        for (String id : map.keySet()){
            Entry temp = map.get(id);
            if (temp.total > entry.total) {
                entry = temp;
                candidate = id;
            }
            if (temp.total == entry.total && temp.personNum > entry.personNum) {
                entry = temp;
                candidate = id;
            }
        }
        System.out.println(candidate);
    }
}
