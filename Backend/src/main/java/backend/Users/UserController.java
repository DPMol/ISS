package backend.Users;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Users.Models.UserDetails;
import backend.Users.UserRequests.DeleteUserRequest;
import backend.Users.UserRequests.GetUserDetailsRequest;
import backend.Users.UserRequests.LoginUserRequest;
import backend.Users.UserRequests.RegisterUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController extends AbstractController {
    UserService userService;

    @PostMapping("/login")
    public UserDetails login(@Valid @RequestBody LoginUserRequest request){
        return userService.handle(request);
    }

    @PostMapping("/getuserdetails")
    public UserDetails getUserDetails(@Valid @RequestBody GetUserDetailsRequest request){
        return userService.handle(request);
    }
}
