package loginpageapi.rea_red_sb.RegistrationRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

import loginpageapi.rea_red_sb.entity.userEntity;

@Repository
public interface newuserrepo extends JpaRepository<userEntity, Long> {

    userEntity findByEmail(String email);

    userEntity deleteByEmail(String email);
}
