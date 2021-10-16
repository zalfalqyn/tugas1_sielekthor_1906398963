package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.service.MemberService;
import apap.tugas.sielekthor.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilterPembelianController {
    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;
    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @GetMapping("/filter-pembelian")
    public String filterPembelian(Model model) {
        List<MemberModel> listAllMember = memberService.getMemberList();
        model.addAttribute("listAllMember", listAllMember);
        return "form-filter-pembelian";
    }

    @PostMapping("/filter-pembelian")
    public String filterPembelianList(
            @RequestParam Long idMember,
            @RequestParam Boolean isCash,
            Model model) {
        List<PembelianModel> listPembelian = pembelianService.getPembelianListFilter(idMember, isCash);
        List<MemberModel> listAllMember = memberService.getMemberList();
        model.addAttribute("listAllMember", listAllMember);
        model.addAttribute("listPembelian", listPembelian);
        return "viewall-filter-pembelian";
    }

}
