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

    public Main(){
        this.setContentPane(HlavniPanel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                convert();
            }
        });
        button1.addMouseListener(new MouseAdapter() {
        });
    }

    public void convert(){
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
        list1.setModel(m);
        list2.setModel(m1);
    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
