package com.cancha.cliente.repository;


import com.cancha.cliente.repository.domain.Usuario;
import com.cancha.cliente.repository.domain.type.TipoDocumento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario,String>{

    Optional<Usuario> findByNickname(String nickname);
    @Query("{ 'persona: {documento': ?0, 'tipoDocumento': ?1}}")
    Optional<Usuario> findByDocumentoAndTipoDocumento( String documento,
                                                       TipoDocumento tipoDocumento);

    Optional<Usuario> findByNicknameAndPassword(String nickname, String password);
}
