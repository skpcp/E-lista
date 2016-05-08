package com.skpcp.elista.nieobecnosci.api;


import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;

import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezTechDate;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezUzytkownika;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOUzytkownik;
import com.skpcp.elista.nieobecnosci.service.INieobecnoscService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-04-04.
 */
@RestController
@Transactional
@RequestMapping(value = "elista/nieobecnosci")
public class NieobecnoscController {

    @Autowired
    INieobecnoscService serwisNieobecnosc;

    @RequestMapping(value = "pobierzPoId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NieobecnoscDTOUzytkownik> znajdzNieobecnoscPoId(@PathVariable("id") Long aId){
        try {
            return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "/pobierzWszystkie",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOUzytkownik>> znajdzWszystkie(){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzWszystkieNieobecnosci(),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoIdUzytkownika/{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOUzytkownik>> znajdzPoIdUzytkownika(@PathVariable("uzytkownik.id")Long aId ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoIdUzytkownika(aId),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoDacie/{data},{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NieobecnoscDTOBezUzytkownika> znajdzPoDacie(@PathVariable("data")Date aData, @PathVariable("uzytkownik.id") Long aIdUzytkownika ){
        try{
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoDacieIUzytkowniku(aData,aIdUzytkownika),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value ="/pobierzPoTypie/{typ}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOUzytkownik>> znajdzPoTypie(@PathVariable("typ")String aTyp ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnosciPoTypie(aTyp),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoTypieIUzytkowniku/{typ},{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOBezUzytkownika>> znajdzPoTypieIUzytkowniku(@PathVariable("typ")String aTyp, @PathVariable("uzytkownik.id") Long aIdUzytkownika ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnosciPoTypieIUzytkowniku(aTyp,aIdUzytkownika),HttpStatus.OK);
    }
    @PreAuthorize("#aNieobecnosciDTO.uzytkownik.email == authentication.name AND hasAuthority('PRACOWNIK') OR hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "/zapiszNieobecnosci",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnoscDTOUzytkownik> zapiszNieobecnosci(@RequestBody NieobecnoscDTOBezTechDate aNieobecnosciDTO){
        try
        {
            return new ResponseEntity<>(serwisNieobecnosc.zapiszNieobecnosc(aNieobecnosciDTO),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunNieobecnosci(@PathVariable("id")Long aId){
        serwisNieobecnosc.usunNieobecnosci(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
