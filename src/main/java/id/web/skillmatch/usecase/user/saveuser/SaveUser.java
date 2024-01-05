package id.web.skillmatch.usecase.user.saveuser;

import id.web.skillmatch.dto.request.SaveUserCmd;

public interface SaveUser {

    void save(SaveUserCmd cmd);

}
