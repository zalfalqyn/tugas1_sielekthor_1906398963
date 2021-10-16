package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.TipeModel;

import java.util.List;

public interface TipeService {
    List<TipeModel> getListTipe();
    TipeModel getTipeById(Long Id);
}
