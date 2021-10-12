package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.repository.BarangDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BarangServiceImpl implements BarangService{
    @Autowired
    BarangDB barangDB;

    @Override
    public List<BarangModel> getBarangList() {
        return barangDB.findAll();
    }

}
