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

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
