package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BarangController {
    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;
}
