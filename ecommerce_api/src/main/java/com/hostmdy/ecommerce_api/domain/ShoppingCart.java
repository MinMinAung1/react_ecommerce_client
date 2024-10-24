package com.hostmdy.ecommerce_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private Double grandTotal;
}
