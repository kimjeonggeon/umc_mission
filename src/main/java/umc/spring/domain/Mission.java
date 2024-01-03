package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer reward;
    @Column(nullable = false)
    private LocalDate deadline;
    @Column(nullable = false, length = 100)
    private String missionSpec;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();




 /*   public void setStore(Store store){
        if (this.store != null)
            store.getMission().remove(this);
        this.store = store;
        store.getReviewList().add(this);
    }*/

    public void challenge(MemberMission memberMission) {
        memberMissionList.add(memberMission);
    }

 }
