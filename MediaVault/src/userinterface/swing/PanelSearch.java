package userinterface.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import backend.*;

/**
 *
 */
@SuppressWarnings("serial")
public class PanelSearch extends JPanel {

    private EventClick event;

    public void addEventClick(EventClick event) {
        this.event = event;
    }

    /**
     * This constructor initializes the PanelSearch and sets the layout using the miglayout package
     */
    public PanelSearch() {
        initComponents();
        setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
    }

    /**
     * Used to set the list of data (movies) to be searched
     * @param movieDuplicates - the list of movies to use
     */
    public void setMovies(List<Movie> movies) {
        this.removeAll();
        for (Movie m : movies) {
            SearchItem item = new SearchItem(m);
            //  add event
            item.addEvent(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //  when clicked
                    event.itemClick(m);
                }
            });
            this.add(item, "wrap");
        }
        repaint();
        revalidate();
        //  Refresh Component
    }

    /**
     * @return the number of components
     */
    public int getItemSize() {
        return getComponentCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }
}
