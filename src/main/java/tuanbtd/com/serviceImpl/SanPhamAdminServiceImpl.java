package tuanbtd.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.LoaiSanPham;
import tuanbtd.com.entity.NhaCungCap;
import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.entity.SanPham;
import tuanbtd.com.repository.SanPhamAdminRepository;
import tuanbtd.com.service.SanPhamAdminService;

@Service
public class SanPhamAdminServiceImpl implements SanPhamAdminService {

    @Autowired
    SanPhamAdminRepository sanPhamAdminRepository;

    @Override
    public List<SanPham> getAllAdminProduct() {
        return sanPhamAdminRepository.getAllAdminProduct();
    }

    @Override
    public SanPham getSanPhamById(int id) {
        return sanPhamAdminRepository.getSanPhamById(id);
    }

    @Override
    public List<LoaiSanPham> getAllLoaiSanPham() {
        return sanPhamAdminRepository.getAllLoaiSanPham();
    }

    @Override
    public List<NhaSanXuat> getAllNSX() {
        return sanPhamAdminRepository.getAllNSX();
    }

    @Override
    public List<NhaCungCap> getAllNCC() {
        return sanPhamAdminRepository.getAllNCC();
    }

    @Override
    public boolean editSanPham(SanPham sp) {
        return sanPhamAdminRepository.editSanPham(sp);
    }

    @Override
    public boolean addSanPham(SanPham sp) {
        return sanPhamAdminRepository.addSanPham(sp);
    }

    @Override
    public boolean deleteSanPham(int maSP) {
        SanPham sp = sanPhamAdminRepository.getSanPhamById(maSP);
        if (sp != null) {
            sp.setDaXoa(true);
            sanPhamAdminRepository.editSanPham(sp);
            return true;
        } else {
            return false;
        }
    }

}
