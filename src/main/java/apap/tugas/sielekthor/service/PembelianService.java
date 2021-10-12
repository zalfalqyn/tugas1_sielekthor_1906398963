package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;

import java.util.List;

public interface PembelianService {
    List<PembelianModel> getPembelianList();
    void generateInvoice(PembelianModel pembelian);
    PembelianModel getPembelianById(Long Id);
}
