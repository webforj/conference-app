package org.example.components.dashboard.charts;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.webforj.component.Composite;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H3;
import com.webforj.utilities.Assets;

public final class ProjectionsVsActual extends Composite<Div> {

  private Div self = getBoundComponent();
  private H3 title = new H3("Revenue By Location");
  private GoogleChart chart = new GoogleChart(GoogleChart.Type.COMBO);

  public ProjectionsVsActual() {
    self.addClassName("dashboard-chart");
    self.add(title);
    title.setStyle("margin", "0 0 11px 0");
    chart.setStyle("width", "100%");

    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("static/data/charts.json"),
        new TypeToken<Map<String, Object>>() {
        }.getType());
    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();

    // cols
    List<Map<String, String>> cols = new ArrayList<>();
    String[] colNames = new String[] { "Month", "Sales", "Rate" };

    for (int i = 0; i < colNames.length; i++) {
      Map<String, String> col = new HashMap<>();
      col.put("label", colNames[i]);
      cols.add(col);
    }

    data.add(cols);

    // rows
    for (int i = 0; i < 6; i++) {
      JsonArray row = new JsonArray();
      row.add(new DateFormatSymbols().getShortMonths()[i + 6]);
      double number = Math.floor(Math.random() * 100000) / 100;
      String formatted = String.format("%.2f", number);
      if (formatted.endsWith("0")) {
        number += 0.01;
      }
      row.add(number);

      number = Math.floor(Math.random() * 100000) / 100;
      formatted = String.format("%.2f", number);
      if (formatted.endsWith("0")) {
        number += 0.01;
      }
      row.add(Math.floor(Math.random() * 100000) / 100);
      data.add(row);
    }

    chart.setData(data);
    self.add(chart);
  }
}
