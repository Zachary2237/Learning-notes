package Cheaper12.Lab.lab2;

import Cheaper12.Lab.lab2.DAO;
import org.junit.Test;

import java.util.List;

/**
 * @author wxh
 * @description
 * @create 2022-12-22 10:23
 */
public class DAOTest {

    @Test
    public void test() {
        DAO<Generic.Lab.lab2.User> dao = new DAO<>();
        dao.save("A", new Generic.Lab.lab2.User(1, 18, "Tom"));
        dao.save("B", new Generic.Lab.lab2.User(2, 20, "Jack"));
        dao.save("C", new Generic.Lab.lab2.User(3, 18, "Rose"));

        System.out.println(dao.get("B"));
        System.out.println(dao.get("C"));

        dao.update("D", new Generic.Lab.lab2.User(3, 19, "Rose"));

        System.out.println(dao.list());

        dao.delete("B");
        System.out.println(dao.list());
    }

}
