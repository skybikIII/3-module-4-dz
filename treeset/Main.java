package treeset;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        CustomTreeSet customTreeSet = new CustomTreeSet();
        customTreeSet.remove(12);
        System.out.println(customTreeSet.contains(12));
        customTreeSet.remove(12);

        TreeSet treeSet = new TreeSet();
        treeSet.add(12);
        System.out.println(treeSet.contains(12));
    }


}
