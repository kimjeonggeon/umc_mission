package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;
import umc.spring.domain.Review;
public interface StoreRepository extends JpaRepository<Store, Long> {
}