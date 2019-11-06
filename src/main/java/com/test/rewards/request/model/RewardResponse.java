package com.test.rewards.request.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userId", "userName", "totalTransactionAmount", "totalRewardPoints" })
public class RewardResponse {

	@JsonProperty("userId")
	public Long userId;
	@JsonProperty("userName")
	public String userName;
	@JsonProperty("totalTransactionAmount")
	public Long totalTransactionAmount;
	@JsonProperty("totalRewardPoints")
	public Long totalRewardPoints;

}
