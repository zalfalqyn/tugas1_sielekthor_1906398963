package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.service.BarangService;
import apap.tugas.sielekthor.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BarangController {
    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;
    @Autowired
    private TipeService tipeService;

    @GetMapping("/barang")
    public String listBarang(Model model) {
        List<BarangModel> listBarang = barangService.getBarangList();
        model.addAttribute("listBarang", listBarang);
        return "viewall-barang";
    }

    @GetMapping("/barang/tambah")
    public String addBarangForm(Model model) {
        BarangModel barang = new BarangModel();
        model.addAttribute("barang", barang);
        model.addAttribute("listTipe", tipeService.getListTipe());
        return "form-add-barang";
    }

    @PostMapping(value = "/barang/tambah")
    public String addBarangSubmit(
            @ModelAttribute BarangModel barang,
            Model model
    ) {
        barangService.addBarang(barang);
        model.addAttribute("kodeBarang", barang.getKodeBarang());
        return "add-barang";
    }
}
