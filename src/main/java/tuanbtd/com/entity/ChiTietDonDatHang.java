package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@NamedQuery(name="ChiTietDonDatHang.findAll", query="SELECT c FROM ChiTietDonDatHang c")
public class ChiTietDonDatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChiTietDDH;

    @Column(nullable = true, columnDefinition = "decimal(18, 0)")
	private BigDecimal donGia;

	private int soLuong;

    @Column(nullable = true, columnDefinition = "nvarchar(255)")
	private String tenSP;

	//bi-directional many-to-one association to Dondathang
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaDDH")
	private DonDatHang donDatHang;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MaSP")
	private SanPham sanPham;

	public ChiTietDonDatHang() {
	}

	public int getMaChiTietDDH() {
		return this.maChiTietDDH;
	}

	public void setMaChiTietDDH(int maChiTietDDH) {
		this.maChiTietDDH = maChiTietDDH;
	}

	public BigDecimal getDonGia() {
		return this.donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenSP() {
		return this.tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public DonDatHang getDondathang() {
		return this.donDatHang;
	}

	public void setDonDatHang(DonDatHang donDatHang) {
		this.donDatHang = donDatHang;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanpham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}