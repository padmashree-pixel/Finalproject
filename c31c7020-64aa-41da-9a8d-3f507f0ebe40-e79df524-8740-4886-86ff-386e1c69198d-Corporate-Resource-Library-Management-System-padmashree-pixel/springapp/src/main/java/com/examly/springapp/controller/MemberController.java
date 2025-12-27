package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

   
    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member savedMember = memberService.addMember(member);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

 
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

 


 
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        if (updatedMember == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

@GetMapping("/phone/{phone}")
public ResponseEntity<?> getMembersByPhone(@PathVariable("phone") String phone) {
    List<Member> members = memberService.getMembersByPhone(phone);
    if (members.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("No member found with phone: " + phone);
    }
    return new ResponseEntity<>(members, HttpStatus.OK);
}


 
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Member>> getMembersByEmail(@PathVariable("email") String email) {
        List<Member> members = memberService.getMembersByEmail(email);
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
