package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행!!!
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //삽입 C
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");

            //조회 R
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //수정 U
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
            //수정시 em.persist 안해도 됨. 마치 자바 컬렉션을 다루는 것처럼 설계되서 그럼.

            //삭제 D
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속 상태
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            //회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
////            em.detach(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//            // 조회할때 DB에 select 쿼리가 안나감 em.persist할때  1차 캐시에 저장되므로 DB에 쿼리 안날림.
//            // DB에서 가져오는게 아니라 1차캐시에서 우선 가져옴
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //영속
//            Member findMember1 = em.find(Member.class, 101L); //DB에서 조회
//            Member findMember2 = em.find(Member.class, 101L); //1차캐시에서 조회
//
//            System.out.println("result = " + (findMember1 == findMember2));

            //영속
            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("===========================");*/

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");

            /*Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush(); //1차캐시는 그대로 유지. 쓰기 지연 SQL 저장소에 쌓인 쿼리들을 DB에 반영시킴
            // 플러시 : 영속성 컨텍스트를 비우지 않음. 영속성 컨텍스트의 변경내용을 DB에 동기화.
            // JPQL 쿼리 실행 시 플러시가 자동으로 실행. 따라서 JPQL 실행시 항상 1차 캐시를 무시하고 DB에 직접 SQL을 실행함. 그리고 실행 결과를 1차 캐시에 보관함.
            // JPQL을 실행해서 DB에서 결과를 가져왔는데, 이미 1차 캐시에 동일한 식별자를 가진 엔티티가 있으면 DB에서 가져온 엔티티를 버리고 1차 캐시에 있는 엔티티를 유지함.

            System.out.println("================================");
//            em.persist(member); JPA는 자바 컬렉션의 값을 변경하는 것과 같음 그냥 값변경만 하면됨
            // 스냅샷 : 영속성 컨텍스트에 최초로 들어온 상태*/

            //영속
            /*Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            //준영속 상태
//            em.detach(member);//select 쿼리만 나가고 update 쿼리가 안나감. 영속성 컨텍스트에서 관리안함.

            em.clear(); // 영속성 컨텍스트를 통으로 초기화함.
            Member member2 = em.find(Member.class, 150L);//1차캐시에 아무것도 없기 때문에 select쿼리 다시실행.

            System.out.println("================================");*/

            /*Member member = new Member();
//            member.setId("ID_A");
            member.setUsername("C");
//            member.setRoleType(RoleType.GUEST);

            System.out.println("===============");

            em.persist(member);// IDENTITY일 경우 pk를 DB insert시 생성하기 때문에 ID 전략이 IDENTITY일땐 em.persist시 insert 쿼리가 날아감.
            // IDENTITY의 경우 영속성 컨텍스트에 모아서 쿼리 날리는 게 안된다는 단점 존재.

            System.out.println("member.id = " + member.getId());
            System.out.println("===============");*/

            /*Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("===============");

            em.persist(member1); //1, 51
            em.persist(member2); //MEM
            em.persist(member3); //MEM

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());

            System.out.println("===============");*/

            //저장
            /*Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }*/
            /*Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            //
            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);*/

            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("========================");
            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("========================");

            tx.commit(); //트랜잭션을 커밋하는 시점에 영속성 컨텍스트에 있는 애가 DB에 쿼리로 날라감.
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
