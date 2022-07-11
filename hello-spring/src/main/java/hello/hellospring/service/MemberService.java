package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MemberService {

  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원가입
   */
  public Long join(Member member) {
    // 같은 이름의 회원 거부
    validateDuplicatedMember(member);

    memberRepository.save(member);
    return member.getId();
  }

  /**
   * 중복 가입 검증
   */
  private void validateDuplicatedMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(n -> {
          throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
  }

  /**
   * 전체 회원 조회
   */
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
