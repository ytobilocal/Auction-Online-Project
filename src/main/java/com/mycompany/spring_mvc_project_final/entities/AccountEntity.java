/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.entities;

import com.mycompany.spring_mvc_project_final.enums.Gender;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 100)
    private String email;
    @Column(name = "userName")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String numPhone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"))
    private Set<RoleEntity> userRoles;

    @OneToMany(mappedBy = "account")
    private Set<CreditCardEntity> creditCards;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    public AccountEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Set<RoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<RoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<CreditCardEntity> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCardEntity> creditCards) {
        this.creditCards = creditCards;
    }
}
