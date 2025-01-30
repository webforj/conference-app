package org.example.components.dashboard.todo;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import static com.webforj.component.button.ButtonTheme.PRIMARY;

import org.example.utils.todo.ToDoRepository;

public class ToDoInput extends Composite<Div> {

  private Div self = getBoundComponent();

  /**
   * Creates a new instance of {@link TodoInput}.
   *
   * @param repository the repository to use
   */
  public ToDoInput() {
    this(null);
  }
  public ToDoInput(ToDoRepository repository) {
    self.addClassName("todo__input-wrapper");

    TextField input = new TextField()
      .addClassName("todo__input")
      .setPlaceholder("What needs to be done?");

    Button button = new Button("Add")
      .setTheme(PRIMARY)
      .addClassName("todo__button");
    button.onClick(e -> {
      if(!input.getText().isEmpty()){
        repository.addItem(input.getText());
        input.setText("");
      }
    });

    self.add(input, button);
  }
}