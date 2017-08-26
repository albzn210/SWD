/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.fhs.swd;

import java.util.ArrayList;

class Restaurant {

    public Guest[] client;

    public Restaurant() {
        client = new Guest[50];
        chairs = new ArrayList();
    }

    protected ArrayList<Employee> employees;

    public ArrayList chairs;

    public void addChair(Chair s) {
        chairs.add(chairs.size(), s);
    }

    public Chair removeChair() {
        return (Chair) chairs.remove(chairs.size() - 1);
    }
}
