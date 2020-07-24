package tuanbtd.com.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.LoaiSanPham;
import tuanbtd.com.entity.NhaCungCap;
import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.entity.SanPham;

@Repository
public class SanPhamAdminRepository {

    private final Logger logger = Logger.getLogger(SanPhamAdminRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public List<SanPham> getAllAdminProduct() {
        List<SanPham> listSP = new ArrayList<SanPham>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT s FROM SanPham s where s.daXoa = 0";
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

    public List<LoaiSanPham> getAllLoaiSanPham() {
        List<LoaiSanPham> listLoaiSP = new ArrayList<LoaiSanPham>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT lsp FROM LoaiSanPham lsp";
            Query query = session.createQuery(sql);
            listLoaiSP = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listLoaiSP;

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

    public List<NhaSanXuat> getAllNSX() {
        List<NhaSanXuat> listNSX = new ArrayList<NhaSanXuat>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT nsx FROM NhaSanXuat nsx";
            Query query = session.createQuery(sql);
            listNSX = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listNSX;

    }

    public List<NhaCungCap> getAllNCC() {
        List<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT ncc FROM NhaCungCap ncc";
            Query query = session.createQuery(sql);
            listNCC = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listNCC;

    }

    public boolean editSanPham(SanPham sp) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(sp);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean addSanPham(SanPham sp) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(sp);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        } finally {
            session.close();
        }
        return true;
    }

}
