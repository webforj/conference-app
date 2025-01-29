package org.example.sections.home;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class Header extends Composite<FlexLayout> {

    FlexLayout self = getBoundComponent();
    H1 title = new H1("webforJ");
    FlexLayout subtitle = new FlexLayout();

    public Header() {
        self.setDirection(FlexDirection.COLUMN);
        self.setAlignment(FlexAlignment.CENTER);

        title.addClassName("home__title");
        subtitle.setHtml( /* html */"""
          <p class='home__subtitle'>A robust and flexible framework that can help you deliver a modern and engaging web user interface with ease. <b>In Java.</b></p>
        """);
        subtitle.setJustifyContent(FlexJustifyContent.CENTER);
        self.add(title, subtitle);
    }
}