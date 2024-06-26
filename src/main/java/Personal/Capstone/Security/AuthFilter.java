package Personal.Capstone.Security;

import Personal.Capstone.Entities.User;
import Personal.Capstone.Exceptions.UnauthorizedException;
import Personal.Capstone.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthFilter extends OncePerRequestFilter {
    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. Verifico se c'è l'header Authorization
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Inserire token in Authorization Header");
        } else {
            // Estraggo il token da Auth Header
            String token = authHeader.substring(7);
            System.out.println("IL TOKEN --> " + token);
            jwtTools.verifyToken(token);

            //Estraggo user id dal Token
            String id = jwtTools.idFromToken(token);

            //Cerco User in db
            User foundUser = userService.findUserById(Integer.parseInt(id));

            //Autorizzo lo user a procedere
            Authentication authentication = new UsernamePasswordAuthenticationToken(foundUser, null, foundUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            //Procedere verso il prossimo blocco della filter chain
            filterChain.doFilter(request, response);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        //  String[] excludedEndpoints = new String[] {"/auth/**"};
        List<String> excludedEndpoints = new ArrayList<String>();

        excludedEndpoints.add("/auth/**");
        excludedEndpoints.add("/cities");
        excludedEndpoints.add("/cities/name=**");
        excludedEndpoints.add("/cities/id=**");
        excludedEndpoints.add("/hotels");
        excludedEndpoints.add("/hotels/name=**");
        excludedEndpoints.add("/hotels/id=**");
        excludedEndpoints.add("/reservations");
        excludedEndpoints.add("/reservations/id=**");
        excludedEndpoints.add("/reviews");
        excludedEndpoints.add("/reviews/id=**");
        excludedEndpoints.add("/users");
        excludedEndpoints.add("/users/me");
        excludedEndpoints.add("/users/me/modify");
        excludedEndpoints.add("users/me/upload");
        excludedEndpoints.add("/users/id=**");


        return Arrays.stream(excludedEndpoints.toArray())
                .anyMatch(e -> new AntPathMatcher().match((String) e, request.getServletPath()));

        //      return new AntPathMatcher().match("/auth/**", request.getServletPath());
        //       return new AntPathRequestMatcher("/**","GET").matches(request);
    }
}
