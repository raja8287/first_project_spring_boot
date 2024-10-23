package loginpageapi.rea_red_sb.Service;

import java.util.List;
import java.util.Optional;

import loginpageapi.rea_red_sb.entity.userEntity;

public interface userService {

    public userEntity RegisterNewUser(userEntity new_user_data);

    public List allUser();

    public userEntity finduserbyemail(String mailId);

    public userEntity deleteUserbyemail(String mailID);

    public String RemoverALL();

}
