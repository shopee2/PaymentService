package com.ong.springswagger.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ong.springswagger.models.PaymentAccount;
import com.ong.springswagger.models.PaymentLog;
import com.ong.springswagger.repositorys.PaymentAccountRepository;
import com.ong.springswagger.repositorys.PaymentLogRepository;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

	@Autowired
	private PaymentAccountRepository PaymentAccountRepository;
	@Autowired
	private PaymentLogRepository PaymentLogRepository;

	@GetMapping("/get-balance")
	public List<PaymentAccount> getBalance(@RequestHeader String user_id) {
		List<PaymentAccount> all = PaymentAccountRepository.findAll();
		List<PaymentAccount> toReturn = new ArrayList();

		for (int i = 0; i < all.size(); i++) {
			if (user_id.equals(all.get(i).getUser_id())) {
				toReturn.add(all.get(i));
			}
		}
		return toReturn;
	}

	@GetMapping("/log")
	public List<PaymentLog> retrieveAllPaymentLog() {
		return PaymentLogRepository.findAll();
	}

	@GetMapping("/log/purchase/{id}")
	public PaymentLog getLog(@PathVariable long id) {
		Optional<PaymentLog> log = PaymentLogRepository.findById(id);
		return log.get();
	}
	@PostMapping("/log/create-log")
	public ResponseEntity<Object> createLog(@RequestBody PaymentLog log) {
		PaymentLog savedLog = PaymentLogRepository.save(log);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLog.getId()).toUri();

		return ResponseEntity.created(location).build();

	}


//
	@DeleteMapping("/{id}")
	public void deleteAccount(@PathVariable long id) {
		PaymentAccountRepository.deleteById(id);
	}

//
	@PostMapping("/create-account")
	public ResponseEntity<Object> createAccount(@RequestBody PaymentAccount acct) {
		PaymentAccount savedAccount = PaymentAccountRepository.save(acct);
		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAccount.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PatchMapping("/topup")
	public PaymentAccount topup(@RequestHeader String user_id, @RequestBody PaymentAccount acct) {
		List<PaymentAccount> all = PaymentAccountRepository.findAll();

		for (int i = 0; i < all.size(); i++) {
			if (user_id.equals(all.get(i).getUser_id())) {
				all.get(i).setBalance(acct.getBalance());
				acct = all.get(i);
				PaymentAccountRepository.save(acct);
				break;
			}
		}
		return  acct;

	}
	@GetMapping("/get-type/{id}")
	public PaymentAccount getType(@PathVariable long id) {
		Optional<PaymentAccount> acct = PaymentAccountRepository.findById(id);

		return acct.get();
	}
}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Object> updateStudent(@RequestBody Course course, @PathVariable long id) {
//
//		Optional<Course> courseOptional = courseRepository.findById(id);
//
//		if (!courseOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		course.setId(id);
//		
//		courseRepository.save(course);
//
//		return ResponseEntity.noContent().build();
//	}
//}