package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.PembelianDB;
import apap.tugas.sielekthor.service.MemberService;
import apap.tugas.sielekthor.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;
    @Autowired
    PembelianDB pembelianDB;

    @GetMapping("/member/tambah")
    public String addMemberForm(Model model) {
        MemberModel member = new MemberModel();
        model.addAttribute("member", member);
        return "form-add-member";
    }

    @PostMapping(value = "/member/tambah")
    public String addMemberSubmit(
            @ModelAttribute MemberModel member,
            Model model
    ) {
        memberService.addMember(member);
        model.addAttribute("namaMember", member.getNamaMember());
        model.addAttribute("idMember", member.getId());
        return "add-member";
    }

    @GetMapping("/member")
    public String listMember(Model model) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        List<MemberModel> listMember = memberService.getMemberList();
        List<String> listTglLahir = new ArrayList<>();
        List<String> listTglDaftar = new ArrayList<>();
        for(MemberModel member: listMember) {
            String tglLahir = member.getTanggalLahir().format(formatter1);
            String tglDaftar = member.getTanggalPendaftaran().format(formatter2);
            listTglLahir.add(tglLahir);
            listTglDaftar.add(tglDaftar);
        }
        model.addAttribute("listMember", listMember);
        model.addAttribute("listTglLahir", listTglLahir);
        model.addAttribute("listTglDaftar", listTglDaftar);
        return "viewall-member";
    }

    @GetMapping("/member/ubah/{idMember}")
    public String updateMemberForm(
            @PathVariable Long idMember,
            Model model
    ) {
        MemberModel member = memberService.getMemberById(idMember);
        model.addAttribute("member", member);
        return "form-update-member";
    }

    @PostMapping("/member/ubah")
    public String updateMemberSubmit(
            @ModelAttribute MemberModel member,
            Model model
    ) {
        MemberModel memberNew = memberService.getMemberById(member.getId());
        List<PembelianModel> listPembelian = memberNew.getListPembelian();
        List<String> listNoInvoice = new ArrayList<>();
        memberService.updateMember(member);
        for (PembelianModel pembelian: listPembelian) {
            pembelianService.generateInvoice(pembelian);
            listNoInvoice.add(pembelian.getNoInvoice());
            pembelianDB.save(pembelian);
        }
        model.addAttribute("namaMember", memberNew.getNamaMember());
        model.addAttribute("listNoInvoice", listNoInvoice);

        return "update-member";
    }
}
