package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.repository.MemberDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberDB memberDB;
}
