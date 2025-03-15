package com.example.sharebite.service;

import com.example.sharebite.model.Donor;
import com.example.sharebite.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Optional<Donor> getDonorById(Long id) {
        return donorRepository.findById(id);
    }

    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public Donor updateDonor(Long id, Donor donorDetails) {
        Optional<Donor> optionalDonor = donorRepository.findById(id);
        if (optionalDonor.isPresent()) {
            Donor donor = optionalDonor.get();
            donor.setName(donorDetails.getName());
            donor.setEmail(donorDetails.getEmail());
            donor.setPhone(donorDetails.getPhone());
            donor.setAddress(donorDetails.getAddress());
            return donorRepository.save(donor);
        } else {
            throw new RuntimeException("Donor not found with id: " + id);
        }
    }

    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}
