package tuanbtd.com.service;

import java.util.List;

import tuanbtd.com.entity.ChiTietDonDatHang;
import tuanbtd.com.entity.DonDatHang;

public interface DatHangService {

    public boolean saveDonDatHang(DonDatHang donDatHang);

    public boolean saveChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang);
    
    public DonDatHang getDDHByMaDDH(int maDDH);
    
    public List<ChiTietDonDatHang> getChiTietDDHByMaDHH(int maDDH);
    
    public boolean updateDDH(DonDatHang ddh);
    
    public List<DonDatHang> getDonHangChuaThanhToan();
    
    public List<DonDatHang> getDonHangDaThanhToanChuaGiao();
    
    public List<DonDatHang> getDonHangDaThanhToanDaGiao();

}