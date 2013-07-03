package chichikov.antroute.ui;

import chichikov.antroute.core.Positionable;
import chichikov.antroute.core.Tracked;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.io.File;
import java.util.List;

/**
 * RouteUnit
 *
 * @author Anatoly Chichikov (03.07.2013)
 */
class RouteUnit extends VerticalLayout {

    final Label
        title,
        routeDescription;

    GridLayout layoutAssociatedForDraw;
    List<Positionable> points;

    RouteUnit(Tracked route, int number, GridLayout layoutAssociatedForDraw) {
        this.layoutAssociatedForDraw = layoutAssociatedForDraw;
        this.points = route.toList();
        this.title = new Label("Route №" + number + ":");
        this.routeDescription = new Label(getFormattedDescription());
        this.addComponent(this.title, 0);
        this.addComponent(this.routeDescription, 1);
        this.addLayoutClickListener(new ClickListener());
    }

    private String getFormattedDescription() {
        StringBuilder routeDescription = new StringBuilder();
        for (Positionable position : points) {
            routeDescription.
                append(" > (").
                append(position.getX()).
                append(", ").
                append(position.getY()).
                append(")");
        }
        return routeDescription.toString();
    }

    private class ClickListener implements LayoutEvents.LayoutClickListener {

        @Override
        public void layoutClick(LayoutEvents.LayoutClickEvent event) {
            String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
            FileResource resource = new FileResource(new File(basepath +
                "/WEB-INF/images/row.jpg"));
            layoutAssociatedForDraw.removeAllComponents();
            for (Positionable position : points) {
                layoutAssociatedForDraw.addComponent(
                    new Image(null, resource),
                    position.getY() - 1,
                    position.getX() - 1);
            }
        }
    }
}
