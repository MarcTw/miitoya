package com.miitoya.controller;

import com.miitoya.model.Vendor;
import com.miitoya.service.V_tokenService;
import com.miitoya.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;
    private V_tokenService v_tokenService;

    @GetMapping("")
    public ResponseEntity<?> getList() {
        return new ResponseEntity<Object>(vendorService.list(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") long id) {

        return new ResponseEntity<Vendor>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String pwd = body.get("password");
        String device_id = "sendfrommynokia3310";

        Vendor v = vendorService.getVendorFromEmailAndPassword(email,pwd);
        if (v != null){
            String token = email+"=..="+new Date().toString();
            System.out.println(v.getV_id());
            v_tokenService.V_tokenSave(token,v.getV_id());
            return new ResponseEntity<String>(this.getMD5(token),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<?> login(@RequestBody Vendor v){
        String email = v.getEmail();
        boolean exist = vendorService.getEmailExist(email);
        if (exist) return new ResponseEntity(HttpStatus.FORBIDDEN);
        else {
            vendorService.vendorRegister(v);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<?> getinfo(@RequestHeader("token") String token) {
        Optional<Vendor> v = vendorService.getVendorInfo(token);
        return new ResponseEntity<Vendor>(v.get(),HttpStatus.OK);
    }

    private String getMD5(String str) {
        String ret = null;
        try {
            // 生成一個MD5加密計算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 計算md5函數
            md.update(str.getBytes());
            // digest()最後確定返回md5 hash值，返回值為8為字符串。因為md5 hash值是16位的hex值，實際上就是8位的字符
            // BigInteger函數則將8位的字符串轉換成16位hex值，用字符串來表示；得到字符串形式的hash值
            ret = new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            //throw new SpeedException("MD5加密出現錯誤");
            e.printStackTrace();
        }
        return ret;
    }

}
