package org.example.components.dashboard.todo;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;

import java.beans.PropertyChangeListener;

import org.example.utils.todo.ToDoRepository;

import java.beans.PropertyChangeEvent;
import static com.webforj.component.button.ButtonTheme.OUTLINED_PRIMARY;

public class ToDoToolbar extends Composite<Div> {
  
  Div self = getBoundComponent();
  private final ToDoRepository repository;
  private Div toolbar;
  private Paragraph remainingItems;

  /**
   * Creates a new instance of {@link TodoToolbar}.
   *
   * @param repository the repository to use
   */
  public ToDoToolbar(ToDoRepository repository) {
    this.repository = repository;
    this.repository.addChangeListener(new RepositoryChangeListener());

    toolbar = new Div()
      .addClassName("todo__toolbar");

    remainingItems = new Paragraph("")
      .addClassName("todo__remainingItems");

    Button clearCompleted = new Button("Archive")
      .setTheme(OUTLINED_PRIMARY);
    clearCompleted.onClick(e -> {
      repository.removeCompletedItems();
    });

    update();
    toolbar.add(remainingItems, clearCompleted);
    self.add(toolbar);
  }

  private void update() {
    int total = repository.getItems().size();
    int remaining = total - repository.getCompletedItems().size();

    remainingItems.setText(remaining + " of " + total + " remaining");
  }

  private class RepositoryChangeListener implements PropertyChangeListener {
    @Override

    public void propertyChange(PropertyChangeEvent e) {
      String[] properties = {"added", "removed", "updated"};
      if (java.util.Arrays.asList(properties).contains(e.getPropertyName())) {
        update();
      }
    }
  }

}
