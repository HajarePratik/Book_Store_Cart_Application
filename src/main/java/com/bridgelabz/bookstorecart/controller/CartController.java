package com.bridgelabz.bookstorecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstorecart.dto.CartDTO;
import com.bridgelabz.bookstorecart.dto.ResponseDTO;
import com.bridgelabz.bookstorecart.service.ICartService;

@RestController
public class CartController
{
	@Autowired
	ICartService cartService;
	
	@PostMapping("/addtocart/{token}")
	public ResponseEntity<ResponseDTO> addToCart(@PathVariable String token,@RequestBody CartDTO cartDTO,@RequestParam int bookid)
	{
		ResponseDTO respDTO = cartService.addToCart(token,cartDTO,bookid);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletefromcart/{token}")
	public ResponseEntity<ResponseDTO> deleteFromCart(@PathVariable String token,int bookid)
	{
		ResponseDTO respDTO = cartService.deleteFromCart(token,bookid);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatequantitycart/{token}")
	public ResponseEntity<ResponseDTO> updateQuantityCart(@PathVariable String token,@RequestParam int bookid,@RequestBody CartDTO cartDTO)
	{
		ResponseDTO respDTO = cartService.updateQuantityCart(token,bookid,cartDTO);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
