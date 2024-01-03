package umc.spring.web.dto.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.validation.annotation.CheckPage;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class PageRequestDTO {
    @NotNull
    @CheckPage
    private Integer page;
    private Integer size;

}
