package com.vasl.crud.dal.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = User.COLLECTION_NAME)
public class User {

    public static final String COLLECTION_NAME = "users";

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String username;


}
