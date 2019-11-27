package com.cancha.cliente.security;


import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.web.handler.error.RestException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SecurityContext {
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "tribuna90";

    @Autowired
    private HttpServletRequest httpServletRequest;

    public UsuarioDto userSession(){
        String token = httpServletRequest.getHeader("Authorization");
        if (existeJWTToken(httpServletRequest)) {
            Claims claims = validateToken(httpServletRequest);
            if (claims.get("usuario") != null) {
                return (UsuarioDto) claims.get("usuario");
            }
        }
        throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario no existe en sesión");
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }


    private boolean existeJWTToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
            return false;
        return true;
    }

}
