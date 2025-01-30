package org.example.components.ecom.checkout;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class InfoControls extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    public InfoControls() {
        self.setDirection(FlexDirection.COLUMN)
            .setSpacing("10px")
            .setPadding("10px");

        self.add(createStepButton("user", "Billing Info", ButtonTheme.INFO));
        self.add(createStepButton("truck-delivery", "Shipping Info", ButtonTheme.DEFAULT));
        self.add(createStepButton("cash", "Payment Info", ButtonTheme.DEFAULT));
    }

    private Button createStepButton(String iconName, String text, ButtonTheme theme) {
        Button stepButton = new Button("""
            <html>
            <div style='text-align: center;'>
                <dwc-icon name='%s' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
                <span style='display: block; margin-top: 10px;'>%s</span>
            </div>
            </html>
        """.formatted(iconName, text));
        
        stepButton.setTheme(theme)
                  .setWidth("100%")
                  .setHeight("100px")
                  .setStyle("background", "#f4f5f7")
                  .setStyle("color", "#353c48")
                  .setStyle("cursor", "pointer");

        return stepButton;
    }
}
