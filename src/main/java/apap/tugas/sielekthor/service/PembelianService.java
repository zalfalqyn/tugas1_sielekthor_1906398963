package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;

import java.util.List;

public interface PembelianService {
    List<PembelianModel> getPembelianList();
    List<PembelianModel> getPembelianListFilter(Long Id, Boolean isCash);
    void generateInvoice(PembelianModel pembelian);
    PembelianModel getPembelianById(Long Id);
    boolean addPembelian(PembelianModel pembelian);
    Integer getTotalPembelian(PembelianModel pembelian);
    void deletePembelian(PembelianModel pembelian);
}
