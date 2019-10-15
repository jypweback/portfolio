package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.MemberDto;


public interface MemberService {

    public MemberDto getMember(MemberDto memberDto);

    public MemberDto createMember(MemberDto memberDto);

}
