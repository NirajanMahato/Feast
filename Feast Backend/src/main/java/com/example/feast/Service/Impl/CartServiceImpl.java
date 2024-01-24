package com.example.feast.Service.Impl;


import com.example.feast.Entity.Cart;
import com.example.feast.Entity.Item;
import com.example.feast.Entity.User;
import com.example.feast.Pojo.CartPojo;
import com.example.feast.Repo.CartRepo;
import com.example.feast.Repo.ItemRepo;
import com.example.feast.Repo.UserRepo;
import com.example.feast.Service.CartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;
    private final ItemRepo itemRepo;
    private final UserRepo userRepo;

    @Override
    public void saveCart(CartPojo cartPojo) {
        Cart cart=new Cart();

        if(cartPojo.getId()!=null){
            cart=cartRepo.findById(cartPojo.getId()).get();
        }

        cart.setId(cartPojo.getId());
        cart.setTotal_price(cartPojo.getTotal_price());
        cart.setQuantity(cartPojo.getQuantity());

        User user = userRepo.findById(cartPojo.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + cartPojo.getUserId()));

        cart.setUser(user);

        Item item = itemRepo.findById(cartPojo.getItemId())
                .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + cartPojo.getItemId()));

        cart.setItem(item);

        cartRepo.save(cart);
        System.out.println("cart saved");
    }

    @Override
    public List<Cart> getAll() {
        return cartRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cartRepo.deleteById(id);
    }

}


