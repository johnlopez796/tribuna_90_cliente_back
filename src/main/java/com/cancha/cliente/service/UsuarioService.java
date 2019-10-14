package com.cancha.cliente.service;


import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.repository.domain.type.TipoDocumento;

import java.util.Optional;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);

    Optional<Usuario> find(String id);

    Optional<Usuario> findByNickName(String nickName);

    Optional<Usuario> findByDocyType(String documento,
                                            TipoDocumento tipoDocumento);

}
