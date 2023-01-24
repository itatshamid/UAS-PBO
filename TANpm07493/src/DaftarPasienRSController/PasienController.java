/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaftarPasienRSController;
import DaftarPasienRSEntity.DaftarpasEntity;
import DaftarPasienRSEntity.PasienEntity;
import DaftarPasienRSEntity.PoliEntity;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abdul.wijaya
 */
public class PasienController implements ControllerInterface{
    int indexLogin = 0;
    public PasienController() {
    }
    
    public PasienEntity getData() {
        return AllObjectModel.pasienModel.getPasienEntityArrayList(indexLogin);
    }
    
    public void daftarPoli(int indexPoli, PasienEntity pasienEntity, boolean isVerified) {
        AllObjectModel.daftarPasModel.insertDataDaftarpas(new DaftarpasEntity(pasienEntity, isVerified, indexPoli));
    }
    
    @Override
    public void login(String kode, String password) {
        indexLogin = AllObjectModel.pasienModel.cekData(kode, password);
    }
    
    public void insert(String kode, String password, String nama, String no_telp, Date tglLahir, String alamat) {
        AllObjectModel.pasienModel.insert(new PasienEntity(kode, password, nama, no_telp, tglLahir, alamat));
    }
    
    public PasienEntity pasienEntity() {
        return AllObjectModel.pasienModel.getPasienEntityArrayList(indexLogin);
    }
    
    public int cekDaftarPas(String kode) {
        int cek = AllObjectModel.daftarPasModel.cekData(kode, null);
        return cek;
    }
    
    public DaftarpasEntity showDaftarPas(int index) {
        return AllObjectModel.daftarPasModel.showDaftarpas(index);
    }
    public DefaultTableModel daftarpas(){
        DefaultTableModel dtmdaftarpas = new DefaultTableModel();
        Object[] kolom ={"Kode","Nama","Password","No Telp","Tgl Lahir","Poliklinik","Verified","Alamat"};
        dtmdaftarpas.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarPasModel.alldatapas().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if(AllObjectModel.daftarPasModel.alldatapas().get(i).isVerified()==false){
        verif = "no";
    }else{
        verif = "yes";
            }
    Object [] data = new Object[8];
    data[0] = AllObjectModel.daftarPasModel.alldatapas().get(i).getPasien().getKode();
    data[1] = AllObjectModel.daftarPasModel.alldatapas().get(i).getPasien().getNama();
    data[2] = AllObjectModel.daftarPasModel.alldatapas().get(i).getPasien().getPassword();
    data[3] = AllObjectModel.daftarPasModel.alldatapas().get(i).getPasien().getNo_telp();
    data[4] = new SimpleDateFormat("dd-MM-yyyy").format(AllObjectModel.daftarPasModel.alldatapas().get(i).getPasien().getTglLahir());
    data[5] = PoliEntity.nama[AllObjectModel.daftarPasModel.alldatapas().get(i).getIndexPoli()];
    data[6] = verif;
    data[7] = AllObjectModel.daftarPasModel.alldatapas().get(i).getPasien().getAlamat();
    dtmdaftarpas.addRow(data);
        }
    return dtmdaftarpas;
    
    }
}