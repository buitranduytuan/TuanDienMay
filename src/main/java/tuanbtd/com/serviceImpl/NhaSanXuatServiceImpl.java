package tuanbtd.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.DTO.NSX_DTO;
import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.repository.NhaSanXuatRepository;
import tuanbtd.com.service.NhaSanXuatService;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NSX_DTO> getListNSX() {
        return nhaSanXuatRepository.getListNSX();
    }

    @Override
    public NhaSanXuat getNSXById(int id) {
        return nhaSanXuatRepository.getNSXById(id);
    }

    @Override
    public boolean addNSX(NhaSanXuat nsx) {
        return nhaSanXuatRepository.addNSX(nsx);
    }

    @Override
    public boolean updateNSX(NhaSanXuat nsx) {
        return nhaSanXuatRepository.updateNSX(nsx);
    }

    @Override
    public boolean deleteNSX(int id) {
        return nhaSanXuatRepository.deleteNSX(id);
    }

}
