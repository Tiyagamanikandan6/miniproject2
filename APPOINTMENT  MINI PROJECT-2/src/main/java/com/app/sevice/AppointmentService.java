package com.app.sevice;

import java.util.List;
import java.util.Random;

import com.app.entity.Appointment;
import com.app.entity.User;
import com.app.repo.AdminRepo;
import com.app.repo.AppointmentRepo;
import com.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo repo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AdminRepo adminRepo;

	/**
	 * Creates a new user account.

	 */
	public boolean createUserAccount(User user) {
		if (userRepo.save(user) != null) {
			return true;
		} else
			return false;
	}

	/**
	 * Finds a user by their email.

	 */
	public boolean findByUserEmail(String email) {
		userRepo.findByEmail(email);
		return true;
	}

	/**
	 * Authenticates a user based on email and password.
	 * @param email The email of the user.

	 */
	public boolean userLogin(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password) != null;
	}

	/**
	 * Authenticates an admin based on email and password.
	 * @param email The email of the admin.

	 */
	public boolean adminLogin(String email, String password) {
		return adminRepo.findByEmailAndPassword(email, password) != null;
	}

	/**
	 * Saves an appointment.

	 */
	public boolean saveData(Appointment appointment) {
		appointment.setAppointmentId(generateRandomString());
		repo.save(appointment);
		return true;
	}

	/**
	 * Retrieves all appointments.

	 */
	public List<Appointment> findAllAppointments() {
		return repo.findAll();
	}

	/**
	 * Generates a random string for appointment ID.

	 */
	public static String generateRandomString() {
		final String FIXED_PART = "RQ";
		final int RANDOM_PART_LENGTH = 5;
		StringBuilder sb = new StringBuilder(FIXED_PART);
		Random random = new Random();

		for (int i = 0; i < RANDOM_PART_LENGTH; i++) {
			int digit = random.nextInt(10);
			sb.append(digit);
		}

		return sb.toString();
	}
}
