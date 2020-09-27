package tuanbtd.com.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.DTO.NSX_DTO;
import tuanbtd.com.entity.NhaSanXuat;
import tuanbtd.com.mapper.NSX_Mapper;

@Repository
public class NhaSanXuatRepository {

    private final Logger logger = Logger.getLogger(NhaSanXuatRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public List<NSX_DTO> getListNSX() {
        List<NSX_DTO> listNSX = new ArrayList<NSX_DTO>();
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT nsx FROM NhaSanXuat nsx";

            List<NhaSanXuat> list = session.createQuery(sql).getResultList();
            for(NhaSanXuat obj : list) {
                listNSX.add(NSX_Mapper.toNSX_DTO(obj));
            }

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
    
    public boolean deleteNSX(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            NhaSanXuat nsx = getNSXById(id);
            session.delete(nsx);
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
