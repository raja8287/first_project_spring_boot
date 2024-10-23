package loginpageapi.rea_red_sb.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginpageapi.rea_red_sb.RegistrationRepo.newuserrepo;
import loginpageapi.rea_red_sb.entity.userEntity;

@Service
public class Serviceimplementation implements userService {

    @Autowired
    public newuserrepo repo;

    @Override
    public userEntity RegisterNewUser(userEntity new_user_data) {

        return repo.save(new_user_data);

    }

    @Override
    public List allUser() {
        //converting list of user data to set to user data
        // HashSet<userEntity> set = new HashSet<userEntity>(repo.findAll());
        List<userEntity> i = repo.findAll();
        if (i.isEmpty()) {
            return null;
        } else {

            return i;
        }

    }

    @Override
    public userEntity finduserbyemail(String mail) {
        userEntity userdata = repo.findByEmail(mail);
        if (userdata == null) {
            return null;
        } else {
            return userdata;
        }

    }

    @Override
    public userEntity deleteUserbyemail(String mailID) {
        userEntity userdata = repo.findByEmail(mailID);
        if (userdata == null) {
            return null;
        } else {
            repo.deleteById(userdata.getId());
            return userdata;
        }
    }

    @Override
    public String RemoverALL() {
        List li = repo.findAll();
        if (li == null) {
            return null;
        } else {
            repo.deleteAll();
            return "All are gone";
        }
    }

}
