package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="DonDatHang.findAll", query="SELECT d FROM DonDatHang d")
public class DonDatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDDH;

	private boolean daThanhToan;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayDat;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayGiao;

	private boolean tinhTrangGiaoHang;

	@Column(nullable = true)
	private int uuDai;

	//bi-directional many-to-one association to Chitietdondathang
	@OneToMany(mappedBy="donDatHang", cascade = CascadeType.ALL)
	private List<ChiTietDonDatHang> chiTietDonDatHangs;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MaKH")
	private KhachHang khachHang;

	public DonDatHang() {
	}

	public int getMaDDH() {
		return this.maDDH;
	}

	public void setMaDDH(int maDDH) {
		this.maDDH = maDDH;
	}

	public boolean getDaThanhToan() {
		return this.daThanhToan;
	}

	public void setDaThanhToan(boolean daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public Date getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return this.ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public boolean getTinhTrangGiaoHang() {
		return this.tinhTrangGiaoHang;
	}

	public void setTinhTrangGiaoHang(boolean tinhTrangGiaoHang) {
		this.tinhTrangGiaoHang = tinhTrangGiaoHang;
	}

	public int getUuDai() {
		return this.uuDai;
	}

	public void setUuDai(int uuDai) {
		this.uuDai = uuDai;
	}

	public List<ChiTietDonDatHang> getChiTietDonDatHangs() {
		return this.chiTietDonDatHangs;
	}

	public void setChiTietDonDatHangs(List<ChiTietDonDatHang> chiTietDonDatHangs) {
		this.chiTietDonDatHangs = chiTietDonDatHangs;
	}

	public ChiTietDonDatHang addChitietdondathang(ChiTietDonDatHang chiTietDonDatHang) {
		getChiTietDonDatHangs().add(chiTietDonDatHang);
		chiTietDonDatHang.setDonDatHang(this);

		return chiTietDonDatHang;
	}

	public ChiTietDonDatHang removeChitietdondathang(ChiTietDonDatHang chiTietDonDatHang) {
		getChiTietDonDatHangs().remove(chiTietDonDatHang);
		chiTietDonDatHang.setDonDatHang(null);

		return chiTietDonDatHang;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachhang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

}