package com.hostmdy.ecommerce_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.ecommerce_api.domain.Product;
import com.hostmdy.ecommerce_api.repository.ProductRepository;

@SpringBootApplication
public class EcommerceApiApplication implements CommandLineRunner{
	
	@Autowired
	public ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Product product1 = new Product();
		product1.setCategory("Electronics");
		product1.setCode("E-001");
		product1.setDescription("Le guide de l'électricien: Toutes les réponses à vos questions . Installations, branchements et textes réglementaires (French Edition) Paperback – January 1, 2006");
		product1.setDiscount(50);
		product1.setImageName("https://m.media-amazon.com/images/W/MEDIAX_792452-T1/images/I/61vjJuKkKzL._SY466_.jpg");
	    product1.setName("Le guide");
	    product1.setPrice(76.79);
		product1.setQuantity(20);
		
		Product product2 = new Product();
		product2.setCategory("Wire Stripper");
		product2.setCode("E-002");
		product2.setDescription("【Professional Electrical Wire Stripping Tool】Upgrade your electrical game with our professional wire stripping tool! Cut, crimp, and strip wires with ease, improving work efficiency and eliminating the need for frequent replacements.\n"
				+ "【Strong & Durable Material】Made of high-quality alloy steel, our wire stripper cutter is durable and wear-resistant, ensuring a long service life.\n"
				+ "【Sharp Cutting】The sharp blade design and fast cutting speed make wire stripping a breeze with smooth and burr-free incisions.");
		product2.setDiscount(0);
		product2.setImageName("https://m.media-amazon.com/images/W/MEDIAX_792452-T1/images/I/512X1FNLDDL._AC_SX679_.jpg");
	    product2.setName("Wire Stripper");
	    product2.setPrice(76.79);
		product2.setQuantity(20);
		
		productRepository.save(product1);
		productRepository.save(product2);
	}

}
