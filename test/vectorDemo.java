
import java.util.Arrays;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huynh
 */
public class vectorDemo {
    private String name;
    public static void main(String[] args) {
        Vector v = new Vector();
        v.addAll(Arrays.asList(1,2,4,2,5));
        System.out.println(v);
        System.out.println(v.elements());
        vectorDemo vectordemo = new vectorDemo();
        System.out.println(vectordemo);
    }
}
