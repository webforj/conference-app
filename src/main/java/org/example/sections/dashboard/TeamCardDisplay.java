package org.example.sections.dashboard;

import org.example.components.dashboard.teamcard.TeamCard;
import org.example.components.dashboard.teamcard.TeamCardWrapper;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;

public class TeamCardDisplay extends Composite<Div> {
  
  TeamCardWrapper teamCardWrapper = new TeamCardWrapper();

  public TeamCardDisplay() {
    String[] names = {
      "Telma Fridley",
      "Chandler Hervieux",
      "Percy Demers",
      "Antoine Masson"
    };

    String[] positions = {
      "Admin User",
      "Manager",
      "Director",
      "Premium User"
    };

    getBoundComponent().add(teamCardWrapper);
    getBoundComponent().setWidth("102%");

    for (int i = 0; i < names.length; i++) {
      TeamCard teamCard = new TeamCard("https://coderthemes.com/ubold/layouts/default/assets/images/users/user-" + (i + 1) +".jpg", names[i], positions[i]);
      teamCardWrapper.addTeamCard(teamCard);
    }
  }
    
}