package loginpageapi.rea_red_sb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Object> createNewUser(@RequestBody userEntity new_user_data) {
        userEntity li = service.finduserbyemail(new_user_data.getEmail());

        if (li == null) {
            userEntity u = service.RegisterNewUser(new_user_data);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User " + new_user_data.getUsername() + " with Email " + new_user_data.getEmail() + " already exists", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/user/{Id}")
    public ResponseEntity<userEntity> getuserbyid(@PathVariable String Id) throws Exception {
        userEntity user = service.finduserbyemail(Id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAlluser() throws Exception {
        System.out.println("==========================>All api called!");
        List resp = service.allUser();
        if (resp == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {

            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> Removeuser(@PathVariable String id) {
        userEntity li = service.finduserbyemail(id);
        if (li == null) {
            return new ResponseEntity<>("USER NOT EXISTS" + li, HttpStatus.NO_CONTENT);
        } else {
            service.deleteUserbyemail(id);
            return new ResponseEntity<>("USER DELETED : " + li, HttpStatus.OK);
        }
    }

    @DeleteMapping("/user/all")
    public ResponseEntity<Object> Allout() {
        List li = service.allUser();
        if (li.isEmpty()) {
            return new ResponseEntity<>("user Not Found", HttpStatus.NOT_FOUND);
        } else {
            service.RemoverALL();
            return new ResponseEntity<>("All Data removed", HttpStatus.OK);
        }
    }
}
