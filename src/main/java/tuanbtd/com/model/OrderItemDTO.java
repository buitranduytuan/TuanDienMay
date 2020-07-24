package tuanbtd.com.model;

import tuanbtd.com.entity.SanPham;

public class OrderItemDTO {

    private int number;

    private SanPham sanPham;

    public OrderItemDTO(int number, SanPham sanPham) {
        super();
        this.number = number;
        this.sanPham = sanPham;
    }

    public OrderItemDTO() {
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

}
