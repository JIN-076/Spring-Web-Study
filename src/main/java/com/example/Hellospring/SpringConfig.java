package com.example.Hellospring;

import com.example.Hellospring.repository.MemberRepository;
import com.example.Hellospring.repository.MemoryMemberRepository;
import com.example.Hellospring.service.MemberServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberServices memberServices() {
        return new MemberServices(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
