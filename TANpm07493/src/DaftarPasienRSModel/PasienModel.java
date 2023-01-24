package DaftarPasienRSModel;

import DaftarPasienRSEntity.DokterEntity;
import DaftarPasienRSEntity.PasienEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author abdul.wijaya
 */
public class PasienModel implements ModelInterfaces {

    private ArrayList<PasienEntity> pasienEntityArrayList;

    public PasienModel() {
        pasienEntityArrayList = new ArrayList<PasienEntity>();
    }

    public void insert(PasienEntity pasienEntity) {
        pasienEntityArrayList.add(pasienEntity);
    }

    public int size() {
        return pasienEntityArrayList.size();
    }

    @Override
    public void view() {
        for (PasienEntity pasienEntity : pasienEntityArrayList) {
            System.out.println("========================================");
            System.out.println("KODE : " + pasienEntity.getKode() 
                    + "\nNama : " + pasienEntity.getNama()
                    + "\nPassowrd : " + pasienEntity.getPassword() 
                    + "\nNo.Telp : " + pasienEntity.getNo_telp()
                    + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(pasienEntity.getTglLahir()));
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String kode, String password) {
        int loop = 0;
        while (!pasienEntityArrayList.get(loop).getKode().equals(kode)
                && !pasienEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }

    public PasienEntity getPasienEntityArrayList(int index) {
        return pasienEntityArrayList.get(index);
    }
}
