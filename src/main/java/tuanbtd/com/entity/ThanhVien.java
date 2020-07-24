package tuanbtd.com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "ThanhVien.findAll", query = "SELECT t FROM ThanhVien t")
public class ThanhVien implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maThanhVien;

    @Column(nullable = true, columnDefinition = "nvarchar(50)")
    private String username;

    @Column(nullable = true, length = 128)
    private String password;

    private boolean isEnabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "thanhVien_role", joinColumns = @JoinColumn(name = "thanhVien_maThanhVien"), inverseJoinColumns = @JoinColumn(name = "role_roleId"))
    private Set<Role> roles;

    @Column(nullable = true, columnDefinition = "nvarchar(255)")
    private String diaChi;

    @Column(nullable = true, columnDefinition = "nvarchar(50)")
    private String email;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
    private String hoTen;

    @Column(nullable = true, columnDefinition = "nvarchar(15)")
    private String soDienThoai;

    @OneToMany(mappedBy = "thanhVien", cascade = CascadeType.ALL)
    private List<BinhLuan> binhLuans;

    @OneToMany(mappedBy = "thanhVien", cascade = CascadeType.ALL)
    private List<KhachHang> khachHangs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoaiTV")
    private LoaiThanhVien loaiThanhVien;

    public ThanhVien() {
    }

    public ThanhVien(String username, String password, boolean isEnabled, String diaChi, String email, String hoTen,
            String soDienThoai, Set<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
        this.diaChi = diaChi;
        this.email = email;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.roles = roles;
    }

    public int getMaThanhVien() {
        return this.maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return this.soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<BinhLuan> getBinhLuans() {
        return this.binhLuans;
    }

    public void setBinhluans(List<BinhLuan> binhLuans) {
        this.binhLuans = binhLuans;
    }

    public BinhLuan addBinhluan(BinhLuan binhLuan) {
        getBinhLuans().add(binhLuan);
        binhLuan.setThanhVien(this);

        return binhLuan;
    }

    public BinhLuan removeBinhluan(BinhLuan binhLuan) {
        getBinhLuans().remove(binhLuan);
        binhLuan.setThanhVien(null);

        return binhLuan;
    }

    public List<KhachHang> getKhachHangs() {
        return this.khachHangs;
    }

    public void setKhachhangs(List<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }

    public KhachHang addKhachhang(KhachHang khachHang) {
        getKhachHangs().add(khachHang);
        khachHang.setThanhvien(this);

        return khachHang;
    }

    public KhachHang removeKhachhang(KhachHang khachHang) {
        getKhachHangs().remove(khachHang);
        khachHang.setThanhvien(null);

        return khachHang;
    }

    public LoaiThanhVien getLoaiThanhVien() {
        return this.loaiThanhVien;
    }

    public void setLoaithanhvien(LoaiThanhVien loaiThanhVien) {
        this.loaiThanhVien = loaiThanhVien;
    }

}