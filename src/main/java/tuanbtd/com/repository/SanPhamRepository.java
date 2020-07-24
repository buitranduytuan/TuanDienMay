package tuanbtd.com.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.SanPham;
import tuanbtd.com.model.DanhMucSanPhamDTO;

@Repository
public class SanPhamRepository {
    private final Logger logger = Logger.getLogger(SanPhamRepository.class);
    
    @Autowired
    SessionFactory sessionFactory;

    public List<SanPham> getAllSanPham() {
        List<SanPham> listSP = new ArrayList<SanPham>();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT s.maSP, s.tenSP, s.donGia, s.hinhAnh FROM SanPham s where s.daXoa = 0";

            Query query = session.createQuery(sql);
            listSP = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listSP;

    }

    public List<DanhMucSanPhamDTO> getDanhMucSP() {
        List<DanhMucSanPhamDTO> listDM = new ArrayList<DanhMucSanPhamDTO>();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            String sql = "SELECT s.loaiSanPham.tenLoai FROM SanPham s Group by s.loaiSanPham.tenLoai";
            Query query = session.createQuery(sql);
            List<String> tenLoais = query.getResultList();

            for (String tenLoai : tenLoais) {
                DanhMucSanPhamDTO danhMuc = new DanhMucSanPhamDTO();
                danhMuc.setTenLoai(tenLoai);

                String sql2 = "SELECT s.nhaSanXuat.tenNSX FROM SanPham s where s.daXoa = 0 Group by s.nhaSanXuat.tenNSX, s.loaiSanPham.tenLoai "
                        + "HAVING s.loaiSanPham.tenLoai = '" + tenLoai + " ' ";
                Query query2 = session.createQuery(sql2);
                List<String> tenNSXs = query2.getResultList();

                for (String tenNSX : tenNSXs) {
                    danhMuc.getListNSX().add(tenNSX);
                }

                listDM.add(danhMuc);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listDM;

    }

    public List<SanPham> getSanPhamByLoaiSP(String loaiSP) {
        List<SanPham> listSPByNSX = new ArrayList<SanPham>();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT s FROM SanPham s WHERE  s.loaiSanPham.tenLoai = '" + loaiSP + "' AND s.daXoa = 0";

            Query query = session.createQuery(sql);
            listSPByNSX = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listSPByNSX;
    }

    public List<SanPham> getSanPhamByLoaiSP_NSX(String loaiSP, String tenNSX) {
        List<SanPham> listSPByNSX = new ArrayList<SanPham>();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT s FROM SanPham s WHERE  s.loaiSanPham.tenLoai = '" + loaiSP
                    + "' AND s.nhaSanXuat.tenNSX = '" + tenNSX + "' AND s.daXoa = 0";

            Query query = session.createQuery(sql);
            listSPByNSX = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listSPByNSX;
    }

    public SanPham getSanPhamById(int id) {
        SanPham sp = new SanPham();
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            sp = session.get(SanPham.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return sp;
    }

    public List<SanPham> findSanPhamByName(String nameSP) {
        List<SanPham> listSP = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(SanPham.class);
            SimpleExpression eq = Restrictions.like("tenSP", "%" + nameSP + "%");
            SimpleExpression chuaXoa = Restrictions.eq("daXoa", false);
            LogicalExpression le = Restrictions.and(eq, chuaXoa);
            cr.add(le);
            listSP = cr.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listSP;
    }

    public List<SanPham> getTop3SanPhamNew() {
        List<SanPham> listSP = new ArrayList<SanPham>();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT s FROM SanPham s where s.daXoa = 0 ORDER BY s.ngapCapNhat DESC"; 

            Query query = session.createQuery(sql);
            query.setMaxResults(3);
            listSP = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listSP;
    }

    public List<SanPham> getTop3GiamGia() {
        List<SanPham> listSP = new ArrayList<SanPham>();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT s FROM SanPham s where s.daXoa = 0 ORDER BY s.soTienGiamGia DESC";

            Query query = session.createQuery(sql);
            query.setMaxResults(3);
            listSP = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listSP;
    }

}