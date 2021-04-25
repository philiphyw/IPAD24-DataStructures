/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarray;

/**
 *
 * @author phili
 */
public class Boat {
    private String name;

    @Override
    public String toString() {
        return "Boat{" + "name=" + name + '}';
    }

    public Boat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
