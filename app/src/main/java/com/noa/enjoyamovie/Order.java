package com.noa.enjoyamovie;

public class Order extends Users{
   private String wayOfPayment;
    private String movieDate;
    private String movieTime;
    private Integer sumMoney;
    public Order(String username, String id, String password, String wayOfPayment,String movieDate, String movieTime,Integer sumMoney) {
        super(username, id, password);
        this.wayOfPayment = wayOfPayment;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.sumMoney = sumMoney;
    }
    public String getWayOfPayment() {
        return wayOfPayment;
    }
    public String getMovieTime() {
        return movieTime;
    }
    public Integer getSumMoney() {
        return sumMoney;
    }
    public String getMovieDate() {
        return movieDate;
    }
    public void setWayOfPayment(String wayOfPayment) {
        this.wayOfPayment = wayOfPayment;
    }
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
    public void setSumMoney(Integer sumMoney) { this.sumMoney = sumMoney;}
    public void setMovieDate(String movieDate) { this.movieDate = movieDate;}

    @Override
    public String toString()
    {
        return super.toString() + " ,way of payment:" + this.wayOfPayment+ " ,date:" + this.movieDate+ " ,time:" + this.movieTime+ " ,total money:" + this.sumMoney;
    }
}
