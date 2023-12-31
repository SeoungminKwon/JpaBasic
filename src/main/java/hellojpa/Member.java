package hellojpa;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Member{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //Period 기간
    @Embedded
    private Period workPeriod;
    //집주소
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_IO"))
    @Column(name = "FOOD_NAME")
    private Set< String > favoriteFoods = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List< AddressEntity > addressHistory = new ArrayList<>();

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

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set< String > getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set< String > favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List< AddressEntity > getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List< AddressEntity > addressHistory) {
        this.addressHistory = addressHistory;
    }
}
