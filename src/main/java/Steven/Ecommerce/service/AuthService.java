package Steven.Ecommerce.service;

import Steven.Ecommerce.dto.auth.AuthResponse;
import Steven.Ecommerce.dto.auth.LoginRequest;
import Steven.Ecommerce.dto.auth.RegisterRequest;
import Steven.Ecommerce.dto.user.UserResponse;

public interface AuthService {

    UserResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    UserResponse getCurrentUser();
}