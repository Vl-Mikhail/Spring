package ru.misha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.misha.implement.Storages;
import ru.misha.model.Client;

import java.util.ArrayList;
import java.util.List;


@Service("provider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Storages storages;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        final Client client = storages.clientDAO.getClientByNameAndPW(login, password);
        if (client != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(client.getRole().getRole()));
            return new UsernamePasswordAuthenticationToken(login, password, authorities);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
