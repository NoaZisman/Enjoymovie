package com.noa.enjoyamovie;

public class Order extends Users{
    String wayOfPayment;

    public Order(String name, String lastName, String gmail, String id, String password, String wayOfPayment) {
        super(name, lastName, gmail, id, password);
        this.wayOfPayment = wayOfPayment;
    }
    public String getWayOfPayment() {
        return wayOfPayment;
    }
    public void setWayOfPayment(String wayOfPayment) {
        this.wayOfPayment = wayOfPayment;
    }
    @Override
    public String toString()
    {
        return super.toString() + " ,way of payment:" + this.wayOfPayment;
    }
}
