package tuanbtd.com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.KhachHang;
import tuanbtd.com.repository.KhachHangRepository;
import tuanbtd.com.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;
    
    @Override
    public boolean saveInfoKH(KhachHang khachHang) {
       return khachHangRepository.saveInfoKH(khachHang);
    }
}
