package com.skpcp.elista.rola.service;


import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public interface IRolaService
{
    RolaDTO znajdzRolePoNazwie(String aNazwa)throws MyServerException;
    List<RolaDTO> znajdzWszystkieRole();
    void usunRole(Long aId);


}