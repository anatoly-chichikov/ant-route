package chichikov.antroute.ui;

import chichikov.antroute.core.Tracked;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.List;

import static chichikov.antroute.core.CoreFactory.getGenerator;
import static chichikov.antroute.core.CoreFactory.getPosition;
import static java.lang.Integer.parseInt;

/**
 * AppView
 *
 * @author Anatoly Chichikov (03.07.2013)
 */
public class AppView {

    final HorizontalLayout
        mainLayout = new HorizontalLayout(),
        controlsLayout = new HorizontalLayout(),
        xLayout = new HorizontalLayout(),
        yLayout = new HorizontalLayout();

    final VerticalLayout
        actionsSide = new VerticalLayout(),
        choicesSide = new VerticalLayout(),
        settingsLayout = new VerticalLayout(),
        startActionsLayout = new VerticalLayout();

    Label
        xLabel = new Label("Set X:"),
        yLabel = new Label("Set Y:"),
        informationLabel = new Label("Input (X, Y) and press calculate.");

    TextField
        xField = new TextField(),
        yField = new TextField();

    Button startButton = new Button("Calculate routes");
    GridLayout routeField = new GridLayout(10, 10);

    public void startApp(UI app) {
        app.setContent(mainLayout);
        startButton.addClickListener(new StartButtonClickListener());
        placeAndSetupLayouts();
        placeAndSetupComponents();
    }

    private void populateRoutesList(List<Tracked> routes, VerticalLayout layout) {
        layout.removeAllComponents();
        layout.addComponent(new Label("All possible routes (" + routes.size() + "):"));
        int i = 1;
        for (Tracked route : routes) {
            layout.addComponent(new RouteUnit(route, i, routeField), i);
            i++;
        }
    }

    private void placeAndSetupLayouts() {
        settingsLayout.setMargin(new MarginInfo(true, true, true ,false));
        startActionsLayout.setMargin(true);
        choicesSide.setMargin(true);
        mainLayout.setMargin(true);
        settingsLayout.addComponent(xLayout, 0);
        settingsLayout.addComponent(yLayout, 1);
        controlsLayout.addComponent(settingsLayout, 0);
        controlsLayout.addComponent(startActionsLayout, 1);
        actionsSide.addComponent(controlsLayout, 0);
        actionsSide.addComponent(routeField, 1);
        mainLayout.addComponent(actionsSide, 0);
        mainLayout.addComponent(choicesSide, 1);
    }

    private void placeAndSetupComponents() {
        xLayout.addComponent(xLabel, 0);
        xLayout.addComponent(xField, 1);
        yLayout.addComponent(yLabel, 0);
        yLayout.addComponent(yField, 1);
        startActionsLayout.addComponent(startButton, 0);
        startActionsLayout.addComponent(informationLabel, 1);
    }

    private class StartButtonClickListener implements Button.ClickListener {
        @Override
        public void buttonClick(Button.ClickEvent event) {
            try {
                int
                    x = parseInt(xField.getValue()),
                    y = parseInt(yField.getValue());

                if ((x * y) <= 60) {
                    informationLabel.setValue("Routes for " + x + "x" + y + " field");
                    populateRoutesList(
                        getGenerator().
                            generateAllPossibleRoutes(getPosition(1, 1), getPosition(x, y)), choicesSide);
                }
                else {
                    informationLabel.setValue("Are you serious? :)");
                }
            }
            catch (NumberFormatException e) {
                informationLabel.setValue("Invalid input (int value only)");
            }
        }
    }
}
