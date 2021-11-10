package com.hans.its.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("posts")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class PostEntity{

    //shit arse jpa cannot recognize _ in variable name
    //it occurs in pagination, where I provide properties
    @Id
    @Column("post_id")
    private Integer postId;

    @Column("uid")
    private Integer uid;

    @Column("title")
    private String title;

    @Column("contents")
    private String contents;

    @Column("created_at")
    //@Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
    @CreatedDate
    private LocalDateTime createdAt;

    //@LastModifiedDate
    //@Temporal(TemporalType.TIMESTAMP)
//    @UpdateTimestamp
    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("delete_at")
    private LocalDateTime deletedAt;

    @Column("is_deleted")
    private Boolean isDeleted;

}
