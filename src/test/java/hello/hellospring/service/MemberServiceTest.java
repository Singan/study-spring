package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService service ;
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("석성희");
        //when
        Long saveId = service.join(member);
        //then
        Member findMember = service.findOne(member).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    void 중복회원예외() {
        //given

        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring1");
        //when
        service.join(member1);
        IllegalStateException e =assertThrows(IllegalStateException.class, () ->service.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*        try {
            service.join(member1);
            fail("예외가 발생해야합니다.");
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }*/
        //then

    }
    @Test
    void 회원목록() {

    }

    @Test
    void 회원한명() {
        
    }
}