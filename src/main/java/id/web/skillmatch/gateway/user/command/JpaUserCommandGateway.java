package id.web.skillmatch.gateway.user.command;

import id.web.skillmatch.model.user.User;
import id.web.skillmatch.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JpaUserCommandGateway implements UserCommandGateway {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(User user) {
        userJpaRepository.save(user);
    }
}
