package com.company.project.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "users2", type = "user2")
public class User implements Serializable {

  private static final long serialVersionUID = -2470913076446177390L;

  //  @JestId
  private Integer id;
  private String name;
  private Integer age;
  private String testField;
  /**
   *  注意这里不要使用 isStudent 这样的boolean字段。避免序列化/反序列化找不到该字段
   *  因为 isStudent 和 student 的 get set方法都是一样的
   */
  private boolean studentIs;

  private Date birthday;

}
