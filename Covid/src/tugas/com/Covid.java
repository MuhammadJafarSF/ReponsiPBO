package tugas.com;

import java.util.ArrayList;

public class Covid extends ArrayList<Covid> {
    private String negara;
    private int Terkonfirmasi;
    private int Sembuh;
    private int Meninggal;


    public Covid(String negara, int terkonfirmasi, int sembuh, int meninggal){
        this.negara = negara;
        this.Terkonfirmasi = terkonfirmasi;
        this.Sembuh = sembuh;
        this.Meninggal = meninggal;
    }

    public String getNegara() {
        return negara;
    }

    public int getTerkonfirmasi() {
        return Terkonfirmasi;
    }

    public int getSembuh() {
        return Sembuh;
    }

    public int getMeninggal() {
        return Meninggal;
    }

    public void InsertTerkonfirmasi(int jmlTerkonfirmasi){
        Terkonfirmasi = Terkonfirmasi + jmlTerkonfirmasi;
    }

    public void InsertMeninggal(int jmlMeninggal){
        Meninggal = Meninggal + jmlMeninggal;
    }

    public void InsertSembuh(int jmlSembuh){
        Sembuh = Sembuh + jmlSembuh;
    }

}
