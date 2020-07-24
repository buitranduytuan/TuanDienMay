package tuanbtd.com.service;

import java.util.List;

import tuanbtd.com.entity.LoaiSanPham;
import tuanbtd.com.entity.NhaCungCap;
import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.entity.SanPham;

public interface SanPhamAdminService {

    public List<SanPham> getAllAdminProduct();
    
    public SanPham getSanPhamById(int id);

    public List<LoaiSanPham> getAllLoaiSanPham();

    public List<NhaSanXuat> getAllNSX();

    public List<NhaCungCap> getAllNCC();

    public boolean editSanPham(SanPham sp);

    public boolean addSanPham(SanPham sp);
    
    public boolean deleteSanPham(int maSP);

}