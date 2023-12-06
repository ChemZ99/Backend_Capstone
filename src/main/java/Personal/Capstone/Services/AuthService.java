package Personal.Capstone.Services;

import Personal.Capstone.Entities.User;
import Personal.Capstone.Exceptions.UnauthorizedException;
import Personal.Capstone.Payloads_DTOs.UserLoginDTO;
import Personal.Capstone.Security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    PasswordEncoder bcrypt;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTools jwtTools;

    public String authUser(UserLoginDTO userLogin) {

        User newUser = userService.findUserByEmail(userLogin.email());
        if (bcrypt.matches(userLogin.password(), newUser.getPassword())) {
            return jwtTools.createToken(newUser);
        } else {
            throw new UnauthorizedException("Credenziali non valide");
        }

    }
}
