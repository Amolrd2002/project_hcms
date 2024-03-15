package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.entity.Payroll;
import com.services.PayrollService;

@RestController
public class PayrollController {

	@Autowired
	private PayrollService payrollService;
	
	@GetMapping("/payrolls")
	private ResponseEntity<List<Payroll>> getAllPayroll(){
		return new ResponseEntity<List<Payroll>>(payrollService.getAllPayroll(),HttpStatus.OK);
	}
	
	@PostMapping("/payrolls")
	public ResponseEntity<Void> addPayroll(@RequestBody Payroll payroll,UriComponentsBuilder uriComponentsBuilder) {
		if(payroll ==null) {
			throw new RuntimeException("Payroll Object Can't be null");
		}
		payrollService.addPayroll(payroll);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/payrolls/{id}")
	public ResponseEntity<Payroll> getPayrollById(@PathVariable("id") int id) {
		Payroll pl = payrollService.getPayrollById(id);	
		if(pl == null) {
			return new ResponseEntity<> (HttpStatus.OK); 
		}else {
			return new ResponseEntity<Payroll>(pl, HttpStatus.OK);
		}

	}
	

	@DeleteMapping("/payrolls/{id}")
	public ResponseEntity<Payroll> deletePayrollById(@PathVariable("id") int id) {
		Payroll pr = payrollService.getPayrollById(id);
		
		if(pr==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Payroll payroll= payrollService.deletePayroll(id);
		
		return new ResponseEntity<Payroll>(payroll,HttpStatus.OK);
	}
	

	@PutMapping("/payrolls/{id}")
	public ResponseEntity<Void> updatePayroll(@RequestBody Payroll updatedPayroll,@PathVariable("id") int id) {
		
		if(updatedPayroll==null) {
			throw new RuntimeException("Payroll Object Can't be null");
		}
		
		Payroll payrollSaved = payrollService.getPayrollById(id);
		
		if(payrollSaved==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		payrollService.updatePayroll(updatedPayroll);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
