package com.ilovepawn.arbiter.user.service;

import com.ilovepawn.arbiter.user.entity.Role;
import com.ilovepawn.arbiter.user.entity.User;
import com.ilovepawn.arbiter.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserResolver {

    private final UserRepository userRepository;

    @Transactional
    public User resolveOrCreate(Jwt jwt) {
        String sub = jwt.getSubject();
        String email = jwt.getClaimAsString("email");
        String name = jwt.getClaimAsString("name");
        String picture = jwt.getClaimAsString("picture");

        if (email == null) {
            throw new IllegalStateException("JWT missing required 'email' claim for sub=" + sub);
        }

        return userRepository.findByKeycloakSub(sub)
                .map(user -> {
                    if (!email.equals(user.getEmail())
                            || name != null && !name.equals(user.getNickname())
                            || picture != null && !picture.equals(user.getProfileImageUrl())) {
                        user.updateProfile(email, name, picture);
                    }
                    return user;
                })
                .orElseGet(() -> userRepository.save(User.builder()
                        .keycloakSub(sub)
                        .email(email)
                        .nickname(name != null ? name : email)
                        .profileImageUrl(picture)
                        .role(Role.USER)
                        .build()));
    }
}
