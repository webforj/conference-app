package org.example.components.ecom.checkout;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class OrderSummary extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    public OrderSummary() {
        self.setDirection(FlexDirection.COLUMN)
            .setSpacing("15px")
            .setPadding("15px")
            .setStyle("border", "1px solid var(--dwc-border-color)")
            .setStyle("margin-left", "10px")
            .setStyle("width", "100%");

        Paragraph title = new Paragraph("Order Summary")
                .setStyle("margin-bottom", "20px")
                .setStyle("font-size", "1.2em")
                .setStyle("font-weight", "bold");

        self.add(title);

        self.add(createOrderItem("context://static/img/product-1.png", "Polo Navy Blue T-shirt", "1 x $39"));
        self.add(createOrderItem("context://static/img/product-2.png", "Red Hoodie for Men", "2 x $98"));
        self.add(createOrderItem("context://static/img/product-3.png", "Designer Awesome T-Shirt", "1 x $49"));

        self.add(createTotalLine("Subtotal", "$284"));
        self.add(createTotalLine("Shipping", "FREE"));
        self.add(createTotalLine("Total", "$284"));
    }

    private FlexLayout createOrderItem(String imageUrl, String name, String quantityAndPrice) {
        FlexLayout orderItem = new FlexLayout();
        orderItem.setDirection(FlexDirection.ROW)
                 .setJustifyContent(FlexJustifyContent.START)
                 .setAlignment(FlexAlignment.CENTER)
                 .setSpacing("10px")
                 .setPadding("10px 0")
                 .setStyle("border-bottom", "1px solid #eee");

        Img image = new Img(imageUrl);
        image.setWidth("15%");

        Paragraph itemName = new Paragraph(name)
                .setStyle("font-size", "1em")
                .setStyle("text-align", "left")
                .setStyle("margin-right", "auto")
                .setStyle("margin-left", "1em");

        Span quantityAndPriceSpan = new Span(quantityAndPrice)
                .setStyle("font-size", "1em")
                .setStyle("font-weight", "bold");

        orderItem.add(image, itemName, quantityAndPriceSpan);
        return orderItem;
    }

    private FlexLayout createTotalLine(String label, String value) {
        FlexLayout totalLine = new FlexLayout();
        totalLine.setDirection(FlexDirection.ROW)
                 .setJustifyContent(FlexJustifyContent.BETWEEN)
                 .setAlignment(FlexAlignment.CENTER)
                 .setPadding("10px 0");

        Span totalLabel = new Span(label)
                .setStyle("font-size", "1em");

        Span totalValue = new Span(value)
                .setStyle("font-size", "1em")
                .setStyle("font-weight", "bold");

        totalLine.add(totalLabel, totalValue);
        return totalLine;
    }
}
