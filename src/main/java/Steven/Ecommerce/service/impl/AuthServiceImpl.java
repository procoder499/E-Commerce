package Steven.Ecommerce.service.impl;

import Steven.Ecommerce.dto.auth.AuthResponse;
import Steven.Ecommerce.dto.auth.LoginRequest;
import Steven.Ecommerce.dto.auth.RegisterRequest;
import Steven.Ecommerce.dto.user.UserResponse;
import Steven.Ecommerce.entity.User;
import Steven.Ecommerce.mapper.UserMapper;
import Steven.Ecommerce.repository.UserRepository;
import Steven.Ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(User.Role.USER);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // TODO: Replace with JWT later
        String fakeToken = "dummy-token-for-" + user.getEmail();

        return new AuthResponse(fakeToken);
    }

    @Override
    public UserResponse getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toResponse(user);
    }
}