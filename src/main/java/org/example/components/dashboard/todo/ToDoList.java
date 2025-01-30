package org.example.components.dashboard.todo;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.example.utils.todo.ToDoItem;
import org.example.utils.todo.ToDoRepository;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.CheckBox;

public class ToDoList extends Composite<Div> {
  
  private Div self = getBoundComponent();
  private final ToDoRepository repository;
  private List<CheckBox> checkBoxes = new ArrayList<>();
  private Div list;

  /**
   * Creates a new instance of {@link TodoList}.
   *
   * @param repository the repository to use
   */
  public ToDoList(ToDoRepository repository) {
    this.repository = repository;
    this.repository.addChangeListener(new RepositoryChangeListener());
    list = new Div()
      .addClassName("todo__list");
    repository.getItems().forEach(item -> {
      addCheckbox(item);
    });

    self.add(list);
  }

  private void addCheckbox(ToDoItem item) {
    CheckBox checkBox = new CheckBox(item.getText())
      .setChecked(item.isCompleted())
      .addClassName("todo__item")
      .removeClassName("bbj-whitespace-nowrap");
    checkBox.setUserData("id", item.getId());
    checkBox.onToggle(e -> {
      item.setCompleted(checkBox.isChecked());
    });

    checkBoxes.add(checkBox);
    list.add(checkBox);
  }

  private class RepositoryChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      if (evt.getPropertyName().equals("added")) {
        addCheckbox((ToDoItem) evt.getNewValue());
      }

      if (evt.getPropertyName().equals("removed")) {
        ToDoItem item = (ToDoItem) evt.getNewValue();
        checkBoxes.forEach( e -> {
          if (e.getUserData("id") != null && item.getId() != null && e.getUserData("id").equals(item.getId())) {
            e.destroy();
        }        
        });
      }
    }
  }
}