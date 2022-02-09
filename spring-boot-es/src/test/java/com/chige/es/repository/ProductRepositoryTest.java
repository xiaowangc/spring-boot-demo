package com.chige.es.repository;

import com.chige.es.ESApplication;
import com.chige.es.dao.repository.AccountRepository;
import com.chige.es.domain.ESAccountDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class ProductRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testProductRep() {
        this.testInsert();
        this.testDeleteOne();
        this.testUpdate();
        this.testQueryById();
        this.testQueryByIds();
    }

    /**
     *  插入一条记录
     */
    private void testInsert() {
        ESAccountDO product = new ESAccountDO();
        product.setAccountNumber(31L);
        product.setBalance(10031L);
        product.setFirstName("王");
        product.setLastName("chige");
        product.setAge(18L);
        product.setGender("F");
        product.setAddress("797 Moffat Street");
        product.setEmployer("Niquent");
        product.setEmail("xiaowangy@qq.com");
        product.setCity("Zarephath");
        product.setState("DE");
        accountRepository.save(product);
    }
    /**
     *  更新一条记录
     */
    private void testUpdate() {

    }
    /**
     *  删除一条记录
     */
    private void testDeleteOne() {

    }
    /**
     *  查询一条记录
     */
    private void testQueryById() {

    }
    /**
     *  查询一批数据
     */
    private void testQueryByIds() {

    }


}
