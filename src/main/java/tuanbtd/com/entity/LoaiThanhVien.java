package tuanbtd.com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name="LoaiThanhVien.findAll", query="SELECT l FROM LoaiThanhVien l")
public class LoaiThanhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maLoaiTV;

    @Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String tenLoai;

	@Column(nullable = true)
	private int uuDai;

	//bi-directional many-to-one association to Thanhvien
	@OneToMany(mappedBy="loaiThanhVien", cascade = CascadeType.ALL)
	private List<ThanhVien> thanhViens;

	public LoaiThanhVien() {
	}

	public int getMaLoaiTV() {
		return this.maLoaiTV;
	}

	public void setMaLoaiTV(int maLoaiTV) {
		this.maLoaiTV = maLoaiTV;
	}

	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public int getUuDai() {
		return this.uuDai;
	}

	public void setUuDai(int uuDai) {
		this.uuDai = uuDai;
	}

	public List<ThanhVien> getThanhViens() {
		return this.thanhViens;
	}

	public void setThanhviens(List<ThanhVien> thanhviens) {
		this.thanhViens = thanhviens;
	}

	public ThanhVien addThanhvien(ThanhVien thanhvien) {
		getThanhViens().add(thanhvien);
		thanhvien.setLoaithanhvien(this);

		return thanhvien;
	}

	public ThanhVien removeThanhvien(ThanhVien thanhvien) {
		getThanhViens().remove(thanhvien);
		thanhvien.setLoaithanhvien(null);

		return thanhvien;
	}

}