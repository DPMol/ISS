package backend.Users.UserRequests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserRequest extends AbstractRequest {
    @NotBlank
    @Size(min = 2)
    private final String username;
    @NotBlank
    @Size(min = 2)
    private final String password;
}
