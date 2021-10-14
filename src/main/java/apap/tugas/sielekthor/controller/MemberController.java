package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class MemberController {
    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/tambah")
    public String addMemberForm(Model model) {
        MemberModel member = new MemberModel();
        model.addAttribute("member", member);
        return "form-add-member";
    }

    @PostMapping(value = "/member/tambah")
    public String addMemberSubmit(
            @ModelAttribute MemberModel member,
            @RequestParam("tglLahir") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date tglLahir,
            @RequestParam("tglDaftar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime tglDaftar,
            Model model
    ) {
        member.setTanggalLahir(tglLahir);
        member.setTanggalPendaftaran((tglDaftar));
        memberService.addMember(member);
        model.addAttribute("namaMember", member.getNamaMember());
        model.addAttribute("idMember", member.getId());
        return "add-member";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
