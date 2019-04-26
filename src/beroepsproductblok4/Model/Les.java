/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beroepsproductblok4.Model;

/**
 *
 * @author jelmu
 */
public class Les {
    int idles;
    int week;
    int day;
    int hour;
    Buurthuis buurthuis;
    Vrijwilliger vrijwilliger;

    public int getIdles() {
        return idles;
    }

    public void setIdles(int idles) {
        this.idles = idles;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Buurthuis getBuurthuis() {
        return buurthuis;
    }

    public void setBuurthuis(Buurthuis buurthuis) {
        this.buurthuis = buurthuis;
    }

    public Vrijwilliger getVrijwilliger() {
        return vrijwilliger;
    }

    public void setVrijwilliger(Vrijwilliger vrijwilliger) {
        this.vrijwilliger = vrijwilliger;
    }
}
