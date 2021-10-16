package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;
import apap.tugas.sielekthor.repository.BarangDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.util.List;

@Service
@Transactional
public class BarangServiceImpl implements BarangService{
    @Autowired
    BarangDB barangDB;

    @Autowired
    TipeService tipeService;

    @Override
    public List<BarangModel> getBarangList() {
        return barangDB.findAll();
    }

    @Override
    public void addBarang(BarangModel barang) {
        barangDB.save(barang);
    }

    @Override
    public BarangModel getBarangById(Long Id) {
        return barangDB.getById(Id);
    }

    @Override
    public void updateBarang(BarangModel barang) {
        barangDB.save(barang);
    }

    @Override
    public List<BarangModel> getBarangListFilter(Long idTipe, Boolean isAvail){
        TipeModel tipe = tipeService.getTipeById(idTipe);
        if (isAvail){
            return barangDB.findPembelianByTipeAndStokAfter(tipe, 1);
        }
        return  barangDB.findPembelianByTipeAndStokBefore(tipe, 1);

    }
}
