package backend.Users;

import backend.Domain.User;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Infrastructure.ErrorMessages;
import backend.Repositories.UserRepository;
import backend.Users.Models.UserDetails;
import backend.Users.UserRequests.GetUserDetailsRequest;
import backend.Users.UserRequests.LoginUserRequest;
import backend.Users.UserRequests.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService extends AbstractService {
    private UserRepository userRepository;

    public UserDetails handle(LoginUserRequest request) {
        Optional<User> result = userRepository.findById(request.getUsername());
        if(result.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }

        User user = result.get();
        if(!Objects.equals(user.getPassword(), request.getPassword())){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }
        return UserDetails.FromUser(user);
    }

    public UserDetails handle(GetUserDetailsRequest request) {
        Optional<User> result = userRepository.findById(request.getEmail());
        if(result.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }

        return UserDetails.FromUser(result.get());
    }
}
