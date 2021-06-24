package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepostiory;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepostiory();
    public Long join(Member member){

        validateDuplicateMember(member);     //중복회원 불가능
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        if (memberRepository.findByName(member.getName()) != null){
            System.out.println(member.getName()+"는 이미 존재하는 이름입니다.");
        }
        memberRepository.findByName(member.getName()).ifPresent(m ->{
            throw new IllegalStateException(m.getName()+"는 이미 존재하는 회원입니다. 2");
        });
    }
    public List<Member> findMembers(){

        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Member member){

        return memberRepository.findById(member.getId());
    }
}
