package tuanbtd.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.SanPham;
import tuanbtd.com.model.DanhMucSanPhamDTO;
import tuanbtd.com.repository.SanPhamRepository;
import tuanbtd.com.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.getAllSanPham();
    }

    @Override
    public List<DanhMucSanPhamDTO> getDanhMucSP() {
        return sanPhamRepository.getDanhMucSP();
    }

    @Override
    public List<SanPham> getSanPhamByLoaiSP(String loaiSP) {
        return sanPhamRepository.getSanPhamByLoaiSP(loaiSP);
    }

    @Override
    public List<SanPham> getSanPhamByLoaiSP_NSX(String loaiSP, String tenNSX) {
        return sanPhamRepository.getSanPhamByLoaiSP_NSX(loaiSP, tenNSX);
    }

    @Override
    public SanPham getSanPhamById(int id) {
        return sanPhamRepository.getSanPhamById(id);
    }

    @Override
    public List<SanPham> findSanPhamByName(String nameSP) {
        return sanPhamRepository.findSanPhamByName(nameSP);
    }

    @Override
    public List<SanPham> getTop3SanPhamNew() {
        return sanPhamRepository.getTop3SanPhamNew();
    }

    @Override
    public List<SanPham> getTop3GiamGia() {
        return sanPhamRepository.getTop3GiamGia();
    }

}
