package com.skpcp.elista.uzytkownik.dto;


import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.dto.GrupaDTOBezLidera;
import com.skpcp.elista.grupa.dto.GrupaDTOUzytkownik;
import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.dto.RolaDTOBezUprawnien;
import com.skpcp.elista.uzytkownik.EStan;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-07.
 */
@ApiModel
public class UzytkownikDTOBezHasla extends BaseDTO {
    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
    private EStan aktywnosc;
    private RolaDTO rola;
    private GrupaDTOUzytkownik grupa;

    public UzytkownikDTOBezHasla(){

    }

    public UzytkownikDTOBezHasla(String imie, String nazwisko, String email, String telefon, EStan aktywnosc, RolaDTO rola, GrupaDTOUzytkownik grupa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;
        this.rola = rola;
        this.grupa = grupa;
    }

    public UzytkownikDTOBezHasla(Long id, Date techDate, String imie, String nazwisko, String email, String telefon, EStan aktywnosc, RolaDTO rola, GrupaDTOUzytkownik grupa) {
        super(id, techDate);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;
        this.rola = rola;
        this.grupa = grupa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public EStan getAktywnosc() {
        return aktywnosc;
    }

    public void setAktywnosc(EStan aktywnosc) {
        this.aktywnosc = aktywnosc;
    }

    public RolaDTO getRola() {
        return rola;
    }

    public void setRola(RolaDTO rola) {
        this.rola = rola;
    }

    public GrupaDTOUzytkownik getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaDTOUzytkownik grupa) {
        this.grupa = grupa;
    }
}