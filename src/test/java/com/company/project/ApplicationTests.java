package com.company.project;

import com.company.project.entity.User;
import com.company.project.repository.UserRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

  @Autowired
  JestClient jestClient;

  @Autowired
  UserRepository userRepository;

  /**
   * 测试es索引（保存）一个对象
   * @throws Exception
   */
  @Test
  public void save() throws Exception {

    //使用jest操作es来索引(存储)一个文档(对象数据)
    //索引相当于数据库中  库
    //类型相当与 表

    //    User user = User.builder().id(1).name("testName").age(23).testField("test field")
    //        .studentIs(true)
    //        .birthday(new Date()).build();
    //
    //    Index index = new Index.Builder(user).index("users").type("user").id("0").build();
    //    jestClient.execute(index);

    //使用SpringData操作es
    User user2 = User.builder().id(2).name("testName").age(23).testField("test field")
        .studentIs(true)
        .birthday(new Date()).build();

    userRepository.index(user2);
  }

  /**
   * 搜索
   * @throws Exception
   */
  @Test
  public void search() throws Exception {

    String searchJson = "{\n"
        + "    \"query\": {\n"
        + "        \"match\": {\n"
        + "            \"testField\": \"test\"\n"
        + "        }\n"
        + "    }\n"
        + "}";

    Search search = new Search.Builder(searchJson).addIndex("users").addType("user").build();
    SearchResult searchResult = jestClient.execute(search);
    System.out.println(searchResult.getJsonString());
  }

}
