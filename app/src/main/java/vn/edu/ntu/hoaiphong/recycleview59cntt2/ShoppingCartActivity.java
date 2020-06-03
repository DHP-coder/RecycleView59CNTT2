package vn.edu.ntu.hoaiphong.recycleview59cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.edu.ntu.hoaiphong.controller.ICartController;
import vn.edu.ntu.hoaiphong.model.Product;

public class ShoppingCartActivity extends AppCompatActivity {

    ICartController controller;
    TextView txtShoppingCart;
    Button btnCancle, btnBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        controller = (ICartController) getApplication();
        addView();
        addEvent();
    }

    private void addEvent() {
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.clearShoppingCart();
                displayShoppingCart();
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Product> products;
                products = controller.getShoppingCart();
                int s = 0;
                for (Product p : products) {
                    s += p.getPrice();
                }
                Toast.makeText(getApplicationContext(),"Tong gia tri la: "+ s + "VND", Toast.LENGTH_LONG);
            }
        });
    }
    private void addView()
    {
        txtShoppingCart = findViewById(R.id.txtCart);
        displayShoppingCart();
        btnCancle = findViewById(R.id.btnCancel);
        btnBuy = findViewById(R.id.btnBuy);
    }

    private void displayShoppingCart()
    {
        List<Product> shoppingCart;
        shoppingCart = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();
        for(Product p:shoppingCart)
        {
            builder.append(p.getName()).append("\t\t\t").append(p.getPrice()).append(" vnd\n");
        }
        if (builder.toString().length()>0)
            txtShoppingCart.setText(builder.toString());
        else txtShoppingCart.setText("Không có mặt hàng nào trong giỏ hàng");
    }
}
