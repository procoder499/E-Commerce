package Steven.Ecommerce.service;

import Steven.Ecommerce.dto.auth.RegisterRequest;
import Steven.Ecommerce.dto.user.UserResponse;
import Steven.Ecommerce.entity.User;
import Steven.Ecommerce.mapper.UserMapper;
import Steven.Ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRole(User.Role.USER);

        return UserMapper.toResponse(userRepository.save(user));
    }
}
