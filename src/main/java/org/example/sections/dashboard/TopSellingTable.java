package org.example.sections.dashboard;


import org.example.utils.table.ProductRecord;
import org.example.utils.table.Service;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H3;
import com.webforj.component.table.Table;
import com.webforj.component.table.renderer.Renderer;

public final class TopSellingTable extends Composite<Div> {

  Div self = getBoundComponent();
  H3 title = new H3("Top Selling Products");
  Table<ProductRecord> table = new Table<>();

  public TopSellingTable() {
    self.add(title, table);
    table.setRepository(Service.getProductRecords());
    
    configureStyling();
    configureColumns();
  }

  private void configureStyling(){
    self.setWidth("100%");
    self.addClassName("dashboard-section");

    title.setStyle("margin", "0 0 11px 0");

    table.setStyle("width", "100%")
    .setStyle("height", "542px")
    .setRowHeight(60.0)
    .setHeaderHeight(60.0)
    .addClassName("table");
  }

  private void configureColumns(){
    table.addColumn("ProductName", ProductRecord::getProduct).setHidden(true);
    table.addColumn("Product", new AvatarRenderer()).setMinWidth(300f);
    table.addColumn("Price", ProductRecord::getPrice).setComparator((a, b) -> {
      String numericPartA = a.getPrice().substring(1);
      String numericPartB = b.getPrice().substring(1);
      if(Float.parseFloat(numericPartA) > Float.parseFloat(numericPartB)){
        return 1;
      } else if (Float.parseFloat(numericPartB) > Float.parseFloat(numericPartA)){
        return -1;
      } else{
        return 0;
      }
    });
    table.addColumn("Quantity", ProductRecord::getQuantity);
    table.addColumn("Amount", ProductRecord::getAmount).setComparator((a, b) -> {
      String numericPartA = a.getAmount().replaceAll("[$,]", "");
      String numericPartB = b.getAmount().replaceAll("[$,]", "");
      if(Float.parseFloat(numericPartA) > Float.parseFloat(numericPartB)){
        return 1;
      } else if (Float.parseFloat(numericPartB) > Float.parseFloat(numericPartA)){
        return -1;
      } else{
        return 0;
      }
    });
    table.addColumn("Image", ProductRecord::getImageURL).setHidden(true);

    table.getColumns().forEach(column -> {
      if (column.getLabel().equalsIgnoreCase("product")) {
        return;
      }
      column.setSortable(true);
    });
  }

  class AvatarRenderer extends Renderer<ProductRecord> {
    @Override

    public String build() {
      return /* html */"""
        <%
        const product = cell.row.getValue('ProductName');
        const imageURL = cell.row.getValue('Image')
        %>
        <div part='avatar-renderer'>
          <img
            part='avatar-img'
            src='<%= imageURL %>' />
          <div part="avatar-text">
            <%= product %>
          </div>
        </div>
      """;
    }
  }
}
