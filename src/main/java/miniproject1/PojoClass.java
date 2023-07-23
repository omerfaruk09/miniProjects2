package miniproject1;

public class PojoClass {
    private String id;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;
    public static int sayac = 1000;

    protected PojoClass(String urunIsmi, String uretici, int miktar, String birim, String raf) {

        this.id = Integer.toString(++sayac);
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }

    // Getter ve setter metodları
    protected String getId() {
        return id;
    }

    protected String getUrunIsmi() {
        return urunIsmi;
    }

    protected void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    protected void setUretici(String uretici) {
        this.uretici = uretici;
    }

    protected int getMiktar() {
        return miktar;
    }

    protected void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    protected String getBirim() {
        return birim;
    }

    protected void setBirim(String birim) {
        this.birim = birim;
    }

    protected String getRaf() {
        return raf;
    }

    protected void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", urunIsmi: " + urunIsmi +
                ", uretici: " + uretici +
                ", miktar: " + miktar +
                ", birim: " + birim +
                ", raf: " + raf;
    }
}

