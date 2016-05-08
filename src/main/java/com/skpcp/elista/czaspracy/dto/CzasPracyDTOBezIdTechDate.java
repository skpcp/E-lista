package com.skpcp.elista.czaspracy.dto;


import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOEmail;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class CzasPracyDTOBezIdTechDate implements Serializable {
    private Long id;
    private UzytkownikDTOEmail uzytkownik;
    private Date dzien;
    private Date rozpoczecie;
    private Date zakonczenie;
    private String zakresPracy;

    public CzasPracyDTOBezIdTechDate() {
    }

    public CzasPracyDTOBezIdTechDate(Long id, UzytkownikDTOEmail uzytkownik, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        this.id = id;
        this.uzytkownik = uzytkownik;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UzytkownikDTOEmail getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTOEmail uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Date getDzien() {
        return dzien;
    }

    public void setDzien(Date dzien) {
        this.dzien = dzien;
    }

    public Date getRozpoczecie() {
        return rozpoczecie;
    }

    public void setRozpoczecie(Date rozpoczecie) {
        this.rozpoczecie = rozpoczecie;
    }

    public Date getZakonczenie() {
        return zakonczenie;
    }

    public void setZakonczenie(Date zakonczenie) {
        this.zakonczenie = zakonczenie;
    }

    public String getZakresPracy() {
        return zakresPracy;
    }

    public void setZakresPracy(String zakresPracy) {
        this.zakresPracy = zakresPracy;
    }
}