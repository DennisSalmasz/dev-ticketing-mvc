package com.cyber.service;

import com.cyber.dto.RoleDTO;

import java.util.List;

public interface CrudService<T,ID> {

    T save(T object);
    T findByID(ID id);
    List<T> findAll();
    void delete(T object);
    void deleteByID(ID id);

    /*
    RoleDTO save(RoleDTO user);
    RoleDTO findByID(Long id);
    List<RoleDTO> findAll();
    void delete(RoleDTO user);
    void deleteByID(Long id);

    UserDTO save(UserDTO user);
    UserDTO findByID(String username);
    List<UserDTO> findAll();
    void delete(UserDTO user);
    void deleteByID(String username);
    */
}
