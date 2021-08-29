package com.bridgelabz.bookstorecart.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.bookstorecart.dto.CartDTO;
import com.bridgelabz.bookstorecart.dto.ResponseDTO;

@Service
public interface ICartService 
{

	ResponseDTO addToCart(String token,CartDTO cartDTO,int bookid);

	ResponseDTO deleteFromCart(String token, int bookid);

	ResponseDTO updateQuantityCart(String token, int bookId,CartDTO cartDTO);

}
