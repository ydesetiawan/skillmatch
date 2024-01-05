package id.web.skillmatch.usecase.user.saveuser;

import id.web.skillmatch.controller.ActionType;
import id.web.skillmatch.dto.request.SaveUserCmd;
import id.web.skillmatch.gateway.user.command.UserCommandGateway;
import id.web.skillmatch.gateway.user.query.UserQueryGateway;
import id.web.skillmatch.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveUserUseCase implements SaveUser {

    private final UserCommandGateway userCommandGateway;
    private final UserQueryGateway userQueryGateway;

    @Override
    @Transactional
    public void save(SaveUserCmd cmd) {

        User user = getUser(cmd);
        userCommandGateway.save(user);

    }

    private User getUser(SaveUserCmd cmd) {
        if (ActionType.EDIT.equals(cmd.getActionType())) {
            return userQueryGateway.findById(cmd.getId()).orElseThrow(() -> new RuntimeException("User is not found"));
        }

        return User.valueOf(cmd);
    }
}
