package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.repository.BarangDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BarangServiceImpl implements BarangService{
    @Autowired
    BarangDB barangDB;
}
