package com.example.sharebite;

import com.example.sharebite.model.Donor;
import com.example.sharebite.repository.DonorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
class SharebiteApplicationTests {

	@Autowired
	private DonorRepository donorRepository;

	@Test
	void contextLoads() {
		assertThat(donorRepository).isNotNull();
	}

	@Test
	void testFindAllDonors() {
		List<Donor> donors = donorRepository.findAll();
		assertThat(donors).isNotNull();
	}

	@Test
	void testSaveDonor() {
		Donor donor = new Donor();
		donor.setName("John Doe");
		donor.setEmail("john.doe@example.com");
		donor.setPhone("1234567890");
		donor.setAddress("123 Street, City");

		Donor savedDonor = donorRepository.save(donor);
		assertThat(savedDonor.getId()).isNotNull();
	}
}

