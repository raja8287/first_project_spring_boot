package loginpageapi.rea_red_sb.Service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginpageapi.rea_red_sb.RegistrationRepo.newuserrepo;
import loginpageapi.rea_red_sb.entity.userEntity;

@Service
public class Serviceimplementation implements userService {

    @Autowired
    public newuserrepo repo;

    @Override
    public void RegisterNewUser(userEntity new_user_data) {

        repo.save(new_user_data);

    }

    @Override
    public HashSet allUser() {
        //converting list of user data to set to user data
        HashSet<userEntity> set = new HashSet<userEntity>(repo.findAll());

        return set;

    }

}
