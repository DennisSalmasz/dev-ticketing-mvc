package com.cyber.bootstrap;

import com.cyber.dto.RoleDTO;
import com.cyber.dto.UserDTO;
import com.cyber.enums.Gender;
import com.cyber.service.RoleService;
import com.cyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    // inject through Interface, not impl class!!
    RoleService roleService;
    UserService userService;

    //create constructor to autowire - no need @Autowired!!
    @Autowired
    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    //whenever we start app, this method first run - to upload dummy data !!
    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@ticketNG.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@ticketNG.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@ticketNG.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@ticketNG.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@ticketNG.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
    }
}
