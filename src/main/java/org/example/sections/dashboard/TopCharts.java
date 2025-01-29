package org.example.sections.dashboard;

import org.example.components.dashboard.charts.LifetimeSales;
import org.example.components.dashboard.charts.RevenueLocation;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class TopCharts extends Composite<FlexLayout>{
  
  FlexLayout self = getBoundComponent();

  public TopCharts(){
    self.add(new RevenueLocation(), new LifetimeSales());
    self.setSpacing("var(--dwc-space-m)");
    self.setWidth("102%");
  }
}
