package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.setTeam(team);
//            em.persist(member);
//
//
//            em.flush();
//            em.clear();
//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            // Spring Data JPA -> Optional이나 null
//            System.out.println("result = " + result.getUsername());

//            List<MemberDTO> result = em.createQuery("select distinct new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("username = " + memberDTO.getUsername());
//            System.out.println("age = " + memberDTO.getAge());
//
//            Member findMember = result.get(0);
//            findMember.setAge(20);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m");
//            String query = "select m from Member m join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
////                    .setFirstResult(1)
////                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());

//            System.out.println("result.size = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }
//            String query = "select m.username, 'HELLO', TRUE From Member m where m.type = :userType";
//            List<Object[]> result = em.createQuery(query).setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }

//            String query = "select " +
//                    "case when m.age <= 10 then '학생요금' " +
//                    "     when m.age >= 60 then '경로요금' " +
//                    "     else '일반요금' " +
//                    "end " +
//                    "from Member m";

            Member member1 = new Member();
            member1.setUsername("관리자1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            em.persist(member2);

            em.flush();
            em.clear();
//            String query = "select nullif(m.username, '관리자') as username from Member m";
//            String query = "select locate('de', 'abcdefg') from Member m";
//            String query = "select size(t.members) from Team t";
//            String query = "select index(t.members) from Team t";
//            String query = "select function('group_concat', m.username) from Member m";
            String query = "select group_concat(m.username) from Member m";

            List<String> result = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : result) {
                System.out.println("s = " + s);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
