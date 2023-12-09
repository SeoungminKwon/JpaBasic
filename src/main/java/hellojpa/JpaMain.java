package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        //UnitName은 persistence.xml파일의 unitName
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code작성 부분

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member m = em.find(Member.class, member.getId());

            System.out.println("m = " + m.getTeam().getClass());

            System.out.println("==============================");
            System.out.println(m.getTeam().getName());
            System.out.println("==============================");


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
