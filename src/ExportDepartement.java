import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExportDepartement extends BaseFrame {
    ButtonCard btnXls = new ButtonCard("Exporter XLS", "resources/xls.png", 130, 220, 200, 100);
    ButtonCard btnTxt = new ButtonCard("Exporter  Txt", "resources/txt.png", 370, 220, 200, 100);

    public ExportDepartement() {
        JLabel label = new JLabel("Export Departement Table", JLabel.CENTER);
        this.setSize(700, 500);
        label.setBounds(200, 100, 300, 25);
        add(label);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("HR");
        add(btnXls);
        add(btnTxt);

        btnXls.addActionListener(new MyListener());
        btnTxt.addActionListener(new MyListener());
    }

    public void exportXls() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        String defaultFilename = "export_departements_" + formattedDateTime + ".xls";


        JFileChooser fchoose = new JFileChooser();
        fchoose.setSelectedFile(new File(defaultFilename));
        int option = fchoose.showSaveDialog(ExportDepartement.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name;
            Departement.exportFileXls(file);
            JOptionPane.showMessageDialog(ExportDepartement.this, "Exportation XLS réussie..");
            dispose();
        }

    }

    public void exportTxt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        String defaultFilename = "export_departements_" + formattedDateTime + ".txt";
        JFileChooser fchoose = new JFileChooser();
        fchoose.setSelectedFile(new File(defaultFilename));
        int option = fchoose.showSaveDialog(ExportDepartement.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name;
            Departement.exportFileTxt(file);
            JOptionPane.showMessageDialog(ExportDepartement.this, "Exportation TXT réussie.");
            dispose();
        }
    }

    class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnXls) {
                exportXls();
            } else if (e.getSource() == btnTxt) {
                exportTxt();
            }
        }
    }
}

