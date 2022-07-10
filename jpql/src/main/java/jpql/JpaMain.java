package jpql;

import javax.persistence.*;
import java.util.Collection;
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

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(0);
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(0);
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(0);
            member3.setTeam(teamB);
            em.persist(member3);

//            em.flush();
//            em.clear();
//            String query = "select nullif(m.username, '관리자') as username from Member m";
//            String query = "select locate('de', 'abcdefg') from Member m";
//            String query = "select size(t.members) from Team t";
//            String query = "select index(t.members) from Team t";
//            String query = "select function('group_concat', m.username) from Member m";
//            String query = "select group_concat(m.username) from Member m";

//            String query = "select m.username from Team t join t.members m";
//            List<Collection> result = em.createQuery(query, Collection.class)
//                    .getResultList();
//
//            System.out.println("result = " + result);

//            for (Member s : result) {
//                System.out.println("s = " + s);
//            }
            /**
             * 지연로딩해도 페치 조인이 항상 우선임.
             */
//            String query = "select m from Member m join fetch m.team";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
//                //회원1, 팀A(SQL)
//                //회원2, 팀A(1차캐시)
//                //회원3, 팀B(SQL)
//
//                //회원 100명 -> N + 1
//            }
//            String query = "select t from Team t";
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName() + "|members=" + team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("-> member = " + member);
//                }
//            }

//            String query = "select m from Member m where m.id = :memberId";
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("memberId", member1.getId())
//                    .getSingleResult();
//
//            System.out.println("findMember = " + findMember);

//            String query = "select m from Member m where m.team = :team";
//            List<Member> members = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();
//
//            for (Member member : members) {
//                System.out.println("member = " + member);
//            }

//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }
            //FLUSH 자동 호출 commit, query, flush
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();
            System.out.println("resultCount = " + resultCount);

            em.clear();

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getAge());

            // flush 한다고 해서 영속성 컨텍스트에는 아직 데이터가 남아있기 때문에 반영이 안됨.
//            System.out.println("member1.getAge() = " + member1.getAge());
//            System.out.println("member2.getAge() = " + member2.getAge());
//            System.out.println("member3.getAge() = " + member3.getAge());

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
