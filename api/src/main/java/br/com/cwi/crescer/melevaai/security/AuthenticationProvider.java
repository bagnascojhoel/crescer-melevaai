package br.com.cwi.crescer.melevaai.security;

import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(
            final UserDetails userDetails,
            final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(
            final String username,
            final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {

        if (username == null) {
            new UsernameNotFoundException("Usuário não econtrado");
        }

        String token = username;

        String url = "http://52.191.131.0:3000/me";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("Authorization", token);

        HttpEntity request = new HttpEntity(headers);

        try {

            ResponseEntity<UserResponse> response = new RestTemplate().exchange(
                    url,
                    HttpMethod.GET,
                    request,
                    UserResponse.class
            );

            UserResponse userAuth = response.getBody();

            return new AuthenticatedUser(
                    userAuth.getFirstName(),
                    userAuth.getLastName(),
                    userAuth.getEmail(),
                    userAuth.getRoles());

        } catch (Exception exception) {

            // TODO ver como retornar o 401
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
        }

    }
}
