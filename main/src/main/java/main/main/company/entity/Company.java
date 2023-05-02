package main.main.company.entity;

import lombok.Getter;
import lombok.Setter;
import main.main.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    private String companySize;
    private Long businessNumber;
    private String address;
    private String information;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
}