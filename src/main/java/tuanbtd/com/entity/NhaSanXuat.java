package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="NhaSanXuat.findAll", query="SELECT n FROM NhaSanXuat n")
public class NhaSanXuat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maNSX;

    @Column(nullable = true, columnDefinition = "nvarchar(MAX)")
	private String logo;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String tenNSX;

    @Column(nullable = true, columnDefinition = "nvarchar(255)")
	private String thongTin;

	//bi-directional many-to-one association to Sanpham
	@OneToMany(mappedBy="nhaSanXuat", cascade = CascadeType.ALL)
	private List<SanPham> sanPhams;

	public NhaSanXuat() {
	}

	public int getMaNSX() {
		return this.maNSX;
	}

	public void setMaNSX(int maNSX) {
		this.maNSX = maNSX;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTenNSX() {
		return this.tenNSX;
	}

	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}

	public String getThongTin() {
		return this.thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public List<SanPham> getSanphams() {
		return this.sanPhams;
	}

	public void setSanphams(List<SanPham> sanphams) {
		this.sanPhams = sanphams;
	}

	public SanPham addSanpham(SanPham sanpham) {
		getSanphams().add(sanpham);
		sanpham.setNhaSanXuat(this);

		return sanpham;
	}

	public SanPham removeSanpham(SanPham sanpham) {
		getSanphams().remove(sanpham);
		sanpham.setNhaSanXuat(null);

		return sanpham;
	}

}