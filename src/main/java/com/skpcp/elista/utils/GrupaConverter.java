package com.skpcp.elista.utils;

import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.ob.GrupaOB;

/**
 * Created by padyyajs on 22.03.2016.
 */
public class GrupaConverter
{
    public static GrupaOB grupaDTOdoGrupaOB(GrupaDTO aGrupaDTO) {
        if (aGrupaDTO == null)
            return null;
        GrupaOB pGrupaOB = new GrupaOB(aGrupaDTO.getNazwa(),UprawnienieConverter.uprawnienieListDTOdoUprwnienOB(aGrupaDTO.getUprawnienia()));
        pGrupaOB.setId(aGrupaDTO.getId());
        pGrupaOB.setTechDate(aGrupaDTO.getTechDate());
        return pGrupaOB;
    }

    public static GrupaDTO grupaOBdoGrupaDTO(GrupaOB aGrupaOB) {
        if (aGrupaOB == null)
            return null;
        return new GrupaDTO(aGrupaOB.getId(), aGrupaOB.getTechDate(), aGrupaOB.getNazwa(),UprawnienieConverter.uprawnienieListOBdoUprawnienDTO(aGrupaOB.getUprawnienia()));
    }
}

