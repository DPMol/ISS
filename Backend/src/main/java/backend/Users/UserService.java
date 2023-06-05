package backend.Users;

import backend.Domain.User;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Infrastructure.ErrorMessages;
import backend.Repositories.SectionRepository;
import backend.Repositories.UserRepository;
import backend.Users.Models.UserDetails;
import backend.Users.UserRequests.GetUserDetailsRequest;
import backend.Users.UserRequests.LoginUserRequest;
import backend.Users.UserRequests.RegisterUserRequest;
import backend.Users.UserRequests.UpdateUserSectionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService extends AbstractService {
    private UserRepository userRepository;
    private SectionRepository sectionRepository;

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
        Optional<User> result = userRepository.findById(request.getUsername());
        if(result.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }

        return UserDetails.FromUser(result.get());
    }

    public void handle(UpdateUserSectionRequest request) {
        var section = sectionRepository.findById(request.getSectionId());

        if(section.isEmpty()){
            throw new IllegalStateException(ErrorMessages.SectionNotFound);
        }

        Optional<User> result = userRepository.findById(request.getUsername());
        if(result.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }

        result.get().setSection(section.get());

        userRepository.save(result.get());
    }
}
