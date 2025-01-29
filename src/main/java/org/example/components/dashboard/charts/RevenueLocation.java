package org.example.components.dashboard.charts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.component.Composite;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H3;
import com.webforj.utilities.Assets;

public class RevenueLocation extends Composite<Div> {

  private Div self = getBoundComponent();
  private H3 title = new H3("Revenue By Location");
  private GoogleChart chart = new GoogleChart(GoogleChart.Type.GEO);

  public RevenueLocation() {
    self.addClassName("dashboard-chart");
    self.add(title);
    title.setStyle("margin", "0 0 11px 0");
    chart.setStyle("width", "100%"); 

    // options
    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("static/data/charts.json"),
        new TypeToken<Map<String, Object>>() {
        }.getType());
    options.put("legend", "none");
    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();

    // cols
    List<String> cols = new ArrayList<>();
    cols.add("Country");
    cols.add("Revenue");
    data.add(cols);

    String[] countries = new String[] { "Germany", "United States", "Brazil", "Canada", "France", "ZA", "AU", "IN",
        "EG", "ES", "JP" };

    // rows
    for (String country : countries) {
      List<Object> row = new ArrayList<>();
      row.add(country);
      double number = Math.floor(Math.random() * 1000000) / 100;
      String formatted = String.format("%.2f", number);
      if (formatted.endsWith("0")) {
        number += 0.01;
      }
      row.add(number);
      data.add(row);
    }

    chart.setData(data);
    self.add(chart);
  }
}
