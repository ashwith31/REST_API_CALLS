package com.bridgelabz.SpringDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HelloWorldController {

    //http://localhost:8080/message
    @RequestMapping(value = {"/", "/hello", "/message"})
    public String getHelloMessage(){
        return "Hello BridgeLabz";
    }

    //http://localhost:8080/test?name=Ashwith
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test1(@RequestParam String name){
        return "Hello :" + name;
    }

    //http://localhost:8080/test1?fname=Ashwith&lname=Kumar
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test4(@RequestParam String fname, @RequestParam String lname){
        return "Hello :" + fname +" "+lname;
    }

    //http://localhost:8080/test2/Ashu
    @RequestMapping(value = "/test2/{name}", method = RequestMethod.GET)
    public String test2(@PathVariable String name){
        return "Hello" + name;
    }

    //http://localhost:8080/test5/Ashu?fname=Ashwith&lname=Kumar
    @RequestMapping(value = "/test5/{name}", method = RequestMethod.GET)
    public String test5(@PathVariable String name, @RequestParam String fname, @RequestParam String lname){
        return "Hello" + name +" "+fname+" "+lname;
    }

//    Here we added required = false to make it a non compulsory field.
//    We can access without fname also.
//    http://localhost:8080/test5/Ashu?lname=Kumar
//    @RequestMapping(value = "/test5/{name}", method = RequestMethod.GET)
//    public String test5(@PathVariable String name, @RequestParam(required = false) String fname, @RequestParam String lname){
//        return "Hello" + name +" "+fname+" "+lname;
//    }

    //http://localhost:8080/test6/?firstname=Ashu
    @RequestMapping(value = "/test6", method = RequestMethod.GET)
    public String test6(@RequestParam(name = "firstname") String fname){
        return "Hello"+" "+ fname;
    }

    /*
        In The @RequestHeader annotation code
        Before compiling this code go to: postman app -> Header
        then pass the key as firstname and value as say Ashu
    */
    @RequestMapping(value = "/test7", method = RequestMethod.GET)
    public String test7(@RequestHeader(name = "firstname") String fname){
        return "Hello"+" "+ fname;
    }

    /*
    In The @RequestBody annotation code
    Before compiling this code go to: postman app -> Body -> raw -> select type as JSON
    then pass this json
    {
        "fname": "abc"
        "rollno":123
        "active":false
    }
     */
    @RequestMapping(value ="/test7", method = RequestMethod.PUT)
    public  String test7(@RequestBody Student student){
        System.out.println(student.toString());;
        return " ";
    }

    @RequestMapping(value ="/test3", method = RequestMethod.PUT)
    public  Student test3(@RequestBody Student student){
       log.info(student.toString());
        return student;
    }
}
