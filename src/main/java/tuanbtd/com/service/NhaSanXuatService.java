package tuanbtd.com.service;

import java.util.List;

import tuanbtd.com.DTO.NSX_DTO;
import tuanbtd.com.entity.NhaSanXuat;

public interface NhaSanXuatService {

    List<NSX_DTO> getListNSX();

    NhaSanXuat getNSXById(int id);

    boolean addNSX(NhaSanXuat nsx);

    boolean updateNSX(NhaSanXuat nsx);
    
    boolean deleteNSX(int id);

}