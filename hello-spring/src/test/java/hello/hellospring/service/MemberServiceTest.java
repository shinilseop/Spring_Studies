package hello.hellospring.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memoryMemberRepository;

  @BeforeEach
  public void beforeEach() {
    memoryMemberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memoryMemberRepository);
  }

  @AfterEach
  public void afterEach() {
    memoryMemberRepository.clearStore();
  }

  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("spring");

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
    member1.setName("spring");
    Member member2 = new Member();
    member2.setName("spring");

    //when
    memberService.join(member1);
    assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//    try {
//      memberService.join(member2);
//    } catch (IllegalStateException e) {
//      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }

    //then

  }

  @Test
  void 멤버전체찾기() {

  }

  @Test
  void 멤버한명찾기() {

  }
}