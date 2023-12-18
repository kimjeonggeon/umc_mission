package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.domain.Store;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
}