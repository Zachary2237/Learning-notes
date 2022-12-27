package Chapter15.Part2.test;

import java.io.Serializable;

/**
 * @author wxh
 * @create 2022-12-27 10:39
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("Breath!");
    }

    public void eat() {
        System.out.println("Eat!");
    }

}
