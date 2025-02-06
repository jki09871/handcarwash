package com.carwash.domain.board.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;

@Getter
@Setter
public class FreeBulletinBoardVO {

        private Long id;
        private String title;
        private String content;
        private String writer;
        private int hits;
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        private String createdAt;
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        private String updatedAt;
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        private String deletedAt;
        private String isDeleted;

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            return "FreeBulletinBoardVO{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", writer='" + writer + '\'' +
                    ", hits=" + hits +
                    ", createdAt=" + (createdAt != null ? dateFormat.format(createdAt) : null) +
                    ", updatedAt=" + (updatedAt != null ? dateFormat.format(updatedAt) : null) +
                    ", deletedAt=" + (deletedAt != null ? dateFormat.format(deletedAt) : null) +
                    ", isDeleted='" + isDeleted + '\'' +
                    '}';
        }
}
