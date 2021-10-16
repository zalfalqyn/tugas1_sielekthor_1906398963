package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;

import java.util.List;

public interface BarangService {
    List<BarangModel> getBarangList();
    List<BarangModel> getBarangListFilter(Long Id, Boolean isAvail);
    void addBarang(BarangModel barang);
    BarangModel getBarangById(Long Id);
    void updateBarang(BarangModel barang);
}
