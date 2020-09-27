package tuanbtd.com.DTO;

import java.util.ArrayList;
import java.util.List;

public class DanhMucSanPhamDTO {

    private String tenLoai;
    private List<String> listNSX = new ArrayList<String>();

    public DanhMucSanPhamDTO() {
        super();
    }

    public DanhMucSanPhamDTO(String tenLoai, List<String> listNSX) {
        super();
        this.tenLoai = tenLoai;
        this.listNSX = listNSX;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<String> getListNSX() {
        return listNSX;
    }

    public void setListNSX(List<String> listNSX) {
        this.listNSX = listNSX;
    }

}
