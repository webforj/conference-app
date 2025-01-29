package org.example.views.outlets;

import org.example.views.MainLayout;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.concern.HasVisibility;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/ecom", outlet = MainLayout.class)
@FrameTitle("Ecom")
public class EcomView extends Composite<FlexLayout> implements HasVisibility{

  private FlexLayout self = getBoundComponent();

  public EcomView() {
    self.setHeight("100%");
    self.setAlignment(FlexAlignment.CENTER);
  }
}
