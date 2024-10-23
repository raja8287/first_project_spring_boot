package loginpageapi.rea_red_sb.Service;

import java.util.HashSet;

import loginpageapi.rea_red_sb.entity.userEntity;

public interface userService {

    public void RegisterNewUser(userEntity new_user_data);

    public HashSet allUser();
}
