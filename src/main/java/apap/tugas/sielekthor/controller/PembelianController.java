package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PembelianController {
    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;
}
