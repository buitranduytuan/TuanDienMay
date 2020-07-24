package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name="PhieuNhap.findAll", query="SELECT p FROM PhieuNhap p")
public class PhieuNhap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maPN;

	private boolean daXoa;

	@Temporal(TemporalType.DATE)
	private Date ngayNhap;

	//bi-directional many-to-one association to Chitietphieunhap
	@OneToMany(mappedBy="phieuNhap", cascade = CascadeType.ALL)
	private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

	//bi-directional many-to-one association to Nhacungcap
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaNCC")
	private NhaCungCap nhaCungCap;

	public PhieuNhap() {
	}

	public int getMaPN() {
		return this.maPN;
	}

	public void setMaPN(int maPN) {
		this.maPN = maPN;
	}

	public boolean getDaXoa() {
		return this.daXoa;
	}

	public void setDaXoa(boolean daXoa) {
		this.daXoa = daXoa;
	}

	public Date getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public List<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
		return this.chiTietPhieuNhaps;
	}

	public void setChiTietPhieuNhaps(List<ChiTietPhieuNhap> chiTietPhieuNhaps) {
		this.chiTietPhieuNhaps = chiTietPhieuNhaps;
	}

	public ChiTietPhieuNhap addChitietphieunhap(ChiTietPhieuNhap chitietphieunhap) {
		getChiTietPhieuNhaps().add(chitietphieunhap);
		chitietphieunhap.setPhieunhap(this);

		return chitietphieunhap;
	}

	public ChiTietPhieuNhap removeChitietphieunhap(ChiTietPhieuNhap chitietphieunhap) {
		getChiTietPhieuNhaps().remove(chitietphieunhap);
		chitietphieunhap.setPhieunhap(null);

		return chitietphieunhap;
	}

	public NhaCungCap getNhaCungCap() {
		return this.nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

}