package com.skpcp.elista.uzytkownik.service;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */

public interface IUzytkownikService {
    UzytkownikDTO znajdzUzytkownikaPoId(Long aId);
    List<UzytkownikDTO> znajdzWszystkichUzytkownikow();
    List<UzytkownikDTO> znajdzUzytkownikowPoImieniu(String aImie);
    List<UzytkownikDTO> znajdzUzytkownikowPoNazwisku(String aNazwisko);
    List<UzytkownikDTO> znajdzUzytkownikowPoImieniuINazwisku(String aImie, String aNazwisko);
    UzytkownikDTO zapiszUzytkownika(UzytkownikDTO aUzytkownikDTO);
    void usunUzytkownika(Long aId);
    List<UzytkownikDTO> znajdzUzytkownikowPoAktywnosci(EStan aAktywnosc);
    UzytkownikDTO zmienAktywnoscUzytkownikaPoId(Long aId, EStan Aktywnosc);
    UzytkownikDTO zmienDaneOsobowePoId(Long aId, String aImie, String aNazwisko, String aTelefon);
    UzytkownikDTO zmienDaneDostepuPoId(Long aId, String aEmail, String aHaslo);
}
