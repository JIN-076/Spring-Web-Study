package com.example.Hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // GET Method
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    /* ResponseBody가 없을 경우, viewResolver 동작 */
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    /* json method */
    /* API method */

    @GetMapping("hello-api")
    @ResponseBody
    /* http 응답에 그대로 넣는 동작 */
    /* 객체가 반환이 되면 default가 json 방식으로 만든다 */
    /* HttpMessageConverter 동작 -> 단순 문자 : string converter, 객체 -> json converter */
    /* 기본 객체 처리 : MappingJackson2HttpMessageConverter -> spring 기본 탑재 */
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    /* getter / setter 단축키 : ctrl + enter */

    static class Hello {
        private String name;

        /* java bean 규약, property 접근 방식 */

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
