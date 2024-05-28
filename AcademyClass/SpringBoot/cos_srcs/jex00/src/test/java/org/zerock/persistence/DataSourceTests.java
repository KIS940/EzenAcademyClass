package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//Java ������ ����ϴ� ��� 
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class DataSourceTests {

  @Setter(onMethod = @__({ @Autowired }))
  private DataSource dataSource;

  @Test
  public void testConnection() {
    
    
    try (Connection con = dataSource.getConnection()){

      log.info(con);      
      
    }catch(Exception e) {
      fail(e.getMessage());
    }
  }
}