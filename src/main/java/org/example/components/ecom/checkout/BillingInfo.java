package org.example.components.ecom.checkout;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.MaskedNumberField;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.optioninput.RadioButton;

public class BillingInfo extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    private TextField firstName, lastName, email, phone, address, city, orderNotes;
    private ChoiceBox states, countries;
    private MaskedNumberField zip;
    private RadioButton diffAddress;
    private Button submit, back;

    public BillingInfo() {
        self.setWidth("90%")
            .setDirection(FlexDirection.COLUMN)
            .setJustifyContent(FlexJustifyContent.EVENLY)
            .setSpacing("40px")
            .setPadding("20px")
            .setStyle("margin", "10px 45px");

        Paragraph title = new Paragraph("Billing Information");
        title.setStyle("font-size", "16px");

        Paragraph subtitle = new Paragraph("Fill the form below in order to send you the order's invoice.");
        subtitle.setStyle("font-size", "12px")
                .setStyle("color", "#9ba8af");

        firstName = new TextField().setLabel("First Name").setWidth("90%");
        lastName = new TextField().setLabel("Last Name").setWidth("90%");
        email = new TextField().setLabel("Email").setWidth("90%");
        phone = new TextField().setLabel("Phone").setWidth("90%");
        address = new TextField().setLabel("Address").setWidth("100%");
        city = new TextField().setLabel("City").setWidth("90%");
        zip = new MaskedNumberField().setLabel("Zip").setWidth("90%");

        populateStates();
        populateCountries();

        diffAddress = new RadioButton().setText("Ship to different address?");
        orderNotes = new TextField().setLabel("Order Notes").setPlaceholder("Write order notes...").setWidth("100%");

        back = new Button("""
            <html>
            <div style='text-align: center;'>
                <dwc-icon name='arrow-left'></dwc-icon>
                Back to Shopping Cart
            </div>
            </html>
        """).setTheme(ButtonTheme.GRAY)
          .setStyle("margin-right", "auto");

        submit = new Button("""
            <html>
            <div style='text-align: center;'>
                <dwc-icon name='truck-delivery'></dwc-icon>
                Proceed to Shipping
            </div>
            </html>
        """).setTheme(ButtonTheme.SUCCESS)
          .setStyle("margin-left", "auto");

        FlexLayout rowOne = new FlexLayout(title, subtitle);
        rowOne.setDirection(FlexDirection.COLUMN);

        FlexLayout rowTwo = new FlexLayout(firstName, lastName);
        rowTwo.setDirection(FlexDirection.ROW)
              .setJustifyContent(FlexJustifyContent.BETWEEN)
              .setSpacing("10px");

        FlexLayout rowThree = new FlexLayout(email, phone);
        rowThree.setDirection(FlexDirection.ROW)
                .setJustifyContent(FlexJustifyContent.BETWEEN)
                .setSpacing("10px");

        FlexLayout rowFour = new FlexLayout(city, states, zip);
        rowFour.setDirection(FlexDirection.ROW)
               .setJustifyContent(FlexJustifyContent.BETWEEN)
               .setSpacing("10px");

        FlexLayout rowSix = new FlexLayout(back, submit);
        rowSix.setDirection(FlexDirection.ROW)
              .setJustifyContent(FlexJustifyContent.BETWEEN)
              .setSpacing("10px")
              .setStyle("margin-top", "30px");

        self.add(rowOne, rowTwo, address, rowThree, rowFour, countries, diffAddress, orderNotes, rowSix);
    }

    private void populateCountries() {
        countries = new ChoiceBox().setLabel("Country").setMaxRowCount(10).setWidth("100%");
        countries.add("US", "United States");
        countries.add("CA", "Canada");
        countries.add("MX", "Mexico");
        countries.add("BR", "Brazil");
        countries.add("AR", "Argentina");
        countries.add("UK", "United Kingdom");
        countries.add("FR", "France");
        countries.add("DE", "Germany");
        countries.add("IT", "Italy");
        countries.add("ES", "Spain");
        countries.add("CN", "China");
        countries.add("JP", "Japan");
        countries.add("IN", "India");
        countries.add("AU", "Australia");
        countries.add("NZ", "New Zealand");
        countries.add("RU", "Russia");
        countries.add("ZA", "South Africa");
        countries.add("EG", "Egypt");
        countries.add("NG", "Nigeria");
        countries.add("KE", "Kenya");
        countries.add("SA", "Saudi Arabia");
        countries.add("AE", "United Arab Emirates");
        countries.add("SG", "Singapore");
        countries.add("TH", "Thailand");
        countries.add("KR", "South Korea");
    }

    private void populateStates() {
        states = new ChoiceBox().setLabel("State").setMaxRowCount(10).setWidth("100%");
        states.add("AL", "Alabama");
        states.add("AK", "Alaska");
        states.add("AZ", "Arizona");
        states.add("AR", "Arkansas");
        states.add("CA", "California");
        states.add("CO", "Colorado");
        states.add("CT", "Connecticut");
        states.add("DE", "Delaware");
        states.add("FL", "Florida");
        states.add("GA", "Georgia");
        states.add("HI", "Hawaii");
        states.add("ID", "Idaho");
        states.add("IL", "Illinois");
        states.add("IN", "Indiana");
        states.add("IA", "Iowa");
        states.add("KS", "Kansas");
        states.add("KY", "Kentucky");
        states.add("LA", "Louisiana");
        states.add("ME", "Maine");
        states.add("MD", "Maryland");
        states.add("MA", "Massachusetts");
        states.add("MI", "Michigan");
        states.add("MN", "Minnesota");
        states.add("MS", "Mississippi");
        states.add("MO", "Missouri");
        states.add("MT", "Montana");
        states.add("NE", "Nebraska");
        states.add("NV", "Nevada");
        states.add("NH", "New Hampshire");
        states.add("NJ", "New Jersey");
        states.add("NM", "New Mexico");
        states.add("NY", "New York");
        states.add("NC", "North Carolina");
        states.add("ND", "North Dakota");
        states.add("OH", "Ohio");
        states.add("OK", "Oklahoma");
        states.add("OR", "Oregon");
        states.add("PA", "Pennsylvania");
        states.add("RI", "Rhode Island");
        states.add("SC", "South Carolina");
        states.add("SD", "South Dakota");
        states.add("TN", "Tennessee");
        states.add("TX", "Texas");
        states.add("UT", "Utah");
        states.add("VT", "Vermont");
        states.add("VA", "Virginia");
        states.add("WA", "Washington");
        states.add("WV", "West Virginia");
        states.add("WI", "Wisconsin");
        states.add("WY", "Wyoming");
    }
}