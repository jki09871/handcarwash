package com.carwash.domain.user;

import com.carwash.domain.DeletedEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserVO {
    private Long id;
    private String name;
    private String password;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date deletedAt;
    private DeletedEnum isDeleted;
    private UserRole userRole;

}
