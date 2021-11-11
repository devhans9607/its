package com.hans.its.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("comments")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("comment_id")
    private Integer commentId;

    //one to many / many to one differ the whole porject
    //@JsonIgnore
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="post_id")
    //cannot remove for usage at findByPostId

    @Column("post_id")
    private Integer postId;

    //@JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="uid")
    @Column("uid")
    private Integer uid;

    //@NonNull
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

    @Column("deleted_at")
    private LocalDateTime deletedAt;

    @Column("is_deleted")
    private Boolean isDeleted;

}
