package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.service.BarangService;
import apap.tugas.sielekthor.service.MemberService;
import apap.tugas.sielekthor.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PembelianController {
    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;
    @Autowired
    private BarangService barangService;
    @Autowired
    private MemberService memberService;

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

    @GetMapping("/pembelian/tambah")
    public String addPembelianForm(Model model) {
        PembelianModel pembelian = new PembelianModel();
        List<PembelianBarangModel> listPB = new ArrayList<>();
        listPB.add(new PembelianBarangModel());
        System.out.println(barangService.getBarangList());
        model.addAttribute("pembelian", pembelian);
        model.addAttribute("listAllBarang", barangService.getBarangList());
        model.addAttribute("listPembelianBarang", listPB);
        model.addAttribute("listAllMember", memberService.getMemberList());
        return "form-add-pembelian";
    }

    @PostMapping(value = "/pembelian/tambah", params = "submit")
    public String addPembelianSubmit(
            @ModelAttribute PembelianModel pembelian,
            Model model
    ) {
//        pembelianService.addPembelian(pembelian);
        pembelianService.generateInvoice(pembelian);
        System.out.println(pembelian.getNamaAdmin());
        System.out.println(pembelian.getMember());
        System.out.println(pembelian.getIsCash());
        System.out.println(pembelian.getNamaAdmin());
        System.out.println(pembelian.getNoInvoice());

        model.addAttribute("pembelian", pembelian);
        return "add-pembelian";
    }

//    @PostMapping(value = "/pembelian/add", params = "addRow")
//    public String addBioskopFormAddRow(
//            @ModelAttribute BioskopModel bioskop,
//            Model model) {
//        List<FilmModel> listFilm = new ArrayList<FilmModel>(bioskop.getListFilm());
//        listFilm.add(null);
//        model.addAttribute("listFilm", listFilm);
//        model.addAttribute("pembelian", pembelian);
//        model.addAttribute("listAllFilm", filmService.getListFilm());
//        return "form-add-pembelian";
//    }

//    @RequestMapping(value = "/pembelian/add", method=RequestMethod.POST, params = "deleteRow")
//    public String addBioskopFormDeleteRow(
//            @ModelAttribute BioskopModel bioskop,
//            Model model,
//            final HttpServletRequest req) {
//        final Integer rowDelete = Integer.valueOf(req.getParameter("deleteRow"));
//        bioskop.getListFilm().remove(rowDelete.intValue());
//        model.addAttribute("listFilm", bioskop.getListFilm());
//        model.addAttribute("bioskop", bioskop);
//        model.addAttribute("listAllFilm", filmService.getListFilm());
//        return "form-add-bioskop";
//    }
//
}
