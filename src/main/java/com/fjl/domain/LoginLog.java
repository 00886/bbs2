package com.fjl.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_login_log")
public class LoginLog {
    private int login_log_id;
    private User user;
    private String ip;
    private Date login_datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int getLogin_log_id() {
        return login_log_id;
    }

    public void setLogin_log_id(int login_log_id) {
        this.login_log_id = login_log_id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column
    public Date getLogin_datetime() {
        return login_datetime;
    }

    public void setLogin_datetime(Date login_datetime) {
        this.login_datetime = login_datetime;
    }
}
