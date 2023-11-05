package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// BEGIN
@Getter
@AllArgsConstructor
public class UserPage {
    private String header;
    private User user;
}
// END
