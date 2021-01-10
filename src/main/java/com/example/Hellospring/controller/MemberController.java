package com.example.Hellospring.controller;

import com.example.Hellospring.domain.Member;
import com.example.Hellospring.service.MemberServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberServices memberServices;

/*
    @Autowired
    public void setMemberServices(MemberServices memberServices) {
        this.memberServices = memberServices;
    }
*/

    @Autowired
    public MemberController(MemberServices memberServices) {
        this.memberServices = memberServices;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberServices.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberServices.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
