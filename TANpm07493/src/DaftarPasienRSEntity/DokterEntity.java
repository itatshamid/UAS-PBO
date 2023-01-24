package DaftarPasienRSEntity;
import java.util.Date;
/**
 *
 * @author abdul.wijaya
 */
public class DokterEntity extends DaftarAbstractEntity{
    private String poliklinik;
    public DokterEntity(String kode, String password, String nama, String no_telp, Date tglLahir, String poli) {
        super(kode, password, nama, no_telp, tglLahir);
        this.poliklinik = poli;
    }
    @Override
    public String getKode() {
        return this.kode;
    }

    public String getPoliklinik() {
        return poliklinik;
    }
    
    public void setPoliklinik(String poliklinik) {
        this.poliklinik = poliklinik;
    }
}
