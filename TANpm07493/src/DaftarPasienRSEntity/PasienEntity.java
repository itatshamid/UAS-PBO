package DaftarPasienRSEntity;
import java.util.Date;
/**
 *
 * @author abdul.wijaya
 */
public class PasienEntity extends DaftarAbstractEntity{
    private String alamat;
    public PasienEntity (String kode, String password, String nama, String no_telp, Date tglLahir, String alamat) {
        super(kode, password, nama, no_telp, tglLahir);
        this.alamat = alamat;
    }

    @Override
    public String getKode() {
        return kode;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
