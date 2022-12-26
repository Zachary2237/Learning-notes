package Cheaper12.Lab.lab2;

import java.util.*;

/**
 * @author wxh
 * @description
 * @create 2022-12-22 10:22
 */
public class DAO<T> {

    private Map<String, T> map;

    public DAO () {
        map = new HashMap<>();
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.replace(id, entity);
    }

    public List<T> list() {
        Collection<T> values = map.values();
        Iterator<T> iterator = values.iterator();
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T next = iterator.next();
            list.add(next);
        }

        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

}
