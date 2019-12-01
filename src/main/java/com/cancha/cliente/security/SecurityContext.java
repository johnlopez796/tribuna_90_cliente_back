package com.cancha.cliente.security;


import com.cancha.cliente.dto.UsuarioDto;
import com.cancha.cliente.map.UsuarioMapper;
import com.cancha.cliente.repository.UsuarioRepository;
import com.cancha.cliente.service.UsuarioService;
import com.cancha.cliente.web.handler.error.RestException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class SecurityContext {
    private final String HEADER = "token";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "tribuna90";

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDto userSession(){
        String token = httpServletRequest.getHeader("token");
        if (existeJWTToken(httpServletRequest)) {
            Claims claims = validateToken(httpServletRequest);
            if (claims.get("usuario") != null) {
                System.out.println(claims.get("usuario").getClass().toString());
                String id = ((LinkedHashMap<String,String>) claims.get("usuario")).get("id");
                return usuarioMapper.toUsuario(usuarioService.find(id).get());
            }
        }
        throw new RestException(HttpStatus.UNAUTHORIZED,"Usuario no existe en sesión");
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }


    private boolean existeJWTToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader("token");
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
            return false;
        return true;
    }

}
