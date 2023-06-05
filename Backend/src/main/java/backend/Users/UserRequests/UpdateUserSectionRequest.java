package backend.Users.UserRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserSectionRequest {
    @NotBlank
    private final String username;
    @NotNull
    private final int sectionId;
}
