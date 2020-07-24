package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="NhaCungCap.findAll", query="SELECT n FROM NhaCungCap n")
public class NhaCungCap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNCC;

    @Column(nullable = true, columnDefinition = "nvarchar(255)")
	private String diaChi;

    @Column(nullable = true, columnDefinition = "nvarchar(50)")
	private String email;

    @Column(nullable = true, columnDefinition = "nvarchar(50)")
	private String fax;

    @Column(nullable = true, columnDefinition = "nvarchar(15)")
	private String soDienThoai;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String tenNCC;

	//bi-directional many-to-one association to Phieunhap
	@OneToMany(mappedBy="nhaCungCap", cascade = CascadeType.ALL)
	private List<PhieuNhap> phieuNhaps;

	//bi-directional many-to-one association to Sanpham
	@OneToMany(mappedBy="nhaCungCap", cascade = CascadeType.ALL)
	private List<SanPham> sanPhams;

	public NhaCungCap() {
	}

	public int getMaNCC() {
		return this.maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
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

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenNCC() {
		return this.tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public List<PhieuNhap> getPhieunhaps() {
		return this.phieuNhaps;
	}

	public void setPhieunhaps(List<PhieuNhap> phieunhaps) {
		this.phieuNhaps = phieunhaps;
	}

	public PhieuNhap addPhieunhap(PhieuNhap phieunhap) {
		getPhieunhaps().add(phieunhap);
		phieunhap.setNhaCungCap(this);

		return phieunhap;
	}

	public PhieuNhap removePhieunhap(PhieuNhap phieunhap) {
		getPhieunhaps().remove(phieunhap);
		phieunhap.setNhaCungCap(null);

		return phieunhap;
	}

	public List<SanPham> getSanphams() {
		return this.sanPhams;
	}

	public void setSanphams(List<SanPham> sanphams) {
		this.sanPhams = sanphams;
	}

	public SanPham addSanpham(SanPham sanpham) {
		getSanphams().add(sanpham);
		sanpham.setNhaCungCap(this);

		return sanpham;
	}

	public SanPham removeSanpham(SanPham sanpham) {
		getSanphams().remove(sanpham);
		sanpham.setNhaCungCap(null);

		return sanpham;
	}

}