package DaftarPasienRSEntity;

/**
 *
 * @author abdul.wijaya
 */
public class DaftarpasEntity {
    private PasienEntity pasien;
    private boolean isVerified;
    private int indexPoli;

    public DaftarpasEntity(PasienEntity pasien, boolean isVerified, int indexPoli) {
        this.pasien = pasien;
        this.isVerified = isVerified;
        this.indexPoli = indexPoli;
    }
    
    public PasienEntity getPasien() {
        return pasien;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexPoli() {
        return indexPoli;
    }

    public void setIndexPoli(int indexPoli) {
        this.indexPoli = indexPoli;
    }
}
