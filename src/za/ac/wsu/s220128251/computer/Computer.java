package za.ac.wsu.s220128251.computer;

import za.ac.wsu.s220128251.exceptions.ComputerListEmpty;
import za.ac.wsu.s220128251.exceptions.ExistException;
import za.ac.wsu.s220128251.exceptions.IpAddressEmpty;
import za.ac.wsu.s220128251.exceptions.emptyList.IsEmptyList;
import za.ac.wsu.s220128251.exceptions.emptyList.ProvideIp;
import za.ac.wsu.s220128251.exceptions.existance.IsComputerAdded;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Computer extends JFrame {

    private JLabel lblHeader = new JLabel("Computer Lab");
    private JLabel lblComputerIP = new JLabel("IP Address");
    private JTextField txtComputerIP = new JTextField(10);
    private JLabel lblValue = new JLabel("Value");
    private JTextField txtValue = new JTextField(10);
    private JButton btnAdd = new JButton("+");
    private JButton btnShowComputer = new JButton("Show Computer");
    private JButton btnClear = new JButton("Clear");
    private JButton btnExit = new JButton("Exit App");
    private ArrayList<String> computerIpAddresses = new ArrayList<>();
    private ArrayList<Double> computerValues = new ArrayList<>();
    private JPanel pnlDetails = new JPanel(new GridLayout(5, 2, 10, 5));
    private JPanel pnlAppHeader = new JPanel();

    public Computer() {
        super("Lap App");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(3);
        pnlAppHeader.add(lblHeader);
        pnlDetails.add(lblComputerIP);
        pnlDetails.add(txtComputerIP);
        pnlDetails.add(lblValue);
        pnlDetails.add(txtValue);
        pnlDetails.add(btnAdd);
        pnlDetails.add(btnShowComputer);
        pnlDetails.add(btnClear);
        pnlDetails.add(btnExit);
        add(pnlAppHeader, BorderLayout.NORTH);
        add(pnlDetails, BorderLayout.SOUTH);

        btnAdd.addActionListener(
                e -> {
                    try {
                        String ipAddress = txtComputerIP.getText();
                        double value = Double.parseDouble(txtValue.getText());
                        ProvideIp ip = new ProvideIp(ipAddress);
                        IsComputerAdded ca = new IsComputerAdded(computerIpAddresses, ipAddress);
                        computerIpAddresses.add(txtComputerIP.getText());
                        computerValues.add(Double.valueOf(txtValue.getText()));
                        JOptionPane.showMessageDialog(null, "Computer Inserted", "INFO", 1);

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Provide Computer Value");
                    } catch (IndexOutOfBoundsException e2) {
                        JOptionPane.showMessageDialog(null, "Not yet added Computer");
                    } catch (ExistException | IpAddressEmpty ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                });
        btnShowComputer.addActionListener(
                e -> {
                    showComputers(computerIpAddresses, computerValues);
                });
        btnClear.addActionListener(
                e -> {
                    txtComputerIP.setText("");
                    txtValue.setText("");
                });
        btnExit.addActionListener(
                e -> {
                    System.exit(0);
                });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showComputers(ArrayList<String> computersIp, ArrayList<Double> computersValue) {

        JPanel pnlComputers = new JPanel(new GridLayout(computersIp.size(), 2, 10, 5));

        try {
            IsEmptyList empty = new IsEmptyList(computersIp, computerValues);
            for (int i = 0; i < computersIp.size(); i++) {
                pnlComputers.add(new JLabel(computersIp.get(i)));
                pnlComputers.add(new JLabel("$" + computersValue.get(i)));
            }
            JOptionPane.showMessageDialog(null, pnlComputers, "Computers", 1);
        } catch (ComputerListEmpty e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
