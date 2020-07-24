package tuanbtd.com.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.NhaSanXuat;

@Repository
public class NhaSanXuatRepository {

    private final Logger logger = Logger.getLogger(NhaSanXuatRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public List<NhaSanXuat> getListNSX() {
        List<NhaSanXuat> listNSX = new ArrayList<NhaSanXuat>();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT nsx.maNSX, nsx.logo, nsx.tenNSX, nsx.thongTin FROM NhaSanXuat nsx";

            Query query = session.createQuery(sql);
            listNSX = session.createQuery(sql).getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return listNSX;
    }

    public NhaSanXuat getNSXById(int id) {
        NhaSanXuat nsx = new NhaSanXuat();
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            nsx = session.get(NhaSanXuat.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }

        return nsx;
    }

    public boolean addNSX(NhaSanXuat nsx) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(nsx);
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

    public boolean updateNSX(NhaSanXuat nsx) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(nsx);
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
