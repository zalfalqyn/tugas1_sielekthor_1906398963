package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PembelianController {
    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @GetMapping("/pembelian")
    public String listBarang(Model model) {
        List<PembelianModel> listPembelian = pembelianService.getPembelianList();
        Integer jumlahBarang = listPembelian.size();
        model.addAttribute("listPembelian", listPembelian);
        model.addAttribute("jumlahBarang", jumlahBarang);
        return "viewall-pembelian";
    }

    @GetMapping("/pembelian/{id}")
    public String viewDetailPembelian(
            @PathVariable Long id,
            Model model
    ) {
        PembelianModel pembelian = pembelianService.getPembelianById(id);
        List<PembelianModel> listPembelian = pembelianService.getPembelianList();
        Integer jumlahBarang = listPembelian.size();
        model.addAttribute("pembelian", pembelian);
        model.addAttribute("jumlahBarang", jumlahBarang);
        return "view-pembelian";
    }
}
