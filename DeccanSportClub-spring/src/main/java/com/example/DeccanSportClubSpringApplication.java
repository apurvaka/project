package com.example;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Batches;
import com.example.entity.Comments;
import com.example.entity.Enrollment;
import com.example.entity.Offers;
import com.example.entity.Sports;
import com.example.entity.Users;
import com.example.repository.BatchesRepository;
import com.example.repository.CommentsRepository;
import com.example.repository.EnrollmentRepository;
import com.example.repository.OffersRepository;
import com.example.repository.SportsRepository;
import com.example.repository.UsersRepository;

@SpringBootApplication(scanBasePackages = "com.example")
public class DeccanSportClubSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeccanSportClubSpringApplication.class, args);
	}

	@Autowired
	UsersRepository userRepository;

	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Autowired
	SportsRepository sportsRepository;

	@Autowired
	OffersRepository offersRepository;

	@Autowired
	BatchesRepository batchesRepository;

	@Autowired
	CommentsRepository commentsRepository;

	@Override
	public void run(String... args) throws Exception {
		Users user=new Users(1, "sd12", "sd@gmail.com", "sd212", "9876543210", "null", "null", "null", false, 1);
		userRepository.save(user);
		System.out.println(userRepository.findAll());

		Sports sport=new Sports(1, "Cricket", 7000);
		sportsRepository.save(sport);
		System.out.println(sportsRepository.findAll());

		Batches batch= new Batches(1, "summer", LocalTime.parse("10:00:00"), LocalTime.parse("11:00:00"), 50, 40);
		batchesRepository.save(batch);
		System.out.println(batchesRepository.findAll());

		Offers offer=new Offers(1, "Gold", 12, 50, 100);
		offersRepository.save(offer);
		System.out.println(offersRepository.findAll());
		
		Comments comment=new Comments(1, offer,user, "hello", true);
		  commentsRepository.save(comment);
		  System.out.println(commentsRepository.findAll());
		 
		  enrollmentRepository.save(new Enrollment(1, user,batch, offer,sport,
		  Date.valueOf("2020-4-5"), Date.valueOf("2020-4-7"), 5555));
		  System.out.println(enrollmentRepository.findAll());
		 

	}

}
