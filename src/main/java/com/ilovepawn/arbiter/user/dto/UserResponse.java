package com.ilovepawn.arbiter.user.dto;

import com.ilovepawn.arbiter.user.entity.User;

public record UserResponse(
        Long id,
        String email,
        String nickname,
        String profileImageUrl,
        String role
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getNickname(),
                user.getProfileImageUrl(),
                user.getRole().name()
        );
    }
}
