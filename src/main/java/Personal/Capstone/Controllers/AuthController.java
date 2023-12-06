package Personal.Capstone.Controllers;

import Personal.Capstone.Entities.User;
import Personal.Capstone.Exceptions.BadRequestException;
import Personal.Capstone.Payloads_DTOs.NewUserDTO;
import Personal.Capstone.Payloads_DTOs.SeccessfullLoginDTO;
import Personal.Capstone.Payloads_DTOs.UserLoginDTO;
import Personal.Capstone.Services.AuthService;
import Personal.Capstone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public SeccessfullLoginDTO login(@RequestBody UserLoginDTO userLogin) {
        return new SeccessfullLoginDTO(authService.authUser(userLogin));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    User saveUser(@RequestBody @Validated NewUserDTO userDTO, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return userService.saveUser(userDTO);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }

    @PatchMapping("/adminify/{id}")
    public User findByIdAndUpdateRole(@PathVariable long id) {
        return userService.findByIdAndUpdateRole(id);
    }

}
