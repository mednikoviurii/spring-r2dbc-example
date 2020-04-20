package com.codesityou.examples.r2dbcexample.models;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Value
@AllArgsConstructor
@Table("users")
public class User {

    @Id @Column("user_id") UUID userId;
    @Column("user_name") String name;

}
