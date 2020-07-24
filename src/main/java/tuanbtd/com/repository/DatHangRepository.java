package tuanbtd.com.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.ChiTietDonDatHang;
import tuanbtd.com.entity.DonDatHang;

@Repository
public class DatHangRepository {

    private final Logger logger = Logger.getLogger(DatHangRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public boolean saveDonDatHang(DonDatHang donDatHang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(donDatHang);
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

    public boolean saveChiTietDonDatHang(ChiTietDonDatHang chiTietDonDatHang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(chiTietDonDatHang);
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

    public DonDatHang getDDHByMaDDH(int maDDH) {
        DonDatHang ddh = new DonDatHang();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            ddh = session.get(DonDatHang.class, maDDH);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return ddh;

    }

    public List<ChiTietDonDatHang> getChiTietDDHByMaDHH(int maDDH) {
        List<ChiTietDonDatHang> chiTietDDHs = new ArrayList<ChiTietDonDatHang>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT ct FROM ChiTietDonDatHang ct WHERE ct.donDatHang.maDDH = " + maDDH;
            Query query = session.createQuery(sql);
            chiTietDDHs = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return chiTietDDHs;
    }

    public boolean updateDDH(DonDatHang ddh) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(ddh);
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

    public List<DonDatHang> getDonHangChuaThanhToan() {
        List<DonDatHang> listOrder = new ArrayList<DonDatHang>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT ddh FROM DonDatHang ddh WHERE ddh.daThanhToan = 0";
            Query query = session.createQuery(sql);
            listOrder = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listOrder;

    }

    public List<DonDatHang> getDonHangDaThanhToanChuaGiao() {
        List<DonDatHang> listOrder = new ArrayList<DonDatHang>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT ddh FROM DonDatHang ddh WHERE ddh.daThanhToan = 1 AND tinhTrangGiaoHang = 0";
            Query query = session.createQuery(sql);
            listOrder = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listOrder;

    }

    public List<DonDatHang> getDonHangDaThanhToanDaGiao() {
        List<DonDatHang> listOrder = new ArrayList<DonDatHang>();

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String sql = "SELECT ddh FROM DonDatHang ddh WHERE ddh.daThanhToan = 1 AND tinhTrangGiaoHang = 1";
            Query query = session.createQuery(sql);
            listOrder = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listOrder;

    }
}
