package miniproject1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MethodStore {
    Map<String, PojoClass> urunler = new HashMap<>();

    protected void urunTanimlama(String urunIsmi, String uretici, String birim) {
        boolean urunYok = true;
        // urunler map'indeki her bir PojoClass nesnesi üzerinde döngü oluşturulur
        for (PojoClass urun : urunler.values()) {
            // urunIsmi, uretici ve birim değerleriyle eşleşen ürün kontrol edilir
            if (urun.getUrunIsmi().equalsIgnoreCase(urunIsmi)
                    && urun.getUretici().equalsIgnoreCase(uretici)
                    && urun.getBirim().equalsIgnoreCase(birim)) {
                urunYok = false;
                System.out.println("Ürün zaten ekli.");
                break;
            }
        }

        // urunYok değişkeni hala true ise, yeni bir ürün eklenir
        if (urunYok) {
            PojoClass urun = new PojoClass(urunIsmi, uretici, 0, birim, null);
            urunler.put(urun.getId(), urun);
        }
    }

    protected void tanimlananUrunListele() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("===============================================================");
        for (PojoClass urun : urunler.values()) {
            ekranGoruntusu(urun);
        }
    }

    protected void raftakiUrunleriListele() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("==============================================================");
        for (PojoClass urun : urunler.values()) {
            if (urun.getRaf() != null) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected void urunGirisi(String id, Scanner input) {
        if (urunler.containsKey(id)) {
            int miktar = input.nextInt();
            input.nextLine(); // Yeni satır karakterini tüketmek için kullanılır.
            PojoClass urun = urunler.get(id);
            int yeniMiktar = urun.getMiktar() + miktar;
            urun.setMiktar(yeniMiktar);
//        } else {
//            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunSil(String id) {
        if (urunler.containsKey(id)) {
            urunler.remove(id);
//        } else {
//            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunuRafaKoy(String id, Scanner input) {
        if (urunler.containsKey(id)) {
            System.out.print("Hangi rafa koymak istersiniz: ");
            String rafIsmi = input.nextLine();
            PojoClass urun = urunler.get(id);
            urun.setRaf(rafIsmi);
//        } else {
//            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunCikisi(String id, Scanner input) {
        if (urunler.containsKey(id)) {
            int miktar = input.nextInt();
            input.nextLine(); // Yeni satır karakterini tüketmek için kullanılır.
            PojoClass urun = urunler.get(id);
            int mevcutMiktar = urun.getMiktar();
            if (miktar <= mevcutMiktar) {
                urun.setMiktar(mevcutMiktar - miktar);
                System.out.println("Ürün çıkışı başarıyla yapıldı.");
            } else {
                System.out.println("Hatalı miktar! Yeterli stok bulunmamaktadır.");
                System.out.println("Stok miktarı: " + urun.getMiktar() + " " + urun.getBirim());
            }
//        } else {
//            System.out.println("Hatalı ID! Ürün tanımlı değil.");
        }
    }

    protected void urunFiltrele(String urunIsmi) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("================================================================");
        for (PojoClass urun : urunler.values()) {
            if (urunIsmi.equalsIgnoreCase(urun.getUrunIsmi())) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected void ureticiFiltrele(String ureticiIsmi) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n", "ID", "Ürün İsmi", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("===============================================================");
        for (PojoClass urun : urunler.values()) {
            if (ureticiIsmi.equalsIgnoreCase(urun.getUretici())) {
                ekranGoruntusu(urun);
            }
        }
    }

    protected Map<String, PojoClass> fakeUrun() {
        PojoClass fake1 = new PojoClass("makarna", "oba", 0, "cuval", null);
        PojoClass fake2 = new PojoClass("un", "oba", 0, "cuval", null);
        PojoClass fake3 = new PojoClass("un", "Hekimoglu", 0, "cuval", null);
        urunler.put(fake1.getId(), fake1);
        urunler.put(fake2.getId(), fake2);
        urunler.put(fake3.getId(), fake3);
        return urunler;
    }

    protected void ekranGoruntusu(PojoClass urun) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %n",
                urun.getId(),
                urun.getUrunIsmi(),
                urun.getUretici(),
                urun.getMiktar(),
                urun.getBirim(),
                urun.getRaf());
    }

    protected void urunGuncelleme(String id, Scanner input) {
        String secim;
        do {
            if (urunler.containsKey(id)) {
                PojoClass urun = urunler.get(id);
                System.out.println("========================== GUNCELLEMELER =======================");

                System.out.println("   ____________________              ____________________");
                System.out.println("   | 1-URUN ISMI        |       |    2-URUN URETICI ISMI      |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.println("   | 3-BIRIM ISMI       |       |    4-UYGULAMADAN CIKIS   |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯  ");
                System.out.println("   | 5-BIR UST MENU");
                System.out.print("SECIM :");

                secim = input.nextLine();
                switch (secim) {
                    case "1":
                        System.out.print("Yeni ürün ismi: ");
                        String urunIsmi = input.nextLine();
                        urun.setUrunIsmi(urunIsmi);
                        break;
                    case "2":
                        System.out.print("Yeni üretici ismi: ");
                        String uretici = input.nextLine();
                        urun.setUretici(uretici);
                        break;
                    case "3":
                        System.out.print("Yeni birim ismi: ");
                        String birim = input.nextLine();
                        urun.setBirim(birim);
                        break;
                    case "4":
                        System.out.println("HOSCAKALIN");
                        System.exit(0);
                        break;
                    case "5":
                        System.out.println("Bir ust menuye Yonlendiriliyorssunuz");
                    default:
                        System.out.println("Geçersiz seçim!");
                        break;

                }
                System.out.println("Ürün güncelleme başarıyla yapıldı.");

            } else {
                System.out.println("Hatalı ID! Ürün tanımlı değil.");
                break;
            }
            tanimlananUrunListele();
        } while (!secim.equals("5"));
    }

    public boolean listeKontrol() {
        boolean kontrol = true;
        if (urunler.isEmpty()) {
            kontrol = false;
        }
        return kontrol;
    }

    public boolean idKontrol(String id) {
        boolean kontrol = false;
        for (PojoClass urun : urunler.values()) {

            if (urun.getId().equals(id)) {
                kontrol = true;
                break;
            }
        }
        if (!kontrol) {
            System.out.println("Hatali ID! tekrar deneyiniz..");
        }
        return kontrol;
    }

    public void tanitim() throws InterruptedException {
        System.out.println("1-)Urun tnimlama \n" +
                "   Urun cinsi:Hangi tip urunu eklemek istersiniz (Or.'un') \n" +
                "   Uretici ismi: urunun hangi ureticiye ait oldugunu gosterir \n" +
                "   Urun Birimi : Hangi tipte urun (or. 'kg','cuval','kasa' v.b \n" +
                "NOT...UYGULAMADA ISLEM YAPABILMEK ICIN TANIMLINURUNLERIN BULUNMASI GEREKMEKTEDIR");
        Thread.sleep(200);
        System.out.println("2-)Urun girisi: Depoya gelen urunun ID numarasi ile girisi sa[lanir");
        Thread.sleep(200);
        System.out.println("3-) Depoda bulunan urunlerin Hangi rafa konulacagini gosterir.Raf isimlerini Siz belirlemelisiniz");
        Thread.sleep(200);
        System.out.println("4-)Satisi yapilan urunun Depodan Cikis yapilan miktari girmenz gerekmektedir");
        Thread.sleep(200);
        System.out.println("5-)Urun ismi ile Deponuzda urun aratabilirsiniz");
        Thread.sleep(100);
        System.out.println("6-)Uretici ismi ile Deponuzda o ureticiye ait olan urunleri Listeleyebilirsiniz");
        Thread.sleep(200);
        System.out.println("7-)Deponuza gelen ve Rafta bulunan urunleri Listeleyebilirsiniz");
        Thread.sleep(200);
        System.out.println("8-)Ismini Yanlis girdiginiz urunlerin 'ismini', 'uretici ismini' veya 'Birimi'ni Duzeltemenize " +
                "imkan verir");
        Thread.sleep(200);
        System.out.println("9-) Daha once tanimladiginiz Urunlerin artik silmek istiyorsaniz Bu sekmeyi kullanabilirsiniz");

    }
}
