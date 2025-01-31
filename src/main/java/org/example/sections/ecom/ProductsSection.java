package org.example.sections.ecom;

import org.example.components.ecom.products.ProductCard;
import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;

public class ProductsSection extends Composite<FlexLayout> {
  
  FlexLayout self = getBoundComponent();

  public ProductsSection() {
    
    self.setWrap(FlexWrap.WRAP);
    self.setJustifyContent(FlexJustifyContent.EVENLY);
    self.setAlignment(FlexAlignment.CENTER);
    self.setSpacing("20px");
    self.setMargin("0 0 200px 0");

    self.add(
        new ProductCard("context://static/img/product-1.png", "Jones Men's T-shirt (Blue)", "$39", "★★★★☆", "98 pcs"),
        new ProductCard("context://static/img/product-2.png", "Brown Hoodie for Men", "$98", "★★★★☆", "56 pcs"),
        new ProductCard("context://static/img/product-3.png", "Designer Awesome T-shirt", "$49", "★★★★★", "235 pcs"),
        new ProductCard("context://static/img/product-4.png", "Jones Awesome T-shirt", "$29", "★★★★★", "385 pcs"),
        new ProductCard("context://static/img/product-5.png", "Green T-shirt for Men", "$49", "★★☆☆☆", "25 pcs"),
        new ProductCard("context://static/img/product-6.png", "Blue Awesome Hoodie", "$19", "★★★☆☆", "39 pcs");
        // new ProductCard("context://static/img/product-7.png", "Jones Men's T-shirt (Green)", "$99", "★★★★★", "36 pcs"),
        // new ProductCard("context://static/img/product-8.png", "Red Hoodie for Men", "$29", "★★★★★", "128 pcs")
    );
  }

}
