package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 40)
    private String address;
    @Column(nullable = false, precision = 3, scale = 2)
    private Float score;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();




    public void region(Region region){
        Optional.ofNullable(this.region)
                .ifPresent(oldRegion -> oldRegion.removeStore(this));

        this.region = region;
        region.addStore(this);
    }
}
