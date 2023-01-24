package DaftarPasienRSController;

import DaftarPasienRSEntity.DokterEntity;
import DaftarPasienRSEntity.DaftarpasEntity;
import DaftarPasienRSEntity.PasienEntity;
import java.util.Date;
import java.util.ArrayList;

public class AdminController implements ControllerInterface{
    int indexLogin = 0;
    public AdminController() {    
    }
    
    public void dataDokter() {
        String kodeDokter[] = {"01", "02", "03", "04", "05", "06", "07"};
        String passwordDokter[] = {"01", "02", "03", "04", "05", "06", "07"};
        String namaDokter[] = {"Dono", "Kasino", "Indro", "Bagio", "Kirun", "Parto", "Tarsan"};
        String noTelpDokter[] = {"081111111", "082222222", "083333333", "084444444", "085555555", "086666666", "0877777777"};
        String tanggalLahirDokter[] = {"01/01/2000", "02/01/2000", "03/01/2000", "04/01/2000",
            "05/01/2000", "06/01/2000", "07/01/2000"};
        String poliklinik[] = {"UMUM", "ANAK", "JANTUNG", "PARU", "GIGI", "PENYAKIT DALAM", "KULIT"};
        for(int i = 0; i < kodeDokter.length; i++) {
            AllObjectModel.dokterModel.insertDokter(new DokterEntity(kodeDokter[i], passwordDokter[i], namaDokter[i], 
                    noTelpDokter[i], new Date(tanggalLahirDokter[i]), poliklinik[i]));
        }
    }
    
    public void viewDokter() {
        AllObjectModel.dokterModel.view();
    }
    
    public void listPendaftarPoli() {
        AllObjectModel.daftarPasModel.view();
    }
       
    @Override
    public void login(String kode, String password) {
        indexLogin = AllObjectModel.dokterModel.cekData(kode, password);
    }
    
    public DokterEntity dokterEntity() {
        return AllObjectModel.dokterModel.showDataDokter(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexPas, PasienEntity pasienEntity) {
        AllObjectModel.daftarPasModel.updateIsVerified(index, new DaftarpasEntity(pasienEntity, true, indexPas));
    }
    
    public ArrayList<DaftarpasEntity> cekDaftarpasModel() {
        return AllObjectModel.daftarPasModel.getDaftarpasArrayList();
    }

    public Object DokterEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
