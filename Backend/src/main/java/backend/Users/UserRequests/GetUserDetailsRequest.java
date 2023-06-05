package backend.Users.UserRequests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDetailsRequest extends AbstractRequest {
    @NotBlank
    private String username;
}
