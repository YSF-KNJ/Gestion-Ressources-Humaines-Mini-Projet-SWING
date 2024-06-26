import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentsFrame extends BaseFrame {
    Font font = new Font("cairo", Font.BOLD, 22);

    public DepartmentsFrame() {
        this.setLayout(null);

        JLabel titleLabel = new JLabel("DÉPARTEMENTS");
        titleLabel.setBounds(250, 40, 300, 60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(font);

        ButtonCard button1 = new ButtonCard("Lister", "resources/list.png", 50, 180, 200, 100);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LisDepartements lisDepartements = new LisDepartements();
                lisDepartements.setVisible(true);
            }
        });
        ButtonCard button2 = new ButtonCard("Ajouter", "resources/add.png", 300, 180, new AjouterDepartement(), 200, 100);
        ButtonCard button3 = new ButtonCard("Supprimer", "resources/remove.png", 550, 180, 200, 100);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupprimerDepartement supprimerdepartement = new SupprimerDepartement();
                supprimerdepartement.setVisible(true);
            }
        });

        ButtonCard button4 = new ButtonCard("Mettre à jour", "resources/update.png", 50, 320, 200, 100);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDepartement updateDepartement = new UpdateDepartement();
                updateDepartement.setVisible(true);
            }
        });

        ButtonCard button5 = new ButtonCard("Importer", "resources/txt.png", 300, 320, 200, 100);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImportDepTxt importDepTxt = new ImportDepTxt();
                importDepTxt.importTxt();
            }
        });
        ButtonCard button6 = new ButtonCard("Exporter", "resources/xls.png", 550, 320, new ExportDepartement(), 200, 100);
        HomeButton button9 = new HomeButton(this);

        this.add(titleLabel);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button9);
    }
}