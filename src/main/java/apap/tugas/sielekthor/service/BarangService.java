package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;

import java.util.List;

public interface BarangService {
    List<BarangModel> getBarangList();
    void addBarang(BarangModel barang);
    BarangModel getBarangById(Long Id);
}
