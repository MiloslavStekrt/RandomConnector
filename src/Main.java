import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.*;

public class Main extends JFrame{
    private JTextArea textArea1;
    private JButton button1;
    private String[] items;
    private JList list1;
    private JPanel HlavniPanel;
    private JLabel hoverLabel;
    private JList list2;
    private JButton delItem;
    private JButton undoButton;
    private String last_list1, last_list2;

    public Main(){
        this.setContentPane(HlavniPanel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convert();
            }
        });
        button1.addMouseListener(new MouseAdapter() {
        });
        delItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteItem();
            }
        });
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getBackItem();
            }
        });
    }

    public void getBackItem() {
        if (last_list1 != null)
            ((DefaultListModel)list1.getModel()).addElement(last_list1);
        if (last_list2 != null)
            ((DefaultListModel)list2.getModel()).addElement(last_list2);
        last_list1 = null;
        last_list2 = null;

    }

    private void DeleteItem() {
        //save item value to string and then remove item from list1 or list2
        if (list1.getSelectedIndex() > -1){
            last_list1 = (String) list1.getSelectedValue();
            ((DefaultListModel) list1.getModel()).remove(list1.getSelectedIndex());
        }
        if (list2.getSelectedIndex() > -1) {
            last_list2 = (String) list2.getSelectedValue();
            ((DefaultListModel) list2.getModel()).remove(list2.getSelectedIndex());
        }
    }



    public void convert(){
        //this convert items random to 2 list
        List<String> itemsR= new ArrayList(Arrays.asList(textArea1.getText().split(",")));
        Collections.shuffle(itemsR);
        items = new String[itemsR.size()];
        itemsR.toArray(items);

        DefaultListModel<String> m = new DefaultListModel();
        DefaultListModel<String> m1 = new DefaultListModel<>();

        for (int i = 0; i < items.length; i++) {
            if(i%2==0)
                m.addElement(items[i]);
            else
                m1.addElement(items[i]);
        }
        //set list to view list
        list1.setModel(m);
        list2.setModel(m1);
    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
