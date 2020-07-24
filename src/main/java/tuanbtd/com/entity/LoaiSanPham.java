package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="LoaiSanPham.findAll", query="SELECT l FROM LoaiSanPham l")
public class LoaiSanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maLoaiSP;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String biDanh;

    @Column(nullable = true, columnDefinition = "nvarchar(MAX)")
	private String icon;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String tenLoai;

	//bi-directional many-to-one association to Sanpham
	@OneToMany(mappedBy="loaiSanPham", cascade = CascadeType.ALL)
	private List<SanPham> sanPhams;
	
	public LoaiSanPham() {
	}

	public int getMaLoaiSP() {
		return this.maLoaiSP;
	}

	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getBiDanh() {
		return this.biDanh;
	}

	public void setBiDanh(String biDanh) {
		this.biDanh = biDanh;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<SanPham> getSanphams() {
		return this.sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public SanPham addSanpham(SanPham sanpham) {
		getSanphams().add(sanpham);
		sanpham.setLoaiSanPham(this);

		return sanpham;
	}

	public SanPham removeSanpham(SanPham sanpham) {
		getSanphams().remove(sanpham);
		sanpham.setLoaiSanPham(null);

		return sanpham;
	}

}