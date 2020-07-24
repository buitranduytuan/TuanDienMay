package tuanbtd.com.service;

import java.util.List;

import tuanbtd.com.entity.SanPham;
import tuanbtd.com.model.DanhMucSanPhamDTO;

public interface SanPhamService {
   
  public  List<SanPham> getAllSanPham();
  
  public List<DanhMucSanPhamDTO> getDanhMucSP();
  
  public SanPham getSanPhamById(int id);
  
  public List<SanPham> getTop3SanPhamNew();
  
  public List<SanPham> getTop3GiamGia();
  
  public List<SanPham> getSanPhamByLoaiSP_NSX(String loaiSP, String tenNSX);
  
  public List<SanPham> getSanPhamByLoaiSP(String loaiSP);
  
  public List<SanPham> findSanPhamByName(String nameSP);
  
}
