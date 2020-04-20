package com.codesityou.examples.r2dbcexample.models;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Value
@AllArgsConstructor
@Table("posts")
public class Post {

    @Id UUID postId;
    String title;
    String content;
    @Column("user_id") UUID userId;

}
