package com.cancha.cliente.config;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;

@MapperConfig(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.SETTER_PREFERRED)
public class MapStructConfig {
}
