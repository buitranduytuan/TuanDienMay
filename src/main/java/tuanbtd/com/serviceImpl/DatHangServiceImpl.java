package tuanbtd.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.ChiTietDonDatHang;
import tuanbtd.com.entity.DonDatHang;
import tuanbtd.com.repository.DatHangRepository;
import tuanbtd.com.service.DatHangService;

@Service
public class DatHangServiceImpl implements DatHangService {

    @Autowired
    DatHangRepository datHangRepository;

    @Override
    public boolean saveDonDatHang(DonDatHang donDatHang) {
        return datHangRepository.saveDonDatHang(donDatHang);
    }

    @Override
    public boolean saveChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
        return datHangRepository.saveChiTietDonDatHang(chiTietDonDatHang);
    }

    @Override
    public DonDatHang getDDHByMaDDH(int maDDH) {
        return datHangRepository.getDDHByMaDDH(maDDH);
    }

    @Override
    public List<ChiTietDonDatHang> getChiTietDDHByMaDHH(int maDDH) {
        return datHangRepository.getChiTietDDHByMaDHH(maDDH);
    }

    @Override
    public boolean updateDDH(DonDatHang ddh) {
        return datHangRepository.updateDDH(ddh);
    }

    @Override
    public List<DonDatHang> getDonHangChuaThanhToan() {
        return datHangRepository.getDonHangChuaThanhToan();
    }

    @Override
    public List<DonDatHang> getDonHangDaThanhToanChuaGiao() {
        return datHangRepository.getDonHangDaThanhToanChuaGiao();
    }

    @Override
    public List<DonDatHang> getDonHangDaThanhToanDaGiao() {
        return datHangRepository.getDonHangDaThanhToanDaGiao();
    }

}
