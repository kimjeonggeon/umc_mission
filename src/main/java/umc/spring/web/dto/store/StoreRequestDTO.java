package umc.spring.web.dto.store;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {
    @Getter
    public static class ReveiwDTO{
        @NotBlank
        String title;
        @NotNull
        Float score;
        @NotBlank
        String body;
    }
    @Getter
    public static class MissionDTO{
        @NotBlank
        String title;
        @NotNull
        Float reward;
        @NotBlank
        String body;
    }
}
