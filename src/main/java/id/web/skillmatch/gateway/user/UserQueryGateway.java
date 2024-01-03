package id.web.skillmatch.gateway.user;

import id.web.skillmatch.model.user.User;

import java.util.Optional;

public interface UserQueryGateway {

    Optional<User> findByUsername(String username);
}
