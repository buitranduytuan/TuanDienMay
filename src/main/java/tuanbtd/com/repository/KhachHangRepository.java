package tuanbtd.com.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.KhachHang;

@Repository
public class KhachHangRepository {
    private final Logger logger = Logger.getLogger(KhachHangRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public boolean saveInfoKH(KhachHang khachHang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(khachHang);
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
