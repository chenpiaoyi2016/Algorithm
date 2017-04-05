package Hihocoder;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, ListNodeOfPath> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String father = scanner.next();
            String child = scanner.next();
            if (!map.containsKey(father)) {
                ListNodeOfPath ln = new ListNodeOfPath(father);
                map.put(father, ln);
            }
            if (!map.containsKey(child)) {
                ListNodeOfPath ln = new ListNodeOfPath(child);
                ln.father = map.get(father);
                map.put(child, ln);
            }
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            String name1 = scanner.next();
            String name2 = scanner.next();
            ListNodeOfPath l1 = map.get(name1);
            ListNodeOfPath l2 = map.get(name2);
            if (l1 == null && l2 == null && name1.equals(name2)) {
                System.out.println(name1);
                continue;
            }
            ListNodeOfPath p = l1;
            int count1 = 0;
            while (p != null) {
                p = p.father;
                count1++;
            }
            ListNodeOfPath q = l2;
            int count2 = 0;
            while (q != null) {
                q = q.father;
                count2++;
            }
            p = l1;
            q = l2;
            if (count2 > count1) {
                p = l2;
                q = l1;
            }
            int diff = Math.abs(count2 - count1);
            while (diff > 0) {
                p = p.father;
                diff--;
            }
            while (p != null && q != null && p.name != q.name) {
                p = p.father;
                q = q.father;
            }
            if (p != null && q != null) {
                System.out.println(p.name);
            } else {
                System.out.println(-1);
            }
        }
        scanner.close();
    }
}

class ListNodeOfPath {
    String name;
    ListNodeOfPath father;
    public ListNodeOfPath(String name) {
        this.name = name;
    }
}