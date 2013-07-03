package chichikov.antroute;

import chichikov.antroute.ui.AppView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * AntRoute
 *
 * @author Anatoly Chichikov (03.07.2013)
 */
@Theme("chameleon")
@SuppressWarnings("serial")
public class AntRoute extends UI {

    @Override
    protected void init(VaadinRequest request) {
        new AppView().startApp(this);
    }
}