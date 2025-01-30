package org.example.sections.ecom;

import org.example.components.ecom.checkout.BillingInfo;
import org.example.components.ecom.checkout.InfoControls;
import org.example.components.ecom.checkout.OrderSummary;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class CheckoutSection extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();
    
    public CheckoutSection() {
        self.setDirection(FlexDirection.COLUMN)
            .setAlignment(FlexAlignment.CENTER)
            .setJustifyContent(FlexJustifyContent.CENTER)
            .setSpacing("20px")
            .setPadding("20px")
            .setStyle("background-color", "var(--dwc-surface-3)")
            .setStyle("box-shadow", "0 4px 6px rgba(0, 0, 0, 0.1)")
            .setStyle("margin", "auto")
            .setStyle("margin-bottom", "50px")
            .setStyle("box-sizing", "border-box");

        Paragraph cartTitle = new Paragraph("Shopping Cart");
        cartTitle.setStyle("font-size", "1.5rem")
                 .setStyle("font-weight", "bold");

        InfoControls infoControls = new InfoControls();
        OrderSummary orderSummary = new OrderSummary();

        FlexLayout leftSection = new FlexLayout();
        leftSection.setDirection(FlexDirection.COLUMN)
                   .setAlignment(FlexAlignment.STRETCH) 
                   .setWidth("30%");
        leftSection.add(infoControls, orderSummary);

        BillingInfo billingInfo = new BillingInfo();

        FlexLayout rightSection = new FlexLayout();
        rightSection.setDirection(FlexDirection.COLUMN)
                    .setAlignment(FlexAlignment.STRETCH)  
                    .setWidth("70%");
        rightSection.add(billingInfo);

        FlexLayout checkoutContainer = new FlexLayout();
        checkoutContainer.setDirection(FlexDirection.ROW)
                         .setSpacing("20px")
                         .setJustifyContent(FlexJustifyContent.BETWEEN)
                         .setStyle("width", "100%");
        checkoutContainer.add(leftSection, rightSection);

        self.add(cartTitle, checkoutContainer);
    }
}