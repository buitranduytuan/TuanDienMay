package tuanbtd.com.serviceImpl;

import java.util.List;

import tuanbtd.com.entity.NhaSanXuat;

public interface NhaSanXuatService {

    List<NhaSanXuat> getListNSX();

    NhaSanXuat getNSXById(int id);

    boolean addNSX(NhaSanXuat nsx);

    boolean updateNSX(NhaSanXuat nsx);

}