package com.shankardesigner.ecare.controller;

import com.shankardesigner.ecare.model.Laptop;
import com.shankardesigner.ecare.model.Student;
import com.shankardesigner.ecare.service.StudentRepositiory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentController {

    private StudentRepositiory studentRepositiory;

    public StudentController(StudentRepositiory studentRepositiory) {
        this.studentRepositiory = studentRepositiory;
    }

    @GetMapping
    private List<Student> getAllStudent() {
        return studentRepositiory.findAll();
    }

    @GetMapping(value = "{name}")
    private Student saveStudent(@PathVariable String name) {
        Student s1 = new Student();
        Laptop laptop = new Laptop();

//        laptop.setStudent(s1);

        s1.setName(name);
        s1.setMarks(200);
        List<Laptop> laptops = new ArrayList<Laptop>();
        laptops.add(new Laptop("Dell",s1));// yes hijo maile gareko error aako thiiyo hai maile all arg constructr banyebaxy yr ani kina json ignore rakhya hami ta json use ni gareko xainam ahile
        //json ignore vaneko database bata data tanda oh oh st udent le laptop tanxa laptop le studnet tanxa
        //jaba json ignore use garxa taba yesle chai studnet le laptop object matra tanna dinxa but laptp ko student  lai chai null set garxa yesto garena vane loop ma chali rakhaxa so yesle stackoverflow error fakxa t
                //tanni kam chai laptop ma studnet ko id rakehkeo xa ni tesle tannxa eh la feri vanxu :D ahah hus bujyo ni hai yes thanks yrhahah muji json i:D ignore jasto aru pani xa jsonpropertiese ani arko pani aauta xa different logic but same kam nai garxa ok
        laptops.add(new Laptop("Hp",s1));//yesma taile laptop ko object lai student sanga pani rakhnuaparxa hus umm khaye taile khais hus hunxa  kina hahah kin ani ni sala xakka khoi thaha xaina hahaha hasais aru vayo vane samjinu hola :D la ma gako

        s1.setLaptop(laptops);

        System.out.println("s1 = " + s1);


        return studentRepositiory.save(s1);
    }
}
