package bejeweled.ui.view;

import bejeweled.service.CommentService;
import bejeweled.service.CommentServiceJDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class TableForm extends JFrame{
    private JTable table = new JTable();

    public TableForm() {
        super("Comments");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        getComments();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 200));

        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void getComments()
    {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Player");
        dtm.addColumn("Comment");
        dtm.addColumn("date");

        table.setModel(dtm);
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setShowGrid(false);
        table.setEnabled(false);

        CommentService commentService = new CommentServiceJDBC();

        var recordsList = commentService.getComments("bejeweled");
        System.out.println(recordsList);
        int ii=0;
        if(recordsList!=null) {
            for (var rec : recordsList) {
                dtm.setRowCount(dtm.getRowCount() + 1);
                String login = rec.getPlayer();
                String score = rec.getComment();
                Date date = rec.getCommentedon();
                dtm.setValueAt(login, ii, 0);
                dtm.setValueAt(score, ii, 1);
                dtm.setValueAt(date.toString().split(" ")[0], ii, 2);
                ii++;
            }
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    }

}
