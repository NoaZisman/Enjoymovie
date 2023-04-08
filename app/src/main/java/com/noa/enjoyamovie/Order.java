package com.noa.enjoyamovie;

public class Order extends Users{
   private String wayOfPayment;

    public Order(String username, String id, String password, String wayOfPayment) {
        super(username, id, password);
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
