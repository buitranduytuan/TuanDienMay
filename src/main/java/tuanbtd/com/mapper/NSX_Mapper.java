package tuanbtd.com.mapper;

import tuanbtd.com.DTO.NSX_DTO;
import tuanbtd.com.entity.NhaSanXuat;

public class NSX_Mapper {
    public static NSX_DTO toNSX_DTO(NhaSanXuat nsx) {
        NSX_DTO nsxDTO = new NSX_DTO(nsx.getMaNSX(), nsx.getTenNSX(), nsx.getThongTin());
        return nsxDTO;
    }
}
