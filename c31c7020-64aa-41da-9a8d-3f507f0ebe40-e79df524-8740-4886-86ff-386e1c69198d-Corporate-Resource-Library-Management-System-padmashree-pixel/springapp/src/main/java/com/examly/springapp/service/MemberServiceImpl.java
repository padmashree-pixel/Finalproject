package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public Member addMember(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @Override
    public Member getMemberById(Long memberId) {
        Optional<Member> member = memberRepo.findById(memberId);
        return member.orElse(null);
    }

    @Override
    public Member updateMember(Long memberId, Member updatedMember) {
        return memberRepo.findById(memberId)
                .map(member -> {
                    member.setName(updatedMember.getName());
                    member.setPhone(updatedMember.getPhone());
                    member.setEmail(updatedMember.getEmail());
                    return memberRepo.save(member);
                })
                .orElse(null);
    }

    @Override
    public List<Member> getMembersByPhone(String phone) {
        return memberRepo.findByPhone(phone);
    }

    @Override
    public List<Member> getMembersByEmail(String email) {
        return memberRepo.findByEmail(email);
    }
}
