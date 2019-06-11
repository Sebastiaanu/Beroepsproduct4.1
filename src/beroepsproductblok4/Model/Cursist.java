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
public class Cursist extends Persoon {

    private int idCursist;
    private String countryOfOrigin;

    public int getIdCursist() {
        return idCursist;
    }

    public void setIdCursist(int idCursist) {
        this.idCursist = idCursist;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

}
