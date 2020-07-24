package tuanbtd.com.model;

public class ThanhVienFrom {

    private String username;

    private String password;

    private String repeatPassword;

    private String diaChi;

    private String email;

    private String hoTen;

    private String soDienThoai;

    public ThanhVienFrom(String username, String password, String repeatPassword, String diaChi, String email,
            String hoTen, String soDienThoai) {
        super();
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.diaChi = diaChi;
        this.email = email;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public ThanhVienFrom() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

}