package vn.edu.ntu.hoaiphong.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.hoaiphong.model.Product;

public class CartController extends Application implements ICartController {

    List<Product> productList = new ArrayList<>();

    public CartController() {
        productList.add(new Product("Chuối Đà Lạt",25000,"Chuối to, chín vàng"));
        productList.add(new Product("Sầu riêng Khánh Sơn",95000,"Cơm vàng, hạt lép"));
        productList.add(new Product("Khoai lang",35000,"Khoai lang nhỏ"));
        productList.add(new Product("Mận Ninh Hòa",10000,"Mận lớn"));
        productList.add(new Product("Xoài",25000,"Xoài Thái"));
        productList.add(new Product("Cà tím",25000,"Cà tím màu tím"));

    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }
}
