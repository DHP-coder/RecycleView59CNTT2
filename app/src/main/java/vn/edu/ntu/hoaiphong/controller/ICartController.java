package vn.edu.ntu.hoaiphong.controller;

import java.util.List;

import vn.edu.ntu.hoaiphong.model.Product;

public interface ICartController {
    List<Product> getAllProduct();
    public boolean addToCart (Product p);
    public List<Product> getShoppingCart();
    public void clearShoppingCart();
}
