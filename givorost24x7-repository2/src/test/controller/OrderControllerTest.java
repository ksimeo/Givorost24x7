package controller;


import com.ksimeo.givorost.api.dao.OrderDAO;
import com.ksimeo.givorost.core.dto.OrderDTO;
import com.ksimeo.givorost.repository.controllers.OrderController;
import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:/givorost24x7-repository2/src/main/webapp/WEB-INF/spring-web-servlet.xml"})
@WebAppConfiguration
public class OrderControllerTest extends TestCase {
    @InjectMocks
    private OrderController orderController;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private ObjectMapper objMapper;

    private OrderDAO orderDAO;




    @BeforeClass
    @Override
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objMapper = new ObjectMapper();
        orderDAO.saveOrUpdate(new OrderDTO("Алехин А.А.", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDAO.saveOrUpdate(new OrderDTO("Курелец С.Р.", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDAO.saveOrUpdate(new OrderDTO("Пивень Л.И.", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDAO.saveOrUpdate(new OrderDTO("Юра Хилько", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDAO.saveOrUpdate(new OrderDTO("Ярослав Прусенко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDAO.saveOrUpdate(new OrderDTO("Ольга Крошка", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDAO.saveOrUpdate(new OrderDTO("Игорь Крючков", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDAO.saveOrUpdate(new OrderDTO("Паша Процько", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDAO.saveOrUpdate(new OrderDTO("Наташа Михайлова", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDAO.saveOrUpdate(new OrderDTO("Таня Кузьменко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDAO.saveOrUpdate(new OrderDTO("Карбачин Саша", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDAO.saveOrUpdate(new OrderDTO("Антон Чуйко", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDAO.saveOrUpdate(new OrderDTO("Ян Аронович", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDAO.saveOrUpdate(new OrderDTO("Сергей Поляков", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDAO.saveOrUpdate(new OrderDTO("Миша Иванов", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDAO.saveOrUpdate(new OrderDTO("Женя", "+380674567890", "Біогумат для відкритого грунту",
                "21/03/17", 98));
        orderDAO.saveOrUpdate(new OrderDTO("Н.В. Шатько", "+380934567678", "Біогумат для закритого грунту",
                "21/03/17", 2));
        orderDAO.saveOrUpdate(new OrderDTO("Сергей Гострый", "04434567689", "Біогумат для відкритого грунту",
                "21/03/17", 23));
        orderDAO.saveOrUpdate(new OrderDTO("Настя Никишкина", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDAO.saveOrUpdate(new OrderDTO("Оксана Дьяченко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
        orderDAO.saveOrUpdate(new OrderDTO("Оксана Кондрашева", "0567750544", "Біогумат для відкритого грунту",
                "21/03/17", 4));
        orderDAO.saveOrUpdate(new OrderDTO("Лиля Прудченко", "0503456789", "Біогумат для закритого грунту",
                "21/03/17", 6));
    }

    @Test
    public void addOrderTest() throws Exception {
        OrderDTO foo = new OrderDTO("Абакумов А.В.", "+380674567890", "Продукт №1", "21/03/17", 98);
        String toSend = objMapper.writeValueAsString(foo);
        MvcResult res = mockMvc.perform(post("/orders/add").content(toSend).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        OrderDTO recivedFoo = objMapper.readValue(echo, OrderDTO.class);
        assertNotSame(0, recivedFoo.getId());
    }

    @Test
    public void getOrderTest() throws Exception {
        MvcResult res = mockMvc.perform(get("orders/getone/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        OrderDTO recievedFoo = objMapper.readValue(echo, OrderDTO.class);
        assertNotNull(recievedFoo);
    }

    @Test
    public void getAllOrder() throws Exception {
        MvcResult res = mockMvc.perform(get("orders/getall"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        List<OrderDTO> recivedFoo = objMapper.readValue(echo, new TypeReference<List<OrderDTO>>(){});
        assertNotNull(recivedFoo);
    }

    @Test
    public void getOrdersTest() throws Exception {
        MvcResult res = mockMvc.perform(get("getorders/1/8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String echo = res.getResponse().getContentAsString();
        List<OrderDTO> recFoos = objMapper.readValue(echo, new TypeReference<List<OrderDTO>>() { });
        assertNotNull(recFoos);
    }

    @Test
    public void delOrderTest() throws Exception {
        mockMvc.perform(delete("orders/delone/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @AfterClass
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        orderDAO.dropAll();
    }
}