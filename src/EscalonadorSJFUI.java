import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EscalonadorSJFUI {

    private final EscalonadorSJF escalonador;
    private JFrame frame;
    private JTable table;
    private JLabel avgWaitLabel;
    private JLabel avgTurnaroundLabel;

    public EscalonadorSJFUI() {
        escalonador = new EscalonadorSJF();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Escalonador SJF");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton generateButton = new JButton("Gerar Processos");
        generateButton.addActionListener((ActionEvent e) -> {
            generateProcesses();
        });

        table = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Chegada", "Execução", "Início", "Interrupção", "Conclusão", "Espera", "TurnAround"},
                0
        ));

        avgWaitLabel = new JLabel("Tempo médio de espera: -");
        avgTurnaroundLabel = new JLabel("Tempo médio de TurnAround: -");

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(2, 1));
        statsPanel.add(avgWaitLabel);
        statsPanel.add(avgTurnaroundLabel);

        panel.add(generateButton, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(statsPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void generateProcesses() {
        escalonador.ordenarProcessos();
        List<Processo> processos = escalonador.getProcessos();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        int somaEspera = 0, somaTurnaround = 0;
        for (Processo processo : processos) {
            model.addRow(new Object[]{
                    processo.getId(),
                    processo.getTempoChegada(),
                    processo.getTempoExecucao(),
                    processo.getTempoInicio(),
                    processo.getTempoInterrupcao(),
                    processo.getTempoConclusao(),
                    processo.getTempoEspera(),
                    processo.getTempoTurnArround()
            });
            somaEspera += processo.getTempoEspera();
            somaTurnaround += processo.getTempoTurnArround();
        }

        avgWaitLabel.setText("Tempo médio de espera: " + (double) somaEspera / processos.size());
        avgTurnaroundLabel.setText("Tempo médio de TurnAround: " + (double) somaTurnaround / processos.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EscalonadorSJFUI::new);
    }
}
