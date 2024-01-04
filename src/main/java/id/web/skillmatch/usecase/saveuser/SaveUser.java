package id.web.skillmatch.usecase.saveuser;

import id.web.skillmatch.dto.request.SaveUserCmd;

public interface SaveUser {

    void save(SaveUserCmd cmd);

}
