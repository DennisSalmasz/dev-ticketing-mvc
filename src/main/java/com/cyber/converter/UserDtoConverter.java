package com.cyber.converter;

import com.cyber.dto.RoleDTO;
import com.cyber.dto.UserDTO;
import com.cyber.service.ProjectService;
import com.cyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {

    @Autowired
    UserService userService;

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
