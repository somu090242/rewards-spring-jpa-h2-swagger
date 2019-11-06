package com.test.rewards.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rewards.exception.ResourceNotFoundException;
import com.test.rewards.model.Transaction;
import com.test.rewards.model.User;
import com.test.rewards.repository.TransactionRepository;
import com.test.rewards.repository.UserRepository;
import com.test.rewards.request.model.RewardResponse;
import com.test.rewards.request.model.TransactionRequest;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction createTransaction(@Valid TransactionRequest transactionRequest) {
		User user=userRepository.findById(transactionRequest.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", transactionRequest.getUserId()));
		Transaction transaction = new Transaction();
		transaction.setItemName(transactionRequest.getItemName());
		transaction.setItemCost(transactionRequest.getItemCost());
		transaction.setTransactionDate(new Date());
		transaction.setCreatedTimestamp(new Date());
		transaction.setUpdatedTimestamp(new Date());
		transaction.setRewardPoints(calculateRewardPoints(transactionRequest.getItemCost()));
		transaction.setUser(user);
		return transactionRepository.save(transaction);
	}

	private Long calculateRewardPoints(Long itemCost) {
		Long rewardPoints = 0L;
		if (itemCost > 100) {
			rewardPoints = ((100 - 50) * 1) + ((itemCost - 100) * 2);
		} else if (itemCost > 50 && itemCost < 100) {
			rewardPoints = (itemCost - 50) * 1;
		}
		return rewardPoints;
	}

	public Optional<Transaction> getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId);
	}

	public void deleteTransaction(Long transactionId) {
		Transaction transaction = getTransactionById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
		transactionRepository.delete(transaction);

	}

	public Transaction updateTransaction(Long transactionId, @Valid TransactionRequest transactionRequest) {
		User user=userRepository.findById(transactionRequest.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", transactionRequest.getUserId()));
		Transaction transaction = getTransactionById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", transactionId));
		transaction.setItemName(transactionRequest.getItemName());
		transaction.setItemCost(transactionRequest.getItemCost());
		transaction.setUpdatedTimestamp(new Date());
		transaction.setTransactionDate(new Date());
		transaction.setRewardPoints(calculateRewardPoints(transactionRequest.getItemCost()));
		transaction.setUser(user);
		return transactionRepository.save(transaction);
	}

	public List<Transaction> getRewardsInrange(Long userId, String fromDate, String toDate) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy");
		
		List<Transaction> trans=transactionRepository.getRewardsInrange(userId,format.parse(fromDate),format.parse(toDate));
		return trans;
	}

	public RewardResponse getTotalRewardsInrange(Long userId, String fromDate, String toDate) throws ParseException {
		User user=userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		List<Transaction> trans=getRewardsInrange(userId,fromDate,toDate);
		
		RewardResponse rewardResponse=new RewardResponse();
		rewardResponse.setTotalTransactionAmount(trans.stream().mapToLong(transaction-> transaction.getItemCost()).sum());
		rewardResponse.setTotalRewardPoints(trans.stream().mapToLong(transaction-> transaction.getRewardPoints()).sum());
		rewardResponse.setUserId(userId);
		rewardResponse.setUserName(user.getUserName());
		return rewardResponse;
	}

}
