package com.miitoya.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class V_token {
    @Id
    private String v_token;
    private long v_id;
    private Timestamp create_time;
    private Timestamp expire_time;

    public V_token(String v_token, long v_id, Timestamp create_time, Timestamp expire_time) {
        this.v_token = v_token;
        this.v_id = v_id;
        this.create_time = create_time;
        this.expire_time = expire_time;
    }

    public V_token(){

    }


    public Long getV_id() {
        return v_id;
    }

    public Timestamp getExpire_time() {
        return expire_time;
    }

}
