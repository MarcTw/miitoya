package com.miitoya.repository;


import com.miitoya.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    @Query("select v from Vendor v where v.email = ?1 and v.pwd = ?2 ")
    Vendor validateVendor(String email,String pwd);

    @Query("select v.email from Vendor v where v.v_id =?1")
    String getEmailFromV_ID(Long v_id);

    @Query("select v.firstname, v.lastname from Vendor v where v.v_id =?1")
    List<String> getNameFromV_ID2(Long v_id);

    @Query(value = "select * from Vendor v where v.v_id in (select t.v_id from v_token t where t.v_token = ?1)", nativeQuery = true)
    Optional<Vendor> getVendorByToken(String token);

    @Query("select count(v) from Vendor v where v.email =?1")
    Integer getEmailCount(String email);




}
