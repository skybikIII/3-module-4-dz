package treeset;

import java.util.TreeMap;

public class CustomTreeSet<E> {
    private transient TreeMap<E,Object> m;

    private static final Object PRESENT = new Object();

    CustomTreeSet(TreeMap<E, Object> m) {
        this.m = m;
    }

    public CustomTreeSet() {
        this(new TreeMap<>());
    }

    public boolean contains(Object o) {
        return m.containsKey(o);
    }

    public boolean add(E e) {
        return m.put(e, PRESENT)==null;
    }

    public boolean remove(E value) {
        return m.remove(value)==PRESENT;
    }
}
