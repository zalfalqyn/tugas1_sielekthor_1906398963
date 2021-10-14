package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.repository.MemberDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberDB memberDB;

    @Override
    public List<MemberModel> getMemberList() {
        return memberDB.findAll();
    }

    @Override
    public void addMember(MemberModel member) {
        memberDB.save(member);
    }
}
