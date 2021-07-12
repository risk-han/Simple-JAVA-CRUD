import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Anime {
    static ArrayList listAnime = new ArrayList();
    static boolean isRunning = true;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    static void showMenu() throws IOException{
        System.out.println("\n" + "\n========= MENU ========");
        System.out.println("[1] Show All Anime");
        System.out.println("[2] Add Anime");
        System.out.println("[3] Edit Anime");
        System.out.println("[4] Delete Anime");
        System.out.println("[5] Keluar");
        System.out.print("PILIH MENU> " + "\n");
        
        int select = Integer.valueOf(input.readLine());

        switch(select){
            case 1:
            showallAnime();
            break;

            case 2:
            addAnime();
            break;

            case 3:
            editAnime();
            break;

            case 4:
            deleteAnime();
            break;

            case 5:
            System.exit(0);
            break;

            default:
            System.out.println("Pilihan tidak ada");
        }
    }

    static void showallAnime(){
        if(listAnime.isEmpty()){
            System.out.println("Belum ada Anime");
        }else{
            System.out.println("Daftar Anime\n");
            for(int i = 0; i < listAnime.size(); i++){
                System.out.println(String.format("[%d] %s", i + 1, listAnime.get(i)));
            }
        }
    }

    static void addAnime() throws IOException{
        System.out.println("Nama Anime : ");
        String namaAnime = input.readLine();
        listAnime.add(namaAnime);
    }

    static void editAnime() throws IOException{
        showallAnime();
        System.out.print("\nPilih nomor anime yang ingin diedit: ");
        int indexAnime = Integer.valueOf(input.readLine());

        System.out.print("Nama Baru: ");
        String namaBaru = input.readLine();

        //ubah nama anime
        listAnime.set(indexAnime - 1, namaBaru);
    }

    static void deleteAnime() throws IOException{
        showallAnime();
        System.out.println("Pilih index anime yang ingin dihapus: ");
        int indexAnime = Integer.valueOf(input.readLine());

        //hapus anime
        listAnime.remove(indexAnime - 1);
    }

    public static void main(String[] args) throws IOException {
        do{
            showMenu();
        }while (isRunning);
    }

}
