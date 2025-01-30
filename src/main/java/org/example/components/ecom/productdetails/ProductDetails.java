package org.example.components.ecom.productdetails;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class ProductDetails extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    public ProductDetails() {
        self.setDirection(FlexDirection.COLUMN);

        ProductInfo productInfo = new ProductInfo(
            new Paragraph("Jack & Jones Men's T-shirt (Blue)"),
            new Paragraph("★★★★☆ (36 Customer Reviews)"),
            new Paragraph("In Stock"),
            "$80 USD",
            "$64 USD",
            "Experience the perfect blend of comfort and style with our Premium Cotton Striped T-Shirt. "
            + "Made from 100% organic cotton, this tee is designed to provide a relaxed fit that is both "
            + "breathable and soft against your skin."
        );

        ProductControls productControls = new ProductControls();

        self.add(productInfo, productControls);
    }
}