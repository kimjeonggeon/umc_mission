package umc.spring.ApiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.ApiPayload.code.BaseErrorCode;
import umc.spring.ApiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {





    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의바랍니다"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    //테스트 관련
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST,"TEMP4001","테스트입니다."),

    // Mission relative exception
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션이 존재하지 않습니다."),

    // Review relative exception
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW4001", "리뷰가 존재하지 않습니다."),
    //페이지 관련 에러
    PAGE_NUMBER_OUT_OF_RANGE(HttpStatus.BAD_REQUEST, "PAGE4001","페이지 번호는 1 이상이어야합니다."),
    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),


    //지역관련
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,"REGION4001","지역이 존재하지 않습니다."),
    // 매장 관련
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "매장이 존재하지 않습니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // FoodCategory Error
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_CATEGORY4001", "음식 카테고리가 없습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();

    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus(){
        return  ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;

    }


}