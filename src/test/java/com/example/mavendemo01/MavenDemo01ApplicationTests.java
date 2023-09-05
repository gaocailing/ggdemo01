package com.example.mavendemo01;

import com.example.mavendemo01.ShujuFanhui.Person;
import com.example.mavendemo01.ShujuFanhui.Student;
import com.example.mavendemo01.ShujuFanhui.User;
import com.example.mavendemo01.contorller.controller;
import com.example.mavendemo01.mybatiscatalog.Comment;
import com.example.mavendemo01.mybatiscatalog.CommentMapper;
import com.example.mavendemo01.mybatiscatalog.jpa.Discuss;
import com.example.mavendemo01.mybatiscatalog.jpa.DiscussRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;


@RunWith(SpringRunner.class)
@SpringBootTest


class MavenDemo01ApplicationTests {
    @Autowired
    controller con;
    @Autowired
    Student stu;
    @Autowired
    Person person;
    @Autowired
    User user;

    @Value("${student.id}")
    int id;

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    CustomProperties customProperties;
    @Autowired
    private CommentMapper commentMapper;


    @Autowired
    private DiscussRepository repository;

    @Test



    void contextLoads() throws RuntimeException {
        String result = con.hello();
        System.out.println("单元测试返回"+con.hello());
        //System.out.println("单元测试返回student"+stu);
      //  System.out.println("单元测试返回id数据---" + id);
      //  System.out.println("单元测试返回user数据--" + user);
      //  System.out.println("单元测试返回Person数据--" + person);

     /*   MyProperties myProperties = (MyProperties) applicationContext.getBean("xmlpropertoes");
        if (myProperties != null) {
            myProperties.getResult();
        }
        System.out.println(customProperties);*/

        //Comment comment=commentMapper.findById(1);
        //System.out.println(comment);

//查询
       // Comment Comment = commentMapper.findById(7);
        //System.out.println("查找数据："+Comment);

        //插入
   Comment comment1=new Comment();
    comment1.setContent("芜湖");
    comment1.setAuthor("11");
    comment1.setaId(5);
    commentMapper.insertComment(comment1);




        //更新
  /* Comment comment=new Comment();
    comment.setContent("篮球与鸡");
    comment.setId(5);
    commentMapper.updateComment(comment);

   */




        //删除
        /*commentMapper.deleteComment(5);

         */


        List <Discuss> list=repository.findByAuthorNotNull();
        System.out.println(list);

        Optional<Discuss> optional=repository.findById(1);
        if(optional.isPresent()) {
            System.out.println(optional.get());
            System.out.println();
        }

        Pageable pageable= PageRequest.of(0,3);
        List<Discuss>allPaged =repository.getDiscussPaged(1,pageable);
        System.out.println(allPaged);

        Discuss discuss=new Discuss();
        discuss.setAuthor("张三");
        Example <Discuss> example=Example.of(discuss);
        List<Discuss> list1  =repository.findAll(example);
        System.out.println(list1);

        Discuss discuss1 =new Discuss();
        discuss.setAuthor("张");
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("author",startsWith());
        Example<Discuss> example1= Example.of(discuss,matcher);
        List<Discuss> list2 =repository.findAll(example1);
        System.out.println(list2);
    }
}
