package org.example.components;

import com.webforj.App;
import com.webforj.component.Composite;
import com.webforj.component.element.event.ElementClickEvent;
import com.webforj.component.html.elements.Div;

public class ThemeToggle extends Composite<Div>{
  
  Div self = getBoundComponent();

  public ThemeToggle(){
    if(App.getTheme().equals("light")){
      self.setHtml("<dwc-icon name=sun></dwc-icon>");
    } else{
      self.setHtml("<dwc-icon name=moon></dwc-icon>");
    }
    self.addClassName("button__theme-toggle");
    self.onClick(this::toggleTheme);
  }

  public void toggleTheme(ElementClickEvent e){
    if(App.getTheme().equals("light")){
      self.setHtml("<dwc-icon name=moon></dwc-icon>");
      App.setTheme("dark");
    } else{
      self.setHtml("<dwc-icon name=sun></dwc-icon>");
      App.setTheme("light");
    }
  }

}
