package com.tech.jpa.persistance.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by x074823 on 8/15/2016.
 */
@ToString
@Entity (name = "JPAUSER")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Getter @Setter
    @Column(name = "ID", nullable = false)
    private String id;

    @Getter @Setter
    @Column(name = "USERNAME", length = 260)
    private String username;

    @Getter @Setter
    @Column(name = "ROLE", length = 260)
    private String role;
}
