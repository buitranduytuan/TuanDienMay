package tuanbtd.com.DTO;

public class NSX_DTO {

    private int maNSX;
    private String logo;
    private String thongTin;

    public NSX_DTO() {
        super();
    }

    public NSX_DTO(int maNSX, String logo, String thongTin) {
        super();
        this.maNSX = maNSX;
        this.logo = logo;
        this.thongTin = thongTin;
    }

    public int getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(int maNSX) {
        this.maNSX = maNSX;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

}
