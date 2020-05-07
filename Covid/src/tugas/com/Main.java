package tugas.com;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        ArrayList<Covid> Pandemik = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String negara, a;
        int Terkonfirmasi, Sembuh, Meninggal;
        Statement statement;

        do {
            System.out.println("\nData Pandemi Covid");
            System.out.println(" 1. Negara Baru ");
            System.out.println(" 2. Negara Terkena");
            System.out.print(" Pilih : ");
            int pilih = input.nextInt();
            if (pilih == 1){
                System.out.println("Input Data Pandemi");
                System.out.print(" Nama Negara : ");
                negara = input.next();
                System.out.print(" Terkonfirmasi: ");
                Terkonfirmasi = input.nextInt();
                System.out.print(" Sembuh : ");
                Sembuh = input.nextInt();
                System.out.print(" Meninggal : ");
                Meninggal = input.nextInt();

                Covid dataBaru = new Covid(negara, Terkonfirmasi, Sembuh, Meninggal);
                Pandemik.add(dataBaru);
                Database database = new Database();
                try {
                    statement = database.getConnection().createStatement();
                    String query = "insert into riwayat values('" + dataBaru.getNegara() + "'," + dataBaru.getTerkonfirmasi() + "," + dataBaru.getSembuh() + "," + dataBaru.getMeninggal() + ")";
                    statement.executeUpdate(query);

                } catch (SQLException e) {
                    e.printStackTrace();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();

                }
            } else {

                System.out.println(" \nTambah Data Pandemi ");
                System.out.print("Nama Negara : ");
                negara = input.next();

                int pilih2, jmlTerkonfirmasi, jmlMeninggal, jmlSembuh;
                for (Covid p : Pandemik){
                    if (p.getNegara().equalsIgnoreCase(negara)){
                        System.out.println(" Data Ditambahkan ");
                        System.out.println(" 1. Terkonfirmasi ");
                        System.out.println(" 2. Sembuh ");
                        System.out.println(" 3. Meninggal ");
                        System.out.print(" Pilih : ");
                        pilih2 = input.nextInt();
                        switch (pilih2){
                            case 1 :

                                System.out.print(" Pasien Terkonfirmasi : ");
                                jmlTerkonfirmasi = input.nextInt();
                                p.InsertTerkonfirmasi(jmlTerkonfirmasi);
                                System.out.println(" Terkonfirmasi : " + p.getTerkonfirmasi());
                                break;
                            case 2 :
                                do {
                                    System.out.print(" Pasien sembuh: ");
                                    jmlSembuh = input.nextInt();
                                    if (jmlSembuh > p.getTerkonfirmasi()){
                                        System.err.println("Error !! ");
                                        System.out.print(" Data yang terkonfirmasi : " + p.getTerkonfirmasi());
                                        System.out.print(" Masukkan data lagi (y/n)? ");
                                        String ulang = input.next();
                                        if (ulang.charAt(0) != 'y'){
                                            break;
                                        }
                                    } else {
                                        p.InsertSembuh(jmlSembuh);
                                        System.out.println(" Sembuh: " + p.getSembuh());
                                    }
                                } while (jmlSembuh > p.getTerkonfirmasi());
                                break;
                            case 3 :
                                do {
                                    System.out.print(" Pasien Yang Meninggal : ");
                                    jmlMeninggal = input.nextInt();

                                    if (jmlMeninggal > p.getTerkonfirmasi()){
                                        System.err.println("Error!!");
                                        System.out.print(" Terkonfirmasi : " + p.getTerkonfirmasi());

                                        System.out.print(" Masukkan data lagi (y/n)? ");
                                        String ulang = input.next();
                                        if (ulang.charAt(0) != 'y'){
                                            break;
                                        }
                                    } else {
                                        p.InsertMeninggal(jmlMeninggal);
                                        System.out.println(" Pasien meninggal: " + p.getMeninggal());
                                    }
                                } while (jmlMeninggal > p.getTerkonfirmasi());
                                break;
                            default:
                                System.err.println("Error");
                        }
                    }
                }
            }
            System.out.print("Kembali ke menu [y/t]?  ");
            a = input.next();
        }while (a.charAt(0) == 'y');

        }

    //public void update(int getTerkonfirmasi, int getSembuh, int getMeninggal, int getNegara){
    //   Statement statement;
    //   Database database = new Database();
    //   try{
    //     String query = "update riwayat set getNegara = "+ getTerkonfirmasi + ","+ getSembuh+", "+ getMeninggal+" WHERE getNegara = "+getNegara+"";
    //     statement = database.getConnection().createStatement();
    //   statement.executeUpdate(query);
    //  }
    //       } catch (SQLException e) {
    //               e.printStackTrace();
    //
    //    } catch (ClassNotFoundException e) {
    //                e.printStackTrace();
    //   }
}


