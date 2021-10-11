package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.repository.PembelianDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PembelianServiceImpl implements PembelianService{
    @Autowired
    PembelianDB pembelianDB;
}
