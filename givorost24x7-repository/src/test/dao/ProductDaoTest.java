package dao;

import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.repository.dao.ProductDao;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class ProductDaoTest extends TestCase {

    private ProductDAO prodDao;

    private int testProdId;

//    public static void main(String[] args) {
////
////        ProductDAO prodDAO = new ProductDao();
////        ProductDTO prod1 = new ProductDTO(1, "Біогумат для відкритого грунту", 0.97f, 3.55f);
////        ProductDTO prod2 = new ProductDTO(2, "Біогумат для закритого грунту", 0.55f, 2.40f);
////        prodDAO.saveOrUpdate(prod1);
////        prodDAO.saveOrUpdate(prod2);
//    }

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        prodDao = new ProductDao();
        ProductDTO prod1 = new ProductDTO("Біогумат для відкритого грунту", 0.97f, 3.55f);
        ProductDTO prod2 = new ProductDTO("Біогумат для закритого грунту", 0.55f, 2.40f);
        prodDao.saveOrUpdate(prod1);
        prodDao.saveOrUpdate(prod2);
    }

    @Test
    public void saveOrUpdateTest() throws Exception {
        ProductDTO foo = new ProductDTO("Біогумат марки 3", 0.55f, 2.40f);
        testProdId = prodDao.saveOrUpdate(foo);
        assertNotSame(0, testProdId);
    }

    @Test
    public void findOneTest() throws Exception {
        ProductDTO foo = prodDao.findOne(testProdId);
        assertNotNull(foo);
    }

    @Test
    public void findAllTest() throws Exception {
        List<ProductDTO> foo = prodDao.findAll();
        assertNotNull(foo);
    }

    @Test
    public void dropOne() throws Exception {
        prodDao.dropOne(testProdId);
    }

    @AfterClass
    @Override
    public void tearDown() throws Exception {
        prodDao.dropAll();
    }
}
