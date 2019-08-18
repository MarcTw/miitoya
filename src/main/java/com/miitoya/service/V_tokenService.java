package com.miitoya.service;

import com.miitoya.model.V_token;
import com.miitoya.repository.V_tokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class V_tokenService {
    @Autowired
    private V_tokenRepository v_tokenRepository;

    public void V_tokenSave(String token, Long v_id){
        v_tokenRepository.save(new V_token(token,v_id,new Timestamp(1566061505l),new Timestamp(1566061505l)));
    }

    public Long V_tokenGetId(String token){
        V_token vtoken = v_tokenRepository.getOne(token);
        return vtoken.getV_id();
    }
}
