package com.cyber.service;

import com.cyber.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {

    //CRUD user!!
    //business logic for all mapping in Controller should be provided here!!

    /*
    UserDTO save(UserDTO user);
    UserDTO findByID(String username);
    List<UserDTO> findAll();
    void delete(UserDTO user);
    void deleteByID(String username);

    In UserDTO, unique property is [String username] --- PK in DB!!
    */

}
