package DaftarPasienRSView;

import DaftarPasienRSController.AllObjectModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DaftarPasienRSController.PasienController;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DokterGUI {

    private static PasienController pasien = new PasienController();
    JFrame Dokter = new JFrame();
    JTable tabelpasien = new JTable();
    JScrollPane scrolldokter = new JScrollPane(tabelpasien);
    JButton back, verif;
    JLabel admin, kodelabel, passlabel;
    JTextField kodetext, passtext;

    public DokterGUI() {
        Dokter.setSize(650, 500);
        Dokter.setLayout(null);
        Dokter.getContentPane().setBackground(Color.PINK);
        admin = new JLabel("Admin");
        admin.setBounds(250, 30, 200, 30);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Dokter.add(admin);
        scrolldokter.setBounds(30, 100, 570, 200);
        tabelpasien.setModel(pasien.daftarpas());
        Dokter.add(scrolldokter);
        kodelabel = new JLabel("Kode");
        kodelabel.setBounds(50, 320, 100, 30);
        Dokter.add(kodelabel);
        kodetext = new JTextField();
        kodetext.setBounds(50, 350, 100, 30);
        Dokter.add(kodetext);
        passlabel = new JLabel("Password");
        passlabel.setBounds(200, 320, 100, 30);
        Dokter.add(passlabel);
        passtext = new JTextField();
        passtext.setBounds(200, 350, 100, 30);
        Dokter.add(passtext);
        verif = new JButton("Verifikasi");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GREEN);
        Dokter.add(verif);
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.yellow);
        Dokter.add(back);
        Dokter.setLocationRelativeTo(null);
        Dokter.setVisible(true);
        Dokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dokter.dispose();
                RSGUI men = new RSGUI();
            }
        });
        verif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kode = kodetext.getText();
                String pass = passtext.getText();
                int index = AllObjectModel.daftarPasModel.cekData(kode, pass);
                Allobjectc.admin.updateIsVerified(index, Allobjectc.Pasien.showDaftarPas(index).getIndexPoli(), Allobjectc.Pasien.showDaftarPas(index).getPasien());
                tabelpasien.setModel(pasien.daftarpas());
            }
        }
        );
        tabelpasien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpasien.getSelectedRow();
                kodetext.setText(Allobjectc.Pasien.daftarpas().getValueAt(i, 0).toString());
                passtext.setText(Allobjectc.Pasien.daftarpas().getValueAt(i, 1).toString());
            }
        }
        );
    }
}
