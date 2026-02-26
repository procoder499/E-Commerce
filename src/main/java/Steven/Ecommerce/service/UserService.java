package Steven.Ecommerce.service;

import Steven.Ecommerce.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    void deleteUser(Long id);
}
