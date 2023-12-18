package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Store> StoreList = new ArrayList<>();

    public void addStore(Store store){
        StoreList.add(store);
    }
    public void removeStore(Store store){
        StoreList.remove(store);
    }
}
