package com.carwash.domain.user;

import com.carwash.domain.DeletedEnum;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
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
    private UserRole role;

    @Override
    public String toString() {
        // 날짜 포맷 정의
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // 포맷팅된 날짜를 포함한 toString 리턴
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + (createdAt != null ? dateFormat.format(createdAt) : null) +
                ", deletedAt=" + (deletedAt != null ? dateFormat.format(deletedAt) : null) +
                ", isDeleted=" + isDeleted +
                ", role=" + role +
                '}';
    }
}
