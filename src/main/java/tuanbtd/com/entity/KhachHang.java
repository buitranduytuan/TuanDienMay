package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="KhachHang.findAll", query="SELECT k FROM KhachHang k")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maKH;

    @Column(nullable = true, columnDefinition = "nvarchar(255)")
	private String diaChi;

	private String email;

	private String soDienThoai;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String tenKH;

	//bi-directional many-to-one association to Dondathang
	@OneToMany(mappedBy="khachHang", cascade = CascadeType.ALL)
	private List<DonDatHang> donDatHangs;

	//bi-directional many-to-one association to Thanhvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaThanhVien")
	private ThanhVien thanhVien;

	public KhachHang() {
	}

	public int getMaKH() {
		return this.maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
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

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenKH() {
		return this.tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public List<DonDatHang> getDondathangs() {
		return this.donDatHangs;
	}

	public void setDondathangs(List<DonDatHang> donDatHangs) {
		this.donDatHangs = donDatHangs;
	}

	public DonDatHang addDondathang(DonDatHang donDatHang) {
		getDondathangs().add(donDatHang);
		donDatHang.setKhachhang(this);

		return donDatHang;
	}

	public DonDatHang removeDondathang(DonDatHang donDatHang) {
		getDondathangs().remove(donDatHang);
		donDatHang.setKhachhang(null);

		return donDatHang;
	}

	public ThanhVien getThanhvien() {
		return this.thanhVien;
	}

	public void setThanhvien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	}

}