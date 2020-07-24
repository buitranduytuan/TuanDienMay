package tuanbtd.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
public class SanPham implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSP;

    @Column(nullable = true, columnDefinition = "nvarchar(255)")
    private String tenSP;

    @Column(nullable = true, columnDefinition = "decimal(18, 0)")
    private BigDecimal donGia;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date ngapCapNhat;

    @Column(nullable = true, columnDefinition = "nvarchar(MAX)")
    private String cauHinh;

    @Column(nullable = true, columnDefinition = "nvarchar(MAX)")
    private String moTa;

    @Column(nullable = true, columnDefinition = "nvarchar(MAX)")
    private String hinhAnh;

    @Column(nullable = true)
    private int soLuongTon;

    @Column(nullable = true)
    private int luotXem;

    @Column(nullable = true, columnDefinition = "decimal(18, 0)")
    private BigDecimal soTienGiamGia;

    @Column(nullable = true)
    private int luotBinhLuan;

    @Column(nullable = true)
    private int soLanMua;

    @Column(nullable = true)
    private boolean moi;

    private boolean daXoa;

    // bi-directional many-to-one association to Nhacungcap
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaNCC")
    private NhaCungCap nhaCungCap;

    // bi-directional many-to-one association to Nhasanxuat
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaNSX")
    private NhaSanXuat nhaSanXuat;

    // bi-directional many-to-one association to Loaisanpham
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaLoaiSP")
    private LoaiSanPham loaiSanPham;

    // bi-directional many-to-one association to Binhluan
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    private List<BinhLuan> binhLuans;

    // bi-directional many-to-one association to Chitietdondathang
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    private List<ChiTietDonDatHang> chiTietDonDatHangs;

    // bi-directional many-to-one association to Chitietphieunhap
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

    public SanPham() {
    }

    public int getMaSP() {
        return this.maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getCauHinh() {
        return this.cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public boolean getDaXoa() {
        return this.daXoa;
    }

    public void setDaXoa(boolean daXoa) {
        this.daXoa = daXoa;
    }

    public BigDecimal getDonGia() {
        return this.donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public BigDecimal getSoTienGiamGia() {
        return soTienGiamGia;
    }

    public void setSoTienGiamGia(BigDecimal soTienGiamGia) {
        this.soTienGiamGia = soTienGiamGia;
    }

    public int getLuotBinhLuan() {
        return this.luotBinhLuan;
    }

    public void setLuotBinhLuan(int luotBinhLuan) {
        this.luotBinhLuan = luotBinhLuan;
    }

    public int getLuotXem() {
        return this.luotXem;
    }

    public void setLuotXem(int luotXem) {
        this.luotXem = luotXem;
    }

    public boolean getMoi() {
        return this.moi;
    }

    public void setMoi(boolean moi) {
        this.moi = moi;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgapCapNhat() {
        return ngapCapNhat;
    }

    public void setNgapCapNhat(Date ngapCapNhat) {
        this.ngapCapNhat = ngapCapNhat;
    }

    public int getSoLanMua() {
        return this.soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    public int getSoLuongTon() {
        return this.soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getTenSP() {
        return this.tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public List<BinhLuan> getBinhLuans() {
        return this.binhLuans;
    }

    public void setBinhluans(List<BinhLuan> binhluans) {
        this.binhLuans = binhluans;
    }

    public LoaiSanPham getLoaiSanPham() {
        return this.loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public NhaCungCap getNhaCungCap() {
        return this.nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public NhaSanXuat getNhaSanXuat() {
        return this.nhaSanXuat;
    }

    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public BinhLuan addBinhluan(BinhLuan binhluan) {
        getBinhLuans().add(binhluan);
        binhluan.setSanPham(this);

        return binhluan;
    }

    public BinhLuan removeBinhluan(BinhLuan binhluan) {
        getBinhLuans().remove(binhluan);
        binhluan.setSanPham(null);

        return binhluan;
    }

    public List<ChiTietDonDatHang> getChitietdondathangs() {
        return this.chiTietDonDatHangs;
    }

    public void setChitietdondathangs(List<ChiTietDonDatHang> chitietdondathangs) {
        this.chiTietDonDatHangs = chitietdondathangs;
    }

    public ChiTietDonDatHang addChitietdondathang(ChiTietDonDatHang chitietdondathang) {
        getChitietdondathangs().add(chitietdondathang);
        chitietdondathang.setSanpham(this);

        return chitietdondathang;
    }

    public ChiTietDonDatHang removeChitietdondathang(ChiTietDonDatHang chitietdondathang) {
        getChitietdondathangs().remove(chitietdondathang);
        chitietdondathang.setSanpham(null);

        return chitietdondathang;
    }

    public List<ChiTietPhieuNhap> getChitietphieunhaps() {
        return this.chiTietPhieuNhaps;
    }

    public void setChitietphieunhaps(List<ChiTietPhieuNhap> chitietphieunhaps) {
        this.chiTietPhieuNhaps = chitietphieunhaps;
    }

    public ChiTietPhieuNhap addChitietphieunhap(ChiTietPhieuNhap chitietphieunhap) {
        getChitietphieunhaps().add(chitietphieunhap);
        chitietphieunhap.setSanpham(this);

        return chitietphieunhap;
    }

    public ChiTietPhieuNhap removeChitietphieunhap(ChiTietPhieuNhap chitietphieunhap) {
        getChitietphieunhaps().remove(chitietphieunhap);
        chitietphieunhap.setSanpham(null);

        return chitietphieunhap;
    }

}