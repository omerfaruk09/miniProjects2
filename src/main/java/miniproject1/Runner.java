package miniproject1;


    import java.util.Scanner;

    public class Runner {
        public static void main(String[] args) throws InterruptedException {
            MethodStore methodStore = new MethodStore();
            Scanner input = new Scanner(System.in);
            System.out.println("Tanitimi izlemek icin 'Q' ya Gecmek icin Herhangi bir tusa basiniz");
            String  tanitim=input.nextLine();
            if (tanitim.equalsIgnoreCase("Q")){
                methodStore.tanitim();
            }

            methodStore.fakeUrun(); // test icin Fake urunler eklendi
            methodStore.tanimlananUrunListele();
            System.out.println("Tarafımzca size ornek olması için yapılan listedir gerekli düzenlemeleri yapabilirsiniz.");
            System.out.println("--------------------------------------------------------------");

            while (true) {
                System.out.println("========================== İŞLEMLER =======================");
                System.out.println("   ____________________              ____________________");
                System.out.println("   | 1-URUN TANIMLAMA       |       |  2-URUN GIRISI      |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.println("   | 3-URUN RAFA KOY        |       |  4-URUN CIKISI      |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.println("   | 5-URUN FILTRELE        |       |  6-URETICI FILTRELE |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.println("   | 7-RAFTAKI URUN LISTELE |       |  8-URUN GUNCELLE    |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.println("   | 9-TANIMLI URUN SIL     |       |  0-CIKIS            |");
                System.out.println("   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                System.out.print("ISLEM SECINIZ : ");
                String menuSecim = input.nextLine();

                if (methodStore.listeKontrol() || menuSecim.equals("1")) {


                    switch (menuSecim) {
                        case "1":
                            System.out.print("Urun cinsini giriniz: ");
                            String cinsi = input.nextLine();
                            System.out.print("Ureticisini giriniz: ");
                            String uretici = input.nextLine();
                            System.out.print("Birimini giriniz: ");
                            String birim = input.nextLine();
                            methodStore.urunTanimlama(cinsi, uretici, birim);
                            methodStore.tanimlananUrunListele();
                            break;
                        case "2":

                            boolean varmi;
                            String id;
                            do {
                                System.out.print("Eklemek istediğiniz urunun ID'sini giriniz: ");

                                id = input.nextLine();
                                varmi = methodStore.idKontrol(id);

                            } while (!varmi);

                            System.out.print("Ne kadar eklemek istersiniz: ");

                            methodStore.urunGirisi(id, input);
                            methodStore.tanimlananUrunListele();
                            break;
                        case "3":

                            do {
                                System.out.print("Rafa Koymak istediğiniz urunun ID'sini giriniz: ");

                                id = input.nextLine();
                                varmi = methodStore.idKontrol(id);

                            } while (!varmi);

                            methodStore.urunuRafaKoy(id, input);
                            methodStore.raftakiUrunleriListele();
                            break;
                        case "4":
                            do {
                                System.out.print("Cikarmak istediğiniz urunun ID'sini giriniz: ");

                                id = input.nextLine();
                                varmi = methodStore.idKontrol(id);

                            } while (!varmi);
                            System.out.print("Kaç adet çıkarmak istersiniz: ");

                            methodStore.urunCikisi(id, input);
                            methodStore.tanimlananUrunListele();
                            break;
                        case "5":
                            System.out.print("Filtrelemek istediğiniz ürün cinsini giriniz: ");
                            String filterCinsi = input.nextLine();
                            methodStore.urunFiltrele(filterCinsi);
                            break;
                        case "6":
                            System.out.print("Filtrelemek istediğiniz üreticiyi giriniz: ");
                            String filterUretici = input.nextLine();

                            methodStore.ureticiFiltrele(filterUretici);
                            break;
                        case "7":
                            methodStore.raftakiUrunleriListele();
                            break;
                        case "8":

                            do {
                                System.out.print("Güncellemek istediğiniz ürünün ID'sini giriniz: ");
                                id = input.nextLine();
                                varmi = methodStore.idKontrol(id);
                            } while (!varmi);

                            methodStore.urunGuncelleme(id, input);

                            break;
                        case "9":

                            do {
                                System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
                                id = input.nextLine();
                                varmi = methodStore.idKontrol(id);

                            } while (!varmi);
                            methodStore.urunSil(id);
                            methodStore.tanimlananUrunListele();
                            break;
                        case "0":
                            System.out.println("Hoscakalin");
                            System.exit(0);
                        default:
                            System.out.println("Gecersiz bir secim yaptiniz!");
                            break;
                    }

                }else {
                    System.out.println("Deponuzda tanimli urun bulunmamaktadir. Lutfen urun tanimlayiniz..");
                }
            }

        }
    }

