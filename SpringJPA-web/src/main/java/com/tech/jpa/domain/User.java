package com.tech.jpa.domain;

import lombok.*;

/**
 * Created by x074823 on 8/15/2016.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String username;
    @Getter @Setter
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

}
