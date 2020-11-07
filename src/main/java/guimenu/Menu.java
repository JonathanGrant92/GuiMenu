package main.java.guimenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;

public class Menu implements ActionListener {

    private volatile boolean lock_menu;
    private volatile boolean lock_text_box;
    private Options user_selection;
    private final JFrame MENU_FRAME;

    public Menu(EnumSet<Options> menu_selection) {
        this.lock_menu = true;
        this.lock_text_box = true;
        MENU_FRAME = new JFrame();
        JPanel menu_panel = new JPanel();
        JLabel menu_label = new JLabel("Select a choice?");

        menu_panel.add(menu_label);
        menu_panel.setBorder(BorderFactory.createEmptyBorder(125,300,100,300));
        menu_panel.setLayout(new GridLayout(0,1));

        for(Options option : menu_selection){
            JButton option_button = new JButton(String.valueOf(option));
            option_button.addActionListener(this);
            menu_panel.add(option_button);
        }

        MENU_FRAME.add(menu_panel, BorderLayout.CENTER);
        MENU_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MENU_FRAME.setTitle("GUI Menu Program");
        MENU_FRAME.pack();
        MENU_FRAME.setVisible(true);
    }

    //	***************************************************************************

    /**
     * Prompt the user for a correct option of the existing menu.
     *
     * @return the selected option to menu.
     */
    public Options getOption() {
            while (lock_menu) Thread.onSpinWait();
            lock_menu = true;
            return this.user_selection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user_input = e.getActionCommand();

        for (Options user_choice : Options.values()) {
            if (user_input.equals(String.valueOf(user_choice))) {
                this.user_selection = user_choice;
                lock_menu = false;
            }
        }
    }

    public void closeMenu() {
        this.MENU_FRAME.dispose();
    }

    /**
     * This method reduces code to create new GUI windows
     * for all operations being done
     *
     * @param title Title to know what operation user is on
     */
    public ArrayList<String> runTextReader(Options title, ArrayList<String> fields) {
        JFrame text_frame = new JFrame();
        JPanel text_panel = new JPanel();
        ArrayList<JTextArea> form_inputs = new ArrayList<>();

        text_panel.setBorder(BorderFactory.createEmptyBorder(125,300,100,300));
        text_panel.setLayout(new GridLayout(0,1));

        for (String field : fields) {
            text_panel.add(new JLabel(field));
            form_inputs.add(new JTextArea());
            text_panel.add(form_inputs.get(fields.indexOf(field)));
        }

        JButton submit = new JButton("SUBMIT");
        submit.addActionListener(this::submitPerformed);
        text_panel.add(submit);

        text_frame.add(text_panel, BorderLayout.CENTER);
        text_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text_frame.setTitle("OPERATION: " + title);
        text_frame.pack();
        text_frame.setVisible(true);

        while (lock_text_box) Thread.onSpinWait();
        lock_text_box = true;

        ArrayList<String> responses = new ArrayList<>();
        for (String field : fields) {
            responses.add(form_inputs.get(fields.indexOf(field)).getText());
        }

        text_frame.dispose();
        return responses;
    }

    public void submitPerformed(ActionEvent s) { lock_text_box = false; }

}
