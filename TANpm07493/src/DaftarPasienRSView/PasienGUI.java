package DaftarPasienRSView;

import DaftarPasienRSEntity.PoliEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PasienGUI {

    JFrame Pasien = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarpoli;
    JComboBox pilpas = new JComboBox(PoliEntity.nama);
    int cek = Allobjectc.Pasien.cekDaftarPas(Allobjectc.Pasien.pasienEntity().getKode());

    public PasienGUI() {
        Pasien.setSize(720, 600);
        Pasien.setLayout(null);
        Pasien.getContentPane().setBackground(Color.PINK);
        datadiri = new JLabel("Data Pasien");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        Pasien.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pasien.add(area);
        daftarpoli = new JLabel("Daftar Poliklinik");
        daftarpoli.setBounds(450, 30, 250, 30);
        daftarpoli.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Pasien.add(daftarpoli);
        pilpas.setBounds(450, 90, 230, 30);
        Pasien.add(pilpas);
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GREEN);
        Pasien.add(daftarbtn);
        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        Pasien.add(back);
        Pasien.setVisible(true);
        Pasien.setLocationRelativeTo(null);
        Pasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Poli", "information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Poli", "information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datapasien());
        }
        daftarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexpas = pilpas.getSelectedIndex();
                Allobjectc.Pasien.daftarPoli(indexpas, Allobjectc.Pasien.getData(), false);
                area.setText(datapasien());
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pasien.dispose();
                RSGUI men = new RSGUI();
            }
        });
    }

    public String datapasien() {
        int cek = Allobjectc.Pasien.cekDaftarPas(Allobjectc.Pasien.pasienEntity().getKode());
        String cekverif;
        if (Allobjectc.Pasien.showDaftarPas(cek).isVerified() == false) {
            cekverif = "belum diverifikasi";
        } else {
            cekverif = "sudah diverifikasi";
        }
        String text = "Kode = " + Allobjectc.Pasien.showDaftarPas(cek).getPasien().getKode() 
                + "\n" + "Nama = " + Allobjectc.Pasien.showDaftarPas(cek).getPasien().getNama() + "\n"
                + "No Telp = " + Allobjectc.Pasien.showDaftarPas(cek).getPasien().getNo_telp() 
                + "\n" + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").format(Allobjectc.Pasien.showDaftarPas(cek).getPasien().getTglLahir()) 
                + "\n" + "verifikasi = " + cekverif + "\n" 
                + "Alamat = " + Allobjectc.Pasien.showDaftarPas(cek).getPasien().getAlamat() + "\n" 
                + "Poliklinik = " + PoliEntity.nama[Allobjectc.Pasien.showDaftarPas(cek).getIndexPoli()];
        return text;
    }
}
