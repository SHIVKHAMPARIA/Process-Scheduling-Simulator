import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProcessSchedulingSimulator extends JFrame {

    private JTextField arrivalTimeField, burstTimeField, priorityField;
    private JButton addButton, simulateButton;
    private JTextArea resultArea;

    private List<Process> processes;

    public ProcessSchedulingSimulator() {
        setTitle("Process Scheduling Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Initialize process list
        processes = new ArrayList<>();

        // Initialize components
        JLabel arrivalLabel = new JLabel("Arrival Time:");
        arrivalTimeField = new JTextField(5);
        JLabel burstLabel = new JLabel("Burst Time:");
        burstTimeField = new JTextField(5);
        JLabel priorityLabel = new JLabel("Priority:");
        priorityField = new JTextField(5);
        addButton = new JButton("Add Process");
        simulateButton = new JButton("Simulate");
        resultArea = new JTextArea(10, 20);
        resultArea.setEditable(false);

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(arrivalLabel);
        inputPanel.add(arrivalTimeField);
        inputPanel.add(burstLabel);
        inputPanel.add(burstTimeField);
        inputPanel.add(priorityLabel);
        inputPanel.add(priorityField);
        inputPanel.add(addButton);
        inputPanel.add(simulateButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProcess();
            }
        });

        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulate();
            }
        });
    }

    private void addProcess() {
        try {
            int arrivalTime = Integer.parseInt(arrivalTimeField.getText());
            int burstTime = Integer.parseInt(burstTimeField.getText());
            int priority = Integer.parseInt(priorityField.getText());

            processes.add(new Process(processes.size() + 1, arrivalTime, burstTime, priority));
            resultArea.append("Process added: Arrival Time=" + arrivalTime + ", Burst Time=" + burstTime + ", Priority=" + priority + "\n");

            // Clear input fields
            arrivalTimeField.setText("");
            burstTimeField.setText("");
            priorityField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.");
        }
    }

    private void simulate() {
        // Perform simulation and display results
        // You can implement this part based on your scheduling algorithm logic
        resultArea.append("Simulation results:\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProcessSchedulingSimulator().setVisible(true);
            }
        });
    }

    // Define Process class (same as before)
    static class Process {
        int id;
        int arrivalTime;
        int burstTime;
        int priority;

        public Process(int id, int arrivalTime, int burstTime, int priority) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
            this.priority = priority;
        }
    }
}
