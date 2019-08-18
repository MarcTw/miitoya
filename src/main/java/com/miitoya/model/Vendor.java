package com.miitoya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long v_id;
    @NotBlank(message = "Password is mandatory")
    @JsonIgnore
    private String pwd;
    @Email(message = "Email should be valid")
    @NotEmpty
    private String email;
    @NotBlank(message = "Brand is mandatory")
    private String brand;
    private String firstname;
    private String lastname;
    private String tax_id;
    private String phone;
    private String addr;
    private String country;
    private int score;
    private String bank_account;
    private int status;
    public Vendor(){
    }

    public Vendor(long v_id,@NotBlank(message = "Password is mandatory") String pwd, @Email(message = "Email should be valid") @NotEmpty String email, @NotBlank(message = "Brand is mandatory") String brand, String firstname, String lastname, String tax_id, String phone, String addr, String country, int score, String bank_account, int status) {
        this.pwd = pwd;
        this.email = email;
        this.brand = brand;
        this.firstname = firstname;
        this.lastname = lastname;
        this.tax_id = tax_id;
        this.phone = phone;
        this.addr = addr;
        this.country = country;
        this.score = score;
        this.bank_account = bank_account;
        this.status = status;
        this.v_id = v_id;
    }

    public Long getV_id() {
        return v_id;
    }

    public void setV_id(Long v_id) {
        this.v_id = v_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
