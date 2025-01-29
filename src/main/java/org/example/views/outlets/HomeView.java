package org.example.views.outlets;

import org.example.sections.home.AppLayoutSection;
import org.example.sections.home.CounterSection;
import org.example.sections.home.Header;
import org.example.sections.home.WebComponentSection;
import org.example.views.MainLayout;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.concern.HasVisibility;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/home", outlet = MainLayout.class)
@FrameTitle("Home")
public class HomeView extends Composite<FlexLayout> implements HasVisibility{
  
  private FlexLayout self = getBoundComponent();

  public HomeView() {
    // self.setPadding("0 0 50vh 0");
    self.addClassName("main-class");
    self.setAlignment(FlexAlignment.CENTER);
    self.setDirection(FlexDirection.COLUMN);
    self.add(new Header(), 
    new CounterSection(), 
    new AppLayoutSection(), 
    new WebComponentSection());
  }
}
