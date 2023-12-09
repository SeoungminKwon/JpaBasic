package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //UnitName은 persistence.xml파일의 unitName
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code작성 부분

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("m1.getClass() = " + refMember.getClass()); //Proxy
            refMember.getUsername();

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("reference.getClass() = " + findMember.getClass()); // Member

            System.out.println("refMember == findMember   : " + (refMember == findMember));


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }




}
