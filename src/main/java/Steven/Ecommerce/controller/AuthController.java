package Steven.Ecommerce.controller;

import Steven.Ecommerce.dto.auth.AuthResponse;
import Steven.Ecommerce.dto.auth.LoginRequest;
import Steven.Ecommerce.dto.auth.RegisterRequest;
import Steven.Ecommerce.dto.user.UserResponse;
import Steven.Ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

    @GetMapping("/me")
    public UserResponse me() {
        return authService.getCurrentUser();
    }
}

