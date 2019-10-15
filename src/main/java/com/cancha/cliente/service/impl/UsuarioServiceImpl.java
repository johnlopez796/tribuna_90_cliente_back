package com.cancha.cliente.service.impl;

import com.cancha.cliente.repository.UsuarioRepository;
import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.repository.domain.type.TipoDocumento;
import com.cancha.cliente.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> find(String id){
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> findByNickName(String nickName){
        return usuarioRepository.findByNickname(nickName);
    }

    @Override
    public Optional<Usuario> findByDocyType(String documento,
                                                   TipoDocumento tipoDocumento){
        return usuarioRepository.findByDocumentoAndTipoDocumento(documento,tipoDocumento);
    }

    @Override
    public Optional<Usuario> findByNicknameYPass(String nickname, String pass){
        return usuarioRepository.findByNicknameAndPassword(nickname,pass);
    }


}
