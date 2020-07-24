package tuanbtd.com.repository;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tuanbtd.com.entity.Role;

@Repository
public class RoleRepository {

    private final Logger logger = Logger.getLogger(RoleRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public Role getRoleByRoleName(String roleName) {
        Role role = new Role();

        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            String sql = "SELECT role FROM Role role WHERE  role.roleName = '" + roleName + "'";

            Query query = session.createQuery(sql);
            role = (Role) query.getSingleResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return null;
        } finally {
            session.close();
        }
        return role;
    }

    public void saveRole(Role role) {
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
    }

}