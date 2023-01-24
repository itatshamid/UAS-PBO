/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaftarPasienRSModel;

import DaftarPasienRSEntity.DaftarpasEntity;
import DaftarPasienRSEntity.PoliEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author abdul.wijaya
 */
public class DaftarpasModel implements ModelInterfaces {

    private ArrayList<DaftarpasEntity> daftarpasArrayList;

    public DaftarpasModel() {
        daftarpasArrayList = new ArrayList<DaftarpasEntity>();
    }

    public void insertDataDaftarpas(DaftarpasEntity daftarpas) {
        daftarpasArrayList.add(daftarpas);
    }

    public ArrayList<DaftarpasEntity> getDaftarpasArrayList() {
        return daftarpasArrayList;
    }
    public ArrayList<DaftarpasEntity>alldatapas(){
        return daftarpasArrayList;
    }
   
    public void view() {
        for (DaftarpasEntity daftarpas : daftarpasArrayList) {
            System.out.println("========================================");
            System.out.println("KODE : " + daftarpas.getPasien().getKode() 
                    + "\nKODE : " + daftarpas.getPasien().getNama()
                    + "\nPassword : " + daftarpas.getPasien().getPassword() 
                    + "\nNo.Telp : " + daftarpas.getPasien().getNo_telp()
                    + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarpas.getPasien().getTglLahir())
                    + "\nPoliklinik : " + PoliEntity.nama[daftarpas.getIndexPoli()] 
                    + "\nIsVerified : ");
            if (daftarpas.isVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi");
            }
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String kode, String password) {
        int loop = 0;
        if (daftarpasArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < daftarpasArrayList.size(); i++) {
                if (daftarpasArrayList.get(i).getPasien().getKode().equals(kode)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public DaftarpasEntity showDaftarpas(int index) {
        return daftarpasArrayList.get(index);
    }

    public void updateIsVerified(int index, DaftarpasEntity daftarpasEntity) {
        daftarpasArrayList.set(index,daftarpasEntity);
    }
}
