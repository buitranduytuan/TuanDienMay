package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@NamedQuery(name="ChiTietPhieuNhap.findAll", query="SELECT c FROM ChiTietPhieuNhap c")
public class ChiTietPhieuNhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChiTietPN;

    @Column(nullable = true, columnDefinition = "decimal(18, 0)")
	private BigDecimal donGiaNhap;

	private int soLuongNhap;

	//bi-directional many-to-one association to Phieunhap
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaPN")
	private PhieuNhap phieuNhap;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaSP")
	private SanPham sanPham;

	public ChiTietPhieuNhap() {
	}

	public int getMaChiTietPN() {
		return this.maChiTietPN;
	}

	public void setMaChiTietPN(int maChiTietPN) {
		this.maChiTietPN = maChiTietPN;
	}

	public BigDecimal getDonGiaNhap() {
		return this.donGiaNhap;
	}

	public void setDonGiaNhap(BigDecimal donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}

	public int getSoLuongNhap() {
		return this.soLuongNhap;
	}

	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}

	public PhieuNhap getPhieunhap() {
		return this.phieuNhap;
	}

	public void setPhieunhap(PhieuNhap phieunhap) {
		this.phieuNhap = phieunhap;
	}

	public SanPham getSanpham() {
		return this.sanPham;
	}

	public void setSanpham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}