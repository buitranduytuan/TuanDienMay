/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuanbtd.com.service;

import tuanbtd.com.entity.ThanhVien;

public interface ThanhVienService {

    public ThanhVien getThanhVienByUsernameAndPassword(String username, String password);
    public ThanhVien getThanhVienByUsername(String username);
    public void registerThanhVien(ThanhVien thanhVien);
    public boolean isUserNameExisting(String username);
    public boolean isEmailExisting(String email);
    public boolean updateMemberInfo(ThanhVien thanhVien);
}
