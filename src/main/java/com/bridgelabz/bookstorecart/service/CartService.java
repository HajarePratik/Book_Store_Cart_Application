package com.bridgelabz.bookstorecart.service;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.bookstorecart.dto.CartDTO;
import com.bridgelabz.bookstorecart.dto.ResponseDTO;
import com.bridgelabz.bookstorecart.exception.CartException;
import com.bridgelabz.bookstorecart.model.CartModel;
import com.bridgelabz.bookstorecart.repository.CartRepository;

@Service
public class CartService implements ICartService
{

	@Autowired
	CartRepository cartRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ResponseDTO addToCart(String token, CartDTO cartDTO, int bookid) 
	{
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if (verify) 
		{
			int userId = restTemplate.getForObject("http://userbook-store/getuserid/" + token,Integer.class);
			CartModel addToCart = modelMapper.map(cartDTO, CartModel.class);
			addToCart.setUserId(userId);
			addToCart.setBookId(bookid);
			cartRepository.save(addToCart);
			return new ResponseDTO("Add to Cart Successfully",addToCart);
		}
		else 
		{
			throw new CartException(400, "User not Login, Please Check");
		}
	}

	@Override
	public ResponseDTO deleteFromCart(String token, int bookid) 
	{
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if(verify) 
		{
			cartRepository.deleteById(bookid);
			return new ResponseDTO("Book Deleted from Cart Successfully",bookid);
		}
		else 
		{
			throw new CartException(400, "User not Login, Please Check");
		}
	}

	@Override
	public ResponseDTO updateQuantityCart(String token, int bookid, CartDTO cartDTO) 
	{
		boolean verify = restTemplate.getForObject("http://userbook-store/verifyemail/" + token,Boolean.class);
		if(verify) 
		{
			Optional<CartModel> isCartPresent = cartRepository.findById(bookid);
			if(isCartPresent.isPresent())
			{
				isCartPresent.get().setQuantity(cartDTO.getQuantity());
				cartRepository.save(isCartPresent.get());
				return new ResponseDTO("Book of Quantity from Cart is Updated",isCartPresent);
			}
			else 
			{
				throw new CartException(400,"Book Id is not Present in Cart");
			}
		}
		else 
		{
			throw new CartException(400, "User not Login, Please Check");
		}
	}

}
