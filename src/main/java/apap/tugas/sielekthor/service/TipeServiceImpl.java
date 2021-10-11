package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.repository.TipeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TipeServiceImpl implements TipeService{
    @Autowired
    TipeDB tipeDB;
}
