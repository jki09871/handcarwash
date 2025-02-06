package com.carwash.domain.notification.vo;

import com.carwash.domain.DeletedEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class NotificationVO {

    private Long id;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date deletedAt;
    private DeletedEnum isDeleted;
    private int hits;

    @Override
    public String toString() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        return "NotificationVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + (createdAt != null ? dateFormat.format(createdAt) : null) +
                ", updatedAt=" + (updatedAt != null ? dateFormat.format(updatedAt) : null) +
                ", deletedAt=" + (deletedAt != null ? dateFormat.format(deletedAt) : null) +
                ", isDeleted=" + isDeleted +
                ", hits=" + hits +
                '}';
    }

}
