package umc.spring.service.StoreService;

import umc.spring.domain.Review;
import umc.spring.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReveiwDTO request);
}
