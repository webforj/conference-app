package org.example.sections.dashboard;

import org.example.components.dashboard.charts.LastSales;
import org.example.components.dashboard.charts.ProjectionsVsActual;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class BottomCharts extends Composite<FlexLayout>{
  
  FlexLayout self = getBoundComponent();

  public BottomCharts(){
    self.add(new LastSales(), new ProjectionsVsActual());
    self.setSpacing("var(--dwc-space-m)");
    self.setWidth("102%");
  }
}