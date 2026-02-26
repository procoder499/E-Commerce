package Steven.Ecommerce.service.impl;

import Steven.Ecommerce.dto.user.UserResponse;
import Steven.Ecommerce.entity.User;
import Steven.Ecommerce.mapper.UserMapper;
import Steven.Ecommerce.repository.UserRepository;
import Steven.Ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}