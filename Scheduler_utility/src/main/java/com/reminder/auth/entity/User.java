package com.reminder.auth.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "users_seq_gen"
	)
	@SequenceGenerator(
	    name = "users_seq_gen",
	    sequenceName = "users_seq",
	    allocationSize = 1
	)
	@Column(name = "user_id")
	private Long userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;
}