package com.cyber.service;

import com.cyber.dto.RoleDTO;

public interface RoleService extends CrudService<RoleDTO,Long>{

    /*
    RoleDTO save(RoleDTO user);
    RoleDTO findByID(Long id);
    List<RoleDTO> findAll();
    void delete(RoleDTO user);
    void deleteByID(Long id);

    In RoleDTO unique property is [Long id] --- PK in DB !!
    */
}
