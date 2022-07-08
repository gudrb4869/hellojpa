package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
/*@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq",
        initialValue = 1, allocationSize = 50)*/
/*@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)*/
public class Member /*extends BaseEntity*/ {

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

    //기간 Period
//    @Embedded
//    private Period workPeriod;

    //주소
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD",
            joinColumns = @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME") //SET은 값이 하나라 예외적으로 됨
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS",
//            joinColumns = @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city",
//                    column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode",
//                    column = @Column(name = "WORK_ZIPCODEv"))
//    })
//    private Address workAddress;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID"/*, insertable = false, updatable = false*/) // 일대다 양방향 읽기 전용 필드. 다대일 양방향 사용을 권장.
    private Team team;

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

//    public Period getWorkPeriod() {
//        return workPeriod;
//    }
//
//    public void setWorkPeriod(Period workPeriod) {
//        this.workPeriod = workPeriod;
//    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }

    /*@OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;*/

    /*@ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();*/

    /*@OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();*/

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

//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
}
