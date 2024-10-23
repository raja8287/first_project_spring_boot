package loginpageapi.rea_red_sb.Controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loginpageapi.rea_red_sb.Service.userService;
import loginpageapi.rea_red_sb.entity.userEntity;

@RestController
@RequestMapping("/api/v1")
public class RegistrationpageController {

    @Autowired
    public userService service;

    @PostMapping("/newuser")
    public String createNewUser(@RequestBody userEntity new_user_data) {

        service.RegisterNewUser(new_user_data);
        return "user Saved!";
    }

    @GetMapping("/all")
    public HashSet getAlluser() {
        return service.allUser();
    }
}
