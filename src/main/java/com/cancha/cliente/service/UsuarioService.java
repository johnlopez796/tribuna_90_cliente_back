package com.cancha.cliente.service;


import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.repository.domain.type.TipoDocumento;

import java.util.Optional;

public interface UsuarioService {
    /**
     *
     * @param usuario
     * @return
     */
    Usuario saveUsuario(Usuario usuario);

    /**
     *
     * @param id
     * @return
     */
    Optional<Usuario> find(String id);

    /**
     *
     * @param nickName
     * @return
     */
    Optional<Usuario> findByNickName(String nickName);

    /**
     *
     * @param documento
     * @param tipoDocumento
     * @return
     */
    Optional<Usuario> findByDocyType(String documento,
                                            TipoDocumento tipoDocumento);

    /**
     *
     * @param nickname
     * @param pass
     * @return
     */
    Optional<Usuario> findByNicknameYPass(String nickname, String pass);

}
