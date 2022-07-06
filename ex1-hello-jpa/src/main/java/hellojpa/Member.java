package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
/*@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq",
        initialValue = 1, allocationSize = 50)*/
/*@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)*/
public class Member {

    @Id //pk를 매핑
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

//    @Column(name = "name", nullable = false) // db컬럼명은 name
    @Column(name = "USERNAME")
    private String username;

    /*@Column(name = "TEAM_ID")
    private Long teamId;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    /*private int age;

    @Enumerated(EnumType.STRING) // 기본적으로 DB에는 enum타입이 없다. ORDINAL보단 STRING쓰는걸 권장.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob // varchar를 넘는 큰 컨텐츠
    private String description;

    @Transient // 메모리에서만 사용. DB 컬럼에 매핑하지 않고 무시.
    private int temp;*/

    // JPA는 기본생성자 하나있어야함. public 또는 protected 생성자


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
