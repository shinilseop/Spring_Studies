package hello.hellospring.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("spring99");

    //when
    Long id = memberService.join(member);

    //then
    Member findMember = memberService.findOne(member.getId()).get();
    assertThat(id).isEqualTo(findMember.getId());
  }

  @Test
  public void 중복_회원_예외() {
    //given
    Member member1 = new Member();
    member1.setName("spring99");
    Member member2 = new Member();
    member2.setName("spring99");

    //when
    memberService.join(member1);
    assertThrows(IllegalStateException.class, () -> memberService.join(member2));
  }
}