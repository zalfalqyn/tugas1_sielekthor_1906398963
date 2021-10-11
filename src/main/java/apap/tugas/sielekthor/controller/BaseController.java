package apap.tugas.sielekthor.controller;

//import apap.tugas.sielekthor.model.BarangModel;
//import apap.tugas.sielekthor.repository.BarangDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
//    @Autowired
//    BarangDB barangDB;


    @GetMapping("/")
    private String home() {
//        BarangModel barang = new BarangModel();
//        barang.setNamaBarang("a");
//        barang.setKodeBarang("a");
//        barang.setHargaBarang(1);
//        barang.setDeskripsiBarang("a");
//        barang.setStok(1);
//        barang.setJumlahGaransi(1);
//        barang.setMerkBarang("a");
//        barangDB.save(barang);
        return "home";
    }
}
