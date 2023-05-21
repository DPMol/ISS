package backend.Users.Models;


import backend.Domain.Role;
import backend.Domain.Section;
import backend.Domain.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDetails {
    private String username;
    private Role role;
    private Section section;

    public static UserDetails FromUser(User user){
        return new UserDetails(user.getUsername(), user.getRole(), user.getSection());
    }

    public static List<UserDetails> FromUsers(List<User> users){
        return users.stream().map(UserDetails::FromUser).toList();
    }
}
