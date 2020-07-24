package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery(name="BinhLuan.findAll", query="SELECT b FROM BinhLuan b")
public class BinhLuan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maBL;

    @Column(nullable = true, columnDefinition = "nvarchar(MAX)")
	private String noiDungBL;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaSP")
	private SanPham sanPham;

	//bi-directional many-to-one association to Thanhvien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaThanhVien")
	private ThanhVien thanhVien;

	public BinhLuan() {
	}

	public int getMaBL() {
		return this.maBL;
	}

	public void setMaBL(int maBL) {
		this.maBL = maBL;
	}

	public String getNoiDungBL() {
		return this.noiDungBL;
	}

	public void setNoiDungBL(String noiDungBL) {
		this.noiDungBL = noiDungBL;
	}

	public SanPham getSanpham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public ThanhVien getThanhVien() {
		return this.thanhVien;
	}

	public void setThanhVien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	}

}