package vn.edu.leading.uaa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.leading.uaa.models.RoleModel;
import vn.edu.leading.uaa.models.UserModel;
import vn.edu.leading.uaa.repositories.RoleRepository;
import vn.edu.leading.uaa.services.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    private final RoleRepository roleRepository;

    //private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    //de tao tai khoan

    public String list(UserModel userModel){
        UserModel newUser = new UserModel();
        newUser.setUsername(userModel.getUsername());
      //  newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
        RoleModel roleModel = (RoleModel) roleRepository.findByName("ROLE_USER");
        Set<RoleModel> roleModels = new HashSet<>();
        roleModels.add(roleModel);
        newUser.setRoleModels(roleModels);
        userService.save(newUser);
        return "thanh cong "+userModel.getUsername()+ " "+userModel.getPassword()+ "sau khi ma hoa" ;
    }
    @PostMapping("/register")
    public String register(@Valid UserModel userModel) throws Exception {
        userService.register(userModel);
       // mailService.sendMail(userModel);
        return "admin/login";
    }
}
