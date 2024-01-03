package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.ApiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberResponseDTO;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JointDto request){
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
    @GetMapping("/{memberId}/reviews")
    @Operation(summary ="내가 작성한 리뷰 목록 조회 api",
            description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. " +
                    "query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode ="COMMON200", description ="OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "가게의 아이디, pathvariable 입니다!"),
            @Parameter(name = "page", description = "페이지번호, 0번이 1페이지"),
    })

    public ApiResponse<MemberResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistMember @PathVariable(name ="memberId")Long memberId,
                                                                             @CheckPage @RequestParam(name = "page")Integer page){
       Page<Review> reviewList = memberQueryService.getReviewList(memberId,page);
        return ApiResponse.onSuccess(MemberConverter.reviewPreviewListDTO(reviewList));
    }
}
