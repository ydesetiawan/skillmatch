package id.web.skillmatch.usecase.user.authentication;

import id.web.skillmatch.gateway.user.query.UserQueryGateway;
import id.web.skillmatch.model.user.User;
import id.web.skillmatch.model.user.UserDetails;
import id.web.skillmatch.model.user.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AuthenticationUserUseCase implements AuthenticationProvider {

    private final UserQueryGateway userQueryGateway;

    @Override
    @Transactional(readOnly = true)
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = getByUsername(username);

        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        Set<GrantedAuthority> authorities = buildUserAuthority();
        return new UsernamePasswordAuthenticationToken(buildUserForAuthentication(user, authorities), password, authorities);
    }

    private User getByUsername(String username) {
        return userQueryGateway.findByUsername(username).orElseThrow(() -> new BadCredentialsException("Username is not found"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }


    private UserDetails buildUserForAuthentication(User user,
                                                   Set<GrantedAuthority> authorities) {
        return new UserDetails(UserInfo.valueOf(user), user.getUsername(), user.getPassword(), authorities,
            !user.isDeleted());
    }

    private Set<GrantedAuthority> buildUserAuthority() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
