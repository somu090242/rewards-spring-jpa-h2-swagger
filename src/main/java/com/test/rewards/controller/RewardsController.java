package com.test.rewards.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.rewards.exception.ResourceNotFoundException;
import com.test.rewards.model.Transaction;
import com.test.rewards.request.model.RewardResponse;
import com.test.rewards.request.model.TransactionRequest;
import com.test.rewards.service.TransactionService;

@RestController
@RequestMapping("/api")
public class RewardsController {

	 	@Autowired
	    TransactionService transactionService;

	    @GetMapping(value="/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public List<Transaction> getAllTransactions() {
	        return transactionService.getAllTransactions();
	    }
	    
	    @GetMapping(value="/rewards/{userId}/{fromDate}/{toDate}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public RewardResponse getTotalRewardsInrange(@PathVariable Long userId,@PathVariable String fromDate,@PathVariable String toDate) throws ParseException {
	        return transactionService.getTotalRewardsInrange(userId,fromDate,toDate);
	    }
	    
	    @GetMapping(value="/transaction/{userId}/{fromDate}/{toDate}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public List<Transaction> getRewardsInrange(@PathVariable Long userId,@PathVariable String fromDate,@PathVariable String toDate) throws ParseException {
	        return transactionService.getRewardsInrange(userId,fromDate,toDate);
	    }
	    
	    

	    @PostMapping(value="/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public Transaction createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
	        return transactionService.createTransaction(transactionRequest);
	    }

	    @GetMapping(value="/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public Transaction getTransactionById(@PathVariable(value = "id") Long transactionId) {
	        return transactionService.getTransactionById(transactionId)
	                .orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
	    }

	    @PutMapping(value="/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody 
	    public Transaction updateTransaction(@PathVariable(value = "id") Long transactionId,
	                                           @Valid @RequestBody TransactionRequest transactionDetails) {

	        Transaction updatedTransaction = transactionService.updateTransaction(transactionId,transactionDetails);
	        return updatedTransaction;
	    }

	    @DeleteMapping(value="/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "id") Long transactionId) {
	        transactionService.deleteTransaction(transactionId);

	        return ResponseEntity.ok().build();
	    }
}
