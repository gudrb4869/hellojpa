package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
            // 조회할때 DB에 select 쿼리가 안나감 em.persist할때  1차 캐시에 저장되므로 DB에 쿼리 안날림.
            // DB에서 가져오는게 아니라 1차캐시에서 우선 가져옴
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //영속
//            Member findMember1 = em.find(Member.class, 101L); //DB에서 조회
//            Member findMember2 = em.find(Member.class, 101L); //1차캐시에서 조회
//
//            System.out.println("result = " + (findMember1 == findMember2));

            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("===========================");
//
////            Member member = em.find(Member.class, 150L);
////            member.setName("ZZZZZ");
//
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush(); //1차캐시는 그대로 유지. 쓰기 지연 SQL 저장소에 쌓인 쿼리들을 DB에 반영시킴
            /**
             * 스냅샷 : 영속성 컨텍스트에 최초로 들어온 상태
             * 플러시 : 영속성 컨텍스트를 비우지 않음. 영속성 컨텍스트의 변경내용을 DB에 동기화.
             * JPQL 쿼리 실행 시 플러시가 자동으로 실행. 따라서 JPQL 실행시 항상 1차 캐시를 무시하고 DB에 직접 SQL을 실행함. 그리고 실행 결과를 1차 캐시에 보관함.
             * JPQL을 실행해서 DB에서 결과를 가져왔는데, 이미 1차 캐시에 동일한 식별자를 가진 엔티티가 있으면 DB에서 가져온 엔티티를 버리고 1차 캐시에 있는 엔티티를 유지함.
              */

//            System.out.println("================================");
//            em.persist(member); JPA는 자바 컬렉션의 값을 변경하는 것과 같음 그냥 값변경만 하면됨


            //영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            //준영속 상태
////            em.detach(member);//select 쿼리만 나가고 update 쿼리가 안나감. 영속성 컨텍스트에서 관리안함.
//
//            em.clear(); // 영속성 컨텍스트를 통으로 초기화함.
//            Member member2 = em.find(Member.class, 150L);//1차캐시에 아무것도 없기 때문에 select쿼리 다시실행.
//
//            System.out.println("================================");
//
//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("C");
////            member.setRoleType(RoleType.GUEST);
//
//            System.out.println("===============");
//
//            em.persist(member);
            /**
             * IDENTITY일 경우 pk를 DB insert시 생성하기 때문에 ID 전략이 IDENTITY일땐 em.persist시 insert 쿼리가 날아감.
             * IDENTITY의 경우 영속성 컨텍스트에 모아서 쿼리 날리는 게 안된다는 단점 존재.
             */

//
//            System.out.println("member.id = " + member.getId());
//            System.out.println("===============");
//
//            Member member1 = new Member();
//            member1.setUsername("A");
//
//            Member member2 = new Member();
//            member2.setUsername("B");
//
//            Member member3 = new Member();
//            member3.setUsername("C");
//
//            System.out.println("===============");
//
//            em.persist(member1); //1, 51
//            em.persist(member2); //MEM
//            em.persist(member3); //MEM
//
//            System.out.println("member1 = " + member1.getId());
//            System.out.println("member2 = " + member2.getId());
//            System.out.println("member3 = " + member3.getId());
//
//            System.out.println("===============");

            //저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());
//
//            //
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            team.addMember(member);
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            System.out.println("========================");
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
//            System.out.println("========================");
//
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            //
//            team.getMembers().add(member);
//
//            em.persist(team);

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Item item = em.find(Item.class, movie.getId());
//            System.out.println("item = " + item);
//
//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member member = new Member();
//            member.setUsername("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("before findMember = " + findMember.getClass());
//            System.out.println("findMember.username = " + findMember.getUsername());
//            System.out.println("after findMember = " + findMember.getClass());

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeam(teamB);
//            em.persist(member2);

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);

//            em.flush();
//            em.clear();

//            Member m = em.find(Member.class, member1.getId());
//
//            System.out.println("m = " + m.getTeam().getClass());
//
//            System.out.println("=============");
//            System.out.println("teamName = " + m.getTeam().getName()); //초기화
//            System.out.println("=============");

//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();
            /**
             * @ManyToOne, @OneToOne은 EAGER가 기본값(즉시 로딩) -> LAZY로 설정!
             * @OneToMany, @ManyToMany는 LAZY가 기본값(지연 로딩)
             * 실무에서는 모든 연관관계에 지연 로딩을 사용하자!
             * 즉시 로딩 이용시 JPQL 로 쿼리날리면 N + 1문제 발생
             */

            //SQL: select * from Member
            //SQL: select * from Team where TEAM_ID = xxx


//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); //proxy
//            Hibernate.initialize(refMember); //강제 초기화 (Hibernate에만 있는 메소드, JPA 표준에는 없음. refMember.getName()과 같이 써야함)

//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

//            em.detach(refMember);
//            em.close();
//            em.clear();

//            refMember.getUsername();

//            Member reference = em.find(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass());
//
//            System.out.println("a == a: " + (m1 == reference));

//            Member m2 = em.getReference(Member.class, member2.getId());

//            logic(m1, m2);

            /**
             * 프록시 객체는 처음 사용할 때 한번만 초기화.
             * 프록시 객체를 초기화 할 때, 프록시 객체가 실제 엔티티로 바뀌는 것은 아님. 초기화되면 프록시 객체를 통해서 실제 엔티티에 접근 가능
             * * 프록시 객체는 원본 엔티티를 상속 받음. 따라서 타입 체크시 주의해야함 ( == 비교 실패, 대신 instance of 사용)
             * * 영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환
             *
             */

//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);
//            em.remove(findParent);

            /**
             * 영속성 전이, 고아 객체 : 참조하는 곳이 하나일 때 사용해야 함!
             * CascadeType.ALL + orphanRemoval=true 두 옵션 모두 활성화하면
             * 부모엔티티를 통해서 자식엔티티의 생명주기 관리 가능
             */

//            Address address = new Address("city", "street", "10000");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
//            member.setHomeAddress(newAddress);
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            //
//            member.getHomeAddress().setCity("newCity");

//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("================ START =================");
//            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
            //homeCity -> newCity
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            // equals와 hashCode 제대로 구현되어있어야 동작함!
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
            /**
             * 값 타입 컬렉션에 변경 사항이 발생하면, 주인 엔티티와 연관된 모든 데이터를 삭제하고, 값 타입 컬렉션에 있는 현재 값을 모두 다시 저장한다.
             */
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));


//            List<Member> result = em.createQuery(
//                    "select m from Member as m where m.username like '%kim%'",
//                    Member.class
//            ).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

            //Criteria 사용 준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member> resultList = em.createQuery(cq).getResultList();

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            //flush -> commit, query



            List<Member> resultList = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from Member", Member.class).getResultList();

            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

            tx.commit(); //트랜잭션을 커밋하는 시점에 영속성 컨텍스트에 있는 애가 DB에 쿼리로 날라감.
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    /*private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));

    }*/
}
