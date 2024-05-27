package com.mkt.car.mapper;

import com.mkt.car.domain.Car;
import com.mkt.car.dto.UserDTOResponse;
import com.mkt.car.dto.UserDtoRequest;
import com.mkt.car.enums.Role;
import com.mkt.car.model.User;
import com.mkt.car.vo.LoginVo;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-16T09:55:56-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTOResponse toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOResponse userDTOResponse = new UserDTOResponse();

        userDTOResponse.setId( user.getId() );
        userDTOResponse.setFistName( user.getFistName() );
        userDTOResponse.setLastName( user.getLastName() );
        userDTOResponse.setEmail( user.getEmail() );
        userDTOResponse.setBirthday( user.getBirthday() );
        userDTOResponse.setPhone( user.getPhone() );
        userDTOResponse.setLogin( user.getLogin() );
        userDTOResponse.setPassword( user.getPassword() );

        return userDTOResponse;
    }

    @Override
    public User toEntity(UserDTOResponse userDTOResponse) {
        if ( userDTOResponse == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTOResponse.getId() );
        user.setFistName( userDTOResponse.getFistName() );
        user.setLastName( userDTOResponse.getLastName() );
        user.setEmail( userDTOResponse.getEmail() );
        user.setBirthday( userDTOResponse.getBirthday() );
        user.setPhone( userDTOResponse.getPhone() );
        user.setLogin( userDTOResponse.getLogin() );
        user.setPassword( userDTOResponse.getPassword() );

        return user;
    }

    @Override
    public User toEntity(UserDtoRequest userDtoRequest) {
        if ( userDtoRequest == null ) {
            return null;
        }

        User user = new User();

        user.setLogin( userDtoRequestLoginLogin( userDtoRequest ) );
        user.setPassword( userDtoRequestLoginPassword( userDtoRequest ) );
        user.setId( userDtoRequest.getId() );
        user.setFistName( userDtoRequest.getFistName() );
        user.setLastName( userDtoRequest.getLastName() );
        user.setEmail( userDtoRequest.getEmail() );
        user.setBirthday( userDtoRequest.getBirthday() );
        user.setPhone( userDtoRequest.getPhone() );
        user.setRole( userDtoRequest.getRole() );

        return user;
    }

    @Override
    public com.mkt.car.domain.User toEntityDomain(UserDtoRequest userDto) {
        if ( userDto == null ) {
            return null;
        }

        Long id = null;
        String fistName = null;
        String lastName = null;
        String email = null;
        LocalDateTime birthday = null;
        String phone = null;
        LoginVo login = null;
        Role role = null;

        id = userDto.getId();
        fistName = userDto.getFistName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        birthday = userDto.getBirthday();
        phone = userDto.getPhone();
        login = userDto.getLogin();
        role = userDto.getRole();

        List<Car> cars = null;

        com.mkt.car.domain.User user = new com.mkt.car.domain.User( id, fistName, lastName, email, birthday, phone, login, role, cars );

        return user;
    }

    private String userDtoRequestLoginLogin(UserDtoRequest userDtoRequest) {
        if ( userDtoRequest == null ) {
            return null;
        }
        LoginVo login = userDtoRequest.getLogin();
        if ( login == null ) {
            return null;
        }
        String login1 = login.getLogin();
        if ( login1 == null ) {
            return null;
        }
        return login1;
    }

    private String userDtoRequestLoginPassword(UserDtoRequest userDtoRequest) {
        if ( userDtoRequest == null ) {
            return null;
        }
        LoginVo login = userDtoRequest.getLogin();
        if ( login == null ) {
            return null;
        }
        String password = login.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }
}
