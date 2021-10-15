package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.MemberModel;

import java.util.List;

public interface MemberService {
    List<MemberModel> getMemberList();
    void addMember(MemberModel member);
    MemberModel getMemberById(Long id);
    void updateMember(MemberModel member);
}
