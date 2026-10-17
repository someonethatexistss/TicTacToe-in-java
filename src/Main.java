import javax.swing.*;

void main() {

    TTTGUI tttgui = new TTTGUI();

    JFrame FRM = new JFrame();
    FRM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    FRM.add(tttgui.$$$getRootComponent$$$());

    FRM.setSize(500, 500);
    FRM.setLocationRelativeTo(null);

    FRM.setTitle("Tic-Tac-Toe in java");

    System.out.println("making Window frame visible...");

    FRM.setVisible(true);

}
