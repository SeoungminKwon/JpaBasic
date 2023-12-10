package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //UnitName은 persistence.xml파일의 unitName
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code작성 부분

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            //Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery< Member > query = cb.createQuery(Member.class);

            Root< Member > m = query.from(Member.class);
            CriteriaQuery< Member > cq = query.select(m);
            String username = "dfsfdsf";
            if (username != null) {
                cq = cq.where(cb.equal(m.get("username"), "kim"));
            }

            List< Member > resultList = em.createQuery(cq).getResultList();

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }




}
