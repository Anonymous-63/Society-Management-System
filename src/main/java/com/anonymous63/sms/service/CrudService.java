package com.anonymous63.sms.service;

import java.util.List;

public interface CrudService<DTO, ID> {
    DTO get(ID id);

    List<DTO> getAll();

    DTO save(DTO dto);

    DTO update(DTO dto, ID id);

    void delete(ID id);
    void deleteAll();
}
