package ru.test.model;

import javax.persistence.*;

@Entity
@Table(name = "testtable")
public class TestModel {

    public TestModel() {
    }

    public String getUserName() {
        return userName;
    }

    // измененние
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(String userGroups) {
        this.userGroups = userGroups;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String userName;

    @Column
    private String userGroups;

}
