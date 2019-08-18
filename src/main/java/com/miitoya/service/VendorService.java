package com.miitoya.service;

import com.miitoya.model.Vendor;
import com.miitoya.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> list() {
        return vendorRepository.findAll();
    }

    public void deleteVendor(long id){
        vendorRepository.deleteById(id);
    }

    // TODO: 2019/8/18
    public Vendor getVendorFromEmailAndPassword(String email,String password){
        Vendor v = vendorRepository.validateVendor(email,password);
        return v;
    }

    public void vendorRegister(Vendor v){
        vendorRepository.save(v);
    }

    public boolean getEmailExist(String email){
        int count = vendorRepository.getEmailCount(email);
        return (count>0);
    }

    public Optional<Vendor> getVendorInfo(Long v_id){
        return vendorRepository.findById(v_id);
    }

    public Optional<Vendor> getVendorInfo(String token){
        return vendorRepository.getVendorByToken(token);
    }
}
