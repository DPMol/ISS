package backend.Users;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Users.Models.UserDetails;
import backend.Users.UserRequests.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController extends AbstractController {
    UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public UserDetails login(@Valid @RequestBody LoginUserRequest request){
        return userService.handle(request);
    }

    @CrossOrigin
    @GetMapping("/getuserdetails")
    public UserDetails getUserDetails(@Valid @RequestParam(name = "username") String username){
        return userService.handle(new GetUserDetailsRequest(username));
    }

    @CrossOrigin
    @PostMapping("/updatesection")
    public void login(@Valid @RequestBody UpdateUserSectionRequest request){
        userService.handle(request);
    }
}
