package com.football.sosyal.model.dto.mapper;

import com.football.sosyal.model.base.IdBaseEntity;
import com.football.sosyal.model.dto.IdBaseDTO;

public interface BaseMapper<V extends IdBaseDTO, E extends IdBaseEntity> {

    V mapToDTO(E e);

    E mapToEntity(V v);
}