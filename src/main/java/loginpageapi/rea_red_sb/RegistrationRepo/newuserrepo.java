package loginpageapi.rea_red_sb.RegistrationRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loginpageapi.rea_red_sb.entity.userEntity;

@Repository
public interface newuserrepo extends JpaRepository<userEntity, Long> {

}
