/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaftarPasienRSModel;

import DaftarPasienRSEntity.DokterEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author abdul.wijaya
 */
public class DokterModel implements ModelInterfaces{
    private ArrayList<DokterEntity> dokterEntityArrayList;
    
    public DokterModel() {
        dokterEntityArrayList = new ArrayList<DokterEntity>();
    }
    
    public void insertDokter(DokterEntity dokter) {
        dokterEntityArrayList.add(dokter);
    }

    @Override
    public void view() {
        for (DokterEntity dokterEntity : dokterEntityArrayList) {
            System.out.println("Kode Dokter :" + dokterEntity.getKode());
            System.out.println("Nama Dokter :" + dokterEntity.getNama());
            System.out.println("No Telpon : " + dokterEntity.getNo_telp());
            System.out.println("Dari Poli : " + dokterEntity.getPoliklinik() + "\n");
        }
    }

    @Override
    public int cekData(String kode, String password) {
        int loop = 0;
        for (DokterEntity dokterEntity : dokterEntityArrayList) {
            if (dokterEntity.getKode().equals(kode) && dokterEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public DokterEntity showDataDokter(int index) {
        return dokterEntityArrayList.get(index);
    }
}
