package tuanbtd.com.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.ThanhVien;

@Repository
public class ThanhVienRepository {

    private final Logger logger = Logger.getLogger(SanPhamRepository.class);
    @Autowired
    SessionFactory sessionFactory;

    public ThanhVien getThanhVienByUsername(String username) {
        ThanhVien thanhVien = new ThanhVien();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT tv FROM ThanhVien tv WHERE  tv.username = '" + username + "'";

            Query query = session.createQuery(sql);
            thanhVien = (ThanhVien) query.getSingleResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return null;
        } finally {
            session.close();
        }
        return thanhVien;
    }

    public ThanhVien getThanhVienByUsernameAndPassword(String username, String password) {
        ThanhVien thanhVien = new ThanhVien();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT tv FROM ThanhVien tv WHERE  tv.username = '" + username + "' AND tv.password = '"
                    + password + "'";

            Query query = session.createQuery(sql);
            thanhVien = (ThanhVien) query.getSingleResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return null;
        } finally {
            session.close();
        }
        return thanhVien;
    }

    public void registerThanhVien(ThanhVien thanhVien) {
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            if (isUserNameExisting(thanhVien.getUsername())) {
                return;
            }
            session.save(thanhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
    }

    public boolean isUserNameExisting(String username) {
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();

            String sql = "SELECT tv.username FROM ThanhVien tv WHERE  tv.username = '" + username + "'";
            Query query = session.createQuery(sql);
            List<String> listUserName = query.getResultList();
            session.getTransaction().commit();

            for (String name : listUserName) {
                if (name.equalsIgnoreCase(username)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        } finally {
            session.close();
        }
        return false;

    }

    public boolean isEmailExisting(String email) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            String sql = "SELECT tv.email FROM ThanhVien tv WHERE  tv.email = '" + email + "'";
            Query query = session.createQuery(sql);
            List<String> listEmail = query.getResultList();
            session.getTransaction().commit();

            for (String e : listEmail) {
                if (e.equalsIgnoreCase(email)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        } finally {
            session.close();
        }
        return false;
    }

    public boolean updateMemberInfo(ThanhVien thanhVien) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(thanhVien);
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
