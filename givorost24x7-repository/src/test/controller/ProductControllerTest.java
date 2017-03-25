package controller;


import com.ksimeo.givorost.api.dao.ProductDAO;
import com.ksimeo.givorost.core.dto.ProductDTO;
import com.ksimeo.givorost.repository.controllers.ProductController;
import com.ksimeo.givorost.repository.dao.ProductDao;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:/givorost24x7-repository2/src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
public class ProductControllerTest extends TestCase {
    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    private ObjectMapper objMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private int testProdId;

    private ProductDAO prodDao;

    @BeforeClass
    @Override
    public void setUp() {
        objMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ProductDTO prod1 = new ProductDTO("Біогумат для відкритого грунту", 0.97f, 3.55f);
        ProductDTO prod2 = new ProductDTO("Біогумат для закритого грунту", 0.55f, 2.40f);
        prodDao = new ProductDao();
        prodDao.saveOrUpdate(prod1);
        prodDao.saveOrUpdate(prod2);
    }

    @Test
    public void addProductTest() throws Exception {
        ProductDTO foo = new ProductDTO("Біогумат типу 3", 0.72f, 1.49f);
        String toSend = objMapper.writeValueAsString(foo);
        MvcResult res = mockMvc.perform(post("product/addone").content(toSend))
                .andExpect(status().isOk())
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        testProdId = Integer.parseInt(echo);
        assertNotSame(testProdId, 0);
    }

    @Test
    public void getProductTest() throws Exception {
        MvcResult res = mockMvc.perform(get("product/getone/" + testProdId))
                .andExpect(status().isOk())
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        ProductDTO foo = objMapper.readValue(echo, ProductDTO.class);
        assertNotNull(foo);
    }

    @Test
    public void getAllProductsTest() throws Exception {
        MvcResult res = mockMvc.perform(get("product/getall"))
                .andExpect(status().isOk())
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        List<ProductDTO> foo = objMapper.readValue(echo, new TypeReference<List<ProductDTO>>() { });
        assertNotNull(foo);
    }

    @Test
    public void delProductTest() throws Exception {
        mockMvc.perform(delete("product/" + testProdId +"/delete"))
                .andExpect(status().isOk());
    }

    @AfterClass
    @Override
    public void tearDown() throws Exception {
        prodDao.dropAll();
    }
}
