package com.test.rewards.request.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userId","itemName", "itemCost" })
public class TransactionRequest {

	@JsonProperty("userId")
	private Long userId;
	@JsonProperty("itemName")
	private String itemName;
	@JsonProperty("itemCost")
	private Long itemCost;

}
