package tuanbtd.com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.ThanhVien;
import tuanbtd.com.repository.ThanhVienRepository;
import tuanbtd.com.service.ThanhVienService;

@Service
public class ThanhVienServiceImpl implements ThanhVienService{

    @Autowired
    ThanhVienRepository thanhVienRepository;
    
    @Override
    public ThanhVien getThanhVienByUsernameAndPassword(String username, String password) {
        return thanhVienRepository.getThanhVienByUsernameAndPassword(username, password);
    }
    
    @Override
    public ThanhVien getThanhVienByUsername(String username) {
        return thanhVienRepository.getThanhVienByUsername(username);
    }

    @Override
    public void registerThanhVien(ThanhVien thanhVien) {
        thanhVienRepository.registerThanhVien(thanhVien);
    }

    @Override
    public boolean isUserNameExisting(String username) {
        return thanhVienRepository.isUserNameExisting(username);
    }

    @Override
    public boolean isEmailExisting(String email) {
        return thanhVienRepository.isEmailExisting(email);
    }

    @Override
    public boolean updateMemberInfo(ThanhVien thanhVien) {
        return thanhVienRepository.updateMemberInfo(thanhVien);
    }

    

}
