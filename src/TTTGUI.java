import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Objects;


public class TTTGUI {
    private JPanel panel1;
    private JTable TTTTable;
    private JLabel SituLabel;


    public TTTGUI() {
        //String[] columns = {"[]","[]","[]"};
        DefaultTableModel model = new DefaultTableModel(3, 3);
        TTTTable.setModel(model);
        //TTTTable.setGridColor(Color.black);
        //TTTTable.setShowGrid(true);
        TTTTable.setTableHeader(null); //Hides Table headers
        TTTTable.setDragEnabled(false); //Disables Column Dragging

        //Disables Cell editing ↓↓↓

        TTTTable.setDefaultEditor(Object.class, null);
        TTTTable.setDefaultEditor(Number.class, null);
        TTTTable.setDefaultEditor(Boolean.class, null);
        TTTTable.setDefaultEditor(Date.class, null);

        //****************************************************

        TTTTable.setRowHeight(133);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        System.out.println(TTTTable.getColumnCount()); //should be 3

        TTTTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        TTTTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); //centers text inside Each column in the table
        TTTTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        /*TTTTable.setValueAt("X", 1,0);
        TTTTable.setValueAt("X", 1,1);   Debug code do not uncomment
        TTTTable.setValueAt("X", 1,2);*/

        SituLabel.setText("Turn : X");

        //EndConditionDialog EndDialog = new EndConditionDialog();

        TTTTable.addMouseListener(new MouseAdapter() {
            private String TURNLTR = "X";

            int Turn = 0;

            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                int clickedRow = TTTTable.rowAtPoint(e.getPoint());
                int clickedColumn = TTTTable.columnAtPoint(e.getPoint());


                if(TTTTable.getValueAt(clickedRow,clickedColumn) == null || TTTTable.getValueAt(clickedRow,clickedColumn).toString().isEmpty()){
                    TTTTable.setValueAt(TURNLTR,clickedRow,clickedColumn);


                    //columns control

                    for (int i = 0; i < 3; i++){



                        String CellValue0 = (TTTTable.getValueAt(0,i) != null) ? TTTTable.getValueAt(0,i).toString() : "";
                        String CellValue1 = (TTTTable.getValueAt(1,i) != null) ? TTTTable.getValueAt(1,i).toString() : "";
                        String CellValue2 = (TTTTable.getValueAt(2,i) != null) ? TTTTable.getValueAt(2,i).toString() : "";

                        if (CombCont(CellValue0, CellValue1, CellValue2, TURNLTR)){

                            String winMessage = TURNLTR + " Won";

                            JOptionPane.showMessageDialog(panel1,winMessage);
                            Window parent = SwingUtilities.getWindowAncestor(panel1);
                            parent.dispose();
                        }

                    }

                    //check rows

                    for(int i = 0; i < 3; i++){
                        String CellValue0 = (TTTTable.getValueAt(i,0) != null) ? TTTTable.getValueAt(i,0).toString() : "";
                        String CellValue1 = (TTTTable.getValueAt(i,1) != null) ? TTTTable.getValueAt(i,1).toString() : "";
                        String CellValue2 = (TTTTable.getValueAt(i,2) != null) ? TTTTable.getValueAt(i,2).toString() : "";

                        if (CombCont(CellValue0, CellValue1, CellValue2, TURNLTR)){

                            String winMessage = TURNLTR + " Won";

                            JOptionPane.showMessageDialog(panel1,winMessage);
                            Window parent = SwingUtilities.getWindowAncestor(panel1);
                            parent.dispose();
                        }

                        /*String winMessage = TURNLTR + " Won";

                        JOptionPane.showMessageDialog(panel1,winMessage);

                        Window parent = SwingUtilities.getWindowAncestor(panel1);
                        parent.dispose();*/
                    }

                    String d1_0 = (TTTTable.getValueAt(0, 0) != null) ? TTTTable.getValueAt(0, 0).toString() : "";
                    String d1_1 = (TTTTable.getValueAt(1, 1) != null) ? TTTTable.getValueAt(1, 1).toString() : "";
                    String d1_2 = (TTTTable.getValueAt(2, 2) != null) ? TTTTable.getValueAt(2, 2).toString() : "";

                    if (CombCont(d1_0, d1_1, d1_2, TURNLTR)){

                        String winMessage = TURNLTR + " Won";

                        JOptionPane.showMessageDialog(panel1,winMessage);
                        Window parent = SwingUtilities.getWindowAncestor(panel1);
                        parent.dispose();
                    }

                    String d2_0 = (TTTTable.getValueAt(0, 2) != null) ? TTTTable.getValueAt(0, 2).toString() : "";
                    String d2_1 = (TTTTable.getValueAt(1, 1) != null) ? TTTTable.getValueAt(1, 1).toString() : "";
                    String d2_2 = (TTTTable.getValueAt(2, 0) != null) ? TTTTable.getValueAt(2, 0).toString() : "";

                    if (CombCont(d2_0, d2_1, d2_2, TURNLTR)){

                        String winMessage = TURNLTR + " Won";

                        JOptionPane.showMessageDialog(panel1,winMessage);
                        Window parent = SwingUtilities.getWindowAncestor(panel1);
                        parent.dispose();
                    }



                    if(Objects.equals(TURNLTR, "X")){
                        TURNLTR = "O";
                        SituLabel.setText("Turn : O");
                    } else {
                        TURNLTR = "X";
                        SituLabel.setText("Turn : X");
                    }
                    Turn++;

                    System.out.println("Turn: " + Turn);

                    if(Turn == 9){
                        JOptionPane.showMessageDialog(panel1, "TIE");
                        Window parent = SwingUtilities.getWindowAncestor(panel1);
                        parent.dispose();
                    }
                }





            }
        });


        System.out.println("GUI finished Building");

        panel1.setVisible(true);
    }

    private boolean CombCont(String V1, String V2, String V3, String player){

        System.out.print(V1);
        System.out.print(V2);
        System.out.print(V3);
        System.out.print(" win condition: ");
        System.out.print(V1.equals(player) && V2.equals(player) && V3.equals(player));
        System.out.println("");

        return V1.equals(player) && V2.equals(player) && V3.equals(player);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel1.add(panel2, BorderLayout.CENTER);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(spacer2, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(scrollPane1, gbc);
        TTTTable = new JTable();
        TTTTable.setEnabled(true);
        scrollPane1.setViewportView(TTTTable);
        SituLabel = new JLabel();
        SituLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(SituLabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
