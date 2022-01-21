package com.chige.es.repository;

import com.chige.es.ESApplication;
import com.chige.es.dao.repository.ProductRepository;
import com.chige.es.domain.ESProductDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

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
        ESProductDO product = new ESProductDO();
        product.setId(1); // 一般 ES 的 ID 编号，使用 DB 数据对应的编号。这里，先写死
        product.setName("池哥学ES");
        product.setSellPoint("愿半生编码，如一生老友");
        product.setDescription("我只是一个描述");
        product.setCid(1);
        product.setCategoryName("技术");
        productRepository.save(product);

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
