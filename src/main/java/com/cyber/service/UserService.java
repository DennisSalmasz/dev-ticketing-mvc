package com.cyber.service;

import com.cyber.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {

    //CRUD user!!
    //business logic for all mapping in Controller should be provided here!!

    //In UserDTO, unique property is [String username] --- PK in DB!!


}
