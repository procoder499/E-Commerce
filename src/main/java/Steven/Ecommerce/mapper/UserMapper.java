package Steven.Ecommerce.mapper;

import Steven.Ecommerce.dto.user.UserResponse;
import Steven.Ecommerce.entity.User;

public class UserMapper {
    public UserResponse toResponse(User user){
        if(user == null) return null;

        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setRole(user.getRole().name());
        return dto;
    }
}
